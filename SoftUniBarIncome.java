import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern patt = Pattern.compile("\\%(?<name>[A-Z][a-z]+)\\%([^\\|\\.\\$\\%]*)\\<(?<product>\\w+)\\>([^\\|\\.\\$\\%]*)\\|(?<count>\\d+)\\|([^\\|\\%\\.\\$\\d]*)(?<price>\\d+\\.?\\d*)\\$");

        double sum = 0.0;
        String input = scan.nextLine();
        while (!"end of shift".equals(input)){
            Matcher mat = patt.matcher(input);
            while (mat.find()){
                String name = mat.group("name");
                String product = mat.group("product");
                String pcsS = mat.group("count");
                int pcs = Integer.parseInt(pcsS);
                double pricePerOne = Double.parseDouble(mat.group("price"));
                sum += pricePerOne * 1.0 * pcs;
                System.out.printf("%s: %s - %.2f%n", name, product, pcs * 1.00 * pricePerOne);
            }

            input = scan.nextLine();
        }
        System.out.printf("Total income: %.2f" , sum);
    }
}
