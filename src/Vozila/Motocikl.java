package Vozila;

public class Motocikl extends Vozilo{
    private String tipMotora = "";

    public Motocikl(String marka, int godPr, String regOz, String tipMotora) {
        super(marka, godPr, regOz);
        this.tipMotora = tipMotora;
    }

    public String getTipMotora() {
        return tipMotora;
    }

    public void setTipMotora(String tipMotora) {
        this.tipMotora = tipMotora;
    }

    @Override
    public String prikaziPodatke() {
        return "Motocikl marke " + Marka + " registarske oznake " + regOz + " je proizvedeno " + godPr + " s " + tipMotora + " tipom motora";
    }
}