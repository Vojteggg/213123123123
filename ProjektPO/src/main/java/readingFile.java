import java.io.*;
import java.util.*;

public class readingFile {
    public static String main (String[] args) throws Exception {
        File file = new File(
                "/Users/wojtek/Desktop/database.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){

            System.out.println(sc.nextLine());
        }
        return "Koniec odczytu.";
    }
}
