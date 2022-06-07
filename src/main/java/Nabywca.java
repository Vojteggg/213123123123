public class Nabywca {
    String nazwa;
    int NIP;
    String ulica;
    int numer;
    String kodPocztowy;
    String poczta;

    Nabywca(String nazwa, int NIP, String ulica, int numer, String kodPocztowy, String poczta){
        this.nazwa=nazwa;
        this.NIP=NIP;
        this.ulica=ulica;
        this.numer=numer;
        this.kodPocztowy=kodPocztowy;
        this.poczta=poczta;
    }

    @Override
    public String toString() {
        return "Nabywający fakturę: " +
                nazwa + '\n' +
                "NIP: " + NIP + "\n" +
                "Ul. '" + ulica + numer + "\n" +
                kodPocztowy + ", " +
                poczta + '\n';
    }
}
