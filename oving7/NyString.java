package oving7;

public final class NyString {
    private String tekst;

    public NyString(String tekst){
        this.tekst = tekst;
    }

    public String forkorting(){
        String[] tekstTabell = tekst.split("[,\\.\\s]");
        String utTekst = "";
        for (String string : tekstTabell) {
            utTekst += string.charAt(0);
        }
        return utTekst;
    }

    public String fjerneTegn(String tegn){
        String utTekst = tekst;
        while (utTekst.indexOf(tegn) != -1){
            int index = utTekst.indexOf(tegn);
            utTekst = utTekst.substring(0, index) + utTekst.substring(index + 1);
        }
        return utTekst;
    }
}
