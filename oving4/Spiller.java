package oving4;

import java.util.Random;

public class Spiller {
        int sumPoeng;
        String spillerNavn;

        public Spiller(int poeng){
            sumPoeng = poeng;
        }

        public int getPoeng() {
            return sumPoeng;
        }

        public int kastTerningen(int poeng) {
            Random terning = new Random();
            int nySum;

            int terningKast = terning.nextInt(6);
            terningKast ++;

            if (terningKast==1) {
                nySum=0;
            }else if (poeng > 100) {
                nySum = poeng - terningKast;
            }else {
                nySum = poeng + terningKast;
            }
            return nySum;
        }

        public boolean erFerdig(int poeng) {
            if (poeng == 100) {
                return true;
            } else {
                return false;
            }
            
        }
}
