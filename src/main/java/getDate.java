import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class getDate {
    public static String main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);

    }


}
