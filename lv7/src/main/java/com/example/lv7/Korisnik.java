package com.example.lv7;

import javafx.beans.property.*;

public class Korisnik {
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty surname = new SimpleStringProperty("");
    private SimpleStringProperty username = new SimpleStringProperty("");
    private SimpleStringProperty eMail = new SimpleStringProperty("");
    private SimpleStringProperty password = new SimpleStringProperty("");

    public Korisnik(String a, String b, String c, String d, String e) {
        name = new SimpleStringProperty(a);
        surname = new SimpleStringProperty(b);
        username = new SimpleStringProperty(c);
        eMail = new SimpleStringProperty(d);
        password = new SimpleStringProperty(e);

    }

    public Korisnik() {

    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String geteMail() {
        return eMail.get();
    }

    public SimpleStringProperty eMailProperty() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail.set(eMail);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    @Override
    public String toString() {
        return name.get()+" "+surname.get();
    }
}
