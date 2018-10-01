package utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Renderer {

    private int color;
    BufferedImage img;

    public Renderer(BufferedImage img) {
        this.img = img;
        color = Color.RED.getRGB();
    }

    private void drawPixel(int x, int y){
        img.setRGB(x,y,color);
    }

    public void lineTrivial(int x1, int y1, int x2, int y2){
        // obecny predpis je: y = kx + q
        int dx = x1 - x2;
        int dy = y1 - y2;

        if (Math.abs(dx) > Math.abs(dy)){
            //ridici osa X
            // q neni potreba, protoze je to pocatecni bod = y1
            float k;
            k = (float)dy/ (float) dx;
            if (x1 > x2){
                int p = x1;
                x1 = x2;
                x2 = p;
                p = y1;
                y1 = y2;
                //y2 = p;
            }

            for (int x = x1; x < x2; x++) {
                int y = y1 + (int) (k * (x - x1));
                drawPixel(x,y);
            }



        } else {
            // ridici osa Y
            float k,q;
            if (y1 > y2){
                int p = x1;
                x1 = x2;
                //x2 = p;
                p = y1;
                y1 = y2;
                y2 = p;
            }
            k = (float)dy/ (float) dx;
            q = y1 - k*(float) x1;
            for (int y = y1; y < y2; y++) {
                int x = (int)((y-q)/k);
                drawPixel(x,y);
            }
        }
    }
}
