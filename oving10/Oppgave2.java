package oving10;

import java.util.Scanner;
import java.util.ArrayList;

public class Oppgave2 {
    private Scanner in = new Scanner(System.in);
    private MenyRegister menyRegister = new MenyRegister();

    public static void main(String[] args) {
        Oppgave2 klient = new Oppgave2();
        klient.testData();
        while (true) {
            klient.visMeny();
        }        
    }

    public void testData(){
        menyRegister.addRett("Grillspyd", "forrett", 60);
        menyRegister.addRett("Vårrull", "forrett", 50);
        menyRegister.addRett("Burger", "hovedrett", 120);
        menyRegister.addRett("Spaghetti Carbonara", "hovedrett", 60);
        menyRegister.addRett("Tiramisu", "dessert",100);
        menyRegister.addRett("Banansplit", "dessert",90);
    }

    public void visMeny(){
        System.out.println("""
                0. Avslutt programmet
                1. Registrer ny rett
                2. Finn en rett, gitt navnet
                3. Finn alle retter av en gitt type
                4. Registrer en ny meny
                5. Finn alle menyer innen en gitt prisintervall
                6. Print alle retter
                """);
        int menyInput = in.nextInt();
        switch (menyInput) {
            case 0:
                System.out.println("Avslutter programmet...");
                System.exit(0);
            case 1:
                nyRett();
                break;
            case 2:
                finnRett();
                break;
            case 3:
                finnRettType();
                break;
            case 4:
                nyMeny();
                break;
            case 5:
                finnMenyer();
                break;
            case 6:
                printAlleRetter();
            default:
                System.out.println("Du må taste et tall mellom 0-6");
                break;
        }
    }

    public void nyRett(){
        in.nextLine();
        System.out.println("Skriv inn navn på retten: ");
        String navn = in.nextLine();
        if (menyRegister.finneRettGittNavn(navn)!= null) {
            System.out.println("Denne retten eksisterer allerede");
        }else{
            System.out.println("Skriv inn hvilken type retten er: ");
            String type = in.nextLine();
            System.out.println("Skriv in prisen på retten: ");
            double pris = in.nextDouble();
            menyRegister.addRett(navn, type, pris);
            System.out.println("Retten ble registrert\n");
        }
    }

    public void finnRett(){
        in.nextLine();
        System.out.println("Skriv inn navn på retten:\n");
        String navn = in.nextLine();
        if (menyRegister.finneRettGittNavn(navn)==null){
            System.out.println("Retten eksisterer ikke\n");
        }else {
            System.out.println(menyRegister.finneRettGittNavn(navn).toString());
        }
    }

    public void finnRettType(){
        in.nextLine();
        System.out.println("Skriv inn typen retter du vil finne: ");
        String type = in.nextLine();
        ArrayList<Rett> rettArr = menyRegister.finneRetterGittType(type);
        for (Rett rett : rettArr) {
            System.out.println(rett.toString());
        }
        System.out.println("");
    }

    public void printAlleRetter(){
        String alleRetter = "";
        for (Rett rett : menyRegister.getRetter()) {
            alleRetter += rett.toString() + "\n";
        }
        System.out.println(alleRetter);
    }

    public void nyMeny(){
        boolean ferdig = false;
        ArrayList<Rett> retter = new ArrayList<Rett>();
        printAlleRetter();

        in.nextLine();
        while (!ferdig) {
            if (retter.size() < 1) {
                System.out.println("Skriv inn navnet på retten som skal legges til: ");
            }else{
                System.out.println("Tast 1 for å registrere menyen eller legg til flere retter ved å skrive navn:");
            }
            String navn = in.nextLine();
            if (navn.equals("1")) {
                ferdig = true;
            }else if (menyRegister.finneRettGittNavn(navn)!= null) {
                retter.add(menyRegister.finneRettGittNavn(navn));
            }else{
                System.out.println("Retten eksisterer ikke");
            }
        }
        System.out.println("Menyen er registrert");
        menyRegister.addMeny(retter);
    }

    public void finnMenyer(){
        System.out.println("Skriv inn laveste pris på menyene:");
        double nedreGrense = in.nextDouble();
        System.out.println("Skriv inn øverste pris på menyene:");
        double oevreGrense = in.nextDouble();
        ArrayList<Meny> menyer = menyRegister.finneMenyGittPrisIntervall(nedreGrense, oevreGrense);
        System.out.println("Menyer med pris mellom " + nedreGrense + " og " + oevreGrense + ":\n");
        int i= 0;
        for (Meny meny : menyer) {
            i++;
            System.out.println("Meny nr." + i + ":");
            System.out.println(meny.toString()+ "\n");
        }
    }
}
