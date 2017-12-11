package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

	PreparedStatement ps;
	Connection conn;
	DBConnector db;
	
	String login;

	public void initialize() {
		login = LoginController.login;
		
		polacz();
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
		
	}
	
	private void polacz() {
		db = new DBConnector();
		conn = db.connInit();
	}

}
