import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Spielfeld des Snake-Spiels.
 * Zeichnet die Schlange, das Essen und den Hintergrund.
 * @author Jurgen Sakti
 */
public class GamePanel extends JPanel implements ActionListener {

    private GameLogic gameLogic;
    private FoodManager foodManager;

    public GamePanel(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        this.foodManager = gameLogic.getFoodManager();
        this.setPreferredSize(new Dimension(Snake.BREITE, Snake.HOEHE));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (gameLogic.isSpielLaeuft()) {
            // Essen zeichnen
            g.setColor(Color.RED);
            g.fillOval(foodManager.getEssenX(), foodManager.getEssenY(), GameLogic.ZELLE, GameLogic.ZELLE);

            // Bonus Essen zeichnen
            if (foodManager.isBonusAktiv()) {
                g.setColor(Color.YELLOW);
                g.fillOval(foodManager.getBonusX(), foodManager.getBonusY(), GameLogic.ZELLE, GameLogic.ZELLE);
            }

            // Schlange zeichnen
            for (int i = 0; i < gameLogic.getTeile(); i++) {
                g.setColor(i == 0 ? Color.GREEN : new Color(45, 180, 0));
                g.fillRect(gameLogic.getSchlangeX()[i], gameLogic.getSchlangeY()[i], GameLogic.ZELLE, GameLogic.ZELLE);
            }

            // Punkte anzeigen
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Punkte: " + gameLogic.getPunkte(), 10, 25);

        } else {
            // Game Over Screen
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 75));
            g.drawString("Game Over", 100, 300);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Punkte: " + gameLogic.getPunkte(), 220, 360);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}