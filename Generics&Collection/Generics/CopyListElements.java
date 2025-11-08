import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyListElements {
    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        for (Number num : src) {
            dest.add(num);
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(4.5, 5.5);

        List<Number> destination = new ArrayList<>();
        
        copyList(destination, integers);
        copyList(destination, doubles);

        System.out.println("Destination list: " + destination);

        List<Object> objectList = new ArrayList<>();
        copyList(objectList, integers);
        System.out.println("Object list: " + objectList);
    }
}
