import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        List<String> numbers = new ArrayList<>();

        Pattern patt = Pattern.compile("\\+359([\\- ])2(\\1)\\d{3}(\\1)\\d{4}\\b");
        Matcher mat = patt.matcher(input);

        while (mat.find()){
            String phone = mat.group();
            numbers.add(phone);
        }
        System.out.print(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
