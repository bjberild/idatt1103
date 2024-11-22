package oving8;

import java.util.Scanner;

public class ArbTaker {
    private Person personalia;
    private int arbtakernr;
    private int ansettelsesaar;
    private java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
    private double maanedsloenn = 25000;
    private double skatteprosent = 15;

    public ArbTaker(Person personalia,int arbtakernr,int ansettelsesaar, double maanedsloenn,double skatteprosent){
        this.personalia = personalia;
        this.arbtakernr = arbtakernr;
        this.ansettelsesaar = ansettelsesaar;
        this.maanedsloenn = maanedsloenn;
        this.skatteprosent = skatteprosent;
    }

    public Person getPersonalia(){
        return personalia;
    }

    public int getArbtakernr(){
        return arbtakernr;
    }

    public int getAnsettelsesaar(){
        return ansettelsesaar;
    }

    public double getMaanedsloenn(){
        return maanedsloenn;
    }
    
    public double getSkatteprosent(){
        return skatteprosent;
    }

    public void setMaanedsloenn(double maanedsloenn){
        this.maanedsloenn = maanedsloenn;
    }

    public void setSkatteprosent(double skatteprosent){
        this.skatteprosent = skatteprosent;
    }

    public double skattetrekkPerMaaned(){
        double skattetrekk = maanedsloenn*skatteprosent/100;
        return skattetrekk;
    }

    public double bruttoloenn(){
        return maanedsloenn*12;
    }

    public double skattetrekkPerAar(){
        double skattetrekk = this.skattetrekkPerMaaned() * 10.5;
        return skattetrekk;
    }

    public String navn(){
        String etternavn = personalia.getEtternavn();
        String fornavn = personalia.getFornavn();
        String utskrift = etternavn + ", " + fornavn;
        return utskrift;
    }

    public int alder(){
        int aar = kalender.get(java.util.Calendar.YEAR);
        int alder = aar - personalia.getFoedselsaar();
        return alder;
    }

    public int aarAnsatt(){
        int aar = kalender.get(java.util.Calendar.YEAR);
        int aarAnsatt = aar - ansettelsesaar;
        return aarAnsatt;
    }

    public boolean ansattMerEnn(int antallAar){
        int aarAnsatt = this.aarAnsatt();
        if (aarAnsatt >= antallAar) {
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        ArbTaker arbTaker = nyArbTaker();
        skrivUtInfo(arbTaker);
        
        while (true) {
            visMeny(arbTaker);
        }
    }

    static void visMeny(ArbTaker arbTaker){
        System.out.println("\nTast 1 for å endre månedslønnen");
        System.out.println("Tast 2 for å endre skatteprosenten");
        System.out.println("Tast 3 for å skrive ut informasjon til arbeidstaker");
        System.out.println("Tast 4 for å avslutte programmet");
        Scanner in = new Scanner(System.in);
        int menyInput = in.nextInt();
        if (menyInput == 1) {
            System.out.print("Skriv inn ny månedslønn: ");
            double nyLoenn = in.nextDouble();
            arbTaker.setMaanedsloenn(nyLoenn);
            System.out.println("Ny registrert månedslønn er: " + arbTaker.getMaanedsloenn());
        }else if (menyInput == 2) {
            System.out.println("Skriv inn ny skatteprosent");
            double nySkatt = in.nextDouble();
            arbTaker.setSkatteprosent(nySkatt);
            System.out.println("Ny registrert skatteprosent er: " + arbTaker.getSkatteprosent());
        } else if (menyInput == 3) {
            skrivUtInfo(arbTaker);
        } else if (menyInput == 4) {
            System.out.println("Avslutter programmet...");
            System.exit(0);
        }

    }
    
    static ArbTaker nyArbTaker(){
        System.out.println("Skriv inn fornavn på arbeidstaker");
        Scanner in = new Scanner(System.in);
        String fornavn = in.nextLine();
        System.out.println("Skriv inn etternavn på arbeidstaker");
        String etternavn = in.nextLine();
        System.out.println("Skriv inn fødselsaar på arbeidstaker");
        int foedselsaar = in.nextInt();
        Person person = new Person(fornavn, etternavn, foedselsaar);
        System.out.println("Skriv inn arbeidstakernummer");
        int arbeidstakernummer = in.nextInt();
        System.out.println("Skriv inn året arbeidstaker ble ansatt?");
        int ansettelsesaar = in.nextInt();
        System.out.println("Skriv inn månedslønnen til arbeidstaker");
        double maanedsloenn = in.nextDouble();
        System.out.println("Skriv inn skatteprosenten til arbeidstaker");
        double skatteprosent = in.nextDouble();
        ArbTaker arbTaker = new ArbTaker(person, arbeidstakernummer, ansettelsesaar, maanedsloenn, skatteprosent);
        System.out.println("Arbeidstaker lagt inn.");
        return arbTaker;
    }

    static void skrivUtInfo(ArbTaker arbTaker){
        System.out.println("\nArbeidstakers informasjon");
        System.out.println("Navn: " + arbTaker.navn());
        System.out.println("Alder: " + arbTaker.alder());
        System.out.println("Bruttolønn per måned: " + arbTaker.getMaanedsloenn());
        System.out.println("Bruttolønn per år: " + arbTaker.bruttoloenn());
        System.out.println("Skattetrekk per måned: " + arbTaker.skattetrekkPerMaaned());
        System.out.println("Skattetrekk per år: " + arbTaker.skattetrekkPerAar());
        System.out.println("Ansettelsesår: " + arbTaker.getAnsettelsesaar());
        System.out.println("Ansatt mer en 5 år: " + arbTaker.ansattMerEnn(5));
    }
}
