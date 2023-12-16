package corso5;

public class AgeCalculator {
    public static void main(String[] args) {
        Day personBirthday = new Day(2004, 7, 9);
        Day today = new Day();
        int daysAlive = today.daysFrom(personBirthday);
        System.out.print("Days alive: ");
        System.out.println(daysAlive);
    }
}
