import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tickets = scan.nextLine().split("\\s*\\,\\s*");

        for (int i = 0; i <tickets.length ; i++) {
            String ticket = tickets[i];
            if (ticket.length() == 20){
                String firstHalf = ticket.substring(0,10);
                String secondHalf = ticket.substring(10,20);
                Pattern patt = Pattern.compile("(?<first>[@]{6,10}|[#]{6,10}|[$]{6,10}|[\\^]{6,10})");
                Matcher mat = patt.matcher(firstHalf);
                Pattern patt2 = Pattern.compile("(?<first>[@]{6,10}|[#]{6,10}|[$]{6,10}|[\\^]{6,10})");
                Matcher mat2 = patt2.matcher(secondHalf);
                String first = "";
                String second = "";
                if (!mat.find() || !mat2.find()){
                    System.out.printf("ticket \"%s\" - no match\n", ticket);
                }else {
                    patt = Pattern.compile("(?<first>[@]{6,10}|[#]{6,10}|[$]{6,10}|[\\^]{6,10})[^@#$\\^]*(?<second>[@]{6,10}|[#]{6,10}|[$]{6,10}|[\\^]{6,10})");
                    mat = patt.matcher(ticket);
                    while (mat.find()){
                        first = mat.group("first");
                    }
                    patt2 = Pattern.compile("(?<first>[@]{6,10}|[#]{6,10}|[$]{6,10}|[\\^]{6,10})");
                    mat2 = patt2.matcher(secondHalf);
                    while (mat2.find()){
                        second = mat2.group("first");
                    }
                    if (first.length() == 10 && second.length() == 10){
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!\n", ticket, first.length(), first.charAt(0));
                    }else if ( first.length() <= second.length()){
                        System.out.printf("ticket \"%s\" - %d%c\n", ticket, first.length(), first.charAt(0));
                    }else if (first.length() > second.length()){
                        System.out.printf("ticket \"%s\" - %d%c\n", ticket, second.length(), second.charAt(0));
                    }
                }

            }else{
                System.out.println("invalid ticket");
            }
        }
    }
}

