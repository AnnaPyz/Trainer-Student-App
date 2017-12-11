package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.database.DBConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TrenerProjektyNowyController {

	@FXML
	private TextField tf_projekt_temat;

	@FXML
	private TextField tf_projekt_opis;

	@FXML
	private TextField tf_projekt_data;

	@FXML
	private TextField tf_projekt_gr;

	@FXML
	private Button btn_projekt_dodaj;

	@FXML
	void dodajProjektAction(MouseEvent event) {

		if (tf_projekt_temat.getText().length() < 1 || tf_projekt_opis.getText().length() < 1
				|| tf_projekt_data.getText().length() < 1 || tf_projekt_gr.getText().length() < 1) {
			Alert brak = new Alert(AlertType.WARNING);
			brak.setTitle("Brak");
			brak.setHeaderText("Brak danych");
			brak.setContentText("Uzupe³nij dane");
			brak.showAndWait();
		} else {

			// ³¹czenie z DB:
			DBConnector db = new DBConnector();
			Connection conn = db.connInit();

			// dodaæ try catch
			try {
				PreparedStatement ps = conn
						.prepareStatement("insert into projekty (temat, opis, termin, grupa) values ( ?,?,?,?);");
				ps.setString(1, tf_projekt_temat.getText());
				ps.setString(2, tf_projekt_opis.getText());
				ps.setString(3, tf_projekt_data.getText());
				ps.setString(4, tf_projekt_gr.getText());
				ps.executeUpdate();
				clearAction(null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		show("TrenerView.fxml","Panel trenera");
		((Node)(event.getSource())).getScene().getWindow().hide();

	}

	private void clearAction(ActionEvent event) {
		tf_projekt_temat.clear();
		tf_projekt_opis.clear();
		tf_projekt_data.clear();
		tf_projekt_gr.clear();
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
