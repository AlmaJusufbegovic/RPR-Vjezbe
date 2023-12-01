package ba.unsa.etf.rpr;

public class Pobjednik {
    private String ime;
    private String prezime;
    private int brojZnakova;

    public Pobjednik(KolekcijaImenaIPrezimena kolekcijaImena) {
        String najduzeIme = kolekcijaImena.getNajduzeIme();
        String[] dijelovi = najduzeIme.split(" ");
        this.ime = dijelovi[0];
        this.prezime = dijelovi[1];
        this.brojZnakova = najduzeIme.length();
    }
    public Pobjednik(KolekcijaImena kolekcijaImena) {
        String najduzeIme = kolekcijaImena.getNajduzeIme();
        String[] dijelovi = najduzeIme.split(" ");
        this.ime = dijelovi[0];
        this.prezime = dijelovi[1];
        this.brojZnakova = najduzeIme.length();
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }
}
