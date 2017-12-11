package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.database.DBConnector;
import app.model.Projekt;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

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

	PreparedStatement ps;
	Connection conn;
	DBConnector db;
	int id_selected;
    
    @FXML
    void ocenProjektAction(MouseEvent event) {
    	

    }

    @FXML
    void odznaczProjektAction(MouseEvent event) {

    }
    
    
	private void connection() {
		db = new DBConnector();
		conn = db.connInit();
	}

	private void select() {
		connection();
		dane.clear();
		t.setItems(dane);
		ps = conn.prepareStatement("SELECT * FROM ankieta");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
		}

		
	}
    
	public void initialize() {
		select();
	}
    

}
