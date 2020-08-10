import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int key = Integer.parseInt(scan.nextLine());
        StringBuilder correct = new StringBuilder();

        String input = scan.nextLine();
        while (!"end".equals(input)){
            StringBuilder message = new StringBuilder(input);
            for (int i = 0; i <message.length() ; i++) {
                char temp = message.charAt(i);
                int temp1 = (int)temp - key;
                temp = (char)temp1;
                correct.append(temp);
            }
            Pattern patt = Pattern.compile("@(?<name>[A-Za-z]+)[^!@\\-:>]*!(?<type>[G|N])!");
            Matcher mat = patt.matcher(correct);
            while (mat.find()){
                String name = mat.group("name");
                String type = mat.group("type");
                if ("G".equals(type)){
                    System.out.println(name);
                }
            }

            input = scan.nextLine();
            correct.setLength(0);
        }
    }
}

