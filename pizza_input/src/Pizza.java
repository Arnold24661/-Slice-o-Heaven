import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
    public class Pizza {
    private String pizzaIngredients;
    private String orderId;
    private double orderTotal;
    private long cardNumber;
    private String expiryDate;
    private int cvv;

    public Pizza(String id, String pizzaIngredients, double total){
        orderId = id;
        this.pizzaIngredients = pizzaIngredients;
          orderTotal = total;
      }
      


    public void takeOrder(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String ing1 = input.nextLine();
        String ing2 = input.nextLine();
        String ing3 = input.nextLine();

        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String pizzaSize = input.nextLine();

        System.out.println("Do you want extra cheese(Y/N):");
        String extraCheese = input.nextLine();

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        String sideDish = input.nextLine();

        System.out.println("Enter drinks(Cold coffee, Cocoa drink, Coke, None)");
        String drinks = input.nextLine();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = input.nextLine();
       

        if(wantDiscount.equals("Y")){
            isItYourBirthday();
        }else{
            makeCardPayment();
        }
        input.close();

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

     public void isItYourBirthday(){
           Scanner input = new Scanner(System.in);
           System.out.println("Your birthdate:");
           int year = input.nextInt();
           int month = input.nextInt();
           int day = input.nextInt();
           LocalDate dob = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();

        Period diff = Period.between(dob, now);
        if(diff.getYears() < 18 && diff.getMonths() ==0 && diff.getDays() ==0){
            System.out.println("Congratulations! You pay only half the price for your order.");
        }else {
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
        }
        input.close();
     }
     public void makeCardPayment(){
        Scanner input = new Scanner(System.in);
        System.out.println("Your card number:");
        long cardNumber = input.nextInt();
        input.nextLine();
        System.out.println("Expiry date:");
        String expiryDate = input.nextLine();
        int year = Integer.parseInt(expiryDate.substring(0, 4));
        int month = Integer.parseInt(expiryDate.substring(5, 6));
        System.out.println("cvv number:");
        int cvv = input.nextInt();
        input.nextLine();
       
        cardPayMent(cardNumber, expiryDate, cvv);
        input.close();
        
     }

     public void cardPayMent(long cardNumber, String expiryDate, int cvv){
        
        int cardLength = Long.toString(cardNumber).length();
     int firstCardDigit = Integer.parseInt(Long.toString(cardNumber).substring(0, 1));
     int lastFourDigits = Integer.parseInt(Long.toString(cardNumber).substring(Long.toString(cardNumber).length() - 4));
     
        if (cardLength == 14){
           System.out.println("Card accepted");
         } else {
             System.out.println("Invalid card");
         }
         String blacklistedNumber = "12345678901234";
         if (Long.toString(cardNumber).equals(blacklistedNumber)) {
             System.out.println("Card is blacklisted. Please use another card");
         }
         StringBuilder cardNumberToDisplay = new StringBuilder();
         cardNumberToDisplay.append(Long.toString(cardNumber).charAt(0));
         for (int i = 1; i < Long.toString(cardNumber).length() - 4; i++) {
             cardNumberToDisplay.append('*');
         }
         cardNumberToDisplay.append(Long.toString(cardNumber).substring(Long.toString(cardNumber).length() - 4));
 
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
      private void printReceipt1(){
        System.out.println("********RECEIPT********");

      System.out.println("Order ID: " + orderId);
      System.out.println("ingredients: " + pizzaIngredients);
      
      System.out.println("Order Total: " + orderTotal);
   }
}
   
