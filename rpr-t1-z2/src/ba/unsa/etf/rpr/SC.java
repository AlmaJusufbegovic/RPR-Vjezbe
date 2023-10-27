package ba.unsa.etf.rpr;

import java.util.Scanner;

public class SC{
    public static int sumaCifara(int a){
        if(a<0) a=-1*a;
        if(a>0 && a<=9) return a;
        int i=0, suma=0;
        while(a>0){
            i=a%10;
            suma+=i;
            a/=10;
        }
        return suma;
    }

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite n: ");
        int n = scanner.nextInt();
        for(int i=1; i<=n; i++){
            if(i%sumaCifara(i)==0)
                System.out.printf("%d ", i );
        }
    }
}