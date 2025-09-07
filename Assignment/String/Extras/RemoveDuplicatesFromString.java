public class RemoveDuplicatesFromString {

    public static String removeDuplicates(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (result.indexOf(currentChar) < 0) {
                result += currentChar;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "programming";
        System.out.println("Original string: " + input);
        System.out.println("String after removing duplicates: " + removeDuplicates(input));
    }
}