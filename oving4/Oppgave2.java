package oving4;

import java.util.Scanner;

public class Oppgave2 {
    public static void main(String[] args) {
        System.out.println("---Terningspillet 100---\n");
        start();
    }


    public static void start() {
        System.out.println("Tast 1 for å starte");
        System.out.println("Tast -1 for å avslutte");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        
        if (input == 1) {
          startSpill();
        } else if (input == -1) {
            in.close();
            System.out.println("Avslutter programmet...");
            System.exit(0);
        } else {
          start();
        }
	}

    public static void startSpill() {
        Spiller[] spiller = new Spiller[3];
        spiller[0] = new Spiller(0);
        spiller[1] = new Spiller(0);

        int rundenummer = 0;

        while (!spiller[0].erFerdig(spiller[0].sumPoeng) && !spiller[1].erFerdig(spiller[1].sumPoeng)) {
            spiller[0].sumPoeng = spiller[0].kastTerningen(spiller[0].sumPoeng);
            spiller[1].sumPoeng = spiller[1].kastTerningen(spiller[1].sumPoeng);
            System.out.println("Rundenr: " + rundenummer + ", spiller 1: " + spiller[0].sumPoeng + ", spiller 2: " + spiller[1].sumPoeng);
            rundenummer += 1;
        }
        System.out.println("\n\n----------");
        if (spiller[0].erFerdig(spiller[0].sumPoeng) == true) {
            System.out.println("Spiller 1 vant!");
        }else {
            System.out.println("Spiller 2 vant!");
        }
        System.out.println("----------\n\n");


        System.out.println("Tast 1 for å spille igjen");
        System.out.println("Tast -1 for å avslutte");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        if (input == 1) {
            startSpill();
          } else if (input == -1) {
              in.close();
              System.out.println("Avslutter programmet...");
              System.exit(0);
          } else {
            start();
          }
    }
}
