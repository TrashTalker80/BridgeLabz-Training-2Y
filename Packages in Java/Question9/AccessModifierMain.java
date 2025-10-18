import com.access.two.Derived;

public class AccessModifierMain {
    public static void main(String[] args) {
        Derived derived = new Derived();
        derived.testAccessibility();
        
        System.out.println("\n========================================");
        System.out.println("ACCESS MODIFIER SUMMARY TABLE");
        System.out.println("========================================");
        System.out.println("Modifier    | Same Class | Same Package | Subclass | Different Package");
        System.out.println("------------|------------|--------------|----------|------------------");
        System.out.println("public      |    Yes     |     Yes      |   Yes    |       Yes");
        System.out.println("protected   |    Yes     |     Yes      |   Yes    |       No");
        System.out.println("default     |    Yes     |     Yes      |   No     |       No");
        System.out.println("private     |    Yes     |     No       |   No     |       No");
        System.out.println("========================================");
    }
}
