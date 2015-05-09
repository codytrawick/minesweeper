import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;


public class Minesweeper extends Application {
    public void start(Stage stage) {
        Game game = new Game(30, 30, 100);

        GridPane gp = game.getGridPane();
        Button reset = new Button("Reset");
        BorderPane.setAlignment(reset, Pos.CENTER);
        BorderPane.setMargin(reset, new Insets(10, 10, 10, 10));
        BorderPane gameView = new BorderPane();
        gameView.setCenter(gp);
        gameView.setBottom(reset);
        reset.setOnAction(e -> gameView.setCenter((new Game(30, 30, 100)).getGridPane()));

        Scene scene = new Scene(gameView);
        stage.setScene(scene);
        stage.show();
    }
}
