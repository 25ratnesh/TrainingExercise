/* Create a class called StringSearchEngine that allows users to search for a specific pattern or substring in a given text. The class should have methods for:
Finding all occurrences of a substring.
Highlighting the matched substrings in the original text.
*/

import java.util.ArrayList;
import java.util.List;

public class StringSearchEngine {
    private String originalText;

    public StringSearchEngine(String originalText) {
        this.originalText = originalText;
    }

    public List<Integer> findAllOccurrences(String substring) {
        List<Integer> occurrences = new ArrayList<>();
        int index = originalText.indexOf(substring);
        while (index != -1) {
            occurrences.add(index);
            index = originalText.indexOf(substring, index + 1);
        }
        return occurrences;
    }

    public String highlightOccurrences(String substring) {
        StringBuilder highlightedText = new StringBuilder(originalText);
        List<Integer> occurrences = findAllOccurrences(substring);

        for (int i = occurrences.size() - 1; i >= 0; i--) {
            int start = occurrences.get(i);
            int end = start + substring.length();
            highlightedText.insert(end, "</b>");
            highlightedText.insert(start, "<b>");
        }

        return highlightedText.toString();
    }

    public static void main(String[] args) {
        StringSearchEngine searchEngine = new StringSearchEngine("Java is a versatile programming language. Java is widely used.");
        String substring = "Java";

        List<Integer> occurrences = searchEngine.findAllOccurrences(substring);
        System.out.println("Occurrences of '" + substring + "': " + occurrences);

        String highlightedText = searchEngine.highlightOccurrences(substring);
        System.out.println("Highlighted Text:\n" + highlightedText);
    }
}
