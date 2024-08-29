import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression1 {
    public static void main(String[] args) {

        //pattern for exactly String a is "a"
        Pattern pattern = Pattern.compile("a"); // provide the regex for pattern matching
        Matcher matcher = pattern.matcher("a"); // provide the input string

        //matches the entire with the pattern
        //returns boolean
        System.out.println(matcher.matches()); // matches the regex with the input string

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

    }
}