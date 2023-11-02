package ba.unsa.etf.rpr;
public class Clock {
    private int h;
    private int min;
    private int sec;
    public Clock(int h, int min, int sec){
        this.Postavi(h, min, sec);
    }
    public void Postavi(int h, int min, int sec){
        this.h=h;
        this.min=min;
        this.sec=sec;
    }
    public void Sljedeci(){
        this.sec++;
        if(this.sec==60){this.sec=0; this.min++;}
        if(this.min==60){this.min=0; this.h++;}
        if(this.h==24){this.h=0;}
    }
    public void Prethodni() {
        this.sec--;
        if(this.sec==-1){this.sec=59; this.min--;}
        if(this.min==-1){this.min=59; this.h--;}
        if(this.h==-1){this.h=23;}
    }
    public void PomjeriZa(int pomak){
        if(pomak>0)
            for (int i=0; i<pomak; i++) this.Sljedeci();
        else for(int i=0; i<-pomak; i++) this.Prethodni();
    }
    public int DajSate() {return this.h;}
    public int DajMinute() {return this.min;}
    public int DajSekunde(){return this.sec;}
    public void Ispisi(){System.out.println(+h+":"+min+":"+sec);}
}