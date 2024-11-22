package oving11;


public class Eiendom {
    private String kommuneNavn, eier, bruksnavn;
    private int kommuneNr, gaardsNr, bruksNr;
    private double areal;

    public Eiendom(String kommuneNavn, int kommuneNr, int gaardsNr, int bruksNr, String bruksnavn, double areal, String eier){
        this.kommuneNavn = kommuneNavn;
        this.kommuneNr = kommuneNr;
        this.gaardsNr = gaardsNr;
        this.bruksNr = bruksNr;
        this.bruksnavn = bruksnavn;
        this.areal = areal;
        this.eier = eier;
    }

    public String getKommuneNavn(){
        return kommuneNavn;
    }

    public int getKommuneNr(){
        return kommuneNr;
    }

    public int getGaardsNr() {
        return gaardsNr;
    }

    public int getBruksNr() {
        return bruksNr;
    }

    public String getBruksnavn() {
        return bruksnavn;
    }

    public double getAreal() {
        return areal;
    }

    public String getEier() {
        return eier;
    }

    public void setKommuneNavn(String kommuneNavn) {
        this.kommuneNavn = kommuneNavn;
    }

    public void setKommuneNr(int kommuneNr) {
        this.kommuneNr = kommuneNr;
    }

    public void setGaardsNr(int gaardsNr) {
        this.gaardsNr = gaardsNr;
    }

    public void setBruksNr(int bruksNr) {
        this.bruksNr = bruksNr;
    }

    public void setBruksnavn(String bruksnavn) {
        this.bruksnavn = bruksnavn;
    }

    public void setAreal(double areal) {
        this.areal = areal;
    }

    public void setEier(String eier){
        this.eier = eier;
    }

    public String getIdString(){
        return this.kommuneNr + "-" + this.gaardsNr + "/" + this.bruksNr;
    }

    
    public String toString(){
        String utskrift = "| kommunenavn: " + kommuneNavn + " | kommuneNr: " + String.valueOf(kommuneNr) + " | gårdsNr: " + String.valueOf(gaardsNr) + " | bruksNr: ";
        utskrift += String.valueOf(bruksNr) + " | bruksnavn: " + bruksnavn + " | areal: " + String.valueOf(areal) + "m^2 | eier: " + eier + " |";
        return utskrift;
    }
}
