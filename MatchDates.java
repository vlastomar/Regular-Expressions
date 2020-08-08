import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Pattern patt = Pattern.compile("(?<day>\\d{2})([\\.\\-\\/])(?<month>[A-Z][a-z]{2})(\\2)(?<year>\\d{4})");
        Matcher mat = patt.matcher(input);

        while (mat.find()){
            String day= mat.group("day");
            String month = mat.group("month");
            String year = mat.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        }
    }
}
