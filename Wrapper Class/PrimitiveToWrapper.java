import java.util.Scanner;

public class PrimitiveToWrapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int primitiveValue = scanner.nextInt();
        
        Integer wrapperValue = Integer.valueOf(primitiveValue);
        
        System.out.println("Primitive value: " + primitiveValue);
        System.out.println("Wrapper value: " + wrapperValue);
        
        scanner.close();
    }
}
