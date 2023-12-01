package ba.unsa.etf.rpr;

public class Predmet {

    private String naziv, opis;
    public String getNaziv() {
        return naziv;
    }

    public Predmet(String naziv, String opis) {
        this.naziv = naziv;
        this.opis = opis;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
