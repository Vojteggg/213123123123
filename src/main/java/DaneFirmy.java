import java.util.Scanner;

public class DaneFirmy {
    Scanner sc = new Scanner(System.in);
    private String trash;
    public String nazwa;
    public long NIP;
    public String ulica;
    public int numer;
    public String kodPocztowy;
    public String poczta;

    DaneFirmy(String nazwa, long NIP, String ulica, int numer, String kodPocztowy, String poczta) {
        this.nazwa = nazwa;
        this.NIP = NIP;
        this.ulica = ulica;
        this.numer = numer;
        this.kodPocztowy = kodPocztowy;
        this.poczta = poczta;
    }

    public DaneFirmy() {

    }

    public DaneFirmy wczytywanie() {
        System.out.println("DANE FIRMY WYSTAWIAJĄCEJ FAKTURĘ\n");
        System.out.println("Podaj nazwę firmy : ");
        String nazwaFirmyW = sc.nextLine();
        System.out.println("Podaj NIP: ");
        long nipW = sc.nextLong();
        trash = sc.nextLine();
        System.out.println("Podaj ulicę: ");
        String ulicaW = sc.nextLine();
        System.out.println("Podaj numer budynku: ");
        int numerW = sc.nextInt();
        trash = sc.nextLine();
        System.out.println("Podaj kod pocztowy: ");
        String kodPocztowyW = sc.nextLine();
        System.out.println("Podaj Miasto: ");
        String miastoW = sc.nextLine();
//        DaneFirmy wystawiajacy = new DaneFirmy(nazwaFirmyW, nipW, ulicaW, numerW, kodPocztowyW, miastoW);
//        System.out.println(wystawiajacy);
        return new DaneFirmy(nazwaFirmyW, nipW, ulicaW, numerW, kodPocztowyW, miastoW);
    }


    @Override
    public String toString() {
        return nazwa + "\n" +
                "NIP: " + NIP + "\n" +
                "Ul." + ulica + " " + numer + "\n" +
                kodPocztowy + ", " +
                poczta + "\n";
    }
}
