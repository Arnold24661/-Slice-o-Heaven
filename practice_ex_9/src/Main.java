public class Main{
    public static void main(String[] args) throws Exception {
        HandleOrders handleOrders = new HandleOrders();
        handleOrders.takeOrder();
        handleOrders.createOrderSummary();
        handleOrders.displayCustomPizzas();
        System.out.println(handleOrders);
    }
}
