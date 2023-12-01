package ba.unsa.etf.rpr;

import java.util.List;

public class KolekcijaImenaIPrezimena {
    private List<String> imena;
    private List<String> prezimena;

    public KolekcijaImenaIPrezimena(List<String> imena, List<String> prezimena) {
        this.imena = imena;
        this.prezimena = prezimena;
    }

    public int getIndexNajduzegPara() {
        int maxIndex = 0;
        int maxDuljina = 0;
        for (int i = 0; i < imena.size(); i++) {
            String imePrezime = imena.get(i) + prezimena.get(i);
            int duljina = imePrezime.length();
            if (duljina > maxDuljina) {
                maxDuljina = duljina;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public String getImeiPrezime(int i) {
        return imena.get(i) + " " + prezimena.get(i);
    }

    public String getNajduzeIme() {
        String najduzeIme = "";
        for (String ime : imena) {
            if (ime.length() > najduzeIme.length()) {
                najduzeIme = ime;
            }
        }
        return najduzeIme;
    }
}
