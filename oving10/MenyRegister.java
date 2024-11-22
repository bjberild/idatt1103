package oving10;

import java.util.ArrayList;

public class MenyRegister {
    private ArrayList<Meny> menyer;
    private ArrayList<Rett> retter;

    public MenyRegister(){
        menyer = new ArrayList<Meny>();
        retter = new ArrayList<Rett>();
    }

    public void addRett(String navn, String type, double pris){
        Rett nyRett = new Rett(navn,type,pris);
        retter.add(nyRett);
    }

    public void addMeny(ArrayList<Rett> menyRetter){
        Meny nyMeny = new Meny(menyRetter);
        menyer.add(nyMeny);
    }

    public Rett finneRettGittNavn(String navn){
        Rett funnetRett = null;
        for (Rett rett : retter) {
            if (rett.getNavn().equals(navn)) {
                funnetRett = rett;
            }
        }
        return funnetRett;
    }

    public ArrayList<Rett> finneRetterGittType(String type){
        ArrayList<Rett> rettArr = new ArrayList<Rett>();
        for (Rett rett : retter) {
            if (rett.getType().equals(type)) {
                rettArr.add(rett);
            }
        }
        return rettArr;
    }

    public ArrayList<Meny> finneMenyGittPrisIntervall(double nedreGrense,double oevreGrense){
        ArrayList<Meny> menyArr = new ArrayList<Meny>();
        for (Meny meny : menyer) {
            if (meny.getTotalPris() >= nedreGrense && meny.getTotalPris() <= oevreGrense) {
                menyArr.add(meny);
            }
        }
        return menyArr;
    }

    public ArrayList<Rett> getRetter(){
        return this.retter;
    }
}
