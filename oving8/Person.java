package oving8;

public final class Person {
    private String fornavn;
    private String etternavn;
    private int foedselsaar;

    public Person(String fornavn,String etternavn,int foedselsaar){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.foedselsaar = foedselsaar;
    }

    public String getFornavn(){
        return fornavn;
    }

    public String getEtternavn(){
        return etternavn;
    }

    public int getFoedselsaar(){
        return foedselsaar;
    }
}
