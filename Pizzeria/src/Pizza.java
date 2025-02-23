public class Pizza {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public int storePhone;
    public String storeMenu;
    private String pizzaIngredients;
    public double pizzaPrice;
    private String sides;
    private String drinks;
    private String orderId;
    private double orderTotal;

    public void takeOrder(String id, String sides, String drinks, double total){
        orderId = id;
        this.sides = sides;
        this.drinks = drinks;
        orderTotal = total;
        System.out.println("Order accepted!");
        System.out.println("Order is being prepared");
        try{
             Thread.sleep(5000);
        }catch (InterruptedException e){
             System.out.println("Order is ready for pickup!");
        }
        System.out.println("Your order is ready!");
        printReceipt();

    }
   public void makePizza (String ingredients){
         
        pizzaIngredients = ingredients;
        System.out.println("making pizza with " + pizzaIngredients);
    
   }

   private void printReceipt(){
        System.out.println("********RECEIPT********");

System.out.println("Order ID: " + orderId);
      System.out.println("chickenpizza");
      System.out.println("sides: " + sides);
      System.out.println("drinks:" + drinks);
      System.out.println("Order Total: " + orderTotal);
      
   }
}
