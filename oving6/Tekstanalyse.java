package oving6;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Tekstanalyse {
    private static int[] antallTegn = new int[30];
    private static String[] bokstaver = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","æ","ø","å"};

    public Tekstanalyse(String tekst){
        for (int a = 0; a < 30; a++) {
            antallTegn[a] = 0;
        }
        tekst = tekst.toLowerCase();
        int lengde = tekst.length();
        for (int i = 0; i < lengde; i++){
            char indexChar = tekst.charAt(i);
            String bokstav = Character.toString((char)indexChar);
            int index = Arrays.asList(bokstaver).indexOf(bokstav);
            if (index == -1) {
                index = 29;
            }
            antallTegn[index] += 1;
            }
    }

    public int getAntallForskjellige() {
        int sum = 0;
        for (int i = 0; i < 29; i++) {
          if (antallTegn[i] > 0) {
            sum++;
          }
        }
        return sum;
    }

    public int getAntallBokstaver() {
        int sum = 0;
        for (int i = 0; i < 29; i++) {
          sum = antallTegn[i] + sum;
        }
        return sum;
    }

    public String getProsentIkkeBokstaver() {
        int antallBokstaver = getAntallBokstaver();
        int antallAndre = antallTegn[29];
        double totalt = antallAndre + antallBokstaver;
        double prosent = (antallAndre / totalt) * 100;
        DecimalFormat dec = new DecimalFormat("#0.00");
        String prosentTekst = dec.format(prosent);
        return prosentTekst;
    }

    public int getAntallSpesifikkBokstav(String bokstav) {
        int index = Arrays.asList(bokstaver).indexOf(bokstav);
        int sum = 0;
        if (index > -1) {
          sum = antallTegn[index];
        }
        return sum;
    }
    public String getFlestForekomster() {
        int hoyest = -1;
        String hoyestBokstav = "";
        for ( int i = 0; i < 29; i++ ) {
          if (antallTegn[i] > hoyest) {
            hoyest = antallTegn[i];
            hoyestBokstav = bokstaver[i];
          } else if (antallTegn[i] == hoyest) {
            hoyestBokstav = hoyestBokstav + ", " + bokstaver[i];
          }
        }
        return "Bokstaven(e) som forekommer oftest er \"" + hoyestBokstav + "\" (" + hoyest + " ganger)";
    }
}
