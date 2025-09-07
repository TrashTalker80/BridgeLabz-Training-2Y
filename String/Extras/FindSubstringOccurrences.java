public class FindSubstringOccurrences {

    public static int countSubstringOccurrences(String str, String subStr) {
        int count = 0;
        int lastIndex = 0;
        while (lastIndex != -1) {
            lastIndex = str.indexOf(subStr, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += subStr.length();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abababab";
        String subStr = "ab";
        System.out.println("String: " + str);
        System.out.println("Substring: " + subStr);
        System.out.println("Occurrences: " + countSubstringOccurrences(str, subStr));
    }
}