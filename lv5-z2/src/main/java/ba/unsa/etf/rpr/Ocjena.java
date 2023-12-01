package ba.unsa.etf.rpr;

public class Ocjena {
    private LicneInformacije osoba;
    private int ocjena;

    // Konstruktor klase Ocjena
    public Ocjena(LicneInformacije osoba, int ocjena) {
        this.osoba = osoba;
        if (ocjena > 0 && ocjena < 10) {
            this.ocjena = ocjena;
        } else {
            this.ocjena = -1;
            System.out.println("Neispravna ocjena! Ocjena mora biti između 1 i 9.");
        }
    }
    public void postaviOcjenu(int novaOcjena) {
        if (novaOcjena > 0 && novaOcjena < 10) {
            this.ocjena = novaOcjena;
        } else {
            System.out.println("Neispravna ocjena! Ocjena mora biti između 1 i 9.");
        }
    }

    // Getteri za pristup atributima klase Ocjena
    public LicneInformacije getOsoba() {
        return osoba;
    }

    public int getOcjena() {
        return ocjena;
    }
}
}
