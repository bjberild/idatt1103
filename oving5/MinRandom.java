package oving5;

import java.util.Random;
public class MinRandom {
    private static Random random = new Random();
    
    public static int nesteHeltall(int nedre, int ovre){
        int tilfeldig =nedre + random.nextInt(ovre-nedre+1);
        return tilfeldig;
    }

    public static double nesteDesimaltall(double nedre, double ovre){
        double interval = ovre-nedre;
        double tilfeldig = nedre + (random.nextDouble() * interval);
        return tilfeldig;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(nesteDesimaltall(-1.9,2.4));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(nesteHeltall(1,5));
        }
    }
}
