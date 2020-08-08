import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Pattern patt = Pattern.compile("(^| )[A-Za-z0-9]+[A-Za-z.\\-_0-9]*@{1}[A-Za-z._-]+(\\.[a-z]+)+");
        Matcher mat = patt.matcher(input);
        while (mat.find()){
            System.out.println(mat.group());
        }
    }
}
