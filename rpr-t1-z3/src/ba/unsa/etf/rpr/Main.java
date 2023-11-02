package ba.unsa.etf.rpr;

public class Main {
    public static void main(String[] args) {
       Clock c  = new Clock(15, 30, 45);
       c.Ispisi();
       c.Sljedeci();
       c.Ispisi();
       c.PomjeriZa(-48);
       c.Ispisi();
       c.Postavi(0,0,0);
       c.Ispisi();
    }
}