package oving10;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class Oppgave1 {
    private ArrangementRegister register = new ArrangementRegister();
    private Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Oppgave1 klient = new Oppgave1();
        while (true) {
            klient.visMeny();
        }
    }

    public void visMeny(){
        System.out.println("""
                
                0. Avslutt programmet
                1. Registrere nytt arrangement
                2. Finn alle arrangementer på et sted
                3. Finn alle arrangementer på en dato
                4. Finn alle arrangementer innen et tidsinterval
                5. Skriv ut alle registrerte arrangementer
                """);
        
        int menyInput = in.nextInt();
        switch (menyInput) {
            case 0:
                System.out.println("Avslutter programmet...");
                System.exit(0);
            case 1:
                lagArrangement();
                break;
            case 2:
                stedArrangementer();
                break;
            case 3:
                datoArrangementer();
                break;
            case 4:
                mellomDatoArrangementer();
                break;
            case 5:
                alleArrangementer();
                break;
            default:
                System.out.println("Du må taste et tall mellom 0-5");
                break;
        }
    }

    public void skrivUtArrangementListe(ArrayList<Arrangement> liste){
        System.out.println("");
        if (liste.size() > 0) {
            for (Arrangement arrangement : liste) {
                System.out.println(arrangement.toString());
            }
        }else {
            System.out.println("Fant ingen arrangementer");
        }
    }

    private void lagArrangement(){
        in.nextLine();
        System.out.println("Tast inn navn: ");
        String navn = in.nextLine();
        System.out.println("Tast inn sted: ");
        String sted = in.nextLine();
        System.out.println("Tast inn arrangør: ");
        String arrangoer = in.nextLine();
        System.out.println("Tast inn type arrangement: ");
        String type = in.nextLine();
        System.out.println("Tast inn tidspunkt i format YYYYMMDDhhmm: ");
        long tid = in.nextLong();
        Arrangement a = register.nyttArrangement(navn, sted, arrangoer, type, tid);
        register.arrangementer.add(a);
    }

    private void stedArrangementer(){
        in.nextLine();
        System.out.println("Tast inn sted: "); String sted = in.nextLine();
        skrivUtArrangementListe(register.listeStedArrangementer(sted));
    }

    private void datoArrangementer(){
        System.out.println("Tast inn dato i format YYYYMMDD: "); long dato = in.nextLong();
        skrivUtArrangementListe(register.listeDatoArrangementer(dato));
    }

    private void mellomDatoArrangementer(){
        System.out.println("Tast inn startdato i format YYYYMMDD: "); long dato1 = in.nextLong();
        System.out.println("Tast inn sluttdato i format YYYYMMDD: "); long dato2 = in.nextLong();
        if (dato1<dato2) {
            skrivUtArrangementListe(register.listeMellomDatoerArrangementer(dato1, dato2));
        }else if (dato1> dato2) {
            skrivUtArrangementListe(register.listeMellomDatoerArrangementer(dato2, dato1));
        }else if (dato1 == dato2){
            skrivUtArrangementListe(register.listeDatoArrangementer(dato1));
        }
    }

    private void alleArrangementer(){
        Collections.sort(register.arrangementer, Comparator.comparing(Arrangement::getSted)
            .thenComparing(Arrangement::getType)
            .thenComparing(Arrangement::getTid));
        skrivUtArrangementListe(register.arrangementer);
    }
}
