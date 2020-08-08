import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        List<String> attack = new ArrayList<>();
        List<String> destroy = new ArrayList<>();

        for (int i = 0; i < number ; i++) {
            String input = scan.nextLine();
            Pattern patt = Pattern.compile("[SsTtAaRr]");
            Matcher mat = patt.matcher(input);
            int count = 0;
            while (mat.find()){
                count++;
            }
            String message = "";
            for (int j = 0; j <input.length() ; j++) {
                char temp = input.charAt(j);
                temp -= count;
                message += temp;
            }
            patt = Pattern.compile("\\@(?<name>[A-Za-z]+)([^\\:\\@\\-\\!\\>]*)\\:(?<population>\\d+)([^\\:\\@\\-\\!\\>]*)\\!(?<attack>[A|D])\\!([^\\:\\@\\-\\!\\>]*)\\-\\>(?<soldier>\\d*)");
            mat = patt.matcher(message);
            while (mat.find()){
                String attacked = mat.group("attack");
                 String name = mat.group("name");
                if ("A".equals(attacked)){
                    attack.add(name);
                }else if ("D".equals(attacked)){
                    destroy.add(name);
                }
            }


        }
        attack.sort((s1,s2) -> s1.compareTo(s2));
        destroy.sort((s1,s2) -> s1.compareTo(s2));
        System.out.printf("Attacked planets: %d%n", attack.size());
        if (attack.size() > 0){
            for (String word : attack){
                System.out.printf("-> %s%n", word);
            }
        }
        System.out.printf("Destroyed planets: %d%n", destroy.size());
        if (destroy.size() > 0){
            for (String word : destroy){
                System.out.printf("-> %s%n", word);
            }
        }

    }
}
