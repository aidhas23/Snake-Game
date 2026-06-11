package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuScreen extends JPanel {

    private JButton playButton;

    // Konstruktor
    public MenuScreen() {
        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        // Play Button erstellen
        playButton = new JButton("PLAY");
        playButton.setBounds(225, 350, 150, 50);
        playButton.setBackground(Color.GREEN);
        playButton.setForeground(Color.BLACK);
        playButton.setFont(new Font("Arial", Font.BOLD, 25));
        playButton.setFocusable(false);

        // Button Aktion
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        this.add(playButton);
    }

    // Spiel starten
    private void startGame() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().removeAll();
        frame.add(new GamePanel());
        frame.revalidate();
        frame.repaint();
    }

    // Menu zeichnen
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Titel
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, 80));
        g.drawString("SNAKE", 150, 200);

        // Untertitel
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Press PLAY to start!", 200, 300);
    }
}