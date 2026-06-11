import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Game Over Screen des Snake-Spiels.
 * Zeigt den finalen Score und einen Neustart-Button.
 * @author Jurgen Sakti
 */
public class GameOver extends JPanel {

    /** Finaler Score des Spielers. */
    private int finalScore = 0;

    /** Neustart Button. */
    private JButton restartButton;

    /**
     * Konstruktor - Initialisiert den Game Over Screen.
     */
    public GameOver() {
        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        restartButton = new JButton("Neustart");
        restartButton.setBounds(225, 350, 150, 50);
        restartButton.setBackground(Color.GREEN);
        restartButton.setForeground(Color.BLACK);
        restartButton.setFont(new Font("Arial", Font.BOLD, 20));
        restartButton.setFocusable(false);
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        this.add(restartButton);
    }

    /**
     * Setzt den finalen Score.
     * @param score Der finale Score
     */
    public void setFinalScore(int score) {
        finalScore = score;
        repaint();
    }

    /**
     * Startet das Spiel neu.
     */
    private void restartGame() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
        Settings settings = new Settings();
        GameLogic gameLogic = new GameLogic(settings.getGeschwindigkeit());
        GamePanel panel = new GamePanel(gameLogic);
        gameLogic.getTimer().addActionListener(panel);
        JFrame newFrame = new JFrame("Snake Spiel");
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.add(panel);
        newFrame.pack();
        newFrame.setLocationRelativeTo(null);
        newFrame.setVisible(true);
        gameLogic.starteSpiel();
    }

    /**
     * Zeichnet den Game Over Screen.
     * @param g Graphics Objekt
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 75));
        g.drawString("Game Over", 100, 200);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Punkte: " + finalScore, 220, 300);
    }
}
