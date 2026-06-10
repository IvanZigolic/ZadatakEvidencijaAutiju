package Vozila;

import java.io.*;
import java.util.ArrayList;

public class EvidencijaVozila {
    public static String spremiPodatkeUDatoteku(ArrayList<Vozilo> ListaVozila) throws IOException {
        File baza = new File("C:/Tecaj/Evidencija.txt");
        baza.createNewFile();
        if (baza.exists()) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(baza, true))) {
                for (Vozilo vozilo : ListaVozila) {
                    if (vozilo instanceof Automobil) {
                        Automobil a = (Automobil) vozilo;
                        pw.println(a.getClass().getSimpleName() + ", " + a.getMarka() + ", " + a.getGodPr() + ", " + a.getRegOz() + ", " + a.getBrojVrata());
                    } else if (vozilo instanceof Motocikl) {
                        Motocikl m = (Motocikl) vozilo;
                        pw.println(m.getClass().getSimpleName() + ", " + m.getMarka() + ", " + m.getGodPr() + ", " + m.getRegOz() + ", " + m.getTipMotora());
                    } else {
                        pw.println(vozilo.getClass().getSimpleName() + ", " + vozilo.getMarka() + ", " + vozilo.getGodPr() + ", " + vozilo.getRegOz());
                    }
                }
            }
        } else {
            throw new NeispravniPodatciException("Datoteka na toj putanji ne postoji!");
        }
        return "";
    }

    public static String dohvatiPodatkeIzDatoteke(ArrayList<Vozilo> ListaVozila) throws IOException {
        File baza = new File("C:/Tecaj/Evidencija.txt");
        if (baza.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(baza))) {
                String redak;
                while ((redak = br.readLine()) != null) {
                    String[] dijelovi = redak.split(", ");
                    String tip = dijelovi[0];
                    String marka = dijelovi[1];
                    int godPr = Integer.parseInt(dijelovi[2]);
                    String regOz = dijelovi[3];
                    switch (tip) {
                        case "Automobil":
                            int brojVrata = Integer.parseInt(dijelovi[4]);
                            ListaVozila.add(new Automobil(marka, godPr, regOz, brojVrata));
                            break;
                        case "Motocikl":
                            String tipMotora = dijelovi[4];
                            ListaVozila.add(new Motocikl(marka, godPr, regOz, tipMotora));
                            break;
                        default:
                            ListaVozila.add(new Vozilo(marka, godPr, regOz));
                    }
                }
            }
        } else {
            throw new NeispravniPodatciException("Datoteka ne postoji!");
        }
        return "";
    }
}