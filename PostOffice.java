import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\|");
        String[] words = input[2].split("\\s+");
        List<String> readyPrint = new ArrayList<>();
        Pattern patt = Pattern.compile("([#|$|%|\\*|&])(?<first>[A-Z]*)(\\1)");
        Matcher mat = patt.matcher(input[0]);
        String first = "";
        while (mat.find()){
            first = mat.group("first");
        }

        Pattern patt2 = Pattern.compile("(?<second1>\\d{2}):(?<second2>\\d{2})");
        Matcher mat2 = patt2.matcher(input[1]);
        while (mat2.find()){
            int letterCode = Integer.parseInt(mat2.group("second1"));
            char lett = (char)letterCode;
            String letter = lett + "";
            int length = Integer.parseInt(mat2.group("second2"));
            if (length >= 1 && length <= 20){

                for (int i = 0; i <words.length ; i++) {
                    if (first.contains(letter) && words[i].charAt(0) == lett && words[i].length() == length + 1){

                        readyPrint.add(words[i]);
                    }
                }
            }
        }
        for (int i = 0; i <first.length() ; i++) {
            char temp = first.charAt(i);
            for (int j = 0; j <readyPrint.size() ; j++) {
                if (readyPrint.get(j).charAt(0) == temp){
                    System.out.println(readyPrint.get(j));
                    break;
                }
            }

        }
    }
}
