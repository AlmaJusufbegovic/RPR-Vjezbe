package com.example.lv7;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {

    private ObservableList<Korisnik> users = FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutni= new SimpleObjectProperty();

    public ObservableList<Korisnik> getUsers() {
        return users;
    }

    public void setUsers(ObservableList<Korisnik> users) {
        this.users = users;
    }

    public SimpleObjectProperty<Korisnik> getTrenutni() {
        return trenutni;
    }
    public void setTrenutni(Korisnik trenutni) {
        this.trenutni.set(trenutni);
    }

    public ObservableList<Korisnik> getKorisnik() {
        return users;
    }


    public void napuni(){
        //users.add(new Korisnik("Amir", "Spahić", "AS1999","aspahi1@etf.unsa.ba","12345"));
        //users.add(new Korisnik("Šeila", "Macić", "SM1998","smaci1@etf.unsa.ba","11111"));
        //users.add(new Korisnik("Marko", "Jurić", "MJ1998","mjuri1@etf.unsa.ba","22222"));
        users.add(new Korisnik("Lejla", "Alibegović", "LA2001","lalibego1@etf.unsa.ba","33333"));
        users.add(new Korisnik("Tarik", "Zaklan", "TZ2002","tzak@etf.unsa.ba","44444"));
        users.add(new Korisnik("Dijana", "Novalić", "DN2000","dnova1@etf.unsa.ba","55555"));
        trenutni.set(users.get(0));
    }

    public void dodajPraznogKorisnika() {
        Korisnik noviKorisnik = new Korisnik("", "", "", "", "");
        users.add(noviKorisnik);
        setTrenutni(noviKorisnik);
    }
}
