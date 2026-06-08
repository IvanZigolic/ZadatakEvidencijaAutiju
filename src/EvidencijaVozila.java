import Vozila.*;
import java.io.*;
import java.util.ArrayList;

public class EvidencijaVozila {
    public static String spremiPodatkeUDatoteku(ArrayList<Vozilo> ListaVozila) throws IOException {
        File baza = new File("C:/Evidencija.txt");
        baza.createNewFile();
        if (baza.exists()) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(baza, true))) {
                for (Vozilo vozilo : ListaVozila) {
                    pw.println(vozilo.getClass().getSimpleName() + ", " + vozilo.getMarka() + ", " + vozilo.getRegOz() + ", " + vozilo.getGodPr());
                }
            }
        } else {
            throw new NeispravniPodatciException("Datoteka na toj putanji ne postoji!");
        }
        return "";
    }
    public static String dohvatiPodatkeIzDatoteke(ArrayList<Vozilo> ListaVozila) throws IOException {
        File baza = new File("C:/Evidencija.txt");
        if (baza.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(baza))) {
                String redak;
                while ((redak = br.readLine()) != null) {
                    String[] dijelovi = redak.split(", ");
                    String tip = dijelovi[0];
                    String marka = dijelovi[1];
                    String regOz = dijelovi[2];
                    int godPr = Integer.parseInt(dijelovi[3]);
                    switch (tip) {
                        case "Automobil":
                            ListaVozila.add(new Automobil(marka, godPr, regOz, 0));
                            break;
                        case "Motocikl":
                            ListaVozila.add(new Motocikl(marka, godPr, regOz, "nepoznato"));
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
    public static void main(String[] args) throws IOException {
        boolean meni = true;
        ArrayList<Vozilo> ListaVozila = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (meni) {
                System.out.println("Unesite vozilo:\n 1. Vozilo\n 2. Automobil\n 3. Motocikl\n 4. Spremi podatke u datoteku\n 5. Dohvatite podatke iz datoteke\n 6. Ispisi listu\n 7. Izlaz");
                try {
                    String unos = br.readLine();
                    switch (unos) {
                        case "1":
                        case "Vozilo": {
                            try {
                                System.out.println("Unesite marku vozila");
                                String nazivV = br.readLine();
                                System.out.println("Unesite godinu proizvodnje vozila");
                                int GodPr = Integer.parseInt(br.readLine());
                                if (!(GodPr >= 1886 && GodPr <= 2026)) {
                                    throw new NeispravniPodatciException("Pogresno unesena godina proizvodnje!");
                                }
                                System.out.println("Unesite registarsku oznaku vozila");
                                String rega = br.readLine();
                                ListaVozila.add(new Vozilo(nazivV, GodPr, rega));
                                System.out.println("Vozilo dodano: " + nazivV + ", " + GodPr + ", " + rega);
                            } catch (NeispravniPodatciException e) {
                                System.err.println(e.getMessage());
                            }
                            break;
                        }
                        case "2":
                        case "Automobil": {
                            try {
                                System.out.println("Unesite marku auta");
                                String nazivV = br.readLine();
                                System.out.println("Unesite godinu proizvodnje auta");
                                int GodPr = Integer.parseInt(br.readLine());
                                if (!(GodPr >= 1886 && GodPr <= 2026)) {
                                    throw new NeispravniPodatciException("Pogresno unesena godina proizvodnje!");
                                }
                                System.out.println("Unesite registarsku oznaku auta");
                                String rega = br.readLine();
                                System.out.println("Unesite broj vrata automobila");
                                int brVr = Integer.parseInt(br.readLine());
                                if (!(brVr >= 1 && brVr <= 5)) {
                                    throw new NeispravniPodatciException("Pogresno unesen broj vrata automobila!");
                                }
                                ListaVozila.add(new Automobil(nazivV, GodPr, rega, brVr));
                                System.out.println("Automobil dodan: " + nazivV + ", " + GodPr + ", " + rega + ", " + brVr);
                            } catch (NeispravniPodatciException e) {
                                System.err.println(e.getMessage());
                            }
                            break;
                        }
                        case "3":
                        case "Motocikl": {
                            try {
                                System.out.println("Unesite marku motocikla");
                                String nazivV = br.readLine();
                                System.out.println("Unesite godinu proizvodnje motocikla");
                                int GodPr = Integer.parseInt(br.readLine());
                                if (!(GodPr >= 1885 && GodPr <= 2026)) {
                                    throw new NeispravniPodatciException("Pogresno unesena godina proizvodnje!");
                                }
                                System.out.println("Unesite registarsku oznaku motocikla");
                                String rega = br.readLine();
                                System.out.println("Unesite tip motora motocikla");
                                String tipM = br.readLine();
                                ListaVozila.add(new Motocikl(nazivV, GodPr, rega, tipM));
                                System.out.println("Motocikl dodan: " + nazivV + ", " + GodPr + ", " + rega + ", " + tipM);
                            } catch (NeispravniPodatciException e) {
                                System.err.println(e.getMessage());
                            }
                            break;
                        }
                        case "4":
                        case "Spremi podatke": {
                            try {
                                spremiPodatkeUDatoteku(ListaVozila);
                                ListaVozila.clear();
                                System.out.println("Podatci iz liste su spremljeni u datoteku!");
                            } catch (NeispravniPodatciException e) {
                                System.err.println(e.getMessage());
                            }
                            break;
                        }
                        case "5":
                        case "Dohvatite podatke": {
                            try {
                                dohvatiPodatkeIzDatoteke(ListaVozila);
                                System.out.println("Podatci ucitani iz datoteke u listu!");
                            } catch (NeispravniPodatciException e) {
                                System.err.println(e.getMessage());
                            }
                            break;
                        }
                        case "6":
                        case "Ispisi listu": {
                            if (ListaVozila.isEmpty()) {
                                System.out.println("Lista je prazna!");
                            } else {
                                System.out.println("||-----ISPIS IZ LISTE-----||");
                                for (Vozilo vozilo : ListaVozila) {
                                    System.out.println(vozilo.prikaziPodatke());
                                }
                                System.out.println("||------------------------||");
                            }
                            break;
                        }
                        case "7":
                        case "Izlaz": {
                            System.out.println("Izasli ste iz menija");
                            ListaVozila.clear();
                            meni = false;
                            break;
                        }
                        default:
                            System.out.println("Nepoznata opcija, pokusajte ponovo.");
                    }
                } catch (NeispravniPodatciException e) {
                    System.out.println("Greska: unesite broj!");
                }
            }
        }
    }
}