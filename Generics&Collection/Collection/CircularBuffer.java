import java.util.Arrays;

class CircularBufferImpl<T> {
    private Object[] buffer;
    private int capacity;
    private int size;
    private int head;
    private int tail;

    public CircularBufferImpl(int capacity) {
        this.capacity = capacity;
        this.buffer = new Object[capacity];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    public void insert(T element) {
        buffer[tail] = element;
        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity;
        }
        tail = (tail + 1) % capacity;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(head + i) % capacity];
        }
        return (T[]) result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}

public class CircularBuffer {
    public static void main(String[] args) {
        CircularBufferImpl<Integer> buffer = new CircularBufferImpl<>(3);
        
        buffer.insert(1);
        System.out.println("After inserting 1: " + buffer);
        
        buffer.insert(2);
        System.out.println("After inserting 2: " + buffer);
        
        buffer.insert(3);
        System.out.println("After inserting 3: " + buffer);
        
        buffer.insert(4);
        System.out.println("After inserting 4 (overwrites oldest): " + buffer);
    }
}
