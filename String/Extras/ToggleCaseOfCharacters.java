public class ToggleCaseOfCharacters {

    public static String toggleCase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                result += Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                result += Character.toUpperCase(ch);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "HeLLo WoRLD";
        System.out.println("Original string: " + input);
        System.out.println("Toggled case string: " + toggleCase(input));
    }
}