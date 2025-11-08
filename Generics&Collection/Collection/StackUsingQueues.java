import java.util.LinkedList;
import java.util.Queue;

class StackUsingTwoQueues<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public StackUsingTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(T element) {
        queue2.add(element);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public T pop() {
        if (queue1.isEmpty()) {
            return null;
        }
        return queue1.remove();
    }

    public T top() {
        if (queue1.isEmpty()) {
            return null;
        }
        return queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

public class StackUsingQueues {
    public static void main(String[] args) {
        StackUsingTwoQueues<Integer> stack = new StackUsingTwoQueues<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
    }
}
