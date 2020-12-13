package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }

    int xKolo = 100;
    int yKolo = 100;
    int dim = 50;
    int wysSzerKwadrat = 250;
    int xKwadrat = 1;//(int) (Math.random()*700-wiHeRECT);
    int yKwadrat = 1;//(int) (Math.random()*700-wiHeRECT);


    public void animacja() {
        boolean pionowa = true;
        boolean pozioma = true;
        while (true) {
            if (xKolo >= getWidth() - dim) {
                pionowa = false;
            }
            if (yKolo >= getHeight() - dim) {
                pozioma = false;
            }

            if (xKolo <= 0) {
                pionowa = true;
            }
            if (yKolo <= 0) {
                pozioma = true;
            }

            if (xKolo + dim >= xKwadrat && xKolo < xKwadrat + wysSzerKwadrat && (yKolo > yKwadrat && yKolo < yKwadrat + wysSzerKwadrat)) {
                pionowa = false;
            }
            if ((xKolo < xKwadrat + wysSzerKwadrat && xKolo > xKwadrat) && (yKolo > yKwadrat && yKolo < yKwadrat + wysSzerKwadrat)) {
                pionowa = true;
            }

            if (yKolo + dim > yKwadrat && yKolo < yKwadrat && (xKolo > xKwadrat && xKolo < xKwadrat + wysSzerKwadrat)) {
                pozioma = false;
            }
            if (yKolo < yKwadrat + wysSzerKwadrat && yKolo > yKwadrat && (xKolo > xKwadrat && xKolo < xKwadrat + wysSzerKwadrat)) {
                pozioma = true;
            }


            if (pionowa == true) {
                xKolo += 3;
            }
            if (pionowa == false) {
                xKolo -= 8;
            }

            if (pozioma == true) {
                yKolo += 4;
            }
            if (pozioma == false) {
                yKolo -= 6;
            }


            try {
                Thread.sleep(20);
            } catch (Exception e) {
            }
            repaint();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillOval(xKolo, yKolo, dim, dim);
        g.drawRect(xKwadrat, yKwadrat, wysSzerKwadrat, wysSzerKwadrat);

    }


    public static void main(String[] args) {
        JFrame window = new JFrame();
        Main m = new Main();
        window.add(m);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.pack();
        m.animacja();
    }
}
