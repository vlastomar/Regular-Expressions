import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String items = "";
        String input    = scan.nextLine();
        while(!"Purchase".equals(input)){
            items += input + ", ";
            input = scan.nextLine();
        }
        Pattern patt = Pattern.compile("\\>\\>(?<name>[A-Z]+[a-z]*)\\<\\<(?<price>\\d+[\\.]*\\d*)\\!(?<pcs>\\d+)\\b");
        Matcher mat = patt.matcher(items);
        double totalMoney = 0.0;
        System.out.println("Bought furniture:");
        while (mat.find()){
            String name = mat.group("name");
            System.out.println(name);
            String price = mat.group("price");
            String pcs = mat.group("pcs");
            double priceD = Double.parseDouble(price);
            int pcsI = Integer.parseInt(pcs);
            totalMoney += priceD * pcsI * 1.0;
        }
        System.out.printf("Total money spend: %.2f", totalMoney);
    }
}