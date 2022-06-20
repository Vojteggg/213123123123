import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class NumerFaktury {


    private String data() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-YYYY", Locale.ENGLISH);
        LocalDateTime now = LocalDateTime.now();
        String Date = dtf.format(now);
        return Date;
    }

    NumerFaktury() {
    }

    public String numerFaktyczny(){
        String data = data();
        int numerfv = 0;
        numerfv++;
        String numerek = numerfv + "-" + data;
        return numerek;
    }

}