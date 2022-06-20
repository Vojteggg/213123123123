import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;

public class Faktura {

    Double sumaWszystkiego = 0.0;
    DaneFirmy wystawiajacy;
    DaneFirmy nabywca;
    PDDocument fakturaFV;
    String dataSprzedazy;
    int n;
    String fakturaTitle = "Faktura VAT wygenerowana przez WL i AW";
    static List<Towar> towary = new ArrayList<>();
    List<Double> sumy = new ArrayList<>();
    List<Double> ilosci = new ArrayList<>();

    Faktura() {
        fakturaFV = new PDDocument();
        PDPage nowastrona = new PDPage();
        fakturaFV.addPage(nowastrona);
    }

    public String remove(String bufstr) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < bufstr.length(); i++) {
            if (WinAnsiEncoding.INSTANCE.contains(bufstr.charAt(i))) {
                b.append(bufstr.charAt(i));
            }
        }
        return b.toString();
    }


    void getData() {
        Scanner sc = new Scanner(System.in);
        String trash;
        System.out.println("DANE FIRMY WYSTAWIAJĄCEJ FAKTURĘ\n");
        System.out.println("Podaj nazwę firmy : ");
//        String nazwaFirmyW = sc.nextLine();
        String nazwaFirmyW = "jp";
        System.out.println("Podaj NIP: ");
//        long nipW = sc.nextLong();
        long nipW = 12345678;
//        trash = sc.nextLine();
        System.out.println("Podaj ulicę: ");
//        String ulicaW = sc.nextLine();
        String ulicaW = "dobra";
        System.out.println("Podaj numer budynku: ");
//        int numerW = sc.nextInt();
        int numerW = 123;
        System.out.println("Podaj kod pocztowy: ");
        String kodPocztowyW = "00-001";
//        trash = sc.nextLine();
//        String kodPocztowyW = sc.nextLine();
        System.out.println("Podaj Miasto: ");
//        String miastoW = sc.nextLine();
        String miastoW = "WojtekProszeNieBadzZly";
        wystawiajacy = new DaneFirmy(nazwaFirmyW, nipW, ulicaW, numerW, kodPocztowyW, miastoW);
        System.out.println(wystawiajacy);


        System.out.println("DANE FIRMY NABYWAJĄCEJ FAKTURĘ\n");
        System.out.println("Podaj nazwę firmy: ");
//        String nazwaFirmyN = sc.nextLine();
        String nazwaFirmyN = "jp2";

        System.out.println("Podaj NIP: ");
//        long nipN = sc.nextLong();
//        trash = sc.nextLine();
        long nipN = 321578376;

        System.out.println("Podaj ulicę: ");
//        String ulicaN = sc.nextLine();
        String ulicaN = "fajna";

        System.out.println("Podaj numer budynku: ");
//        int numerN = sc.nextInt();
        int numerN = 24;
//        trash = sc.nextLine();

        System.out.println("Podaj kod pocztowy: ");
//        String kodPocztowyN = sc.nextLine();
        String kodPocztowyN = "00-000";


        System.out.println("Podaj Miasto: ");
//        String miastoN = sc.nextLine();
        String miastoN = "AdamProszeNieWkurwiajMnie";
        nabywca = new DaneFirmy(nazwaFirmyN, nipN, ulicaN, numerN, kodPocztowyN, miastoN);


        System.out.println("DATA WYSTAWIENIA FAKTURY\n");
        System.out.println("Podaj dzień: ");
        int dzien = sc.nextInt();

        System.out.println("Podaj miesiąc: ");
        int miesiac = sc.nextInt();

        System.out.println("Podaj rok: ");
        int rok = sc.nextInt();

        dataSprzedazy = String.valueOf(new sellingDate(dzien, miesiac, rok));
//        String dataWystawienia = getDate.main();
//        new ComparingDates(dataSprzedazy, dataWystawienia);

//        System.out.println(dataWystawienia);


                System.out.println("Ile chcesz dodać towarów na fakturę?");
                int n = sc.nextInt();

                for (int i = 0; i < n; i++) {
                    System.out.println("Podaj nazwę towaru: ");
                    trash = sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Podaj cenę brutto towaru: ");
                    Double cena = sc.nextDouble();
                    trash = sc.nextLine();
                    System.out.println("Podaj podatek VAT towaru: ");
                    int VAT = sc.nextInt();
                    System.out.println("Podaj ilosc towaru: ");
                    double ilosc = sc.nextDouble();
                    Towar towarN = new Towar(name, VAT, cena);
                    Double sumaCalkowita = towarN.sumacalkowita(towarN, ilosc);
                    ilosci.add(ilosc);
                    towary.add(towarN);
                    sumy.add(sumaCalkowita);
                }
        for (int i = 0; i < n; i++){
            System.out.println(towary.get(i).getName(towary.get(i)));
            System.out.println(towary.get(i).getPrice(towary.get(i)));
            System.out.println(towary.get(i).getVAT(towary.get(i)));
        }

    }

    void tworzenieFV() {
        PDPage mojastrona = fakturaFV.getPage(0);
        try {
            PDFont font = PDType0Font.load(fakturaFV, new File("C:\\Windows\\Fonts\\Calibri.ttf"));
            PDPageContentStream cs = new PDPageContentStream(fakturaFV, mojastrona);
            NumerFaktury numerFV= new NumerFaktury();
            String numerFV1 = numerFV.numerFaktyczny();

            System.out.println(numerFV);
            //Pisanie pojedynczej linii tekstu
            //Pisanie tytułu
            cs.beginText();
            cs.setFont(font, 20);
            cs.newLineAtOffset(20, 750);
            cs.showText(remove(fakturaTitle));
            cs.endText();

            cs.beginText();
            cs.setFont(font, 14);
            cs.newLineAtOffset(20, 710);
            cs.showText("Data Wystawienia : " + getDate.main());
            cs.endText();

            cs.beginText();
            cs.setFont(font, 14);
            cs.newLineAtOffset(20, 690);
            cs.showText("Data Sprzedaży : " + dataSprzedazy);
            cs.endText();


            cs.beginText();
            cs.setFont(font, 18);
            cs.newLineAtOffset(20, 730);
            cs.showText(remove("Faktura VAT nr. " + numerFV1));
            cs.endText();

            cs.beginText();
            cs.setFont(font, 14);
            cs.setLeading(20f);
            cs.newLineAtOffset(20, 660);
            cs.showText("Wystawiajacy fakture: ");
            cs.newLine();
            cs.showText(wystawiajacy.nazwa);
            cs.newLine();
            cs.showText("NIP: " + wystawiajacy.NIP);
            cs.newLine();
            cs.showText("Ul. " + wystawiajacy.ulica + " " + wystawiajacy.numer);
            cs.newLine();
            cs.showText(wystawiajacy.kodPocztowy + " " + wystawiajacy.poczta);
            cs.endText();

            cs.beginText();
            cs.setFont(font, 14);
            cs.setLeading(20f);
            cs.newLineAtOffset(300, 660);
            cs.showText("Sprzedawca: ");
            cs.newLine();
            cs.showText(nabywca.nazwa);
            cs.newLine();
            cs.showText("NIP: " + nabywca.NIP);
            cs.newLine();
            cs.showText("Ul. " + nabywca.ulica + " " + nabywca.numer);
            cs.newLine();
            cs.showText(nabywca.kodPocztowy + " " + nabywca.poczta);
            cs.endText();



            cs.beginText();
            cs.setFont(font, 14);
            cs.newLineAtOffset(20, 500);
            cs.showText("Nazwa Produktu");
            cs.endText();


            cs.beginText();
            cs.setFont(font, 14);
            cs.newLineAtOffset(140, 500);
            cs.showText("Cena brutto");
            cs.endText();

            cs.beginText();
            cs.setFont(font, 14);
            cs.newLineAtOffset(260, 500);
            cs.showText("Ilosc");
            cs.endText();

            cs.beginText();
            cs.setFont(font, 14);
            cs.newLineAtOffset(320, 500);
            cs.showText("VAT");
            cs.endText();

            cs.beginText();
            cs.setFont(font, 14);
            cs.newLineAtOffset(380, 500);
            cs.showText("Wartosc brutto");
            cs.endText();

            cs.beginText();
            cs.setFont(font, 12);
            cs.setLeading(20f);
            cs.newLineAtOffset(20, 500);
            for(int i =0; i<n; i++) {
                cs.showText(String.valueOf(towary.get(i).getName(towary.get(i))));
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setFont(font, 12);
            cs.setLeading(20f);
            cs.newLineAtOffset(140, 520);
            for(int i =0; i<n; i++) {
                cs.showText(String.valueOf(towary.get(i).getPrice(towary.get(i))));
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setFont(font, 12);
            cs.setLeading(20f);
            cs.newLineAtOffset(260, 520);
            for(int i =0; i<n; i++) {
                cs.showText(String.valueOf(ilosci.get(i)));
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setFont(font, 12);
            cs.setLeading(20f);
            cs.newLineAtOffset(320, 520);
            for(int i =0; i<n; i++) {
                cs.showText(String.valueOf(towary.get(i).getVAT(towary.get(i))));
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setFont(font, 12);
            cs.setLeading(20f);
            cs.newLineAtOffset(380, 520);
            for(int i =0; i<n; i++) {
                cs.showText(String.valueOf(sumy.get(i)));
                cs.newLine();
            }
            cs.endText();





            String sciezka = numerFV1+ ".pdf";
            cs.close();
            //Zapisz pdf
            fakturaFV.save(sciezka);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Faktura FV = new Faktura();

        FV.getData();
        FV.tworzenieFV();

//        String numer = String.valueOf(new NumerFaktury());
//        System.out.println(String.valueOf(new NumerFaktury()));


    }
}