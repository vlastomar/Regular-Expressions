import java.util.Scanner;
import java.util.function.IntSupplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class RagQuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Pattern patt = Pattern.compile("(?<symbol>[^0-9]+)(?<number>\\d+)");
        Matcher mat = patt.matcher(input);
        StringBuilder result = new StringBuilder();
        while (mat.find()){
            String symb = mat.group("symbol");
            symb = symb.toUpperCase();
            String numb = mat.group("number");
            int number = Integer.parseInt(numb);
            for (int i = 0; i <number ; i++) {
                result.append(symb);
            }

        }

        long count = result.chars().distinct().count();
        System.out.printf("Unique symbols used: %d\n", result.chars().distinct().count());
        System.out.println(result);

    }
}
