package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> imena1 = new ArrayList<>();
        imena1.add("MIrza Hamza");
        imena1.add("Lejla Seila");
        KolekcijaImena staraKolekcija = new KolekcijaImena(imena1);
        Pobjednik pobjednik1 = new Pobjednik(staraKolekcija);
        System.out.println("Ime pobjednika: " + pobjednik1.getIme());

        // Nova kolekcija
        List<String> imena2 = new ArrayList<>();
        List<String> prezimena2 = new ArrayList<>();
        imena2.add("Mirsad");
        prezimena2.add("Delic");
        imena2.add("Lamija");
        prezimena2.add("Terzic");
        KolekcijaImenaIPrezimena novaKolekcija = new KolekcijaImenaIPrezimena(imena2, prezimena2);
        Pobjednik pobjednik2 = new Pobjednik(novaKolekcija);
        System.out.println("Prezime pobjednika: " + pobjednik2.getPrezime());
    }
}
