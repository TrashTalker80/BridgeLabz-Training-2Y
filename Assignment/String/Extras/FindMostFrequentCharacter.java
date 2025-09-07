public class FindMostFrequentCharacter {

    public static char findMostFrequentChar(String str) {
        int[] frequency = new int[256];
        for (char ch : str.toCharArray()) {
            frequency[ch]++;
        }

        int maxFreq = -1;
        char mostFrequentChar = ' ';
        for (char ch : str.toCharArray()) {
            if (frequency[ch] > maxFreq) {
                maxFreq = frequency[ch];
                mostFrequentChar = ch;
            }
        }
        return mostFrequentChar;
    }

    public static void main(String[] args) {
        String input = "success";
        System.out.println("String: " + input);
        System.out.println("Most Frequent Character: '" + findMostFrequentChar(input) + "'");
    }
}