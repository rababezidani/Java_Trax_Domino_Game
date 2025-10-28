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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class TuilePanel extends JPanel {
    private Tuile tuile;
    final int tileSize = 50; // Taille de chaque section de tuile

    public TuilePanel(Tuile tuile) {
        this.tuile = tuile;
        setPreferredSize(new Dimension(200, 200));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void setTuile(Tuile tuile) {
        this.tuile = tuile;
        repaint();
    }

    public Tuile getTuile() {
        return tuile;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (tuile != null) {
            drawTuile(g, tuile);
        }
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
}



public class Plateau extends JPanel {
    private Tuile[] tuilesSurPlateau;
    private static final int MAX_TUILES = 50;
    private Tuile tuileActive;
    private Random random = new Random();
    private TuilePanel tuilePreviewPanel;
    private JButton rotateButton;
    private JButton piocherButton;

    public Plateau() {
        tuilesSurPlateau = new Tuile[MAX_TUILES];
        setLayout(new GridLayout(10, 5)); // Un layout pour un plateau de 10x5 tuiles
        initializePlateau();
        initializePreviewAndRotation();
    }

    private void initializePlateau() {
        for (int i = 0; i < MAX_TUILES; i++) {
            TuilePanel tuilePanel = new TuilePanel(null);
            int position = i;
            tuilePanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (tuileActive != null && tuilePanel.getTuile() == null) {
                        tuilesSurPlateau[position] = tuileActive;
                        tuilePanel.setTuile(tuileActive);
                        tuileActive = null;
                        tuilePanel.repaint();
                    }
                }
            });
            add(tuilePanel);
        }
    }

    private void initializePreviewAndRotation() {
        tuilePreviewPanel = new TuilePanel(null); // Panel pour montrer la tuile piochée
        rotateButton = new JButton("Rotation Tuile");
        rotateButton.addActionListener(e -> {
            if (tuileActive != null) {
                tuileActive.rotation();
                tuilePreviewPanel.repaint();
            }
        });

        piocherButton = new JButton("Piocher une tuile");
        piocherButton.addActionListener(e -> {
            Tuile tuile = piocherTuile();
            tuilePreviewPanel.setTuile(tuile);
            tuilePreviewPanel.repaint();
        });

        // Ajout des composants de contrôle et de visualisation
        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.add(rotateButton, BorderLayout.NORTH);
        controlPanel.add(piocherButton, BorderLayout.SOUTH);

        add(controlPanel, BorderLayout.EAST);
        add(tuilePreviewPanel, BorderLayout.CENTER);
    }

    public Tuile piocherTuile() {
        // Cette fonction pioche une tuile avec des chiffres aléatoires pour chaque côté
        int[] haut = {random.nextInt(5), random.nextInt(5), random.nextInt(5)};
        int[] droit = {random.nextInt(5), random.nextInt(5), random.nextInt(5)};
        int[] bas = {random.nextInt(5), random.nextInt(5), random.nextInt(5)};
        int[] gauche = {random.nextInt(5), random.nextInt(5), random.nextInt(5)};
        tuileActive = new Tuile(haut, droit, bas, gauche);
        return tuileActive;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Plateau de Tuiles");
            Plateau plateau = new Plateau();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(plateau, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}