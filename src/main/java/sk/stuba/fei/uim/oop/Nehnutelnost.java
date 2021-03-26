package sk.stuba.fei.uim.oop;

public class Nehnutelnost {
    public int cena=400;
    public int dan =100;
    public int cisloHraca = -1;

    public void setCena(int nasobok){
        this.cena*=nasobok;
    }
    public int getCena(){
        return cena;
    }

    public void setDan(int nasobok){
        this.dan*=nasobok;
    }
    public int getDan(){
        return dan;
    }

    public void setCisloHraca(int cislo){
        this.cisloHraca=cislo;
    }
    public int getCisloHraca(){
        return cisloHraca;
    }
}
