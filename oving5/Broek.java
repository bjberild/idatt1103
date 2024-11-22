package oving5;

public class Broek {
    private int teller, nevner;
    private String resultat;

    public Broek(int teller, int nevner) {
        if (nevner == 0) {
            throw new IllegalArgumentException("Nevneren kan ikke være lik 0");
        } else {
            this.nevner = nevner;
            this.teller = teller;
        }
    }

    public Broek(int teller) {
        this.teller = teller;
        this.nevner = 1;
    }   

    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    public void addere(Broek b){
        int resTeller = (this.teller * b.nevner) + (b.teller*this.nevner);
        int resNevner = this.nevner * b.nevner;
        int g = gcd(resTeller,resNevner);
        resTeller /= g;
        resNevner /= g;
        String resultat = resTeller + "/" + resNevner;
        this.resultat = resultat;
    }

    public void subtrahere(Broek b){
        int resTeller = (this.teller * b.nevner) - (b.teller*this.nevner);
        int resNevner = this.nevner * b.nevner;
        int g = gcd(resTeller,resNevner);
        resTeller /= g;
        resNevner /= g;
        String resultat = resTeller + "/" + resNevner;
        this.resultat = resultat;
    }

    public void multiplisere(Broek b){
        int resTeller = this.teller * b.teller;
        int resNevner = this.nevner * b.nevner;
        int g = gcd(resTeller,resNevner);
        resTeller /= g;
        resNevner /= g;
        String resultat = resTeller + "/" + resNevner;
        this.resultat = resultat;
    }

    public void dividere(Broek b){
        int resTeller = this.teller * b.nevner;
        int resNevner = this.nevner * b.teller;
        int g = gcd(resTeller,resNevner);
        resTeller /= g;
        resNevner /= g;
        String resultat = resTeller + "/" + resNevner;
        this.resultat = resultat;
    }

    public String getResultat(){
        return this.resultat;
    }

    public static void main(String[] args) {
        Broek a,b;

        try {
            a = new Broek(4,3);
        } catch (IllegalArgumentException e) {
            a = new Broek(5);
        }

        try {
            b = new Broek(5,4);
        } catch (IllegalArgumentException e) {
            b = new Broek(6);
        }

        a.addere(b);
        System.out.println(a.getResultat());
        a.subtrahere(b);
        System.out.println(a.getResultat());
        a.multiplisere(b);
        System.out.println(a.getResultat());
        a.dividere(b);
        System.out.println(a.getResultat());
    }
}