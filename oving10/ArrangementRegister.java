package oving10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrangementRegister {
    public ArrayList<Arrangement> arrangementer;

    public ArrangementRegister() {
    arrangementer = new ArrayList<Arrangement>();
    }

    public Arrangement nyttArrangement(String navn, String sted, String arrangoer, String type, long tid) {
        int id = arrangementer.size();
        Arrangement arrangement = new Arrangement(id, navn, sted, arrangoer, type, tid);
        return arrangement;
    }

    public ArrayList<Arrangement> listeStedArrangementer(String sted) {
        ArrayList<Arrangement> stedArr = new ArrayList<Arrangement>();
        for (int i = 0; i < arrangementer.size(); i++) {
            if (arrangementer.get(i).getSted().equals(sted)) {
            stedArr.add(arrangementer.get(i));
            }
        }
        return stedArr;
    }

    public ArrayList<Arrangement> listeDatoArrangementer(long dato) {
        ArrayList<Arrangement> datoArr = new ArrayList<Arrangement>();
        for (int i = 0; i < arrangementer.size(); i++) {
            int arrangementDato = (int)Math.floor(arrangementer.get(i).getTid() / 10000);
            if (arrangementDato == dato) {
            datoArr.add(arrangementer.get(i));
            }
        }
        return datoArr;
    }

    public ArrayList<Arrangement> listeMellomDatoerArrangementer(long dato1, long dato2) {
        ArrayList<Arrangement> datoArr = new ArrayList<Arrangement>();
        for (int i = 0; i < arrangementer.size(); i++) {
            int arrangementDato = (int)Math.floor(arrangementer.get(i).getTid() / 10000);
            if (arrangementDato >= dato1 && arrangementDato <= dato2) {
                datoArr.add(arrangementer.get(i));
            }
        }
        Comparator<Arrangement> sorterEtterTid = (Arrangement a1, Arrangement a2) -> (int)a1.getTid() - (int)a2.getTid();
        Collections.sort(datoArr, sorterEtterTid);
        return datoArr;
    }
}
