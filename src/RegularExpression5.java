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
        matcher = pattern5.matcher("Agent 007");
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

        //groups
        Pattern pattern9 = Pattern.compile("(^agent)(\\.)(\\d{2,})$");
        matcher = pattern9.matcher("agent.007");
        if (matcher.find()) {
            // Group 0: Full Match
            System.out.println("Full match : Group 0 match: " + matcher.group(0));
            // Group 1
            System.out.println("Group 1 match:" + matcher.group(1));
            // Group 2: The second group (month)
            System.out.println("Group 2 match:" + matcher.group(2));
            //Group 3:
            System.out.println("Group 3 match:" + matcher.group(3));
        } else {
            System.out.println("No match found");
        }
        // matcher.group() is same as matcher.group(0)
        if (matcher.group().equals("agent.007")) {
            System.out.println("Full Match");
        }
        if (matcher.group(3).equals("007")) {
            System.out.println("Found");
        }

        /*
         * matcher.group() or matcher.group(0):
         * Returns the entire substring of the input that matches the regex pattern.
         * Equivalent to matcher.group(0)
         *
         *
         * */

        String regex = "(\\d{2})-(\\d{2})-(\\d{4})";
        String input = "Date: 29-08-2024";

        Pattern pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);

        if (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));  //  Entire match "29-08-2024"
            System.out.println("Day: " + matcher.group(1));          // First group "29"
            System.out.println("Month: " + matcher.group(2));        // Second group "08"
            System.out.println("Year: " + matcher.group(3));         // Third group "2024"
        }

        // Won't work like this it will give exception No Match Found
        // It should first match the regex if then we can go the group(0), group(1)..
        // and so on

//        regex = "(\\d{2})-(\\d{2})-(\\d{4})";
//        pattern = Pattern.compile(regex);
//        input = "Date of Joining: 29-08-2024";
//        matcher=pattern.matcher(input);
//
//        if (matcher.group(1).equals("29")) {
//            System.out.println("String found !!!!");
//        }

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

