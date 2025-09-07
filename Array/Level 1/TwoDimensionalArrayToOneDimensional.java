import java.util.Scanner;

class TwoDimensionalArrayToOneDimensional {
    
    public static int[] convertTo1D(int[][] matrix, int rows, int columns) {
        int[] array = new int[rows * columns];
        int index = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }
        
        return array;
    }
    
    public static void display2DArray(int[][] matrix, int rows, int columns) {
        System.out.println("2D Array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void display1DArray(int[] array) {
        System.out.println("1D Array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();
        
        int[][] matrix = new int[rows][columns];
        
        System.out.println("Enter elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = input.nextInt();
            }
        }
        
        display2DArray(matrix, rows, columns);
        
        int[] array = convertTo1D(matrix, rows, columns);
        display1DArray(array);
        
        input.close();
    }
}
