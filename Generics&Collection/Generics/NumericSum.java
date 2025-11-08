import java.util.Arrays;
import java.util.List;

public class NumericSum {
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Sum of integers: " + sumNumbers(integers));

        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        System.out.println("Sum of doubles: " + sumNumbers(doubles));

        List<Number> numbers = Arrays.asList(10, 20.5, 30, 40.75);
        System.out.println("Sum of numbers: " + sumNumbers(numbers));
    }
}
