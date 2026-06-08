package Vozila;

public class Automobil extends Vozilo{
    private int brojVrata = 0;

    public Automobil(String marka, int godPr, String regOz, int brojVrata) {
        super(marka, godPr, regOz);
        this.brojVrata = brojVrata;
    }

    public int getBrojVrata() {
        return brojVrata;
    }

    public void setBrojVrata(int brojVrata) {
        this.brojVrata = brojVrata;
    }

    @Override
    public String prikaziPodatke() {
        return "Automobil marke " + Marka + " registarske oznake " + regOz + " je proizvedeno " + godPr + " s " + brojVrata + " vrata";
    }
}