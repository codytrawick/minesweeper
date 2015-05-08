import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;


public class Minesweeper extends Application {
    public void start(Stage stage) {
        Game game = new Game(30, 30, 100);

        GridPane gp = game.getGridPane();
        // for (int i = 0; i < game.getWidth(); i++) {
        //     for (int j = 0; j < game.getHeight(); j++) {
        //         gp.add(game.makeButton(i, j), i, j);
        //     }
        // }

        Scene scene = new Scene(gp);
        stage.setScene(scene);
        stage.show();
    }
}
