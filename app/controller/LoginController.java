package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.database.DBConnector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javafx.scene.Node;

public class LoginController {

	DBConnector db;

	@FXML
	private TextField tf_login;

	@FXML
	private PasswordField pf_login;

	@FXML
	private Button bt_login;

	@FXML
	void enterAction(KeyEvent event) {
		if (event.getCode().toString().equals("ENTER")) {
			loginMethod();
			((Node)(event.getSource())).getScene().getWindow().hide();
		}

	}

	@FXML
	void loginAction(MouseEvent event) {
		loginMethod();
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

	private void loginMethod() {
		System.out.println("Login method");
		String login = tf_login.getText();
		String pass = pf_login.getText();
		db = new DBConnector();
		Connection conn = db.connInit();
		ResultSet rs = null;
		try {
			Statement cursor = conn.createStatement();
			rs = cursor.executeQuery(
					"SELECT upraw FROM uzytkownicy WHERE login='" + login + "' and pass='" + pass + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (rs.next()) {
				String temp;
				String title;
				if (rs.getInt("upraw")==1) {
					temp = "TrenerView.fxml";
					title="Panel trenera";
				} else {
					temp = "KursantView.fxml";
					title="Panel kursanta2";
				}

				Stage stage = new Stage();
				Parent rodzic = null;
				Scene scenka = null;
				try {
					rodzic = (Parent) FXMLLoader.load(getClass().getResource("/app/view/" + temp));
				} catch (IOException e) {
					e.printStackTrace();
				}
				scenka = new Scene(rodzic);
				stage.setScene(scenka);
				stage.setTitle(title);
				stage.show();
			} else {
				Alert loginError = new Alert(AlertType.ERROR);
				loginError.setTitle("B³¹d logowania!");
				loginError.setHeaderText("Logowanie nieudane");
				loginError.setContentText("Has³o lub login s¹ niepoprawne!");
				loginError.showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
