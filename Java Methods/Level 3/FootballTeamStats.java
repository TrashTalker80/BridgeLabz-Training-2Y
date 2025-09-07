import java.util.Arrays;

public class FootballTeamStats {

    public static int[] generatePlayerHeights(int numberOfPlayers) {
        int[] heights = new int[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;
        }
        return heights;
    }

    public static int sumHeights(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    public static double meanHeight(int[] heights) {
        return (double) sumHeights(heights) / heights.length;
    }

    public static int shortestHeight(int[] heights) {
        int shortest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < shortest) {
                shortest = heights[i];
            }
        }
        return shortest;
    }

    public static int tallestHeight(int[] heights) {
        int tallest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > tallest) {
                tallest = heights[i];
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        int[] heights = generatePlayerHeights(11);
        System.out.println("Player heights: " + Arrays.toString(heights));

        System.out.println("The sum of the heights is: " + sumHeights(heights));
        System.out.println("The mean height is: " + meanHeight(heights));
        System.out.println("The shortest height is: " + shortestHeight(heights));
        System.out.println("The tallest height is: " + tallestHeight(heights));
    }
}

