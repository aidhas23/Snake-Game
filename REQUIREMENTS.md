# Requirements Design – Snake Spiel
**SEW Projekt | Gruppe: Aiden Hasanaj & Jurgen Sakti**  
**Datum: Mai 2026**


## 1. Projektbeschreibung

Im Rahmen des SEW-Projekts entwickeln wir ein Snake-Spiel in Java mit grafischen Elementen (Java Swing). Das Projekt wird in einer Gruppe von zwei Personen durchgeführt und mit Git versioniert. Die Zusammenarbeit erfolgt über klar definierte Branches (Master, Devil, Feature-Branches).


## 2. Ziele (Was soll das Programm können?)

### 2.1 Spielfunktionen
- Der Spieler steuert eine Schlange mit den Pfeiltasten (oben, unten, links, rechts)
- Die Schlange bewegt sich automatisch in die gewählte Richtung
- Die Schlange wächst wenn sie Essen frisst
- Bei Kollision mit der Wand oder mit sich selbst endet das Spiel (Game Over)

### 2.2 Essen & Punkte
- Es gibt normales Essen das zufällig auf dem Spielfeld erscheint
- Es gibt Bonus-Essen das nur für kurze Zeit sichtbar ist und mehr Punkte gibt
- Die Punkte werden während des Spiels laufend angezeigt
- Der Highscore wird gespeichert und angezeigt

### 2.3 Menü & Einstellungen
- Es gibt ein Startmenü mit einem Play-Button
- Der Spieler kann vor dem Spiel zwischen Easy-Modus (langsam) und Hard-Modus (schnell) wählen
- Nach dem Game Over erscheint ein Game Over Screen mit den erreichten Punkten und einem Neustart-Button

### 2.4 Grafik
- Das gesamte Spiel hat eine grafische Oberfläche mit Java Swing
- Das Spielfeld, die Schlange und das Essen werden grafisch dargestellt


## 3. Nicht-Ziele (Was ist explizit NICHT Teil des Projekts?)

- Kein Multiplayer-Modus
- Keine Online-Funktionalität oder Netzwerkverbindung
- Kein Sound oder Musik
- Keine mobile Version
- Keine Bestenliste mit mehreren Spielern
- Keine verschiedenen Level oder Welten
- Keine animierten Effekte oder Partikel
- Keine Datenbank zur Datenspeicherung


## 4. Klassenübersicht

| Klasse | Verantwortlich | Beschreibung |
|--------|---------------|--------------|
| `Snake.java` | Aiden | Hauptklasse, startet das Programm, erstellt das JFrame Fenster |
| `GameLogic.java` | Aiden | Spiellogik: Bewegung, Kollisionserkennung, Punktezählung |
| `FoodManager.java` | Aiden | Verwaltet normales und Bonus-Essen auf dem Spielfeld |
| `Settings.java` | Aiden | Schwierigkeitsgrad: Easy und Hard Modus |
| `GamePanel.java` | Jurgen | Grafik: zeichnet Schlange, Essen und Spielfeld |
| `ScoreBoard.java` | Jurgen | Zeigt Punkte an und speichert den Highscore |
| `GameOver.java` | Jurgen | Game Over Screen mit Punkten und Neustart-Button |
| `MenuScreen.java` | Jurgen | Startmenü mit Play-Button |


## 5. Technologien

| Technologie | Verwendung |
|-------------|-----------|
| Java | Programmiersprache |
| Java Swing | Grafische Oberfläche |
| Git & GitHub | Versionskontrolle & Zusammenarbeit |
| IntelliJ IDEA | Entwicklungsumgebung |


## 6. Git Struktur

```
master        → Finaler, stabiler Code
   └── devil  → Integration und Tests
        ├── feature/snake-main
        ├── feature/snake-logic
        ├── feature/food-manager
        ├── feature/settings
        ├── feature/game-panel
        ├── feature/scoreboard
        ├── feature/gameover
        ├── feature/menu
        └── feature/javadoc
```


## 7. UML Diagramm

Das UML Diagramm ist in der Datei `UML.jpg` im Repository zu finden.

