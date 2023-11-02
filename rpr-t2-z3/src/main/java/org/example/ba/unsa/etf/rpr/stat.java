package org.example.ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class stat {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite brojeve (ili 'stop' za kraj unosa):");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("stop")) {
                break;
            }

            try {
                double number = Double.parseDouble(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Neispravan unos. Molimo unesite broj ili 'stop' za kraj unosa.");
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("Nema unesenih brojeva.");
        } else {
            double min = numbers.stream().min(Double::compareTo).get();
            double max = numbers.stream().max(Double::compareTo).get();
            double mean = numbers.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            double sumOfSquares = numbers.stream().mapToDouble(num -> Math.pow(num - mean, 2)).sum();
            double standardDeviation = Math.sqrt(sumOfSquares / numbers.size());

            System.out.println("Minimum: " + min);
            System.out.println("Maksimum: " + max);
            System.out.println("Prosjek: " + mean);
            System.out.println("Standardna devijacija: " + standardDeviation);
        }

        scanner.close();
    }
}
