import java.util.Random;
import javafx.scene.control.Button;

public class Game {
    String[][] minefield;
    int remainingMines;
    Random rand = new Random();

    public Game(int width, int height, int mineNum) {
        minefield = new String[height][width];
        this.remainingMines = mineNum;
        placeMines();
    }

    public Button makeButton(int width, int height) {
        Button button = new Button();
        button.setMinWidth(25);
        button.setText(minefield[height][width]);
        button.setOnAction(e -> System.out.println("Button Press"));
        return button;
    }

    private void placeMines() {
        int minesPlaced = 0;
        while (minesPlaced < remainingMines) {
            int randX = rand.nextInt(minefield[0].length);
            int randY = rand.nextInt(minefield.length);
            if (minefield[randY][randX] != "*") {
                minefield[randY][randX] = "*";
                minesPlaced++;
            }
        }
        for (int x = 0; x < minefield[0].length; x++) {
            for (int y = 0; y < minefield.length; y++) {
                if (minefield[y][x] != "*") {
                    minefield[y][x] = countNeighbors(x, y);
                }
            }
        }
    }

    private String countNeighbors(int x, int y) {
        int count = 0;
        //Index through the nine spaces surrounding the point
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    if (minefield[y + j][x + i] == "*") {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    //Index out of grid
                    continue;
                }
            }
        }
        return (count == 0) ? " " : Integer.toString(count);
    }

}
