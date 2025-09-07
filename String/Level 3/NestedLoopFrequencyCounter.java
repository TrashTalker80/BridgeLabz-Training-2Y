import java.util.Scanner;

public class NestedLoopFrequencyCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        String[] frequencies = findFrequenciesWithNestedLoops(text);

        System.out.println("Character frequencies:");
        for (String entry : frequencies) {
            System.out.println(entry);
        }
        scanner.close();
    }

    public static String[] findFrequenciesWithNestedLoops(String text) {
        if (text == null || text.isEmpty()) {
            return new String[0];
        }

        char[] chars = text.toCharArray();
        int n = chars.length;
        int[] freq = new int[n];
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            if (chars[i] == '\0') continue;

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    count++;
                    chars[j] = '\0'; 
                }
            }
            freq[i] = count;
            uniqueCount++;
        }

        String[] result = new String[uniqueCount];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '\0') {
                result[index++] = "'" + chars[i] + "': " + freq[i];
            }
        }
        return result;
    }
}