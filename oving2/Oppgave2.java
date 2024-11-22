package oving2;

public class Oppgave2 {
    public static void main(String[] args) {
        double prisA = 35.9;
        double vektA = 450;
        double prisB = 39.5;
        double vektB = 500;
        double kiloprisA = (prisA/vektA)*1000;
        double kiloprisB = (prisB/vektB)*1000;
        if (kiloprisA>kiloprisB) {
            System.out.println("Merke A er billigere per kilogram enn merke B");
        }
        if (kiloprisB>kiloprisA) {
            System.out.println("Merke B er billigere per kilogram enn merke A");
        }
        if (kiloprisA==kiloprisB) {
            System.out.println("Merke A og Merke B koster like mye per kilogram");
        }
    }
}
