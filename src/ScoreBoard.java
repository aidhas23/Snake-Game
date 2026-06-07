/**
 * ScoreBoard - Zeigt den aktuellen Punktestand und Highscore an.
 * Speichert den Highscore in einer Datei.
 *
 * @author Jurgen Sakti
 * @version 1.0
 */

package src;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ScoreBoard extends JPanel {

    private int currentScore = 0;
    private int highScore = 0;
    private final String HIGH_SCORE_FILE = "highscore.txt";

    // Konstruktor
    public ScoreBoard() {
        this.setPreferredSize(new Dimension(600, 50));
        this.setBackground(Color.DARK_GRAY);
        loadHighScore();
    }

    // Aktuellen Score setzen
    public void setScore(int score) {
        currentScore = score;
        if (currentScore > highScore) {
            highScore = currentScore;
            saveHighScore();
        }
        repaint();
    }

    // Score zurücksetzen
    public void resetScore() {
        currentScore = 0;
        repaint();
    }

    // Highscore aus Datei laden
    private void loadHighScore() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(HIGH_SCORE_FILE));
            highScore = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (Exception e) {
            highScore = 0;
        }
    }

    // Highscore in Datei speichern
    private void saveHighScore() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(HIGH_SCORE_FILE));
            writer.write(String.valueOf(highScore));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Score anzeigen
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Aktueller Score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + currentScore, 20, 33);

        // Highscore
        g.setColor(Color.YELLOW);
        g.drawString("Highscore: " + highScore, 400, 33);
    }

    // Score zurückgeben
    public int getScore() {
        return currentScore;
    }

    // Highscore zurückgeben
    public int getHighScore() {
        return highScore;
    }
}