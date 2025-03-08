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
    public final String blacklistedNumber = "12345678901234";

    public Pizza(String id, String pizzaIngredients, double total){
        orderId = id;
        this.pizzaIngredients = pizzaIngredients;
          orderTotal = total;
      }
      


    public void takeOrder(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please pick any three of the following ingredients: \n1.Mushroom\n2.Paprika\n3.Sun-dried tomatoes\n4.Chicken\n5.Pineapple\nEnter any three choices (1,2,3,...) separated by spaces");
        int ingChoice1 = input.nextInt();
        int ingChoice2 = input.nextInt();
        int ingChoice3 = input.nextInt();
        input.nextLine();
        while (ingChoice1<1||ingChoice1>5||ingChoice2<1||ingChoice2>5||ingChoice3<1||ingChoice3>5){
                System.out.println("Invalid choice, please pick only from the given list");
                 ingChoice1 = input.nextInt();
                 ingChoice2 = input.nextInt();
                  ingChoice3 = input.nextInt();
                  input.nextLine();
        }
        
        
        String ing1 = "0";
        String ing2 = "0";
        String ing3 = "0";

        switch(ingChoice1){
            case 1:
            ing1 = "Mushroom";
            break;
            case 2:
            ing1 = "Paprika";
            break;
            case 3:
            ing1 = "Sun-dried tomatoes";
            break;
            case 4:
            ing1 = "Chicken";
            break;
            case 5:
            ing1 = "Pineapple";
            break;
        }
        switch(ingChoice2){
            case 1:
            ing2 = "Mushroom";
            break;
            case 2:
            ing2 = "Paprika";
            break;
            case 3:
            ing2 = "Sun-dried tomatoes";
            break;
            case 4:
            ing2 = "Chicken";
            break;
            case 5:
            ing2 = "Pineapple";
            break;
        }
        switch(ingChoice3){
            case 1:
            ing3 = "Mushroom";
            break;
            case 2:
            ing3 = "Paprika";
            break;
            case 3:
            ing3 = "Sun-dried tomatoes";
            break;
            case 4:
            ing3 = "Chicken";
            break;
            case 5:
            ing3 = "Pineapple";
            break;
        }
       System.out.println(ing1);
       System.out.println(ing2);
       System.out.println(ing3);



        System.out.println("What size should your pizza be?\n1.Large\n2.Medium\n3.Small\nEnter only one choice(1,2,or 3):");
        int sizeChoice = input.nextInt();
        input.nextLine();
        while(sizeChoice <1||sizeChoice>3){
            System.out.println("Invalid choice");
            sizeChoice = input.nextInt();
            input.nextLine();
        }
        String pizzaSize = "0";
        switch(sizeChoice){
            case 1:
            pizzaSize = "Large";
            break;
            case 2:
            pizzaSize = "Medium";
            break;
            case 3:
            pizzaSize = "Small";
            break;

        }
        System.out.println(pizzaSize);
        

        System.out.println("Do you want extra cheese(Y/N):");
        String extraCheese = input.nextLine();

        System.out.println("Following are the side dish that go well with your pizza:\n1.Calzone\n2.Garlic bread\n3.Chicken puff\n4.Muffin\n5.Nothing for me\nWhat would you like? Pick one(1,2,3,...)");
        int sideDishChoice = input.nextInt();
        input.nextLine();
        while(sideDishChoice <1||sideDishChoice>5){
            System.out.println("Invalid choice");
            sideDishChoice = input.nextInt();
            input.nextLine();
        }
        String sideDish = "0";
        switch(sideDishChoice){
            case 1:
            sideDish = "Calzone";
            break;
            case 2:
            sideDish = "Garlic bread";
            break;
            case 3:
            sideDish = "Chicken puff";
            break;
            case 4:
            sideDish = "Muffin";
            break;
            case 5:
            sideDish = "Nothing for me";
            break;

        }
        System.out.println(sideDish);

        System.out.println("Choose from one of the drinks below. We recommend Coac cola:\n1.Coca cola\n2.Cold coffee\n3.Cocoa Drink\n4.No drinks for me\nEnter your choice:");
        int drinkChoice = input.nextInt();
        input.nextLine();
        while(drinkChoice <1||drinkChoice>4){
            System.out.println("Invalid choice");
            drinkChoice = input.nextInt();
            input.nextLine();
        }
        String drinks = "0";
        switch(drinkChoice){
            case 1:
            drinks = "Coca cola";
            break;
            case 2:
            drinks = "Cold coffee";
            break;
            case 3:
            drinks = "Cocoa drink";
            break;
            case 4:
            drinks = "No drinks for me";
            break;
        }
        System.out.println(drinks);

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
        
         
    }

     public void isItYourBirthday(){
           Scanner input = new Scanner(System.in);
           System.out.println("Your birthdate:");
           int year = input.nextInt();
           int month = input.nextInt();
           int day = input.nextInt();
           input.nextLine();
           while(year<1905||year>2020){
            System.out.println("Invalid date. You are either too young or too dead to order. Please enter a valid date:");
             year = input.nextInt();
             month = input.nextInt();
             day = input.nextInt();
             input.nextLine();
           }
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
        long cardNumber = input.nextLong();
        input.nextLine();
        System.out.println("Expiry date:");
        String expiryDate = input.nextLine();
        int year = Integer.parseInt(expiryDate.substring(0, 4));
        int month = Integer.parseInt(expiryDate.substring(5, 6));
        while(year<2025||month<3){
            System.out.println("Invalid date. ");
            expiryDate = input.nextLine();
            year = Integer.parseInt(expiryDate.substring(0,4));
            month = Integer.parseInt(expiryDate.substring(5,6));
        }

        System.out.println("cvv number:");
        int cvv = input.nextInt();
        input.nextLine();
       
        cardPayMent(cardNumber, expiryDate, cvv);
        input.close();
        
     }

     public void cardPayMent(long cardNumber, String expiryDate, int cvv){
        Scanner input = new Scanner(System.in);
        int cardLength = Long.toString(cardNumber).length();
     int firstCardDigit = Integer.parseInt(Long.toString(cardNumber).substring(0, 1));
     int lastFourDigits = Integer.parseInt(Long.toString(cardNumber).substring(Long.toString(cardNumber).length() - 4));
     
        
        while(cardLength != 14){
             System.out.println("Invalid card");
             cardNumber = input.nextInt();
             input.nextLine();
        }
        if (cardLength == 14){
            System.out.println("Card accepted");
          } 
        
         while(Long.toString(cardNumber).equals(blacklistedNumber)) {
             System.out.println("Card is blacklisted. Please use another card");
             cardNumber = input.nextInt();
             input.nextLine();
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
      public String toString(){
        return "Order ID:" + orderId +"Ingredient:" +pizzaIngredients+"Order total:"+ orderTotal;
      }
}
   
