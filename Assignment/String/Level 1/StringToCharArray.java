import java.util.Arrays;
import java.util.Scanner;

public class StringToCharArray {

    public char[] convertToCharArray(String text) {
        char[] charArray = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            charArray[i] = text.charAt(i);
        }
        return charArray;
    }

    public boolean areCharArraysEqual(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = scanner.next();

        StringToCharArray converter = new StringToCharArray();
        char[] customCharArray = converter.convertToCharArray(text);
        System.out.println("Custom char array: " + Arrays.toString(customCharArray));

        char[] builtinCharArray = text.toCharArray();
        System.out.println("Built-in char array: " + Arrays.toString(builtinCharArray));

        boolean areEqual = converter.areCharArraysEqual(customCharArray, builtinCharArray);
        System.out.println("Are the two char arrays equal? " + areEqual);

        scanner.close();
    }
}