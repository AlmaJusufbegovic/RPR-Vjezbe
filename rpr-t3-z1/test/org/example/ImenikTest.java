package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class ImenikTest {
    private static Imenik imenik= new Imenik();

    @BeforeAll
    public static void setup(){
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

    @Test
    public void dajBrojFound(){
        String broj= imenik.dajBroj("Selma");
        assertEquals(broj,"033/554-223");
    }
    @Test
    public void dajBrojNotFound(){
        String broj= imenik.dajBroj("Edin");
        assertNull(broj);
    }

     @Test
    public void dodajTestPositive(){
        TelefoniskiBroj br = new MobilniBroj(62, "543-121");
        imenik.dodaj("Almedina", br);
        String brojStr = imenik.dajBroj("Almedina");
        assertEquals(brojStr, "062/543-121");
     }

     @Test
    public void dodajFiksniException(){
        assertThrows(BrException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new FiksniBroj(null, "111-111");
            }
        });
        assertThrows(BrException.class, () -> {new FiksniBroj(null,"111-111");});
     }

}