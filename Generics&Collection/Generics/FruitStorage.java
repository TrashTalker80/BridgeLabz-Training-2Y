import java.util.ArrayList;
import java.util.List;

class Fruit {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Apple extends Fruit {
    public Apple() {
        super("Apple");
    }
}

class Mango extends Fruit {
    public Mango() {
        super("Mango");
    }
}

class FruitBox<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void displayFruits() {
        System.out.println("Fruits in box: " + fruits);
    }
}

public class FruitStorage {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.displayFruits();

        FruitBox<Mango> mangoBox = new FruitBox<>();
        mangoBox.addFruit(new Mango());
        mangoBox.displayFruits();

        FruitBox<Fruit> mixedBox = new FruitBox<>();
        mixedBox.addFruit(new Apple());
        mixedBox.addFruit(new Mango());
        mixedBox.displayFruits();
    }
}
