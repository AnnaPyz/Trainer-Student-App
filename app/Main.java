package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage stejdz) throws Exception {
		Parent rodzic = (Parent) FXMLLoader.load(getClass().getResource("/app/view/LoginView.fxml"));
		Scene scenka = new Scene(rodzic);
		stejdz.setScene(scenka);
		stejdz.setTitle("Logowanie");
		stejdz.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
