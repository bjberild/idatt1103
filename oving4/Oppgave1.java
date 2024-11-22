package oving4;

import java.util.*;

public class Oppgave1 {
    public static Valuta[] valuta = new Valuta[3];

    public static void main(String[] args) {
        valuta[0] = new Valuta(11.92d, "euro");
        valuta[1] = new Valuta(10.78d, "amerikanske dollar");
        valuta[2] = new Valuta(1.04d, "svenske kroner");
        System.out.println("---Valutakalkulator---");
        visMeny();
    }

    public static void visMeny() {
        Scanner in = new Scanner(System.in);
        System.out.println("Tast 1 for euro");
        System.out.println("Tast 2 for amerikanske dollar");
        System.out.println("Tast 3 for svenske kroner");
        System.out.println("Tast 4 for å avslutte");

        int menyInput = in.nextInt();

        if (menyInput == 4) {
            in.close();
            System.out.println("Avslutter programmet...");
            System.exit(0);
        }else if (menyInput != 1 && menyInput != 2 && menyInput != 3) {
            System.out.println("Du må taste inn et tall mellom 1 og 4");
            visMeny();
        }else {
            konverter(menyInput);
        }

    }
    
    public static void konverter(int valutaId) {
        Scanner in = new Scanner(System.in);

        System.out.println("\nSkal du konvertere fra eller til norske kroner?");
        System.out.println("Tast 1 for å konvertere fra " + valuta[(valutaId - 1)].valutaNavn + " til norske kroner");
        System.out.println("Tast 2 for å konvertere fra norske kroner til " + valuta[(valutaId - 1)].valutaNavn);

        int valgInput = in.nextInt();

        if (valgInput != 1 && valgInput != 2) {
            System.out.println("\nDu må taste inn enten 1 eller 2\n");
            konverter(valutaId);
        }

        System.out.println("\nTast inn hvor mye som skal konverteres");
        double antall = in.nextDouble();

        if (valgInput == 1) {
            System.out.println("\n" + Valuta.tilNok(antall, valuta[(valutaId - 1)]));
        }else {
            System.out.println("\n" + Valuta.fraNok(antall, valuta[(valutaId - 1)]));
        }

		System.out.println("\n\n---Valutakalkulator---");
        in.close();
		visMeny();
    }
}
