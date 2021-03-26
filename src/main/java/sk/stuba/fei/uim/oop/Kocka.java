package sk.stuba.fei.uim.oop;

import java.util.Random;

public class Kocka {
    public static int hodKocka(){
        Random rand = new Random();
        int tvojhod = rand.nextInt(6);
        tvojhod++;
        if (tvojhod == 6) {
            System.out.println("Hodil si cislo 6, hod este raz");
            tvojhod += rand.nextInt(6) + 1;
        }
        System.out.println("Hodil si spolu " + tvojhod);
        return tvojhod;
    }
}
