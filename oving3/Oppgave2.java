import java.util.Scanner;

public class Oppgave2 {
    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Skriv in et tall for å sjekke om det er et primtall.");
            System.out.println("Skriv in -1 om du vil avslutte programmet.");
            int tall = scanner.nextInt();

            if (tall==-1) {
                scanner.close();
                flag = false;
                System.out.println("Avslutter programmet...");
                System.exit(0);
            }
            sjekkPrimtall(tall);
        }
    }

    public static void sjekkPrimtall(int tall) {
        System.out.println("------");
        boolean primtall = true;
        double sqrt = Math.sqrt(tall);
        if (tall==0||tall==1){primtall = false;}
        for (int i = 2; i <= sqrt; i++) {
            int temp = tall%i;
            if (temp == 0) {
                primtall = false;
                break;
            }
        
        }
        if (primtall) {
            System.out.println(tall + " er et primtall");
            System.out.println("------");
        }
        else {
            System.out.println(tall + " er ikke et primtall");
            System.out.println("------");
        }

    }
}
