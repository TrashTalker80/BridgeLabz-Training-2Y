import java.util.ArrayList;

public class PerformanceComparison {
    public static void main(String[] args) {
        int size = 1000000;
        
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> wrapperList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            wrapperList.add(i);
        }
        int wrapperSum = 0;
        for (Integer num : wrapperList) {
            wrapperSum += num;
        }
        long wrapperTime = System.currentTimeMillis() - startTime;
        
        startTime = System.currentTimeMillis();
        int[] primitiveArray = new int[size];
        for (int i = 0; i < size; i++) {
            primitiveArray[i] = i;
        }
        int primitiveSum = 0;
        for (int num : primitiveArray) {
            primitiveSum += num;
        }
        long primitiveTime = System.currentTimeMillis() - startTime;
        
        System.out.println("ArrayList<Integer> time: " + wrapperTime + " ms");
        System.out.println("int[] time: " + primitiveTime + " ms");
        System.out.println("Performance difference: " + (wrapperTime - primitiveTime) + " ms");
        System.out.println("\nWrapper sum: " + wrapperSum);
        System.out.println("Primitive sum: " + primitiveSum);
    }
}
