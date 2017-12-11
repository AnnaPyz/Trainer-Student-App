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
    private TableView<?> t;

    @FXML
    private TableColumn<?, ?> t_id;

    @FXML
    private TableColumn<?, ?> t_login;

    @FXML
    private TableColumn<?, ?> t_imie;

    @FXML
    private TableColumn<?, ?> t_nazwisko;

    @FXML
    private TableColumn<?, ?> t_grupa;

    @FXML
    private TableColumn<?, ?> t_tel;

    @FXML
    private TableColumn<?, ?> t_mail;

    @FXML
    private TableColumn<?, ?> t_github;
    
    PreparedStatement ps;
	Connection conn;
	DBConnector db;
	
	public ObservableList<Kursant> dane = FXCollections.observableArrayList();
	
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
				dane.add(new Kursant(rs.getString("login"), rs.getString("pass"), rs.getInt("upraw"), rs.getString("imie"),
						rs.getString("nazwisko"), rs.getInt("grupa"), rs.getString("telefon"), rs.getString("mail"),
						rs.getString("github")));
			}
			t_id.setCellValueFactory(new PropertyValueFactory<Admin, Integer>("id"));
			t_name.setCellValueFactory(new PropertyValueFactory<Admin, String>("name"));
			t_last.setCellValueFactory(new PropertyValueFactory<Admin, String>("last"));
			t_java.setCellValueFactory(new PropertyValueFactory<Admin, Boolean>("java"));
			t_python.setCellValueFactory(new PropertyValueFactory<Admin, Boolean>("python"));
			t_other.setCellValueFactory(new PropertyValueFactory<Admin, String>("other"));
			t_english.setCellValueFactory(new PropertyValueFactory<Admin, String>("english"));
			t_kurs.setCellValueFactory(new PropertyValueFactory<Admin, String>("kurs"));
			t_data.setCellValueFactory(new PropertyValueFactory<Admin, String>("data"));
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

    }

    @FXML
    void OdznaczKursantaAction(MouseEvent event) {

    }

    
    
}
