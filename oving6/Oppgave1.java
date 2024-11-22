package oving6;

import java.util.Random;

public class Oppgave1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] antall = new int[10];
        for (int i = 0; i < 1000; i++) {
            int tall = random.nextInt(10);
            antall[tall] += 1;
        }
        for (int i = 0; i < antall.length; i++) {
            String stars = "*".repeat(antall[i]/10);
            System.out.println((i+1) +" " + antall[i]+" " + stars);
        }
    }
}