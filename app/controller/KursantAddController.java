package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

public class KursantAddController {

	@FXML
	private TextField add_name;

	@FXML
	private TextField add_last;

	@FXML
	private TextField add_phone;

	@FXML
	private TextField add_mail;

	@FXML
	private TextField add_github;

	@FXML
	private TextField add_login;

	@FXML
	private TextField add_password;

	@FXML
	private Button btn_dodaj;
	
	PreparedStatement ps;
	Connection conn;
	DBConnector db;

	@FXML
	void dodajNowegoAction(MouseEvent event) {
		polacz();
		String name = add_name.getText();
		String last = add_last.getText();
		String phone = add_phone.getText();
		String mail = add_mail.getText();
		String github = add_github.getText();
		String login = add_login.getText();
		String pass = add_password.getText();
		
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into uzytkownicy(login, pass, imie, nazwisko, telefon, mail, github) values (?,?,?,?,?,?,?);");
			ps.setString(1, login);
			ps.setString(2, pass);
			ps.setString(3, name);
			ps.setString(4, last);
			ps.setString(5, phone);
			ps.setString(6, mail);
			ps.setString(7, github);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		show("TrenerView.fxml", "Panel trenera");
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	
	private void polacz() {
		db = new DBConnector();
		conn = db.connInit();
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
