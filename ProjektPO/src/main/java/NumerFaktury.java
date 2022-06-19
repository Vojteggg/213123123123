import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class NumerFaktury {

    private int miesiac;
    private int rok;
    private int numer;


    private static String main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm-yyyy", Locale.ENGLISH);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }


    public void wygenerujNumer(){
        int numer = 0;

        numer++;
        System.out.println(numer);
    }




    NumerFaktury(Integer numer, Integer miesiac, Integer rok) {

        this.numer = numer;
        this.miesiac = miesiac;
        this.rok = rok;
    }

    public String toString() {
        return numer + "/" + miesiac + "-" + rok;
    }
}
