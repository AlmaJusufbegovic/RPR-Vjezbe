package org.example;

import java.util.Objects;
public class MedunarodniBroj extends TelefoniskiBroj {
    private String drzava;
    private String broj;
    public MedunarodniBroj(String drzava, String broj){
        this.drzava=drzava;
        this.broj=broj;
    }
    @Override
    public String ispisi(){
        if(broj!=null && drzava!=null){ return drzava+broj;}
        else { return null; }
    }
    @Override
    public int hashCode(){return Objects.hash(drzava,broj);}
}
