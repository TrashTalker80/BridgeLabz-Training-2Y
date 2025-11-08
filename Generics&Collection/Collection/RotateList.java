import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateList {
    public static <T> void rotateLeft(List<T> list, int positions) {
        if (list == null || list.isEmpty() || positions <= 0) {
            return;
        }
        int size = list.size();
        positions = positions % size;
        
        for (int i = 0; i < positions; i++) {
            T first = list.remove(0);
            list.add(first);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original List: " + list);
        rotateLeft(list, 2);
        System.out.println("After rotating by 2: " + list);
    }
}
