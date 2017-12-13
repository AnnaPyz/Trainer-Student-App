package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.database.DBConnector;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class TrenerProjektyOcenOcenaController {
    @FXML
    private Button btn_0;
    @FXML
    private Button btn_2;
    @FXML
    private Button btn_4;
    @FXML
    private Button btn_6;
    @FXML
    private Button btn_8;
    @FXML
    private Button btn_10;
    
    int proj_nowa_ocena;
    
    PreparedStatement ps;
	Connection conn;
	DBConnector db;
    
    @FXML
    void dodajOcene0Action(MouseEvent event) {
    	proj_nowa_ocena = 0;
    	update();
    	((Node) (event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    void dodajOcene10Action(MouseEvent event) {
    	proj_nowa_ocena = 10;
    	update();
    	((Node) (event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    void dodajOcene2Action(MouseEvent event) {
    	proj_nowa_ocena = 2;
    	update();
    	((Node) (event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    void dodajOcene4Action(MouseEvent event) {
    	proj_nowa_ocena = 4;
    	update();
    	((Node) (event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    void dodajOcene6Action(MouseEvent event) {
    	proj_nowa_ocena = 6;
    	update();
    	((Node) (event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    void dodajOcene8Action(MouseEvent event) {
    	proj_nowa_ocena = 8;
    	update();
    	((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    private void connection() {
		db = new DBConnector();
		conn = db.connInit();
	}
    
	private void update(){
		connection();		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("update projekty set ocena = ? where id = ?;");
			System.out.println("Jestem w update");
		ps.setInt(1, proj_nowa_ocena);
		ps.setInt(2, TrenerProjektyOcenController.proj_id_selected);
		ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
