import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Punkteanzeige des Snake-Spiels.
 * Zeigt den aktuellen Score und den Highscore.
 * @author Jurgen Sakti
 */
public class ScoreBoard extends JPanel {

    /** Aktueller Score. */
    private int currentScore = 0;

    /** Highscore. */
    private int highScore = 0;

    /** Dateiname für den Highscore. */
    private final String HIGH_SCORE_FILE = "highscore.txt";

    /**
     * Konstruktor - Initialisiert das ScoreBoard.
     */
    public ScoreBoard() {
        this.setPreferredSize(new Dimension(600, 50));
        this.setBackground(Color.DARK_GRAY);
        loadHighScore();
    }

    /**
     * Setzt den aktuellen Score.
     * @param score Der neue Score
     */
    public void setScore(int score) {
        currentScore = score;
        if (currentScore > highScore) {
            highScore = currentScore;
            saveHighScore();
        }
        repaint();
    }

    /**
     * Setzt den Score zurück.
     */
    public void resetScore() {
        currentScore = 0;
        repaint();
    }

    /**
     * Lädt den Highscore aus einer Datei.
     */
    private void loadHighScore() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(HIGH_SCORE_FILE));
            highScore = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (Exception e) {
            highScore = 0;
        }
    }

    /**
     * Speichert den Highscore in eine Datei.
     */
    private void saveHighScore() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(HIGH_SCORE_FILE));
            writer.write(String.valueOf(highScore));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gibt den aktuellen Score zurück.
     * @return Aktueller Score
     */
    public int getScore() { return currentScore; }

    /**
     * Gibt den Highscore zurück.
     * @return Highscore
     */
    public int getHighScore() { return highScore; }

    /**
     * Zeichnet das ScoreBoard.
     * @param g Graphics Objekt
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + currentScore, 20, 33);
        g.setColor(Color.YELLOW);
        g.drawString("Highscore: " + highScore, 400, 33);
    }
}