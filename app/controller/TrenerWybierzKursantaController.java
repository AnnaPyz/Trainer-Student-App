package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.Kursant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TrenerWybierzKursantaController {

	@FXML
	private Button btn_dodajkursanta;

	@FXML
	private Button btn_odznaczkursanta;

	@FXML
	private TableView<Kursant> t;

	@FXML
	private TableColumn<Kursant, String> t_login;

	@FXML
	private TableColumn<Kursant, String> t_imie;

	@FXML
	private TableColumn<Kursant, String> t_nazwisko;

	@FXML
	private TableColumn<Kursant, String> t_grupa;

	@FXML
	private TableColumn<Kursant, String> t_tel;

	@FXML
	private TableColumn<Kursant, String> t_mail;

	@FXML
	private TableColumn<Kursant, String> t_github;

	PreparedStatement ps;
	Connection conn;
	DBConnector db;

	public ObservableList<Kursant> dane = FXCollections.observableArrayList();

	public void initialize() {
		select();
	}
	
	private void polacz() {
		db = new DBConnector();
		conn = db.connInit();
	}

	private void select() {
		polacz();
		dane.clear();
		try {
			ps = conn.prepareStatement("SELECT * FROM uzytkownicy");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dane.add(new Kursant(rs.getString("login"), rs.getString("pass"), rs.getInt("upraw"),
						rs.getString("imie"), rs.getString("nazwisko"), rs.getString("grupa"), rs.getString("telefon"),
						rs.getString("mail"), rs.getString("github")));
			}
			t_login.setCellValueFactory(new PropertyValueFactory<Kursant, String>("login"));
			t_imie.setCellValueFactory(new PropertyValueFactory<Kursant, String>("imie"));
			t_nazwisko.setCellValueFactory(new PropertyValueFactory<Kursant, String>("nazwisko"));
			t_grupa.setCellValueFactory(new PropertyValueFactory<Kursant, String>("grupa"));
			t_tel.setCellValueFactory(new PropertyValueFactory<Kursant, String>("telefon"));
			t_mail.setCellValueFactory(new PropertyValueFactory<Kursant, String>("mail"));
			t_github.setCellValueFactory(new PropertyValueFactory<Kursant, String>("github"));

			t.setItems(null);
			t.setItems(dane);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void DodajKursantaAction(MouseEvent event) {
		String login_selected = "";
		try {
			login_selected = t.getSelectionModel().getSelectedItem().getLogin();
		} catch (Exception e) {
			Alert loginError = new Alert(AlertType.ERROR);
			loginError.setTitle("B³¹d!");
			loginError.setHeaderText("B³¹d");
			loginError.setContentText("B³¹d!!!!");
			loginError.showAndWait();
		}
		
		polacz();
		String temp_grupa = TrenerGrupyController.grupa;
		try {
			ps = conn.prepareStatement("update uzytkownicy set grupa = ? where login = ?;");
			ps.setString(1, temp_grupa);
			ps.setString(2, login_selected);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		select();
	}

	@FXML
	void OdznaczKursantaAction(MouseEvent event) {
		show("TrenerView.fxml","Wybierz kursanta do grupy");
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
