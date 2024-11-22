import java.util.Scanner;

public class Oppgave1 {
    public static void main(String[] args) {
        Scanner tall = new Scanner(System.in);
        System.out.println("Skriv in det minste tallet først.");
        int tall1 = tall.nextInt();
        System.out.println("Skriv nå inn det høyeste tallet.");
        int tall2 = tall.nextInt();
        tall.close();
        if (tall1>tall2) {
            for (int i = tall2; i <= tall1; i++) {
                for (int j = 1; j <= 10; j++) {
                    System.out.println(i + " x " + j + " = " + i*j);
                }
                System.out.println("\n");
            }
        }else {
            for (int i = tall1; i <= tall2; i++) {
                for (int j = 1; j <= 10; j++) {
                    System.out.println(i + " x " + j + " = " + i*j);
                }
                System.out.println("\n");
            }

        } 
    }
}
