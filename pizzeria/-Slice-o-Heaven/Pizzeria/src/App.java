public class App {
    public static void main(String[] args) throws Exception {
        Pizza pizza1 = new Pizza();
        Pizza pizza2 = new Pizza("1234", "Garlic", 10.00);
        pizza1.takeOrder1();
       pizza2.takeOrder2();
       
       System.out.println("Order ID: " + pizza2.getOrderId());
      System.out.println("ingredients: " + pizza2.getPizzaIngredients());
      System.out.println("Order Total: " + pizza2.getOrderTotal());
      
}
}