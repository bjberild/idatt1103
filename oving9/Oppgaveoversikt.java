package oving9;
import java.util.ArrayList;

public class Oppgaveoversikt {
    private ArrayList<Student> studenter;
    private int antStud = 0;

    public Oppgaveoversikt(){
        this.studenter = new ArrayList<Student>();
    }

    public int getAntStud(){
        return this.studenter.size();
    }

    public int getAntOppg(int index){
        Student student = studenter.get(index);
        return student.getAntOppg();
    }

    public void leggTilStudent(String navn,int antOppg){
        System.out.println("Skriv inn navn på studenten");
        Student student = new Student(navn, antOppg);
        this.studenter.add(student);
    }

    public void oekAntOppg(int index){
        studenter.get(index).oekAntOppg();
    }

    public String toString(){
        String tekst = "";
        int index = 0;
        for (Student student : studenter) {
            index += 1;
            tekst += index + student.toString() + "\n";
        }
        return tekst;
    }

    public void printStudenter(){
        System.out.println(studenter.toString());
    }

    public static void main(String[] args) {
         
    }
}
