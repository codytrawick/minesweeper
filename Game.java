import java.util.Random;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;

public class Game {
    String[][] minefield;
    int remainingMines;
    Random rand = new Random();

    // private static class ButtonEvent {
    //     static EventHandler<MouseEvent> makeAction(Button b) {
    //         if (b.getText().equals("*")) {
    //             return (eInput -> {
    //                 MouseEvent e = (MouseEvent) eInput;
    //                 System.out.println(e.getButton());
    //             });
    //         } else {
    //             return (e -> System.out.println("Try again"));
    //         }
    //     }
    // }

    public Game(int width, int height, int mineNum) {
        minefield = new String[height][width];
        this.remainingMines = mineNum;
        placeMines();
    }

    public Button makeButton(int width, int height) {
        String content = minefield[height][width];
        Button button = new Button();
        button.setMinWidth(30);
        button.setText(" ");
        button.setOnMouseClicked(e -> {
            if (e.getButton().equals(MouseButton.SECONDARY)) {
                if (!button.getText().equals("?")) {
                    button.setText("?");
                } else {
                    button.setText(" ");
                }
            }
        });
        button.setOnAction(e -> {
            String text = button.getText();
            if (text.equals("?")) {
                //Nothing happens
            } else if (content.equals("*")) {
                button.setDisable(true);
                endGame();
            } else {
                button.setDisable(true);
                button.setText(content);
            }
        });
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

    private void endGame() {
        System.out.println("You lose");
    }

}
