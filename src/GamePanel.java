import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Spielfeld des Snake-Spiels.
 * Zeichnet die Schlange, das Essen und den Spielstatus.
 * @author Jurgen Sakti
 */
public class GamePanel extends JPanel implements ActionListener {

    /** Spiellogik Instanz. */
    private GameLogic gameLogic;

    /** FoodManager Instanz. */
    private FoodManager foodManager;

    /**
     * Konstruktor - Initialisiert das Spielfeld.
     * @param gameLogic Die Spiellogik
     */
    public GamePanel(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        this.foodManager = gameLogic.getFoodManager();
        this.setPreferredSize(new Dimension(Snake.BREITE, Snake.HOEHE));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:    gameLogic.setzeRichtung('U'); break;
                    case KeyEvent.VK_DOWN:  gameLogic.setzeRichtung('D'); break;
                    case KeyEvent.VK_LEFT:  gameLogic.setzeRichtung('L'); break;
                    case KeyEvent.VK_RIGHT: gameLogic.setzeRichtung('R'); break;
                }
            }
        });
    }

    /**
     * Zeichnet das Spielfeld, die Schlange und das Essen.
     * @param g Graphics Objekt
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameLogic.isSpielLaeuft()) {
            g.setColor(Color.RED);
            g.fillOval(foodManager.getEssenX(), foodManager.getEssenY(), GameLogic.ZELLE, GameLogic.ZELLE);
            if (foodManager.isBonusAktiv()) {
                g.setColor(Color.YELLOW);
                g.fillOval(foodManager.getBonusX(), foodManager.getBonusY(), GameLogic.ZELLE, GameLogic.ZELLE);
            }
            for (int i = 0; i < gameLogic.getTeile(); i++) {
                g.setColor(i == 0 ? Color.GREEN : new Color(45, 180, 0));
                g.fillRect(gameLogic.getSchlangeX()[i], gameLogic.getSchlangeY()[i], GameLogic.ZELLE, GameLogic.ZELLE);
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Punkte: " + gameLogic.getPunkte(), 10, 25);
        } else {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 75));
            g.drawString("Game Over", 100, 300);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Punkte: " + gameLogic.getPunkte(), 220, 360);
        }
    }

    /**
     * Wird vom Timer aufgerufen - aktualisiert das Spielfeld.
     * @param e ActionEvent vom Timer
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
