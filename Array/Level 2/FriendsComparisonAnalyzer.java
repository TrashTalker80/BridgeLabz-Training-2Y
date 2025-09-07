import java.util.Scanner;

class FriendsComparisonAnalyzer {
    
    public static void inputFriendsData(int[] ages, double[] heights, Scanner input) {
        String[] names = {"Amar", "Akbar", "Anthony"};
        
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter " + names[i] + "'s age: ");
            ages[i] = input.nextInt();
            System.out.print("Enter " + names[i] + "'s height: ");
            heights[i] = input.nextDouble();
        }
    }
    
    public static int findYoungest(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }
    
    public static int findTallest(double[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }
    
    public static void displayResults(int[] ages, double[] heights, int youngestIndex, int tallestIndex) {
        String[] names = {"Amar", "Akbar", "Anthony"};
        
        System.out.println("\n=== FRIENDS COMPARISON RESULTS ===");
        System.out.println("Youngest friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + ")");
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        System.out.println("Enter age and height for 3 friends:");
        inputFriendsData(ages, heights, input);
        
        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);
        
        displayResults(ages, heights, youngestIndex, tallestIndex);
        
        input.close();
    }
}
