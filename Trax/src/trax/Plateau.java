/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trax;







import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Plateau extends JPanel {
    private Tuile[][] grid;
    private Tuile selectedTile; 
    private final int gridSize = 8;
    private JPanel holdingArea; 

    
    public Plateau() {
        setLayout(new BorderLayout()); 

        JPanel gridPanel = new JPanel(new GridLayout(gridSize, gridSize)); 
        grid = new Tuile[gridSize][gridSize];
        initializeGrid(gridPanel);
        add(gridPanel, BorderLayout.CENTER);

      
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton piocherButton = new JButton("Piocher une tuile");
        JButton rotateButton = new JButton("Rotation Tuile");
        
        
        
        holdingArea = new JPanel();
        holdingArea.setPreferredSize(new Dimension(100, 100));
        holdingArea.setBorder(BorderFactory.createLineBorder(Color.black));

        piocherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                piocherTuile();
            }
        });

        rotateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotateTile();
            }
        });

        buttonPanel.add(piocherButton);
        buttonPanel.add(rotateButton);
        buttonPanel.add(holdingArea);

        add(buttonPanel, BorderLayout.SOUTH);
        
        
    }
    
    
    

    
    
    private void initializeGrid(JPanel gridPanel) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                JPanel panel = new JPanel(new BorderLayout());
                panel.setBorder(BorderFactory.createLineBorder(Color.black));
                final int finalI = i;
                final int finalJ = j;
                panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        placeTile(finalI, finalJ, panel);
                    }
                });
                gridPanel.add(panel);
            }
        }
    }

    
    
    
  private Random random = new Random(); 

    public void piocherTuile() {
        boolean isCrossTile = random.nextBoolean();
        
        selectedTile = new Tuile(isCrossTile); 
        holdingArea.add(selectedTile); 
        holdingArea.revalidate();
        holdingArea.repaint();
    }
    
    
    public void rotateTile() {
        if (selectedTile != null) {
            selectedTile.rotate(); 
            holdingArea.repaint();
        }
    }
    
    

    public void placeTile(int x, int y, JPanel panel) {
        if (grid[x][y] == null && selectedTile != null) {
            grid[x][y] = selectedTile;
            panel.add(selectedTile);
            selectedTile = null; 
            holdingArea.removeAll(); 
            holdingArea.revalidate();
            holdingArea.repaint();
            panel.revalidate();
            panel.repaint();
        }
    }

}
