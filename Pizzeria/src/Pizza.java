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
    public String cardNumber;
    public String expiryDate;
    public int cvv;
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
     public void setOrderId(String id
     
     ){
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
   public void cardPayMent(String cardNumber, String expiryDate, int cvv){
       this.cardNumber = cardNumber;
       this.expiryDate = expiryDate;
       this.cvv = cvv;
       int cardLength = cardNumber.length();
    int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));
    int lastFourDigits = Integer.parseInt(cardNumber.substring(cardNumber.length() - 4));
    
       if (cardLength == 14){
          System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
        }
        String blacklistedNumber = "12345678901234";
        if (cardNumber.equals(blacklistedNumber)) {
            System.out.println("Card is blacklisted. Please use another card");
        }
        StringBuilder cardNumberToDisplay = new StringBuilder();
        cardNumberToDisplay.append(cardNumber.charAt(0));
        for (int i = 1; i < cardNumber.length() - 4; i++) {
            cardNumberToDisplay.append('*');
        }
        cardNumberToDisplay.append(cardNumber.substring(cardNumber.length() - 4));

        System.out.println("First digit of the card: " + firstCardDigit);
        System.out.println("Last four digits of the card: " + lastFourDigits);
        System.out.println("Card number to display: " + cardNumberToDisplay);

   }
   public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice){
     StringBuilder details = new StringBuilder();
        details.append("Pizza of the day: ").append(pizzaOfTheDay).append("\n");
        details.append("Side of the day: ").append(sideOfTheDay).append("\n");
        details.append("Special price: ").append(specialPrice);
        System.out.println(details.toString());
   }



}
