import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class Minesweeper extends Application {
    public void start(Stage stage) {
        Label label = new Label("Game not made yet");

        Scene scene = new Scene(label);
        stage.setScene(scene);
        stage.show();
    }
}
