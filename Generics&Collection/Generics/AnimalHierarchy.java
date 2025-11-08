import java.util.Arrays;
import java.util.List;

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

public class AnimalHierarchy {
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(new Dog("Buddy"), new Dog("Max"));
        System.out.println("Dogs:");
        printAnimals(dogs);

        List<Cat> cats = Arrays.asList(new Cat("Whiskers"), new Cat("Mittens"));
        System.out.println("\nCats:");
        printAnimals(cats);

        List<Animal> animals = Arrays.asList(new Dog("Rex"), new Cat("Felix"));
        System.out.println("\nMixed Animals:");
        printAnimals(animals);
    }
}
