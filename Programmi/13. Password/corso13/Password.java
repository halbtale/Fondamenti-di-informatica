
public class Password {
    public static void main(String[] args) {
        String firstName = "Alberto";
        String lastName = "Heissl";
        int age = 19;

        String initials = firstName.substring(0, 1) + lastName.substring(0, 1);
        String pw = initials.toLowerCase() + age;

        System.out.println("La tua password è: " + pw);

        // String ageString = pw.substring(2);
        String ageString = Integer.toString(age);
        int ageInt = Integer.parseInt(ageString);

        System.out.println(ageInt);

        System.out.println((char) ('a' + 1));
    }
}
