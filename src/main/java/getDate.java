import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class getDate {
    public static String main() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);

    }


}
