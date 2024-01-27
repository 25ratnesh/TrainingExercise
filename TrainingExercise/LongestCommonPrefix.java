public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;

        // Find the minimum length among all strings
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        if (minLength == 0) {
            return "";
        }

        // Find the common prefix efficiently
        int low = 1;
        int high = minLength;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int length) {
        String prefix = strs[0].substring(0, length);

        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] matrix = {
                {"flower", "flow", "flight"},
                {"dog", "racecar", "car"},
                {"apple", "apricot", "april"}
        };

        for (String[] row : matrix) {
            String result = longestCommonPrefix(row);
            System.out.println("Longest Common Prefix: " + result);
        }
    }
}
