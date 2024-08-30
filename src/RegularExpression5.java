import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression5 {
    public static void main(String[] args) {

        Pattern pattern1 = Pattern.compile("agent \\d\\d\\d"); // better do this: \\d{3}
        Matcher matcher = pattern1.matcher("agent 007");
        System.out.println(matcher.find()); //true

        Pattern pattern2 = Pattern.compile("^agent \\d{2,}");
        matcher = pattern2.matcher("agent 007");
        System.out.println(matcher.find()); //true

        Pattern pattern3 = Pattern.compile("^agent \\d{2,}$");
        matcher = pattern3.matcher("agent 0");
        System.out.println(matcher.find()); //false


        Pattern pattern4 = Pattern.compile("^agent[1-6]{2,}$");
        matcher = pattern4.matcher("agent 11");//false since there is a space
        System.out.println(matcher.find());

        Pattern pattern5 = Pattern.compile("^[aA]gent [0-7]{2,}$");
        matcher = pattern5.matcher("agent 007");
        System.out.println(matcher.find()); //true
        matcher=pattern5.matcher("Agent 007");
        System.out.println(matcher.find()); //true

        Pattern pattern6 = Pattern.compile("^(a|A|aa)gent \\d{2,}$");
        matcher = pattern6.matcher("aagent 007");
        System.out.println(matcher.find());//true


        Pattern pattern7 = Pattern.compile("^\\w* \\d{2,}$");
        matcher = pattern7.matcher("agent 007");
        System.out.println(matcher.find());//true

        Pattern pattern8 = Pattern.compile("^[a|A]gent \\d{2,}$");
        matcher = pattern8.matcher("agent 007");
        System.out.println(matcher.find());//true
    }
}

// For reference
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

