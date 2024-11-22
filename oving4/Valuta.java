package oving4;

import java.text.DecimalFormat;

public class Valuta {
    double valutaKurs;
    String valutaNavn;

    // Konstruktør til Valuta klassen
    public Valuta(double kurs, String navn) {
        valutaKurs = kurs;
        valutaNavn = navn;
    }

    // Funksjon som konverterer en mengde av en valuta til norkse kroner
    public static String tilNok(double antall, Valuta valuta) {
        double sum;
        sum = valuta.valutaKurs * antall;
        DecimalFormat dec = new DecimalFormat("#0.000");
        String text = antall + " " + valuta.valutaNavn + " er lik " + dec.format(sum) + " norske kroner.";
        return text;
    }
    
    // Funksjon som konverterer en mengde norkse kroner til en annen valuta
    public static String fraNok(double antall, Valuta valuta) {
        double sum;
        sum = (1/valuta.valutaKurs) * antall;
        DecimalFormat dec = new DecimalFormat("#0.000");
        String text = antall + " norske kroner er lik " + dec.format(sum) + " " + valuta.valutaNavn + ".";
        return text;
    }
}
