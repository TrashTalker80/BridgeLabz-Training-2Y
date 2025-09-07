import java.util.Arrays;

public class RandomNumberAnalyzer {

    public int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return randomNumbers;
    }

    public double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int number : numbers) {
            sum += number;
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        double average = sum / numbers.length;
        return new double[]{average, (double) min, (double) max};
    }

    public static void main(String[] args) {
        RandomNumberAnalyzer analyzer = new RandomNumberAnalyzer();
        int[] randomNumbers = analyzer.generate4DigitRandomArray(5);

        System.out.println("The generated random numbers are: " + Arrays.toString(randomNumbers));

        double[] result = analyzer.findAverageMinMax(randomNumbers);

        System.out.println("The average value is: " + result[0]);
        System.out.println("The minimum value is: " + result[1]);
        System.out.println("The maximum value is: " + result[2]);
    }
}

