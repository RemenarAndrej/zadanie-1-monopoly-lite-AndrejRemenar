package sk.stuba.fei.uim.oop;

import static sk.stuba.fei.uim.oop.Sanca.stupilNaSancu;
import java.util.Scanner;


public class Hra {
    public void monopoly() {
        int pocetHracov = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Hra caka na input iba pocas kupovania nehnutelnosti");
        System.out.println("Vo vsetkych ostatnych pripadoch ide dopredu bez cakania (aby to bolo rychle)");
        System.out.println("Za stupenie na nehnutelnost hrac plati jednu stvrtinu ceny hracovy ktory ju vlastni");
        System.out.println("Pre zacatie hry zadaj pocet hracov od 2 do 10 (radsej menej nech to netrva dlho)");

        while(pocetHracov < 2 || pocetHracov > 10) {
            try {
                pocetHracov =  Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Musis zadat integer");
            }
            if (pocetHracov < 2 || pocetHracov > 10)
            {
            System.out.println("Spravil si chybu v zadavani, zadaj znovu");
            }
        }
        System.out.println("Zacinam hru s poctom hracov " + pocetHracov);
        Hrac[] cisloHraca = new Hrac[pocetHracov];
        for (int i=0; i< pocetHracov; i++)
        {
            cisloHraca[i] = new Hrac();
            System.out.println("Zvol meno hracovy cislo " + (i+1));
            String zadanieMena = scan.nextLine();
            cisloHraca[i].setMeno(zadanieMena);
        }
        Nehnutelnost[] cisloDomu = new Nehnutelnost[24];
        int nasobenie=1;
        for (int i = 1; i<24; i++)
        {
            cisloDomu[i] = new Nehnutelnost();
            if (i==3 || i==6 || i==9 || i==12 || i==15|| i==18 || i==21)
            {
                continue;
            }
            cisloDomu[i].setCena(nasobenie);
            cisloDomu[i].setDan(nasobenie);
            nasobenie++;
        }

        boolean koniecHry=false;
        int pocetPrehranych=0;
        while (!koniecHry){
        for (int i = 0; i < pocetHracov; i++)
        {
            if (cisloHraca[i].getPrehral())
            {
                continue;
            }
            System.out.println("Na rade je hrac cislo " + (i + 1) + " s menom " + cisloHraca[i].getMeno());
            if (!cisloHraca[i].getVezenie()) {
                cisloHraca[i].setPozicia(cisloHraca[i].getPozicia() + Kocka.hodKocka());
                if (cisloHraca[i].getPozicia() > 23) {
                    cisloHraca[i].setPozicia(cisloHraca[i].getPozicia() - 24);
                    System.out.println("Presiel si startom, dostavas odmenu");
                    cisloHraca[i].addPeniaze(1500);
                }
                System.out.println("Tvoja pozicia je " + cisloHraca[i].getPozicia());
                System.out.println("tvoje peniaze : " + cisloHraca[i].getPeniaze());
            }
            if (cisloHraca[i].getPozicia() == 3 || cisloHraca[i].getPozicia() == 9 || cisloHraca[i].getPozicia() == 15 || cisloHraca[i].getPozicia() == 21)
            {
                stupilNaSancu(cisloHraca,i);
            } else if (cisloHraca[i].getPozicia() == 12) {
                System.out.println("Bol si uvezneni, chod na policko na pozicii 5 na 2 tahy");
                cisloHraca[i].setPozicia(6);
                cisloHraca[i].setVezenie(true);
                cisloHraca[i].setDobaVoVezeni();
            } else if (cisloHraca[i].getPozicia() == 6) {
                if (!cisloHraca[i].getVezenie()) {
                    System.out.println("Navstivil si vezenie");
                }
                if (cisloHraca[i].getVezenie() && cisloHraca[i].getDobaVoVezeni() > 0) {
                    System.out.println("Teraz sa nachadzas vo vezeni");
                    cisloHraca[i].subDobaVoVezeni();
                }
                if (cisloHraca[i].getVezenie() && cisloHraca[i].getDobaVoVezeni() == 0) {
                    System.out.println("Dalsie kolo uz vyjdes z vezenia");
                    cisloHraca[i].setVezenie(false);
                }
            } else if (cisloHraca[i].getPozicia() == 18) {
                System.out.println("Padol si na policko Platba Dane, zaplat 1000");
                cisloHraca[i].subPeniaze(1000);
            } else if (cisloHraca[i].getPozicia() == 0) {
                System.out.println("Prave stojis na starte");

            } else if (cisloDomu[cisloHraca[i].getPozicia()].getCisloHraca() == -1 || cisloHraca[cisloDomu[cisloHraca[i].getPozicia()].getCisloHraca()].getPrehral()) {
                if (cisloHraca[i].getPeniaze()>cisloDomu[cisloHraca[i].getPozicia()].getCena()) {
                    System.out.println("Mozes kupit nehnutelnost na tomto policku za " + cisloDomu[cisloHraca[i].getPozicia()].getCena());
                    System.out.println("napis y pre potvrdenie, alebo cokolvek ine pre nesuhlas");
                    String yn = scan.nextLine();
                    if (yn.equals("y")) {
                        cisloHraca[i].subPeniaze(cisloDomu[cisloHraca[i].getPozicia()].getCena());
                        cisloDomu[cisloHraca[i].getPozicia()].setCisloHraca(i);
                        System.out.println("Kupil si tuto nehnutelnost");
                    }
                }
                else {
                        System.out.println("Nemas peniaze na kupu nehnutelnosti pretoze stoji " + cisloDomu[cisloHraca[i].getPozicia()].getCena());
                }

            } else if (cisloDomu[cisloHraca[i].getPozicia()].getCisloHraca() != -1 && cisloDomu[cisloHraca[i].getPozicia()].getCisloHraca() != i) {
                System.out.println("Postavil si sa niekomu na jeho nehnutelnost, stracas " + cisloDomu[cisloHraca[i].getPozicia()].getDan());
                cisloHraca[i].subPeniaze(cisloDomu[cisloHraca[i].getPozicia()].getDan());
                cisloHraca[cisloDomu[cisloHraca[i].getPozicia()].getCisloHraca()].addPeniaze(cisloDomu[cisloHraca[i].getPozicia()].getDan());

            }else if (cisloDomu[cisloHraca[i].getPozicia()].getCisloHraca() == i) {
                System.out.println("Tuto nehnutelnost uz vlastnis");
            }
            System.out.println("tvoje peniaze po upravach : " + cisloHraca[i].getPeniaze());
            if (cisloHraca[i].getPeniaze()<1)
            {
                cisloHraca[i].setPrehral(true);
                System.out.println("Hrac cislo " + (i + 1) + " s menom " + cisloHraca[i].getMeno() + " prave teraz prehral");
            }
            System.out.println();
        }
        for (int j=0;j<pocetHracov;j++)
        {
            if (cisloHraca[j].getPrehral()) pocetPrehranych++;
        }
        if (pocetPrehranych > pocetHracov-2)
        {
            koniecHry=true;
        }
        pocetPrehranych=0;
        }
        for (int k=0;k<pocetHracov;k++)
        {
            if (!cisloHraca[k].getPrehral()) {
                System.out.println("Hrac cislo " + (k + 1) + " s menom " + cisloHraca[k].getMeno() + " vyhral tuto hru monopoly, gratulujem, ty stastko");
            }
        }
    }
}
