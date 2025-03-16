import java.util.Scanner;
public class App {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
       

        PizzaOrderSystem orderSystem = new PizzaOrderSystem(); 
        boolean ordering = true;

        while (ordering) {
            orderSystem.takeOrder(); 
            System.out.print("Do you want to order more? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                ordering = false;
            }
        }

        System.out.println(orderSystem.toString());
    }

}
