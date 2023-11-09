package org.example;
import java.util.Scanner;
import java.util.Set;
public class Program {
    public static Scanner scanner= new Scanner(System.in);
    public static Imenik imenik=new Imenik();
    public static void main(String[]agrs){
        popuniPodatke();
        while (true){
            System.out.println("Unesite komandu (dodaj, dajBroj, dajIme, naSlovo, izGrada, izGradaBrojevi, Imenik, Izlaz): )");
            String command =scanner.nextLine();
            switch (command){
                case "dodaj":
                    dodajBroj();
                    break;
                case "dajBroj":
                    dajBroj();
                    break;
                case "dajIme":
                    dajIme();
                    break;
                case "naSlovo":
                    naSlovo();
                    break;
                case "izGrada":
                    izGrada();
                    break;
                case "izGadaBrojevi":
                    izGradaBrojevi();
                    break;
                case "Imenik":
                    ispisiImenik();
                    break;
                case "Izlaz":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pogresna komanda!");
            }
        }
    }
    private static void izGradaBrojevi(){
        System.out.println("Unesite ime grada: ");
        String grad= scanner.nextLine();
        try{
            Grad g= Grad.valueOf(grad);
            Set<TelefoniskiBroj> response=imenik.IzGradaBrojevi(g);
            for (TelefoniskiBroj b: response){
                System.out.println(b.ispisi());
            }
        } catch (java.lang.Exception e){
            System.out.println("Pogresan grad");
            return;
        }
    }

    private static void izGrada(){
        System.out.println("Unesite ime grada: ");
        String grad = scanner.nextLine();
        try {
            Grad g= Grad.valueOf(grad);
            Set<String> response = imenik.izGrada(g);
            System.out.println(response);
        } catch (Exception e){
            System.out.println("Pogresan grad");
            return;
        }
    }
    private static void naSlovo(){
        System.out.println("Unesite prvo slovo imena: ");
        String c= scanner.nextLine();
        String response = imenik.naSlovo(c.toCharArray()[0]);
        System.out.println(response);
    }
    private static void dajIme(){
        TelefoniskiBroj br = unesiBrojTelefona();
        String ime = imenik.dajIme(br);
        if(ime == null){
            System.out.println("Ne postoji u imeniku");
        } else {
            System.out.println("Vlasnik broja "+ br.ispisi()+" je"+ ime);
        }
    }

    private static TelefoniskiBroj unesiBrojTelefona(){
        System.out.println("Unesite tip broja[fiksni, mobilni, medunarodni: ]");
        String type= scanner.nextLine();
        switch (type){
            case "fiksni":
                System.out.println("Unesite pozivni: ");
                String pozivni=scanner.nextLine();
                System.out.println("Unesite broj: ");
                String broj= scanner.nextLine();
                return new FiksniBroj(Grad.izPozivnog(pozivni), broj);

            case "mobilni":
                System.out.println("Unesite mrezu: ");
                int mreza=scanner.nextInt();
                System.out.println("Unesite broj: ");
                String mobBroj= scanner.nextLine();
                return new MobilniBroj(mreza, mobBroj);

            case "medunarodni":
                System.out.println("Unesite kod drzave [+387]: ");
                String kod=scanner.nextLine();
                System.out.println("Unesite broj: ");
                String medBroj= scanner.nextLine();
                return new MedunarodniBroj(kod, medBroj);
        }
        return null;
    }
    private static void dodajBroj() {
        System.out.println("Unesite ime: ");
        String name=scanner.nextLine();
        TelefoniskiBroj br = unesiBrojTelefona();
        imenik.dodaj(name, br);
    }
    private static void ispisiImenik(){ System.out.println(imenik.toString());}

    private static void dajBroj(){
        System.out.println("Unesite ime: ");
        String ime = scanner.nextLine();
        String rezultat = imenik.dajBroj(ime);
        System.out.println(rezultat==null ? "Nema u imeniku." : rezultat);
    }

    private static void popuniPodatke(){
        imenik.dodaj("Selma", new FiksniBroj(Grad.Sarajevo, "554-223"));
        imenik.dodaj("Enis", new FiksniBroj(Grad.Mostar, "323-537"));
        imenik.dodaj("Zerina", new MobilniBroj(62, "554-434"));
        imenik.dodaj("Zehra", new FiksniBroj(Grad.Konjic, "043-456"));
        imenik.dodaj("Sara", new MobilniBroj(61, "212-939"));
        imenik.dodaj("Lejla", new MobilniBroj(60, "54-23-331"));
        imenik.dodaj("Tarik", new FiksniBroj(Grad.Kakanj, "355-789"));
        imenik.dodaj("Sanja", new FiksniBroj(Grad.Sarajevo, "663-456"));
        imenik.dodaj("Sandra", new MedunarodniBroj("+44", "0987891100"));
        imenik.dodaj("Benjamin", new FiksniBroj(Grad.Tuzla, "990-677"));
        imenik.dodaj("Elvedina", new MobilniBroj(63, "112-289"));
        imenik.dodaj("Mina", new MedunarodniBroj("+381", "663442331"));
        imenik.dodaj("Nina", new MedunarodniBroj("+385", "974564443"));
        imenik.dodaj("Nadja", new MobilniBroj(63, "442-543"));
        imenik.dodaj("Faris", new FiksniBroj(Grad.Bijeljina, "231-432"));
        imenik.dodaj("Adna", new FiksniBroj(Grad.Bihać, "458-898"));
        imenik.dodaj("Tijana", new MedunarodniBroj("+385", "442211789"));

    }
}
