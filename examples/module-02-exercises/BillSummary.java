import java.util.Scanner;

public class BillSummary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Product name: ");
        String item = input.nextLine();
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(input.nextLine());
        System.out.print("Unit price: ");
        double unitPrice = Double.parseDouble(input.nextLine());

        double subtotal = qty * unitPrice;
        double discount = subtotal * 0.10;        // 10% off
        double amountDue = subtotal - discount;

        System.out.println("========================");
        System.out.println("        RECEIPT");
        System.out.println("========================");
        System.out.printf("Item:            %s%n", item);
        System.out.printf("%d @ %.2f each%n", qty, unitPrice);
        System.out.printf("Subtotal:        %.2f%n", subtotal);
        System.out.printf("You saved (10%%): %.2f%n", discount);
        System.out.printf("Amount due:      %.2f%n", amountDue);
        System.out.println("========================");

        input.close();
    }
}