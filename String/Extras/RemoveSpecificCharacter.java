public class RemoveSpecificCharacter {

    public static String removeChar(String str, char charToRemove) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != charToRemove) {
                result += str.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "Hello World";
        char charToRemove = 'l';
        System.out.println("Original String: " + str);
        System.out.println("Character to Remove: '" + charToRemove + "'");
        System.out.println("Modified String: " + removeChar(str, charToRemove));
    }
}