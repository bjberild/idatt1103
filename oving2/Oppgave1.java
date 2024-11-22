package oving2;

import java.util.Scanner;


public class Oppgave1 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Skriv in årstall:");
        int aar = myObj.nextInt();
        myObj.close();
        boolean skuddaar;

        if ((aar%100)==0) {
            if ((aar%400)==0) {
                skuddaar = true;
            }
            else {
                skuddaar = false;
            }
        }else if ((aar%4)==0){
            skuddaar = true;
        }
        else {
            skuddaar = false;
        }
        if (skuddaar) {
            System.out.println(aar + " er et skuddår");
        } else {
            System.out.println(aar + " er ikke et skuddår");
        }
    }
}
