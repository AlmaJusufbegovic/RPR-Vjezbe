package org.example;
public class Klasa {
    public static int fakt(int a){
        int f=1;
        for(int i=1; i<=a; i++){
            f*=i;
        }
        return f;
    }
    public static double sinus(int a){
        double sin=Math.sin(a);
        return sin;
    }
}