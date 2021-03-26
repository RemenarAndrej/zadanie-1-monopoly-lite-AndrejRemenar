package sk.stuba.fei.uim.oop;

public class Sanca {
    static int balik = 0;
    public static void stupilNaSancu(Hrac[] tentoHrac, int cislo)
    {
        switch (balik){
            case 0:
                System.out.println("Stupil si na policko sance, chod do vezenia");
                tentoHrac[cislo].setPozicia(6);
                tentoHrac[cislo].setVezenie(true);
                tentoHrac[cislo].setDobaVoVezeni();
                balik++;
                break;
            case 1:
                System.out.println("Stupil si na policko sance, dostavas 1000");
                tentoHrac[cislo].addPeniaze(1000);
                balik++;
                break;
            case 2:
                System.out.println("Stupil si na policko sance, chod na start a dostan peniaze zanho");
                tentoHrac[cislo].setPozicia(0);
                tentoHrac[cislo].addPeniaze(1500);
                balik++;
                break;
            case 3:
                System.out.println("Stupil si na policko sance, navstiv kamaratov vo vezeni");
                tentoHrac[cislo].setPozicia(6);
                balik++;
                break;
            case 4:
                System.out.println("Stupil si na policko sance, stracas 5000");
                tentoHrac[cislo].subPeniaze(5000);
                balik=0;
                break;
        }

    }
}
