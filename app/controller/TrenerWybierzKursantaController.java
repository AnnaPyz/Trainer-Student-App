package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.Kursant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class TrenerWybierzKursantaController {

	@FXML
	private Button btn_dodajkursanta;

	@FXML
	private Button btn_odswieztabele;

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
	private TableColumn<Kursant, Integer> t_grupa;

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
						rs.getString("imie"), rs.getString("nazwisko"), rs.getInt("grupa"), rs.getString("telefon"),
						rs.getString("mail"), rs.getString("github")));
			}
			t_login.setCellValueFactory(new PropertyValueFactory<Kursant, String>("login"));
			t_imie.setCellValueFactory(new PropertyValueFactory<Kursant, String>("imie"));
			t_nazwisko.setCellValueFactory(new PropertyValueFactory<Kursant, String>("nazwisko"));
			t_grupa.setCellValueFactory(new PropertyValueFactory<Kursant, Integer>("grupa"));
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

	}

	@FXML
	void OdswezKursantaAction(MouseEvent event) {
		select();
	}

	@FXML
	void OdznaczKursantaAction(MouseEvent event) {

	}

}
