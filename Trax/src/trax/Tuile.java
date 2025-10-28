/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trax;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Tuile extends JPanel {
    private final boolean isCrossTile;
    private BufferedImage image;
    private int rotationState;

    
    
    public Tuile(boolean isCrossTile) {
        this.isCrossTile = isCrossTile;
        setPreferredSize(new Dimension(100, 100));
        this.rotationState = 0;

        try {

            if (isCrossTile) {
                image = ImageIO.read(getClass().getResourceAsStream("Tuile1.jpeg"));
            } else {
                image = ImageIO.read(getClass().getResourceAsStream("Tuile2.jpeg"));
            } 
            
            Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            g2d.drawImage(scaledImage, 0, 0, null);
            g2d.dispose();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    
    
    

    public void rotate() {
        this.rotationState = (this.rotationState + 1) % 4;
        repaint();
    }

    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int x = (getWidth() - image.getWidth()) / 2;
        int y = (getHeight() - image.getHeight()) / 2;


        g2d.rotate(Math.toRadians(rotationState * 90), getWidth() / 2.0, getHeight() / 2.0);
        g2d.drawImage(image, x, y, this);
        g2d.dispose();
    }
}



