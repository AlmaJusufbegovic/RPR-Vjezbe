package com.example.lv7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.*;


public class HelloController {
    private KorisniciModel model = new KorisniciModel();

    //public HelloController(KorisniciModel model) {this.model = model;}

    @FXML
    private Button add;

    @FXML
    private Button end;

    @FXML
    private ListView listOfUsers = new ListView();

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private TextField surname;

    @FXML
    private TextField username;


    @FXML
    private void addKorisnik(ActionEvent actionEvent) {
        listOfUsers.getSelectionModel().selectLast();
        model.dodajPraznogKorisnika();
        System.out.println("User added successfully");
    }

    @FXML
    private void exit(ActionEvent event) {
        System.out.println("Action finished successfully");
        System.exit(0);
    }

    @FXML
    public void initialize() {
        model.napuni();
        listOfUsers.setItems(model.getUsers());

        listOfUsers.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            if (newKorisnik != null) {
                name.textProperty().unbindBidirectional(model.getTrenutni().get().nameProperty());
                surname.textProperty().unbindBidirectional(model.getTrenutni().get().surnameProperty());
                email.textProperty().unbindBidirectional(model.getTrenutni().get().eMailProperty());
                username.textProperty().unbindBidirectional(model.getTrenutni().get().usernameProperty());
                password.textProperty().unbindBidirectional(model.getTrenutni().get().passwordProperty());

                model.setTrenutni((Korisnik) newKorisnik);

                name.textProperty().bindBidirectional(model.getTrenutni().get().nameProperty());
                surname.textProperty().bindBidirectional(model.getTrenutni().get().surnameProperty());
                email.textProperty().bindBidirectional(model.getTrenutni().get().eMailProperty());
                username.textProperty().bindBidirectional(model.getTrenutni().get().usernameProperty());
                password.textProperty().bindBidirectional(model.getTrenutni().get().passwordProperty());
                listOfUsers.refresh();
            }
        });
    }
}
