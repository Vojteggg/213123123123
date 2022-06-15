import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Wczytywanie wczyt = new Wczytywanie();
        //Wystawiający fakturę
        wczyt.wczytDaneWystaw();
        //Klient
        wczyt.wczytDaneKup();
        //Wczytywanie daty sprzedazy
        wczyt.wczytDaneSprzed();


        

       //  new ComparingDates(dataSprzedazy,dataWystawienia);
        String dataWystawienia = getDate.main(args);
        System.out.println();

    }

}
