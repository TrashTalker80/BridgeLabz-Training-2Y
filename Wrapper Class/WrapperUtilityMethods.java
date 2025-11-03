public class WrapperUtilityMethods {
    public static void main(String[] args) {
        int parsedInt = Integer.parseInt("123");
        System.out.println("Integer.parseInt(\"123\"): " + parsedInt);
        
        double parsedDouble = Double.parseDouble("3.14");
        System.out.println("Double.parseDouble(\"3.14\"): " + parsedDouble);
        
        boolean parsedBoolean = Boolean.parseBoolean("true");
        System.out.println("Boolean.parseBoolean(\"true\"): " + parsedBoolean);
        
        String binaryString = Integer.toBinaryString(10);
        System.out.println("Integer.toBinaryString(10): " + binaryString);
        
        boolean isDigit = Character.isDigit('5');
        System.out.println("Character.isDigit('5'): " + isDigit);
        
        char upperCase = Character.toUpperCase('a');
        System.out.println("Character.toUpperCase('a'): " + upperCase);
    }
}
