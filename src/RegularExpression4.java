import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression4 {
    public static void main(String[] args) {

        // Create RE that accept alphanumeric characters only
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher("abbcgd566");
        System.out.println(matcher.matches());

        //create RE that creates 10 digits only
        //short hand
        System.out.println(Pattern.matches("[0-9]{10}","1234567890")); //true


        //create RE that matches the email address
        // like - Test11-$._16@gamil.com
        Pattern pattern1 = Pattern.compile("^[a-zA-Z0-9_.$-]+@[a-z]+\\.[a-zA-Z]{2,4}$");
        Matcher matcher1 = pattern1.matcher("abbcgd566");
        System.out.println(matcher1.matches());

        //or this way both are correct
        Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b");
        Matcher m = p.matcher("foobar@gmail.com");
    }
}
