package oving1;

public class Oppgave3 {
    public static void main(String[] args) {
        int totalSekunder = 36610;
        int timer = totalSekunder / 3600;
        int sekunder = totalSekunder % 3600;
        int minutter = sekunder / 60;
        sekunder = sekunder % 60;
        System.out.println(totalSekunder +" sekunder er det samme som " + timer+" timer, "+ minutter + " minutter og "+sekunder + " sekunder.");
    }
}
