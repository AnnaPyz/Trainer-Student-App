package app.controller;

import javafx.fxml.FXML;
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
    
    static int proj_nowa_ocena;
    
    @FXML
    void dodajOcene0Action(MouseEvent event) {
    	proj_nowa_ocena = 0;
    }
    @FXML
    void dodajOcene10Action(MouseEvent event) {
    	proj_nowa_ocena = 10;
    }
    @FXML
    void dodajOcene2Action(MouseEvent event) {
    	proj_nowa_ocena = 2;
    }
    @FXML
    void dodajOcene4Action(MouseEvent event) {
    	proj_nowa_ocena = 4;
    }
    @FXML
    void dodajOcene6Action(MouseEvent event) {
    	proj_nowa_ocena = 6;
    }
    @FXML
    void dodajOcene8Action(MouseEvent event) {
    	proj_nowa_ocena = 8;
    }

}
