import Vozila.Automobil;
import Vozila.Motocikl;
import Vozila.NeispravniPodatciException;
import Vozila.Vozilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static Vozila.EvidencijaVozila.dohvatiPodatkeIzDatoteke;
import static Vozila.EvidencijaVozila.spremiPodatkeUDatoteku;

public class Main {
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
                                if (!(brVr >= 2 && brVr <= 5)) {
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