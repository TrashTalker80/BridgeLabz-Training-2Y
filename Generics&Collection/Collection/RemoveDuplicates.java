import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> list) {
        LinkedHashSet<T> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println("Original List: " + list);
        List<Integer> result = removeDuplicates(list);
        System.out.println("After removing duplicates: " + result);
    }
}
