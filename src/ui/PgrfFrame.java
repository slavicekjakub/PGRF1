package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class PgrfFrame extends JFrame {

    static int FPS = 1000/60;
    private BufferedImage img; // pro vykreslovani
    static int width = 800;
    static int height = 600;
    private JPanel panel; // musime pridat panel, protoze to nevykreslovalo

    public static void main(String... args) {
        PgrfFrame pgrfFrame = new PgrfFrame();
        pgrfFrame.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); // Prideleni ARGB barev
        pgrfFrame.init(width,height);
    }

    // Inicializace vykresleni
    private void init(int width, int height){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(width,height);
        setTitle("Počítačová grafika");

        panel = new JPanel();
        add(panel);

        setLocationRelativeTo(null);

        Timer timer = new Timer(); // timer pro obnoveni toho vykresleni a ted uz to funguje
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        }, 100, FPS);
        draw();

    }

    // vykresleni
    private void draw(){
        img.getGraphics().fillRect(0,0,img.getWidth(),img.getHeight()); // prideleni pozadi
        for (int i = 0; i <100 ; i++) {
            img.setRGB(200 + i,200, Color.RED.getRGB()); // udela se cara
        }


        panel.getGraphics().drawImage(img, 0,0,img.getWidth(), img.getHeight(), null); // zde ji to vykresli
        panel.paintComponents(getGraphics());
    }

}
