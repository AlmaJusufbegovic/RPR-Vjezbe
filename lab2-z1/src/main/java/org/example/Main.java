package org.example;

import java.util.Scanner;

import static org.example.Klasa.fakt;
import static org.example.Klasa.sinus;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite n: ");
        int n = scanner.nextInt();

        System.out.printf("Faktorijel unesenog broja je: %d\n", fakt(n));
        System.out.printf("Sinus unesenog broja je: %f", sinus(n));
    }
}