public class MontyHall {
    private int choosenDoor;
    private int carDoor; // range 1-3 -> 1+2+3=6
    private int openedDoor;
    private boolean changed;

    MontyHall() {
        carDoor = generateRandomInt(1, 3);
    }

    private int generateRandomInt(int min, int max) {
        return (int) (Math.floor(Math.random() * max) + min);
    }

    public void openGoatDoor() {
        if (choosenDoor != carDoor) {
            openedDoor = 6 - carDoor - choosenDoor; // numero porta mancante
        } else {
            openedDoor = randomlyChooseADifferentDoor(choosenDoor);
        }
    }

    private int randomlyChooseADifferentDoor(int excludeDoor) {
        boolean chooseFirst = Math.random() >= 0.5;
        if (excludeDoor == 1) {
            if (chooseFirst)
                return 2;
            else
                return 3;
        } else if (excludeDoor == 2) {
            if (chooseFirst)
                return 1;
            else
                return 3;
        } else if (excludeDoor == 3) {
            if (chooseFirst)
                return 1;
            else
                return 2;
        }
        return -1;
    }

    public void setFirstChoice() {
        choosenDoor = generateRandomInt(1, 3);
    }

    public void setSecondChoice() {
        boolean shouldChange = ((double) Math.random()) >= 0.5;
        if (shouldChange) {
            choosenDoor = randomlyChooseADifferentDoor(openedDoor);
            changed = true;
        } else {
            changed = false;
        }
    }

    public boolean victory() {
        return choosenDoor == carDoor;
    }

    public boolean hadChanged() {
        return changed;
    }

    public String toString() {
        return getClass().getName() + "[choosenDoor=" + choosenDoor + "," + "carDoor=" + carDoor + "," + "openedDoor="
                + openedDoor + "]";
    }
}
