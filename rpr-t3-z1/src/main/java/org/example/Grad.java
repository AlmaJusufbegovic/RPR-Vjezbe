package org.example;

public enum Grad {
    Fojnica ("030"),
    Jajce ("030"),
    Kiseljak ("030"),
    Kreševo ("030"),
    Travnik ("030"),
    Vitez ("030"),
    Odžak ("031"),
    Orašje ("031"),
    Kakanj ("032"),
    Maglaj ("032"),
    Olovo ("032"),
    Tešanj ("032"),
    Visoko ("032"),
    Zavidovići ("032"),
    Zenica ("032"),
    Žepče ("032"),
    Sarajevo ("033"),
    Livno ("034"),
    Srebrenik ("035"),
    Tuzla ("035"),
    Čapljina ("036"),
    Konjic ("036"),
    Jablanica ("036"),
    Mostar ("036"),
    Neum ("036"),
    Stolac("036"),
    Bihać ("037"),
    Goražde ("038"),
    Posušje ("039"),
    MrkonjićGrad ("050"),
    BanjaLuka ("051"),
    Prijedor ("052"),
    Doboj ("053"),
    Šamac ("054"),
    Bijeljina ("055"),
    Zvornik ("056"),
    Pale ("057"),
    Foča ("058"),
    Trebinje("059"),
    Brčko("049");

    private String pozivniBroj;
    Grad (String pozivniBroj) {this.pozivniBroj=pozivniBroj;}
    public static Grad izPozivnog(String pozivni){
        for(Grad g: Grad.values()){
            if(g.getPozivniBroj().equals(pozivni)){
                return g;
            }
        }
        return null;
    }
    public String getPozivniBroj(){return pozivniBroj;}
}