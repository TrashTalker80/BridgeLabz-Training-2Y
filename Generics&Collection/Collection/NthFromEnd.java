import java.util.LinkedList;

public class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || list.isEmpty() || n <= 0) {
            return null;
        }
        
        int firstPointer = 0;
        int secondPointer = 0;
        
        for (int i = 0; i < n; i++) {
            if (firstPointer >= list.size()) {
                return null;
            }
            firstPointer++;
        }
        
        while (firstPointer < list.size()) {
            firstPointer++;
            secondPointer++;
        }
        
        return list.get(secondPointer);
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        
        System.out.println("List: " + list);
        System.out.println("2nd element from end: " + findNthFromEnd(list, 2));
        System.out.println("4th element from end: " + findNthFromEnd(list, 4));
    }
}
