import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;


// 871198282
public class Hannan22 {
    public static void main(String[] args) {
        String rawText = read("./0022_names.txt");
        String[] fWords = filterWords(rawText);
        

        LinkedList<String> words = new LinkedList<>();
        for (String word : fWords) {
            words.add(word);
        }
        Collections.sort(words);

        // HashMap<Integer, String> sortedWords = new HashMap<>();
        // int index = 0;
        // for (String word : words) {
        //     sortedWords.put(index, word);
        //     index++;
        // }

        BigInteger total = new BigInteger("0");
        for (int i = 0; i < words.size(); i++) {
            int count = 0;
            String word = words.get(i);
            for (int j = 0; j < word.length(); j++) {
                // System.out.println(word.charAt(j) - 64);
                count += word.charAt(j) - 64;
            }
            total = total.add(BigInteger.valueOf(count * (i + 1)));
        }

        System.out.println(total.toString());
    }

    public static String read(String path) {
        String txt = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                txt += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading file");
        }
        finally {
            // System.out.println("Successfully read file");
        }
        return txt;
    }

    public static String[] filterWords(String text) {
        String[] words = {};
        try {
            text = text.replaceAll("\"", "");
            words = text.split(",");
            // for (int i = 0; i > words.length; i++) {
            //     words[i].replaceAll(String.valueOf("\""), "");
            //     System.out.printf("%2s ", word);
            // }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error filtering words");
        }
        finally {
            // System.out.println("Words filtered successfully");
        }
        return words;
    }
}
