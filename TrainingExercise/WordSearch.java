//Given a 2D matrix of strings, write a function to find all occurrences of a specific word.
import java.util.*;

public class WordSearch {

    public static List<int[]> findOccurrences(String[][] matrix, String word) {
        List<int[]> occurrences = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || word == null || word.isEmpty()) {
            return occurrences;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j].equals(word)) {
                    occurrences.add(new int[]{i, j});
                }
            }
        }

        return occurrences;
    }

    public static void main(String[] args) {
        String[][] matrix = {
                {"apple", "orange", "banana"},
                {"grape", "apple", "pear"},
                {"cherry", "apple", "kiwi"}
        };

        String targetWord = "apple";

        List<int[]> result = findOccurrences(matrix, targetWord);

        if (!result.isEmpty()) {
            System.out.println("Occurrences of '" + targetWord + "':");
            for (int[] position : result) {
                System.out.println("Row: " + position[0] + ", Column: " + position[0]);
            }
        } else {
            System.out.println("'" + targetWord + "' not found in the matrix.");
        }
    }
}
