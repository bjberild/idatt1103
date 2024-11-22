package oving7;

public class Oppgave2 {
    public static void main(String[] args) {
        TekstBehandling tekstbehandling = new TekstBehandling("Dette er Setning en. Dette er setning to. Dette er enda en setning til.");

        System.out.println(tekstbehandling.antallOrd());

        System.out.println(tekstbehandling.ordlengde());

        System.out.println(tekstbehandling.ordPerPeriode());

        System.out.println(tekstbehandling.getTekst());

        tekstbehandling.ordskifte("setning", "utsagn");

        System.out.println(tekstbehandling.getTekst());

        System.out.println(tekstbehandling.getUpperTekst());
    }
}
