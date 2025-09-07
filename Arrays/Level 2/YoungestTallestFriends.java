import java.util.Scanner;

class YoungestTallestFriends {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        System.out.println("Enter age and height for 3 friends:");
        
        for (int i = 0; i < 3; i++) {
            System.out.println("\n" + names[i] + ":");
            System.out.print("Age: ");
            ages[i] = input.nextInt();
            System.out.print("Height (in cm): ");
            heights[i] = input.nextDouble();
        }
        
        int youngestIndex = 0;
        int tallestIndex = 0;
        
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        
        System.out.println("\n=== Results ===");
        System.out.println("Youngest friend: " + names[youngestIndex] + " (age " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend: " + names[tallestIndex] + " (height " + heights[tallestIndex] + " cm)");
        
        input.close();
    }
}
