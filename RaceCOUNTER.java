import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RaceCOUNTER {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String initial = scan.nextLine();
        String[] players = initial.split(", ");
        Map <String,Integer> playersMap = new LinkedHashMap<>();
        //AtomicInteger count = new AtomicInteger(1);


        String input = scan.nextLine();
        while (!"end of race".equals(input)){
         Pattern patt = Pattern.compile("(?<name>[A-Za-z])");
         Matcher mat = patt.matcher(input);
         String name = "";
         while (mat.find()){
             name += mat.group();
         }

         if (initial.contains(name)) {
             playersMap.putIfAbsent(name, 0);
             patt = Pattern.compile("\\d");
             mat = patt.matcher(input);
             int sum = 0;
                while (mat.find()){
                    sum += Integer.parseInt(mat.group());
                }
             //String numbers = mat.group();

             /*for (int i = 0; i < numbers.length(); i++) {
                 String numbersS = numbers.charAt(i) + "";
                 int numb = Integer.parseInt(numbersS);
                 sum += numb;
             }*/
             sum = sum + playersMap.get(name);
             playersMap.put(name, sum);
         }

           input = scan.nextLine();
        }
        int[] count = {1};
        playersMap.entrySet()
                .stream()
                .sorted((s1,s2) -> s2.getValue().compareTo(s1.getValue()))
                .limit(3)
                .forEach(p -> {
                    switch (count[0]){
                        case 1:
                            System.out.printf("1st place: %s%n", p.getKey());
                            break;
                        case 2:
                            System.out.printf("2nd place: %s%n", p.getKey());
                            break;
                        case 3:
                            System.out.printf("3rd place: %s%n", p.getKey());
                            break;
                    }
                    count[0]++;
                });
    }
}
