

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOver extends JPanel {

    private int finalScore = 0;
    private JButton restartButton;

    // Konstruktor
    public GameOver() {
        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        // Restart Button erstellen
        restartButton = new JButton("Neustart");
        restartButton.setBounds(225, 350, 150, 50);
        restartButton.setBackground(Color.GREEN);
        restartButton.setForeground(Color.BLACK);
        restartButton.setFont(new Font("Arial", Font.BOLD, 20));
        restartButton.setFocusable(false);

        // Button Aktion
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });

        this.add(restartButton);
    }

    // Score setzen
    public void setFinalScore(int score) {
        finalScore = score;
        repaint();
    }

    // Spiel neustarten
    private void restartGame() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
        // Neues Spiel starten
        JFrame newFrame = new JFrame("Snake Game");
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.add(new GamePanel());
        newFrame.pack();
        newFrame.setLocationRelativeTo(null);
        newFrame.setVisible(true);
    }

    // Game Over Screen zeichnen
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Game Over Text
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 75));
        g.drawString("Game Over", 100, 200);

        // Punkte anzeigen
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Punkte: " + finalScore, 220, 300);
    }
}