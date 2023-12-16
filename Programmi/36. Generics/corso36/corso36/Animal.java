
public class Animal implements Comparable<Animal> {
    public String toString() {
        return "Hello";
    }

    public void eat() {
        System.out.println("Eating....");
    }

    public int compareTo(Animal o) {
        return 0;
    }
}
