package org.example.ba.unsa.etf.rpr;

import java.util.List;

public class Banka {
    private Long brRacuna;
    private List<Korisnik> korisnici;
    private List<Uposlenik> uposlenici;

    public Banka() {}
    public Korisnik kreirajNovogKorisnika(String ime, String prezime) {
        return new Korisnik(ime, prezime);
    }

    public Uposlenik kreirajNovogUposlenika(String ime, String prezime) {
        return new Uposlenik(ime, prezime);
    }

    public Racun kreirajRacunZaKorisnika(Korisnik noviKorisnik) {
        return new Racun(brRacuna, noviKorisnik);
    }
}
