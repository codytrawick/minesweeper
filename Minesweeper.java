import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;


public class Minesweeper extends Application {
    public void start(Stage stage) {
        Game game = new Game(3, 3, 3);

        GridPane gp = new GridPane();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gp.add(game.makeButton(i, j), i, j);
            }
        }

        Scene scene = new Scene(gp);
        stage.setScene(scene);
        stage.show();
    }
}
