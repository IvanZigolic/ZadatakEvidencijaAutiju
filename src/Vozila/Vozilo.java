package Vozila;

public class Vozilo {
    public String regOz = "";
    public String Marka = "";
    public int godPr = 0;

    public Vozilo(String marka, int godPr, String regOz) {
        Marka = marka;
        this.godPr = godPr;
        this.regOz = regOz;
    }

    public String getRegOz() {
        return regOz;
    }

    public void setRegOz(String regOz) {
        this.regOz = regOz;
    }

    public String getMarka() {
        return Marka;
    }

    public void setMarka(String marka) {
        Marka = marka;
    }

    public int getGodPr() {
        return godPr;
    }

    public void setGodPr(int godPr) {
        this.godPr = godPr;
    }
    public String prikaziPodatke() {
        return "Vozilo marke " + Marka + " registarske oznake " + regOz + " je proizvedeno " + godPr + " godine";
    }
}
