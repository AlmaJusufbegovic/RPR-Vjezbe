package ba.unsa.etf.rpr;
public class Poruka {
    private String mess;

    public Poruka(String mess) {
        this.mess = mess;
    }

    public void predstavi(){
        System.out.println(this.mess);
    }
}
