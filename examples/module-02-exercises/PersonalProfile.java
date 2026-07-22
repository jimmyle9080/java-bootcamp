import java.util.Scanner;

public class PersonalProfile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(input.nextLine());   // parsed to a real int
        System.out.print("City: ");
        String city = input.nextLine();
        System.out.print("Hobby: ");
        String hobby = input.nextLine();

        System.out.println();
        String line = "+------------+----------------------+";
        System.out.println(line);
        System.out.printf("| %-10s | %-20s |%n", "FIELD", "VALUE");
        System.out.println(line);
        System.out.printf("| %-10s | %-20s |%n", "Name", name);
        System.out.printf("| %-10s | %-20d |%n", "Age", age);   // %-20d = left-aligned int
        System.out.printf("| %-10s | %-20s |%n", "City", city);
        System.out.printf("| %-10s | %-20s |%n", "Hobby", hobby);
        System.out.println(line);

        input.close();
    }
}