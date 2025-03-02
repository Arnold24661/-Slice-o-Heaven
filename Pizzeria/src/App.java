public class App {
    public static void main(String[] args) throws Exception {
        Pizza pizza1 = new Pizza();
        Pizza pizza2 = new Pizza("1234", "Garlic", 10.00);
        
       
        pizza1.takeOrder1();
       pizza2.takeOrder2();
       
       System.out.println("Order ID: " + pizza2.getOrderId());
      System.out.println("ingredients: " + pizza2.getPizzaIngredients());
      System.out.println("Order Total: " + pizza2.getOrderTotal());
      pizza1.cardPayMent("12345678901234","2.28",123);
      pizza1.specialOfTheDay("chickenPizza", "Bread", "$12.99");

}
}