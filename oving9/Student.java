package oving9;

public class Student {
    private String navn;
    private int antOppg;

    public Student(String navn,int antOppg){
        this.navn = navn;
        this.antOppg = antOppg;
    }

    public String getNavn(){
        return this.navn;
    }

    public int getAntOppg(){
        return this.antOppg;
    }

    public void oekAntOppg(){
        this.antOppg += 1;
    }

    public String toString(){
        String utskrift = this.navn + String.valueOf(this.antOppg);
        return utskrift;
    }
}
