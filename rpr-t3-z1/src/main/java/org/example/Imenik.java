package org.example;
import java.util.*;
public class Imenik {
    private Map<String, TelefoniskiBroj> brojevi;
    public Imenik(){ this.brojevi=new HashMap<String, TelefoniskiBroj>();}
    public Map<String, TelefoniskiBroj> getBrojevi(){ return brojevi;}
    public void setBrojevi(Map<String, TelefoniskiBroj> brojevi){this.brojevi=brojevi;}
    public void dodaj(String ime, TelefoniskiBroj broj){this.brojevi.put(ime,broj);}
    public String dajBroj(String ime) {
        TelefoniskiBroj broj = this.brojevi.get(ime);
        if (broj != null) {
            return broj.ispisi();
        } else {
            return null;
        }
    }

    public String dajIme(TelefoniskiBroj broj){
        for (Map.Entry <String, TelefoniskiBroj> entry: this.brojevi.entrySet()){
            if(entry.getValue().ispisi().equals(broj.ispisi())){
                return entry.getKey();
            }
        }
        return null;
    }
    public  String naSlovo(char c) {
        StringBuilder builder= new StringBuilder();
        int br=1;
        for (Map.Entry <String, TelefoniskiBroj> entry: this.brojevi.entrySet()){
            if (entry.getKey().startsWith(String.valueOf(c))){
                builder.append(br)
                        .append(". ")
                        .append(entry.getKey())
                        .append(" - ")
                        .append(entry.getValue().ispisi())
                        .append(System.lineSeparator());
            }
            br++;
        }
        return builder.toString();
    }
    public Set<String> izGrada(Grad g){
        Set<String> results =new TreeSet<String>();
        for (Map.Entry <String, TelefoniskiBroj> entry: this.brojevi.entrySet()){
            if (jelIzGrada(entry.getValue(),g)){
                results.add(entry.getKey());
            }
        }
        return results;
    }

    public Set<TelefoniskiBroj> IzGradaBrojevi(Grad g){
        Set<TelefoniskiBroj> results =new TreeSet<TelefoniskiBroj>(new Comparator<TelefoniskiBroj>(){
            @Override
            public int compare (TelefoniskiBroj o1, TelefoniskiBroj o2){return o1.ispisi().compareTo(o2.ispisi());}
        });
        for (Map.Entry <String, TelefoniskiBroj> entry: this.brojevi.entrySet()){
            if (jelIzGrada(entry.getValue(),g)){
                results.add(entry.getValue());
            }
        }
        return results;
    }
    private boolean jelIzGrada(TelefoniskiBroj broj, Grad g){
        if(broj instanceof FiksniBroj){
            return g.equals(((FiksniBroj) broj).getGrad());
        } else { return false;}
    }

    @Override
    public  String toString() {
        StringBuilder builder= new StringBuilder();
        int br=1;
        for (Map.Entry <String, TelefoniskiBroj> entry: this.brojevi.entrySet()){
                builder.append(br)
                        .append(". ")
                        .append(entry.getKey())
                        .append(" - ")
                        .append(entry.getValue().ispisi())
                        .append(System.lineSeparator());
            br++;
        }
        return builder.toString();
    }
}
