package ba.unsa.etf.rpr;

public class InformacijeOStudentu extends LicneInformacije{
    private int godinaStudija;
    private int brojIndexa;

    public InformacijeOStudentu(String ime, String prezime, int godinaStudija, int brojIndexa) {
        super(ime, prezime);
        this.godinaStudija = godinaStudija;
        this.brojIndexa = brojIndexa;
    }

    public InformacijeOStudentu(){
    }

    public int getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(int godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public int getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(int brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return "InformacijeOStudentu{" +
                "godinaStudija=" + godinaStudija +
                ", brojIndexa=" + brojIndexa +
                '}';
    }
}
