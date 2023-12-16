package corso36;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {
        Printer<Animal> printer = new Printer<>(new Animal());

        printer.print();

        shout(new Animal(), 10);

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());
        printList(animalList);
    }

    private static <T, V> T shout(T thingToShout, V otherThingToShout) {
        System.out.println(thingToShout);
        System.out.println(otherThingToShout);
        return thingToShout;
    }

    private static void printList(List<? extends Animal> myList) {
        System.out.println();
    }
}
