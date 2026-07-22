import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Radius: ");
        double r = Double.parseDouble(input.nextLine());

        double diameter = 2 * r;
        double circumference = 2 * Math.PI * r;   // 2 pi r
        double area = Math.PI * r * r;            // pi r squared

        System.out.printf("Diameter:      %.2f%n", diameter);
        System.out.printf("Circumference: %.2f%n", circumference);
        System.out.printf("Area:          %.2f%n", area);

        input.close();
    }
}