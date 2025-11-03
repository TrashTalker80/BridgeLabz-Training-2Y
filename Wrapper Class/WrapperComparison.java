public class WrapperComparison {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        
        System.out.println("a == b: " + (a == b));
        System.out.println("c == d: " + (c == d));
        System.out.println("a.equals(b): " + a.equals(b));
        
        System.out.println("\nExplanation:");
        System.out.println("a == b returns true because Integer values between -128 and 127 are cached.");
        System.out.println("c == d returns false because 200 is outside the cache range, creating different objects.");
        System.out.println("a.equals(b) returns true because equals() compares the actual values, not references.");
    }
}
