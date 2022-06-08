import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


public class ComparingDates {
    String dateOfSell;
    String dateOfIssue;

    public ComparingDates(String dateOfSell, String dateOfIssue) {
        try {
            Date start = new SimpleDateFormat("d.M.yyyy", Locale.ENGLISH)
                    .parse(dateOfSell);
            Date end = new SimpleDateFormat("d.M.yyyy", Locale.ENGLISH)
                    .parse(dateOfIssue);

            System.out.println(start);
            System.out.println(end);

            while (start.compareTo(end) > 0) {
                System.out.println("Powtórz dodawanie daty sprzedaży!");
                break;
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }


}


