import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Background: After some investigation, the scientists found that if a person
 * owns a certain kind of genetic information, they are more likely to receive
 * a certain kind of disease compared to those without such a DNA sequence.
 * 
 * Question: you are going to write a program, to detect if a certain kind of
 * genetic information exists in the given DNA sequence. You are going to find
 * the number of times the DNA molecule: adenine (A), cytosine (C), guanine (G),
 * and thymine (T), in the order of "GTC" appeared in the sequence. If the
 * patient got the sequence more than ten (10) times, s/he is more likely
 * to get infected.
 */
public class Main {
    public static void main(String[] args) {
        detectDNA("sample1");
        detectDNA("sample2");
    }

    static void detectDNA(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename + ".txt"))) {

            String line = reader.readLine();
            Pattern GTC_PATTERN = Pattern.compile("(s|GTC)");
            Matcher match = GTC_PATTERN.matcher(line);
            long count = match.results().count();

            System.out.println(filename + " input:");
            if (count > 10) {
                System.out.println("sequence \"GTC\" appeared " + count + " times; infection change is high.\n");
            } else {
                System.out.println("sequence \"GTC\" appeared " + count + " times.\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
