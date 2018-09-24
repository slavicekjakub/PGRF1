package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PgrfFrame extends JFrame {

    private BufferedImage img; // pro vykreslovani
    static int width = 800;
    static int height = 600;

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

        draw();

    }

    // vykresleni
    private void draw(){
        img.getGraphics().fillRect(0,0,img.getWidth(),img.getHeight()); // prideleni pozadi
        for (int i = 0; i <100 ; i++) {
            img.setRGB(200 + i,200, Color.RED.getRGB()); // udela se cara
        }

        getGraphics().drawImage(img, 0,0,img.getWidth(), img.getHeight(), null); // zde ji to vykresli
    }

}
