package Vozila;

public class NeispravniPodatciException extends RuntimeException {
    public NeispravniPodatciException(String poruka) {
        super(poruka);
    }
}
