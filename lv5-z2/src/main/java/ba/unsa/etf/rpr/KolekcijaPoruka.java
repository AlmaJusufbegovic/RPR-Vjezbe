package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class KolekcijaPoruka<Tip>{
    private List<Poruka> poruke;
    //public static Scanner scanner= new Scanner(System.in);

    public KolekcijaPoruka() {
        this.poruke = new ArrayList<>();
    }

    public List<Poruka> getPoruke() {return poruke;}

    public void dodajPoruku(Tip ko, Poruka novaPoruka) { this.poruke.add(novaPoruka);}

    // Prikazivanje svih poruka u kolekciji
    public void prikaziPoruke() {
        for (Poruka poruka : poruke) {
            System.out.println(poruka);
        }
    }
}
