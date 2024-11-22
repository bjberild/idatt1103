package oving7;

public class Oppgave1 {
    public static void main(String[] args) {
        NyString tekst = new NyString("Dette er en setning");

        String forkorting = tekst.forkorting();

        System.out.println(forkorting);

        System.out.println(tekst.fjerneTegn("e"));
    }
}
