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
    private final String DEF_ORDER_ID = "DEF-SOH-099";
    private final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private final double DEF_ORDER_TOTAL = 15.00;
   
   

    

    public Pizza(){
     orderId = DEF_ORDER_ID;
     pizzaIngredients = DEF_PIZZA_INGREDIENTS;
     orderTotal = DEF_ORDER_TOTAL;
     sides = "cake";
     drinks = "coke";

    }
    public Pizza(String id, String pizzaIngredients, double total){
      orderId = id;
      this.pizzaIngredients = pizzaIngredients;
        orderTotal = total;
    }


    public String getPizzaIngredients(){
     return pizzaIngredients;
    }
    public void setPizzaIngredients(String ingredients){
           pizzaIngredients = ingredients;
    }
    
    public String getOrderId(){
     return orderId;
    }
     public void setOrderId(String id){
          orderId = id;
     }

    public double getOrderTotal(){
     return orderTotal;
    }
    public void setOrderTotal(double total){
     orderTotal = total;
    }
   


    public void takeOrder1(){
        
        System.out.println("Order accepted!");
        System.out.println("Order is being prepared");
        try{
             Thread.sleep(5000);
        }catch (InterruptedException e){
             System.out.println("Order is ready for pickup!");
        }
        System.out.println("Your order is ready!");
        printReceipt1();
        

    }

    public void takeOrder2(){
        
     System.out.println("Order accepted!");
     System.out.println("Order is being prepared");
     try{
          Thread.sleep(5000);
     }catch (InterruptedException e){
          System.out.println("Order is ready for pickup!");
     }
     System.out.println("Your order is ready!");
    
     
     
 }

    

   private void printReceipt1(){
        System.out.println("********RECEIPT********");

      System.out.println("Order ID: " + orderId);
      System.out.println("ingredients: " + pizzaIngredients);
      System.out.println("sides: " + sides);
      System.out.println("drinks:" + drinks);
      System.out.println("Order Total: " + orderTotal);
   }

}
