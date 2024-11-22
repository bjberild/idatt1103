package oving10;

public class Arrangement {
    private final int id;
    private final String navn, sted, type, arrangoer;
    private final long tid;

    public Arrangement(int id, String navn, String sted, String arrangoer, String type, long tid){
        this.id = id;
        this.navn = navn;
        this.sted = sted;
        this.type = type;
        this.arrangoer = arrangoer;
        this.tid = tid;
    }

    public int getId(){
        return id;
    }

    public String getNavn(){
        return navn;
    }

    public String getSted(){
        return sted;
    }

    public String getType(){
        return type;
    }

    public String getArrangoer(){
        return arrangoer;
    }

    public long getTid(){
        return tid;
    }

    public String toString(){
        String t = String.valueOf(this.tid);
        String tidspunkt = t.substring(6, 8) + "." + t.substring(4, 6) + "." + t.substring(0, 4) + " kl. " + t.substring(8, 10) + ":" + t.substring(10, 12);
        String utskrift = "Id: " + this.id + ", navn: " + this.navn + ", sted: " + this.sted + ", arrangør: " + this.arrangoer + ", type: " + this.type + ", tidspunkt: " + tidspunkt;
        return utskrift;
    }
}
