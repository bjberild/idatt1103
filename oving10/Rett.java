package oving10;

public class Rett {
    private String navn,type;
    private double pris;

    public Rett(String navn, String type, double pris){
        this.navn = navn;
        this.type = type;
        this.pris = pris;
    }

    public String getNavn(){
        return navn;
    }

    public String getType(){
        return type;
    }

    public double getPris(){
        return pris;
    }

    public String toString(){
        return "Navn: " + navn + ", Type: " + type +", Pris: " + pris + "kr.";
    }
}
