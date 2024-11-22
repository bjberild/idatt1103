package oving10;

import java.util.ArrayList;

public class Meny {
    private ArrayList<Rett> menyRetter;
    private double totalPris;

    public Meny(ArrayList<Rett> menyRetter){
        this.menyRetter = menyRetter;
        double totalPris = 0;
        for (Rett rett : menyRetter) {
            totalPris += rett.getPris();
        }
        this.totalPris = totalPris;
    }

    public ArrayList<Rett> getMeny(){
        return menyRetter;
    }

    public double getTotalPris(){
        return totalPris;
    }

    public String toString(){
        String utskrift = "";
        for (Rett rett : menyRetter) {
            utskrift += rett.toString() + "\n";
        }
        utskrift += "Totalpris: " + this.getTotalPris() + "kr";
        return utskrift;
    }
}
