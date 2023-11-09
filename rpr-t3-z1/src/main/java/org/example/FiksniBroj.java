package org.example;

import java.util.Objects;

public class FiksniBroj extends TelefoniskiBroj {
    private Grad grad;
    public String broj;
    public FiksniBroj(Grad grad, String broj){
        if(null==broj) throw new BrException("NEVAZECI POZIVNI BROJ");
        this.broj=broj;
        this.grad=grad;
    }
    @Override
    public String ispisi(){
        if(grad!=null && broj!=null){
            return grad.getPozivniBroj()+"/"+broj;
        } else {
            return null;
        }
    }
    @Override
    public int hashCode(){return Objects.hash(grad, broj);}
    public Grad getGrad(){return grad;}
    public String getBroj() {return broj;}

}
