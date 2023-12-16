
public class SimpleCar {
    public static final double INITIAL_SPEED = 10;
    public static final int MIN_GEAR = 0;
    public static final int MAX_GEAR = 6;
    public static final double SPEED_INCREMENT_PERCENT = 0.50;
    public static final double SPEED_DECREMENT_PERCENT = 0.30;

    private int m = 0;
    private double v = 0;

    public void speedUp() {
        if (v == 0) {
            v = INITIAL_SPEED;
        } else {
            v *= (1 + SPEED_INCREMENT_PERCENT);
        }
    }

    public void brake() {
        if (v == 0)
            return;
        v -= v * SPEED_DECREMENT_PERCENT;
    }

    public void gearUp() {
        if (m < MAX_GEAR) {
            m++;
        }
    }

    public void gearDown() {
        if (m > MIN_GEAR) {
            m--;
        }
    }

    public String toString() {
        return "SimpleCar: marcia = " + m + ", velocita' = " + v + " km/h";
    }
}
