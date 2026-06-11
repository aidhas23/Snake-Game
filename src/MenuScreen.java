import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Startmenü des Snake-Spiels.
 * Zeigt den Titel und einen Play-Button.
 * @author Jurgen Sakti
 */
public class MenuScreen extends JPanel {

    /** Play Button. */
    private JButton playButton;

    /**
     * Konstruktor - Initialisiert das Startmenü.
     */
    public MenuScreen() {
        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        playButton = new JButton("PLAY");
        playButton.setBounds(225, 350, 150, 50);
        playButton.setBackground(Color.GREEN);
        playButton.setForeground(Color.BLACK);
        playButton.setFont(new Font("Arial", Font.BOLD, 25));
        playButton.setFocusable(false);
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        this.add(playButton);
    }

    /**
     * Startet das Spiel wenn Play gedrückt wird.
     */
    private void startGame() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().removeAll();
        Settings settings = new Settings();
        GameLogic gameLogic = new GameLogic(settings.getGeschwindigkeit());
        GamePanel panel = new GamePanel(gameLogic);
        gameLogic.getTimer().addActionListener(panel);
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
        gameLogic.starteSpiel();
    }

    /**
     * Zeichnet das Startmenü.
     * @param g Graphics Objekt
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, 80));
        g.drawString("SNAKE", 150, 200);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Press PLAY to start!", 200, 300);
    }
}