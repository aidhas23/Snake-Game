package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener {

    // Spielfeld Größe
    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    static final int SIZE = 25; // Größe eines Feldes
    static final int DELAY = 150; // Geschwindigkeit

    // Schlange Position
    int[] x = new int[100];
    int[] y = new int[100];
    int length = 3; // Startlänge

    // Essen Position
    int foodX, foodY;
    int score = 0;

    // Richtung und Status
    char direction = 'R'; // R=Rechts, L=Links, U=Oben, D=Unten
    boolean running = false;

    Timer timer;
    Random random = new Random();

    // Konstruktor
    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT  && direction != 'R') direction = 'L';
                if (e.getKeyCode() == KeyEvent.VK_RIGHT && direction != 'L') direction = 'R';
                if (e.getKeyCode() == KeyEvent.VK_UP    && direction != 'D') direction = 'U';
                if (e.getKeyCode() == KeyEvent.VK_DOWN  && direction != 'U') direction = 'D';
            }
        });
        startGame();
    }

    // Spiel starten
    public void startGame() {
        spawnFood();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    // Essen spawnen
    public void spawnFood() {
        foodX = random.nextInt(WIDTH / SIZE) * SIZE;
        foodY = random.nextInt(HEIGHT / SIZE) * SIZE;
    }

    // Alles zeichnen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (running) {
            // Essen zeichnen
            g.setColor(Color.RED);
            g.fillOval(foodX, foodY, SIZE, SIZE);

            // Schlange zeichnen
            for (int i = 0; i < length; i++) {
                g.setColor(i == 0 ? Color.GREEN : new Color(45, 180, 0));
                g.fillRect(x[i], y[i], SIZE, SIZE);
            }

            // Punkte anzeigen
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Punkte: " + score, 10, 25);

        } else {
            // Game Over Text
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 75));
            g.drawString("Game Over", 120, 300);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Punkte: " + score, 230, 360);
        }
    }

    // Schlange bewegen
    public void move() {
        for (int i = length; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (direction == 'R') x[0] += SIZE;
        if (direction == 'L') x[0] -= SIZE;
        if (direction == 'U') y[0] -= SIZE;
        if (direction == 'D') y[0] += SIZE;
    }

    // Essen checken
    public void checkFood() {
        if (x[0] == foodX && y[0] == foodY) {
            length++;
            score++;
            spawnFood();
        }
    }

    // Kollision checken
    public void checkCollisions() {
        // Wand
        if (x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT) {
            running = false;
        }
        // Eigener Körper
        for (int i = 1; i < length; i++) {
            if (x[0] == x[i] && y[0] == y[i]) running = false;
        }
        if (!running) timer.stop();
    }

    // Timer Tick
    public void actionPerformed(ActionEvent e) {
        move();
        checkFood();
        checkCollisions();
        repaint();
    }
}