package ba.unsa.etf.rpr;

public class implementacija implements MozeOcijeniti{
    @Override
    public Ocjena ocijeni(int x) {
        InformacijeOStudentu student = new InformacijeOStudentu("Nadja", "Kovacevic", 2, 19132);
        Ocjena novaOcjena = new Ocjena(student, x);
        return novaOcjena;
    }
}
