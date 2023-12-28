package ba.unsa.etf.rpr;

public class Grad {
    private int grad_id;
    private String naziv;
    private int broj_stanovnika;
    private int drzava;

    public Grad(int grad_id, String naziv, int broj_stanovnika, int drzava) {
        this.grad_id = grad_id;
        this.naziv = naziv;
        this.broj_stanovnika = broj_stanovnika;
        this.drzava = drzava;
    }

    public Grad() {
    }

    public int getGrad_id() {
        return grad_id;
    }

    public void setGrad_id(int id) {
        this.grad_id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBroj_stanovnika() {
        return broj_stanovnika;
    }

    public void setBroj_stanovnika(int broj_stanovnika) {
        this.broj_stanovnika = broj_stanovnika;
    }

    public int getDrzava() {
        return drzava;
    }

    public void setDrzava(int drzava) {
        this.drzava = drzava;
    }

    public void setDrzava(Drzava drzava) {
    }
}
