package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.Projekt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class KursantController {

	@FXML
	private Button btn_sub1;

	@FXML
	private Button btn_sub2;

	@FXML
	private Button btn_sub3;

	@FXML
	private Button btn_sub4;

	@FXML
	private Label lbl_name;

	@FXML
	private Label lbl_last;

	@FXML
	private Label lbl_group;

	@FXML
	private Label lbl_phone;

	@FXML
	private Label lbl_email;

	@FXML
	private Label lbl_github;
	
	@FXML
    private TableView<Projekt> tbl;

    @FXML
    private TableColumn<Projekt, String> tbl_temat;

    @FXML
    private TableColumn<Projekt, String> tbl_opis;

    @FXML
    private TableColumn<Projekt, String> tbl_termin;
    
    public ObservableList<Projekt> dane = FXCollections.observableArrayList();

	PreparedStatement ps;
	Connection conn;
	DBConnector db;
	
	String login;

	public void initialize() {
		login = LoginController.login;
		select();
		
	}
	
	private void select(){
		polacz();
		dane.clear();
		try {
			ps = conn.prepareStatement("SELECT * FROM uzytkownicy WHERE login = '"+login+"';");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				lbl_name.setText(rs.getString("imie"));
				lbl_last.setText(rs.getString("nazwisko"));
				lbl_group.setText(rs.getString("grupa"));
				lbl_phone.setText(rs.getString("telefon"));
				lbl_email.setText(rs.getString("mail"));
				lbl_github.setText(rs.getString("github"));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ps = conn.prepareStatement("select temat,opis, termin from projekty join uzytkownicy on projekty.grupa = uzytkownicy.grupa where uzytkownicy.login = '"+login+"' and zrobione=0;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dane.add(new Projekt(rs.getString("temat"), rs.getString("opis"),rs.getString("termin")));
			}
			tbl_temat.setCellValueFactory(new PropertyValueFactory<Projekt, String>("temat"));
			tbl_opis.setCellValueFactory(new PropertyValueFactory<Projekt, String>("opis"));
			tbl_termin.setCellValueFactory(new PropertyValueFactory<Projekt, String>("termin"));

			tbl.setItems(null);
			tbl.setItems(dane);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
    @FXML
    void submitAction(MouseEvent event) {
    	String temat_selected = "";
		try {
			temat_selected = tbl.getSelectionModel().getSelectedItem().getTemat();
		} catch (Exception e) {
			Alert loginError = new Alert(AlertType.ERROR);
			loginError.setTitle("B³¹d!");
			loginError.setHeaderText("B³¹d");
			loginError.setContentText("B³¹d!!!!");
			loginError.showAndWait();
		}
		
		polacz();
		try {
			ps = conn.prepareStatement("update projekty set zrobione = 1 where temat = ?;");
			ps.setString(1, temat_selected);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		select();
    }
	
	private void polacz() {
		db = new DBConnector();
		conn = db.connInit();
	}

}
