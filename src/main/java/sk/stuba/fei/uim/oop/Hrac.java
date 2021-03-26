package sk.stuba.fei.uim.oop;

public class Hrac {
    private int peniaze = 10000;
    public int pozicia = 0;
    private int dobaVoVezeni = 0;
    public boolean vezenie = false;
    public boolean prehral = false;
    String meno = "";

    public int getDobaVoVezeni(){
        return dobaVoVezeni;
    }
    public void setDobaVoVezeni() {
        this.dobaVoVezeni = 2;
    }
    public void subDobaVoVezeni() {
        this.dobaVoVezeni--;
    }
    public boolean getVezenie() {
        return vezenie;
    }
    public void setVezenie(boolean anoNie) {
        this.vezenie = anoNie;
    }
    public boolean getPrehral() {
        return prehral;
    }
    public void setPrehral(boolean anoNie) {
        this.prehral = anoNie;
    }
    public String getMeno() {
        return meno;
    }
    public void setMeno(String noveMeno) {
        this.meno = noveMeno;
    }
    public int getPeniaze(){
        return peniaze;
    }
    public void addPeniaze(int pridajPeniaze){
        this.peniaze+= pridajPeniaze;
    }
    public void subPeniaze(int odcitajPeniaze){
        this.peniaze-= odcitajPeniaze;
    }
    public int getPozicia() {
        return pozicia;
    }
    public void setPozicia(int pozicia) {
        this.pozicia = pozicia;
    }

}
