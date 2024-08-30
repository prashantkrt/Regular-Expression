import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression6 {
    public static void main(String[] args) {
        //Masking
        String cardNumber ="1234-4567-8901-1234";
        // "XXXX-XXXX-XXXX-1234"

        Pattern pattern = Pattern.compile("\\d{4}-\\d{4}-\\d{4}-");
        Matcher matcher= pattern.matcher(cardNumber);
        String masked = matcher.replaceAll("XXXX-XXXX-XXXX-");
        System.out.println(masked);

        Pattern pattern1 = Pattern.compile("^(\\d+) divided by (\\d+)$");
        Matcher matcher1 = pattern1.matcher("10 divided by 2");

        // Convert to 10/2
        if(matcher1.find()){
            String simplified = "Result "+ matcher1.replaceFirst("$1/$2"); // group1 / group2
            System.out.println(simplified);
            int value = Integer.parseInt(matcher1.group(1))/Integer.parseInt(matcher1.group(2));
            System.out.println(value);
        }
    }
}
