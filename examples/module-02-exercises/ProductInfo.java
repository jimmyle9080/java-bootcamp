import java.util.Scanner;

public class ProductInfo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Product name: ");
        String name = input.nextLine();

        System.out.print("Category: ");
        String category = input.nextLine();

        System.out.print("Quantity: ");
        int qty = Integer.parseInt(input.nextLine());

        System.out.print("Unit price: ");
        double price = Double.parseDouble(input.nextLine());

        double lineTotal = qty * price;

        System.out.println("--- Product Details ---");
        System.out.printf("Name:     %s%n", name);
        System.out.printf("Category: %s%n", category);
        System.out.printf("Quantity: %d%n", qty);
        System.out.printf("Price:    %.2f%n", price);
        System.out.printf("Total:    %.2f%n", lineTotal);

        input.close();
    }
}