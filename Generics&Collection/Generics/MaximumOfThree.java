public class MaximumOfThree {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Max Integer: " + maximum(10, 25, 15));
        System.out.println("Max Double: " + maximum(3.14, 2.71, 4.56));
        System.out.println("Max String: " + maximum("apple", "orange", "banana"));
        System.out.println("Max Character: " + maximum('a', 'z', 'm'));
    }
}
