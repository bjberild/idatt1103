package oving11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EiendomsRegister {
    private ArrayList<Eiendom> eiendommer;

    public EiendomsRegister(){
        this.eiendommer = new ArrayList<Eiendom>();
    }

    public void registrerEiendom(Eiendom eiendom){
        eiendommer.add(eiendom);
    }

    public void slettEiendom(Eiendom eiendom){
        eiendommer.remove(eiendom);
    }

    public int antallEiendommer(){
        return eiendommer.size();
    }

    public ArrayList<Eiendom> getEiendommer() {
        return eiendommer;
    }

    public Optional<Eiendom> finnEiendom(String idString){
        String[] nummer = idString.split("\\w+");
        int kommuneNr = Integer.parseInt(nummer[0]);
        int gaardsNr = Integer.parseInt(nummer[1]);
        int bruksNr = Integer.parseInt(nummer[2]);
        return eiendommer.stream()
        .filter(obj -> 
            obj.getKommuneNr() == kommuneNr &&
            obj.getGaardsNr() == gaardsNr &&
            obj.getBruksNr() == bruksNr)
        .findFirst();
    }

    public Optional<Eiendom> finnEiendom(int kommuneNr, int gaardsNr, int bruksNr){
        return eiendommer.stream()
        .filter(obj -> 
            obj.getKommuneNr() == kommuneNr &&
            obj.getGaardsNr() == gaardsNr &&
            obj.getBruksNr() == bruksNr)
        .findFirst();
    }

    public double getGjennomsnittsAreal(){
        double totalareal = 0;
        for (Eiendom eiendom : eiendommer) {
            totalareal += eiendom.getAreal();
        }
        totalareal /= eiendommer.size();
        return totalareal;
    }

    public List<Eiendom> finnEiendommerGittGaardsnummer(int gaardsNr){
        return eiendommer.stream()
        .filter(obj -> obj.getGaardsNr()==gaardsNr)
        .collect(Collectors.toList());
    }
}
