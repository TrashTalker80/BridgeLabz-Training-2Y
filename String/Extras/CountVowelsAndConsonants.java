public class CountVowelsAndConsonants {

    public static void countVowelsAndConsonants(String str) {
        int vowelCount = 0;
        int consonantCount = 0;
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);
    }

    public static void main(String[] args) {
        String input = "Hello World";
        countVowelsAndConsonants(input);
    }
}