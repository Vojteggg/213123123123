import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String trash;
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


            System.out.println("DATA WYSTAWIENIA FAKTURY\n");
            System.out.println("Podaj dzień: ");
            int dzien = sc.nextInt();

            System.out.println("Podaj miesiąc: ");
            int miesiac = sc.nextInt();

            System.out.println("Podaj rok: ");
            int rok = sc.nextInt();

            String dataSprzedazy = String.valueOf(new sellingDate(dzien, miesiac, rok));
            String dataWystawienia = getDate.main(args);
            new ComparingDates(dataSprzedazy, dataWystawienia);

            System.out.println(dataWystawienia);


            System.out.println("Ile chcesz dodać towarów na fakturę?");
            int n = sc.nextInt();
            List<Towar> towary = new ArrayList<>();
            List<Double> sumy = new ArrayList<>();
            for (int i=0;i<n;i++){
                System.out.println("Podaj nazwę towaru: ");
                String name = sc.nextLine();
                System.out.println("Podaj cenę brutto towaru: ");
                Double cena = sc.nextDouble();
                System.out.println("Podaj podatek VAT towaru: ");
                int VAT = sc.nextInt();
                System.out.println("Podaj jednostki miary towaru (szt/L/op): ");
                String jm = sc.nextLine();
                System.out.println("Podaj ilosc towaru: ");
                double ilosc = sc.nextDouble();
                Towar towarN = new Towar(name,VAT,cena,jm);
                Double sumaCalkowita = towarN.sumacalkowita(towarN,ilosc);
                towary.add(towarN);
                sumy.add(sumaCalkowita);
            }
        } catch (InputMismatchException exception){
            System.out.println("Nieprawidłowy format danych! Spróbuj ponownie.");
        }




    }
}
