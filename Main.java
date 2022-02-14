import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    private static void detectDNA(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename + ".txt"))) {

            String line = reader.readLine();
            char c = 'G';
            int count = 0;
            for (int i = 0; i < line.length(); i++) {
                char current = line.charAt(i);
                if (c == current) {
                    switch (current) {
                        case 'G':
                            c = 'T';
                            continue;
                        case 'T':
                            c = 'C';
                            continue;
                        case 'C':
                            count++;
                            c = 'G';
                            continue;
                    }
                }
                if (c != 'G') {
                    c = (current == 'G') ? 'T' : 'G';
                }
            }

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
