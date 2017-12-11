package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import app.database.DBConnector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TrenerGrupyController {

	DBConnector db;
	Connection conn;
	Statement cursor;
	PreparedStatement ps;

	@FXML
	private TextField tf_nazwagr;

	@FXML
	private Button btn_dodajkursantow;

	private void polacz() {
		db = new DBConnector();
		conn = db.connInit();
	}

	@FXML
	void dodajKursantowAction(MouseEvent event) {
		String temp = tf_nazwagr.getText();
		polacz();
		try {
			cursor = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("B³¹d kursora!");
		}

		try {
			cursor.executeUpdate("insert into grupy(nazwa) values('" + temp + "');");
		} catch (SQLException e) {
			System.out.println("B³¹d inserta!");
		}
		show("TrenerWybierzKursanta.fxml","Wybierz kursanta do grupy");
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
