package org.example.ba.unsa.etf.rpr;

public class Osoba {
    private String ime;
    private String prezime;
    public Osoba(String i, String p){
        this.ime=ime;
        this.prezime=prezime;
    }
    @Override
    public String toString(){
        return ime + " " + prezime;
    }
}