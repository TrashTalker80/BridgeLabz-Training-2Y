public class GenericPair<T, U> {
    private T first;
    private U second;

    public GenericPair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public static void main(String[] args) {
        GenericPair<String, Integer> student = new GenericPair<>("Amol", 20);
        System.out.println("Name: " + student.getFirst());
        System.out.println("Age: " + student.getSecond());

        GenericPair<Integer, String> idName = new GenericPair<>(101, "John");
        System.out.println("ID: " + idName.getFirst());
        System.out.println("Name: " + idName.getSecond());
    }
}
