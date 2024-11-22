package oving7;

import java.text.DecimalFormat;

public class TekstBehandling {
    private String tekst;

    public TekstBehandling(String tekst){
        this.tekst = tekst;
    }

    private String[] splitTekst(){
        String str = tekst;
        str.replaceAll("[^\\p{IsLetter}]+", " ");
        String[] strArray = str.split(" ");
        return strArray;
    }

    public int antallOrd(){
        String[] strArray = splitTekst();
        int antallOrd = strArray.length;
        return antallOrd;
    }

    public String ordlengde(){
        String[] strArray = splitTekst();
        float totalOrdlenge = 0;
        for (String string : strArray) {
            totalOrdlenge += string.length();
        }
        float antallOrd = antallOrd();
        float ordlengde = totalOrdlenge/antallOrd;
        DecimalFormat dec = new DecimalFormat("#0.000");
        String utskrift = dec.format(ordlengde);
        return utskrift;
    }

    public String ordPerPeriode(){
        String[] periodeArray = tekst.split("[,\\.\\:\\;\\?]");
        float antallPerioder = periodeArray.length;
        float antallOrd = 0;
        for (String string : periodeArray) {
            String str = string;
            str.replaceAll("[^\\p{IsLetter}]+", " ");
            String[] strArray = str.split(" ");
            antallOrd += strArray.length;
        }
        float ordPerPeriode = antallOrd/antallPerioder;
        DecimalFormat dec = new DecimalFormat("#0.000");
        String utskrift = dec.format(ordPerPeriode);
        return utskrift;
    }

    public void ordskifte(String gammeltOrd,String nyttOrd){
        String str = tekst;
        String regex = "(?i)" + gammeltOrd;
        str = str.replaceAll(regex, nyttOrd);
        this.tekst = str;
    }
/*  
    public String ordskifte(String gammeltOrd,String nyttOrd){
        String str = tekst;
        String regex = "(?i)" + gammeltOrd;
        str = str.replaceAll(regex, nyttOrd);
        return str;
    }
*/
    public String getTekst(){
        return tekst;
    }

    public String getUpperTekst(){
        return tekst.toUpperCase();
    }
}
