package app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
