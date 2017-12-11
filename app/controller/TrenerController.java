package app.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TrenerController {

	
	private void show(String plik, String tytul){
		Stage stejdz = new Stage();
		Parent rodzic = null;
		
		try {
			rodzic = (Parent) FXMLLoader.load(getClass().getResource("/app/view/"+plik));
		} catch (IOException e) {
			System.out.println("B³¹d przy odpalaniu widoku!");
		}
		Scene scenka = new Scene(rodzic);
		stejdz.setScene(scenka);
		stejdz.setTitle(tytul);
		stejdz.show();
	}
	
	
	
	@FXML
	void trenerGrupyAction(MouseEvent event) {
		show("TrenerGrupyView.fxml","Grupy");
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	void trenerKursanciAction(MouseEvent event) {
		show("TrenerWybierzKursanta.fxml","Kursanci");
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	void trenerProjektyAction(MouseEvent event) {
		show("TrenerProjektyView.fxml","Projekty");
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

}
