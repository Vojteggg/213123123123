import java.util.Scanner;

public class Wczytywanie {
    Wczytywanie() {

    }

    Scanner sc = new Scanner(System.in);
    String trash;
    public DaneFirmy wczytDaneWystaw(){

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
        DaneFirmy wystawiajacy = new DaneFirmy(nazwaFirmyW, nipW, ulicaW, numerW, kodPocztowyW, miastoW);
        System.out.println(wystawiajacy);
        return wystawiajacy;
    }
    public DaneFirmy wczytDaneKup(){
        System.out.println("DANE FIRMY NABYWAJĄCEJ FAKTURĘ\n");
        System.out.println("Podaj nazwę firmy: ");
        String nazwaFirmyN = sc.nextLine();

        System.out.println("Podaj NIP: ");
        long nipN = sc.nextLong();
        trash = sc.nextLine();

        System.out.println("Podaj ulicę: ");
        String ulicaN = sc.nextLine();

        System.out.println("Podaj numer budynku: ");
        int numerN = sc.nextInt();
        trash = sc.nextLine();

        System.out.println("Podaj kod pocztowy: ");
        String kodPocztowyN = sc.nextLine();

        System.out.println("Podaj Miasto: ");
        String miastoN = sc.nextLine();
        DaneFirmy nabywca = new DaneFirmy(nazwaFirmyN, nipN, ulicaN, numerN, kodPocztowyN, miastoN);

        System.out.println(nabywca);
        return nabywca;
    }
    public String wczytDaneSprzed(){
        System.out.println("DATA WYSTAWIENIA FAKTURY\n");
        System.out.println("Podaj dzień: ");
        int dzien = sc.nextInt();

        System.out.println("Podaj miesiąc: ");
        int miesiac = sc.nextInt();

        System.out.println("Podaj rok: ");
        int rok = sc.nextInt();


        String dataSprzedazy = String.valueOf(new sellingDate(dzien, miesiac, rok));
        return dataSprzedazy;

    }
}
