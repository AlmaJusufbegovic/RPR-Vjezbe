package ba.unsa.etf.rpr;

public class Main {
    public static void main(String[] args) {

        InformacijeOStudentu infoStudent1 = new InformacijeOStudentu("Zehra", "Pajić", 2, 18332);
        System.out.println("Ime: " + infoStudent1.getIme()+
                "\nPrezime: " + infoStudent1.getPrezime()+
                "\nGodina studija: " + infoStudent1.getGodinaStudija()+
                 "\nBroj indexa: " + infoStudent1.getBrojIndexa());

        InformacijeOStudentu infoStudent2 = new InformacijeOStudentu("Amra", "Jusufbegović", 3, 19332);
        System.out.println("Ime: " + infoStudent2.getIme()+
                "\nPrezime: " + infoStudent2.getPrezime()+
                "\nGodina studija: " + infoStudent2.getGodinaStudija()+
                "\nBroj indexa: " + infoStudent2.getBrojIndexa());

        InformacijeOStudentu infoStudent3 = new InformacijeOStudentu("Dino", "Avdušinovič", 2, 18221);
        System.out.println("Ime: " + infoStudent3.getIme()+
                "\nPrezime: " + infoStudent3.getPrezime()+
                "\nGodina studija: " + infoStudent3.getGodinaStudija()+
                "\nBroj indexa: " + infoStudent3.getBrojIndexa());

        InformacijeOStudentu infoStudent4 = new InformacijeOStudentu("Emina", "Šljivo", 1, 19222);
        System.out.println("Ime: " + infoStudent4.getIme()+
                "\nPrezime: " + infoStudent4.getPrezime()+
                "\nGodina studija: " + infoStudent4.getGodinaStudija()+
                "\nBroj indexa: " + infoStudent4.getBrojIndexa());

        InformacijeOStudentu infoStudent5 = new InformacijeOStudentu();
        infoStudent5.setIme("Amar");
        infoStudent5.setPrezime("Biber");
        infoStudent5.setBrojIndexa(15512);
        infoStudent5.setGodinaStudija(3);

        System.out.println("Ime: " + infoStudent5.getIme()+
                "\nPrezime: " + infoStudent5.getPrezime()+
                "\nGodina studija: " + infoStudent5.getGodinaStudija()+
                "\nBroj indexa: " + infoStudent5.getBrojIndexa());

        InformacijeONastavniku infoNastavnik1 = new InformacijeONastavniku("Daria", "Jozić", "PhD");
        System.out.println("Ime: " + infoNastavnik1.getIme()+
                "\nPrezime: " + infoNastavnik1.getPrezime()+
                "\nTitula: " + infoNastavnik1.getTitula());

        InformacijeONastavniku infoNastavnik2 = new InformacijeONastavniku("Mirza", "Hamza", "PhD");
        System.out.println("Ime: " + infoNastavnik2.getIme()+
                "\nPrezime: " + infoNastavnik2.getPrezime()+
                "\nTitula: " + infoNastavnik2.getTitula());

        Predmet sub1 = new Predmet ("Diskretna matematika", "5 ECTS bodova");
        System.out.println("Naziv predmeta: " + sub1.getNaziv()+ "\nOpis: " + sub1.getOpis());
        Predmet sub2 = new Predmet ("Razvoj programskih rješenja", "5 ECTS bodova");
        System.out.println("Naziv predmeta: " + sub2.getNaziv()+ "\nOpis: " + sub2.getOpis());
        Predmet sub3 = new Predmet ("Algoritmi i strukture podataka", "5 ECTS bodova");
        System.out.println("Naziv predmeta: " + sub3.getNaziv()+ "\nOpis: " + sub3.getOpis());
        Predmet sub4 = new Predmet ("Logički dizajn", "5 ECTS bodova");
        System.out.println("Naziv predmeta: " + sub4.getNaziv()+ "\nOpis: " + sub4.getOpis());
        Predmet sub5 = new Predmet ("Osnove baza podataka", "5 ECTS bodova");
        System.out.println("Naziv predmeta: " + sub5.getNaziv()+ "\nOpis: " + sub5.getOpis());
        Predmet sub6 = new Predmet ("Sistemsko programiranje", "5 ECTS bodova");
        System.out.println("Naziv predmeta: " + sub6.getNaziv()+ "\nOpis: " + sub6.getOpis());

        KolekcijaPoruka<InformacijeOStudentu> kolekcijaInformacijaStudenta = new KolekcijaPoruka<>();
        System.out.println("Unesite poruku o: " +infoStudent1.getIme());
        kolekcijaInformacijaStudenta.dodajPoruku(infoStudent1);
        System.out.println("Unesite poruku o: " +infoStudent2.getIme());
        kolekcijaInformacijaStudenta.dodajPoruku(infoStudent2);
        System.out.println("Unesite poruku o: " +infoStudent3.getIme());
        kolekcijaInformacijaStudenta.dodajPoruku(infoStudent3);
        System.out.println("Unesite poruku o: " +infoStudent4.getIme());
        kolekcijaInformacijaStudenta.dodajPoruku(infoStudent4);
        kolekcijaInformacijaStudenta.prikaziPoruke();

        KolekcijaPoruka<InformacijeONastavniku> kolekcijaInformacijaNastavnika = new KolekcijaPoruka<>();
        System.out.println("Unesite poruku o: " +infoNastavnik1.getIme());
        kolekcijaInformacijaNastavnika.dodajPoruku(infoNastavnik1);
        System.out.println("Unesite poruku o: " +infoNastavnik2.getIme());
        kolekcijaInformacijaNastavnika.dodajPoruku(infoNastavnik2);
        kolekcijaInformacijaNastavnika.prikaziPoruke();

        KolekcijaPoruka<Predmet> kolekcijaPredmeta = new KolekcijaPoruka<>();
        System.out.println("Unesite poruku o predmetu: " + sub1.getNaziv());
        kolekcijaPredmeta.dodajPoruku(sub1);
        System.out.println("Unesite poruku o predmetu: " + sub2.getNaziv());
        kolekcijaPredmeta.dodajPoruku(sub2);
        System.out.println("Unesite poruku o predmetu: " + sub3.getNaziv());
        kolekcijaPredmeta.dodajPoruku(sub3);
        System.out.println("Unesite poruku o predmetu: " + sub4.getNaziv());
        kolekcijaPredmeta.dodajPoruku(sub4);
        System.out.println("Unesite poruku o predmetu: " + sub5.getNaziv());
        kolekcijaPredmeta.dodajPoruku(sub5);
        System.out.println("Unesite poruku o predmetu: " + sub6.getNaziv());
        kolekcijaPredmeta.dodajPoruku(sub6);
        kolekcijaPredmeta.prikaziPoruke();
    }
}
