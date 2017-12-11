package app.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TrenerProjektyController {

	@FXML
	private Button btn_nowyprojekt;

	@FXML
	private Button btn_ocenprojekt;

	@FXML
	void DodajProjektAction(MouseEvent event) {
		show("TrenerProjektyNowyView.fxml", "Nowy projekt");
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	void OcenProjektAction(MouseEvent event) {
		show("TrenerProjektyOcenView.fxml", "Wybierz projekt do oceny");
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

	private void show(String plik, String tytul) {
		Stage stejdz = new Stage();
		Parent rodzic = null;
		try {
			rodzic = (Parent) FXMLLoader.load(getClass().getResource("/app/view/" + plik));
		} catch (IOException e) {
			System.out.println("B³¹d przy odpalaniu widoku!");
		}
		Scene scenka = new Scene(rodzic);
		stejdz.setScene(scenka);
		stejdz.setTitle(tytul);
		stejdz.show();
	}
}
