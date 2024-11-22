package oving11;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Optional;
import java.text.DecimalFormat;

public class Klientprogram {
    private EiendomsRegister register = new EiendomsRegister();
    private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Klientprogram klient = new Klientprogram();
        klient.testData();
        boolean exit = false;
        

        while (!exit) {
            visMeny();
            int valg = getValg(klient.scanner);
            klient.scanner.nextLine();

            switch (valg) {
                case 1:
                    Eiendom eiendom = leggTilEiendom(klient.scanner);
                    klient.register.registrerEiendom(eiendom);
                    System.out.println("Eiendom registrert");
                    break;
                case 2:
                    klient.printEiendommer(klient.register.getEiendommer());
                    break;
                case 3:
                    klient.finnEiendom(klient.scanner);
                    break;
                case 4:
                    klient.gjennomsnittsAreal();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Tast inn et av heltallene fra menyen");
                    break;
            }
        }
        System.out.println("Avslutter programmet...");
        System.exit(0);
    }

    public static void visMeny(){
        System.out.println("""
                \n~~~~~~~~~~~~~~~~~~~~~~
                1. Legg til eiendom
                2. Skriv ut alle eiendommer
                3. Finn eiendom
                4. Vis gjennomsnittsarealet
                0. Avslutt programmet
                ~~~~~~~~~~~~~~~~~~~~~~\n
                """);
    }

    public static int getValg(Scanner scanner){
        while (!scanner.hasNextInt()) {
            System.out.println("Skriv in et gyldig tall");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static Eiendom leggTilEiendom(Scanner scanner){
        System.out.println("Skriv in kommunenavn");
        String kommuneNavn = scanner.nextLine();
        System.out.println("Skriv in kommunenummer");
        int kommuneNr = scanner.nextInt();
        System.out.println("Skriv in gårdsnummer");
        int gaardsNr = scanner.nextInt();
        System.out.println("Skriv in bruksnummer");
        int bruksNr = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Skriv in bruksnavn");
        System.out.println("Dersom eiendommen ikke har bruksnavn, tast \"null\"");
        String bruksnavn = scanner.nextLine();
        System.out.println("Skriv in arealet på eiendommen");
        double areal = Double.parseDouble(scanner.nextLine());
        System.out.println("Skriv in eier på eiendommen");
        String eier = scanner.nextLine();
        Eiendom eiendom = new Eiendom(kommuneNavn, kommuneNr, gaardsNr, bruksNr, bruksnavn, areal, eier);
        return eiendom;
    }

    public void printEiendommer(ArrayList<Eiendom> eiendommer){
        for (Eiendom eiendom : eiendommer) {
            System.out.println(eiendom.toString());
        }
    }

    public void finnEiendom(Scanner scanner){
        System.out.println("Skriv in kommunenummer");
        int kommuneNr = scanner.nextInt();
        System.out.println("Skriv in gårdsnummer");
        int gaardsNr = scanner.nextInt();
        System.out.println("Skriv in bruksnummer");
        int bruksNr = scanner.nextInt();
        Optional<Eiendom> eiendomOpt = register.finnEiendom(kommuneNr, gaardsNr, bruksNr);
        if (eiendomOpt.isPresent()) {
            Eiendom eiendom = eiendomOpt.get();
            System.out.println(eiendom.toString());
        }else{
            System.out.println("Fann ingen eiendom gitt disse nummerene");
        }
    }

    public void gjennomsnittsAreal(){
        double gjennomsnittsareal = register.getGjennomsnittsAreal();
        DecimalFormat dec = new DecimalFormat("#0.00");
        String arealTekst = dec.format(gjennomsnittsareal);
        System.out.println("Gjennomsnittsarealet til alle de registrerte eiendommene er " + arealTekst + "m^2");
    }

    public void testData(){
        Eiendom eiendom1 = new Eiendom("Gloppen", 1445, 77, 631, null, 1017.6, "Jens Olsen");
        register.registrerEiendom(eiendom1);
        Eiendom eiendom2 = new Eiendom("Gloppen", 1445, 77, 131, "Syningom", 661.3, "Nicolay Madsen");
        register.registrerEiendom(eiendom2);
        Eiendom eiendom3 = new Eiendom("Gloppen", 1445, 75, 19, "Fugletun", 650.6, "Evilyn Jensen");
        register.registrerEiendom(eiendom3);
        Eiendom eiendom4 = new Eiendom("Gloppen", 1445, 74, 188, null, 1457.2, "Karl Ove Bråten");
        register.registrerEiendom(eiendom4);
        Eiendom eiendom5 = new Eiendom("Gloppen", 1445, 69, 47, "Høiberg", 1339.4, "Elsa Indregård");
        register.registrerEiendom(eiendom5);
    }
}
