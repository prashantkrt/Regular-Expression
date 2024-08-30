import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression3 {
    public static void main(String[] args) {

        /*
         * [abc] Single character of a, b or c
         * [^abc] Any character except a, b, or c (negation)
         * [a-z] Single character in a range: a to z
         * a|b Match either a or b
         * \d A digit 0 to 9
         * \D non digit [^0-9]
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

        //1st way
        Pattern p = Pattern.compile(".s");//. represents a single character
        Matcher m = p.matcher("as");
        boolean b1 = m.matches();

        //2nd way
        boolean b2 = Pattern.compile(".s").matcher("as").matches();

        //3rd way
        boolean b3 = Pattern.matches(".s", "as");


        System.out.println(Pattern.matches(".s", "as"));//true (2nd char is s)
        System.out.println(Pattern.matches(".s", "mk"));//false (2nd char is not s)
        System.out.println(Pattern.matches(".s", "mst"));//false (has more than 2 char)
        System.out.println(Pattern.matches(".s", "amms"));//false (has more than 2 char)
        System.out.println(Pattern.matches("..s", "mas"));//true (3rd char is s)


        System.out.println(Pattern.matches("[amn]", "abcd"));//false (not a or m or n)
        System.out.println(Pattern.matches("[amn]", "a"));//true (among a or m or n)
        System.out.println(Pattern.matches("[amn]", "ammmna"));//false (m and a comes more than once)

        /*
        * \d [0-9]
        * \D [^0-9]
        * \w [a-zA-Z_0-9]
        * \W [^\w]
        * */

        System.out.println(Pattern.matches("\\d", "abc"));//false (non-digit)
        System.out.println(Pattern.matches("\\d", "1"));//true (digit and comes once)
        System.out.println(Pattern.matches("\\d", "4443"));//false (digit but comes more than once)
        System.out.println(Pattern.matches("\\d", "323abc"));//false (digit and char)

        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun32"));//true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "kkvarun32"));//false (more than 6 char)
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "JA2Uk2"));//true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun$2"));//false ($ is not matched)

        System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "9953038949"));//true
        System.out.println(Pattern.matches("[789][0-9]{9}", "9953038949"));//true

        System.out.println(Pattern.matches("[789][0-9]{9}", "99530389490"));//false (11 characters)
        System.out.println(Pattern.matches("[789][0-9]{9}", "6953038949"));//false (starts from 6)
        System.out.println(Pattern.matches("[789][0-9]{9}", "8853038949"));//true


        System.out.println(Pattern.matches("[789]{1}\\d{9}", "8853038949"));//true
        System.out.println(Pattern.matches("[789]{1}\\d{9}", "3853038949"));//false (starts from 3)

        // Check if all elements are numbers
        System.out.println(Pattern.matches("\\d+", "1234")); //true

        // Check if all elements are non-numbers
        System.out.println(Pattern.matches("\\D+", "1234")); //false

        // Check if all the elements are non-numbers
        System.out.println(Pattern.matches("\\D+", "Gfg")); //true
        System.out.println(Pattern.matches("\\D+", "gfg1")); //false

        // Check if all the elements are non-spaces
        System.out.println(Pattern.matches("\\S+", "gfg")); //true
    }
}
