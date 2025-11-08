public class GenericBox<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public static void main(String[] args) {
        GenericBox<Integer> intBox = new GenericBox<>();
        intBox.set(100);
        System.out.println("Integer: " + intBox.get());

        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.set("Hello");
        System.out.println("String: " + stringBox.get());

        GenericBox<Double> doubleBox = new GenericBox<>();
        doubleBox.set(99.99);
        System.out.println("Double: " + doubleBox.get());
    }
}
