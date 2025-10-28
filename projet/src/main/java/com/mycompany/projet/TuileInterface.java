/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet;

/**
 *
 * @author sarah
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class TuileInterface extends JFrame {
    private Tuile tuile1, tuile2;

    public TuileInterface() {
        super("Tuile Viewer"); //titre de la fenetre, on pouvait aussi utiliser setTitle
        tuile1 = new Tuile(new int[]{0, 2, 3}, new int[]{0, 5, 3}, new int[]{2, 0, 4}, new int[]{0, 0, 0});
        tuile2 = new Tuile(new int[]{1, 2, 3}, new int[]{0, 0, 0}, new int[]{4, 0, 2}, new int[]{0, 0, 0});

        TuilePanel panelTuile1 = new TuilePanel(tuile1);
        TuilePanel panelTuile2 = new TuilePanel(tuile2);

        JButton rotateButton1 = new JButton("Rotation Tuile 1");
        rotateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tuile1.rotation();
                panelTuile1.repaint();
            }
        });

        JButton rotateButton2 = new JButton("Rotation Tuile 2");
        rotateButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tuile2.rotation();
                panelTuile2.repaint();
            }
        });

        JButton checkCompatibilityButton = new JButton("Vérifier la compatibilité");
        checkCompatibilityButton.addActionListener(new ActionListener() {
            @Override
            
            // on a un bouton qui nous permet de savoir si un côté de la tuile2 est compatible avec la tuile 1
            public void actionPerformed(ActionEvent e) {
                String[] directions = {"haut", "droit", "bas", "gauche"};

                for (int i = 0; i < 4; i++) {
                    boolean compatible = tuile1.estCompatible(tuile2, i);
                    JOptionPane.showMessageDialog(null, "Compatibilité avec le côté " + directions[i] + " de la tuile 1 : " + compatible);
                }
            }

        });

        setLayout(new FlowLayout());
        add(panelTuile1);
        add(rotateButton1);
        add(panelTuile2);
        add(rotateButton2);
        add(checkCompatibilityButton);

        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class TuilePanel extends JPanel {
        Tuile tuile;
        final int tileSize = 50; 

        public TuilePanel(Tuile tuile) {
            this.tuile = tuile;
            setPreferredSize(new Dimension(200, 200));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawTuile(g, tuile);
        }

        private void drawTuile(Graphics g, Tuile tuile) {
            int xCenter = getWidth() / 2 - tileSize / 2;
            int yCenter = getHeight() / 2 - tileSize / 2;
            
            int numHeight = tileSize / 3;
            int numWidth = tileSize / 3;

            // Dessiner le carre central
            g.setColor(Color.GRAY);
            g.fillRect(xCenter, yCenter, tileSize, tileSize);
            
            

            // Dessiner les cotes de la tuile
            // Top
            
            drawSide(g, tuile.getCote(0), xCenter, yCenter - numHeight, tileSize, numHeight, "top");
            // Right
            drawSide(g, tuile.getCote(1), xCenter + tileSize, yCenter, tileSize / 3, tileSize, "right");
            // Bottom
            drawSide(g, tuile.getCote(2), xCenter, yCenter + tileSize, tileSize, numHeight, "bottom");
            // Left
            drawSide(g, tuile.getCote(3), xCenter - tileSize / 3, yCenter, tileSize / 3, tileSize, "left");
        }

        private void drawSide(Graphics g, int[] numbers, int x, int y, int width, int height, String side) {
            int numHeight = height / 3;
            int numWidth = width / 3;
            FontMetrics fm = g.getFontMetrics();

            for (int i = 0; i < 3; i++) {
                int xPos = x + (side.equals("top") || side.equals("bottom") ? i * numWidth : 0);
                int yPos = y + (side.equals("left") || side.equals("right") ? i * numHeight : 0);
                int adjust = fm.getAscent() / 2; // Centrer le texte verticalement
                int numToDraw = numbers[i];

                // Pour les côtés bas et gauche, nous devons inverser l'ordre de lecture des nombres
                if (side.equals("bottom")) {
                    numToDraw = numbers[2 - i];
                    yPos = y;
                } else if (side.equals("left")) {
                    numToDraw = numbers[2 - i];
                    xPos = x;
                }

                // Positionnement du texte dans le rectangle
                int textX = xPos + (numWidth - fm.stringWidth(String.valueOf(numToDraw))) / 2;
                int textY = yPos + (numHeight - fm.getAscent()) / 2 + fm.getAscent();


                // Dessin des rectangles blancs pour les chiffres
                g.setColor(Color.WHITE);
                g.fillRect(xPos, yPos, width > height ? numWidth : width, height > width ? numHeight : height);
                // Dessin des chiffres
                g.setColor(Color.BLACK);
                g.drawString(String.valueOf(numToDraw), textX, textY);
                
            }
        }
        
    }    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TuileInterface();
            }
        });


    }
}


