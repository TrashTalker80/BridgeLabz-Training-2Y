public class NullPointerExceptionDemo {

    public void generateException() {
        String text = null;
        System.out.println(text.length());
    }

    public void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.err.println("Caught NullPointerException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        NullPointerExceptionDemo demo = new NullPointerExceptionDemo();

        System.out.println("--- Demonstrating handling the exception ---");
        demo.handleException();
        
        System.out.println("\n--- Demonstrating generating the unhandled exception ---");
        try {
            demo.generateException();
        } catch(NullPointerException e) {
            System.err.println("Exception was generated and caught in main: " + e.getMessage());
        }
    }
}