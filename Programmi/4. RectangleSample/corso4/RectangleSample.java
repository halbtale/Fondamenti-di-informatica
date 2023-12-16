package corso4;

import java.awt.Rectangle;

public class RectangleSample {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(5, 10, 20, 20);
        Rectangle rect2 = rect1;

        rect1.translate(15, 25);

        System.out.println(rect1.getX());
        System.out.println(rect2.getX());
    }
}
