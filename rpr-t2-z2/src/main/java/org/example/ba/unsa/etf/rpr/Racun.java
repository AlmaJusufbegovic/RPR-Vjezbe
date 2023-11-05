package org.example.ba.unsa.etf.rpr;

public class Racun {
    private Long brRacuna;
    private Osoba korisnik;
    private boolean prekoracenje;
    private double stanje;

    public Racun(Long racun, Osoba korisnik){
        this.brRacuna=racun;
        this.korisnik=korisnik;
    }
    private boolean provjeriOdobenjePrekoracenja(double x){return prekoracenje;}
    public void izvrsiUplatu (double stanjeRacuna){this.stanje=stanjeRacuna;}
    public void odobriPrekoracenje(double x){this.prekoracenje=true;}

}
