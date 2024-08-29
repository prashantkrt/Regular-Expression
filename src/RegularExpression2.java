import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression2 {
    public static void main(String[] args) {
        /*
         * [abc] Single character of a, b or c
         * [^abc] Any character except a, b, or c (negation)
         * [a-z] Single character in a range: a to z
         * a|b Match either a or b
         * \d A digit 0 to 9
         * \w A word character [a-zA-Z_0-9]
         *   A lowercase letter (a to z)
         *   An uppercase letter (A to Z)
         *   An underscore (_)
         *   A digit (0 to 9)
         *
         * . Any single character
         * a{3} Exactly 3 as: aaa, X{n} X occurs n times only
         * a{3,} 3 or more a,  X{n,} X occurs n or more times
         * a{2,4} between 2 or 4 a: aa, aaa or aaaa, X{y,z} X occurs at least y times but less than z times
         * ^ The beginning of the line.
         * $ the end of the line
         * * Matches zero or more occurrence.  X* X occurs zero or more times.
         * + Matches one or more occurrences. X+ X occurs once or more times.
         * ? Matches zero or one occurrence (optional 0 or 1 occurrence): X?  X occurs once or not at all
         * */

        // which means one or more characters that can be a letter (upper or lower case), a digit, or an underscore.
        // Define the regex pattern
        String regex = "[a-zA-Z_0-9]+";

        // Create a pattern object
        Pattern pattern = Pattern.compile(regex);

        // Input string to match
        String input = "Hello_World123";

        // Create a matcher object
        Matcher matcher = pattern.matcher(input);

        // Check if the input matches the regex pattern
        if (matcher.matches()) {
            System.out.println("The string is valid.");
        } else {
            System.out.println("The string is not valid.");
        }

        //example 2
        Pattern pattern2 = Pattern.compile("a*b");
        Matcher matcher2 = pattern2.matcher("aaaaaab");
        if (matcher2.matches()) {
            System.out.println("The string is valid for example2");
        }
        else {
            System.out.println("The string is not valid for example2");
        }
    }
}
