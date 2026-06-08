package Vozila;

import Vozila.*;

import java.io.IOException;

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
    public void ucitajPodatke(String unos, String odabir) throws NeispravniPodatciException {
        System.out.println("Unesite podatke: 1. Registarska oznaka\n 2. Marka\n 3. Godina proizvodnje\n 4. Dohvatite podatke");
        if(unos.equals("1") || unos.equals("Registarska oznaka")){
            setRegOz(odabir);
        }
        else if(unos.equals("2") || unos.equals("Marka")){
            setMarka(odabir);
        }
        else if(unos.equals("3") || unos.equals("Godina proizvodnje")){
            setGodPr(Integer.parseInt(odabir));
        }
        else if(unos.equals("4") || unos.equals("Dohvatite podatke")){
            prikaziPodatke();
        }
        else{
            throw new NeispravniPodatciException("Pogresan unos: " + unos);
        }
    }
    public String prikaziPodatke() {
        return "Vozilo marke " + Marka + " registarske oznake " + regOz + " je proizvedeno " + godPr;
    }
}
