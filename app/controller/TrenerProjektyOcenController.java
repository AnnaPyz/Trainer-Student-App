package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.Projekt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TrenerProjektyOcenController {

	@FXML
	private TableView<Projekt> t;

	@FXML
	private TableColumn<Projekt, Integer> t_idproj;
	@FXML
	private TableColumn<Projekt, String> t_temat;
	@FXML
	private TableColumn<Projekt, String> t_opis;
	@FXML
	private TableColumn<Projekt, String> t_termin;
	@FXML
	private TableColumn<Projekt, String> t_grupa;
	@FXML
	private TableColumn<Projekt, Integer> t_zrobione;
	@FXML
	private TableColumn<Projekt, Integer> t_ocena;
	@FXML
	private Button btn_ocen;
	@FXML
	private Label btn_odznacz;

	public ObservableList<Projekt> dane = FXCollections.observableArrayList();

	PreparedStatement ps;
	Connection conn;
	DBConnector db;
	static public int proj_id_selected;

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

	@FXML
	void ocenProjektAction(MouseEvent event) {
		try {
			proj_id_selected = t.getSelectionModel().getSelectedItem().getId();
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Brak wyboru");
			a.setHeaderText("Brak wyboru");
			a.setContentText("Zaznacz rekord");
			a.showAndWait();
		}
		show("TrenerProjektyOcenOcenaView.fxml", "Ocena projektu");
	}

	@FXML
	void comebackAction(MouseEvent event) {
		show("TrenerView.fxml", "Panel trenera");
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	void refreshAction(MouseEvent event) {
		select();
	}

	private void connection() {
		db = new DBConnector();
		conn = db.connInit();
	}

	private void select() {
		connection();
		dane.clear();
		t.setItems(dane);
		try {
			ps = conn.prepareStatement("SELECT * FROM projekty");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				dane.add(new Projekt(rs.getInt("id"), rs.getString("temat"), rs.getString("opis"),
						rs.getString("termin"), rs.getString("grupa"), rs.getInt("zrobione"), rs.getInt("ocena")));
			}
			t_idproj.setCellValueFactory(new PropertyValueFactory<Projekt, Integer>("id"));
			t_temat.setCellValueFactory(new PropertyValueFactory<Projekt, String>("temat"));
			t_opis.setCellValueFactory(new PropertyValueFactory<Projekt, String>("opis"));
			t_termin.setCellValueFactory(new PropertyValueFactory<Projekt, String>("termin"));
			t_grupa.setCellValueFactory(new PropertyValueFactory<Projekt, String>("grupa"));
			t_zrobione.setCellValueFactory(new PropertyValueFactory<Projekt, Integer>("zrobione"));
			t_ocena.setCellValueFactory(new PropertyValueFactory<Projekt, Integer>("ocena"));
			t.setItems(null);
			t.setItems(dane);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void initialize() {
		select();
	}

}
