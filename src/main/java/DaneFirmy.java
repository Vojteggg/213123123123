import java.util.Scanner;

public class DaneFirmy {
    private String nazwa;
    private long NIP;
    private String ulica;
    private int numer;
    private String kodPocztowy;
    private String poczta;

    DaneFirmy (String nazwa, long NIP, String ulica, int numer, String kodPocztowy, String poczta) {
        this.nazwa = nazwa;
        this.NIP = NIP;
        this.ulica = ulica;
        this.numer = numer;
        this.kodPocztowy = kodPocztowy;
        this.poczta = poczta;
    }


    @Override
    public String toString() {
        return "Dane firmy: " +
                nazwa + "\n" +
                "NIP: " + NIP + "\n" +
                "Ul." + ulica + " " + numer + "\n" +
                kodPocztowy + ", " +
                poczta + '\n';
    }
}
