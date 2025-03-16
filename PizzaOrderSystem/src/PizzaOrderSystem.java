import java.util.Scanner;

    public class PizzaOrderSystem {
    
    
        enum PizzaSelection {
            PEPPERONI("Pepperoni", "Lots of pepperoni and extra cheese", 18),
            HAWAIIAN("Hawaiian", "Pineapple, ham, and extra cheese", 22),
            VEGGIE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives", 25),
            BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper, and cheddar cheese", 35),
            EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions, green pepper, mushrooms, black olives, and extra cheese", 45);
    
            private final String pizzaName;
            private final String pizzaToppings;
            private final double price;
    
            PizzaSelection(String pizzaName, String pizzaToppings, double price) {
                this.pizzaName = pizzaName;
                this.pizzaToppings = pizzaToppings;
                this.price = price;
            }
    
            public String getPizzaName() {
                return pizzaName;
            }
    
            public String getPizzaToppings() {
                return pizzaToppings;
            }
    
            public double getPrice() {
                return price;
            }
    
            @Override
            public String toString() {
                return pizzaName + " Pizza with " + pizzaToppings + ", for €" + price;
            }
        }
    
    
        enum PizzaToppings {
            HAM("Ham", 2),
            PEPPERONI("Pepperoni", 2),
            BEEF("Beef", 2),
            CHICKEN("Chicken", 2),
            SAUSAGE("Sausage", 2),
            PINEAPPLE("Pineapple", 1),
            ONION("Onion", 0.5),
            TOMATOES("Tomatoes", 0.4),
            GREEN_PEPPER("Green Pepper", 0.5),
            BLACK_OLIVES("Black Olives", 0.5),
            SPINACH("Spinach", 0.5),
            CHEDDAR_CHEESE("Cheddar Cheese", 0.8),
            MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8),
            FETA_CHEESE("Feta Cheese", 1),
            PARMESAN_CHEESE("Parmesan Cheese", 1);
    
            private final String topping;
            private final double toppingPrice;
    
            PizzaToppings(String topping, double toppingPrice) {
                this.topping = topping;
                this.toppingPrice = toppingPrice;
            }
    
            public String getTopping() {
                return topping;
            }
    
            public double getToppingPrice() {
                return toppingPrice;
            }
    
            @Override
            public String toString() {
                return topping + " (€" + toppingPrice + ")";
            }
        }
    
    
        enum PizzaSize {
            LARGE("Large", 10),
            MEDIUM("Medium", 5),
            SMALL("Small", 0);
    
            private final String pizzaSize;
            private final double addToPizzaPrice;
    
            PizzaSize(String pizzaSize, double addToPizzaPrice) {
                this.pizzaSize = pizzaSize;
                this.addToPizzaPrice = addToPizzaPrice;
            }
    
            public String getPizzaSize() {
                return pizzaSize;
            }
    
            public double getAddToPizzaPrice() {
                return addToPizzaPrice;
            }
    
            @Override
            public String toString() {
                return pizzaSize + " (€" + addToPizzaPrice + ")";
            }
        }
    
    
        enum SideDish {
            CALZONE("Calzone", 15),
            CHICKEN_PUFF("Chicken Puff", 20),
            MUFFIN("Muffin", 12),
            NOTHING("No side dish", 0);
    
            private final String sideDishName;
            private final double addToPizzaPrice;
    
            SideDish(String sideDishName, double addToPizzaPrice) {
                this.sideDishName = sideDishName;
                this.addToPizzaPrice = addToPizzaPrice;
            }
    
            public String getSideDishName() {
                return sideDishName;
            }
    
            public double getAddToPizzaPrice() {
                return addToPizzaPrice;
            }
    
            @Override
            public String toString() {
                return sideDishName + " (€" + addToPizzaPrice + ")";
            }
        }
    
    
        enum Drinks {
            COCA_COLA("Coca Cola", 8),
            COCOA_DRINK("Cocoa Drink", 10),
            NOTHING("No drinks", 0);
    
            private final String drinkName;
            private final double addToPizzaPrice;
    
            Drinks(String drinkName, double addToPizzaPrice) {
                this.drinkName = drinkName;
                this.addToPizzaPrice = addToPizzaPrice;
            }
    
            public String getDrinkName() {
                return drinkName;
            }
    
            public double getAddToPizzaPrice() {
                return addToPizzaPrice;
            }
    
            @Override
            public String toString() {
                return drinkName + " (€" + addToPizzaPrice + ")";
            }
        }
    
    
        private static final double PIZZA_BASE_PRICE = 10.0;
    
    
        private static String[] pizzasOrdered = new String[10];
        private static String[] pizzasSizeOrdered = new String[10];
        private static String[] sideDishesOrdered = new String[20];
        private static String[] drinksOrdered = new String[20];
    
    
        private static int pizzaIndex = 0;
        private static int sideDishIndex = 0;
        private static int drinkIndex = 0;
        private static double totalOrderPrice = 0.0;
    
    
        private static Scanner scanner = new Scanner(System.in);
    
        
        public void takeOrder() {
            
            System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here's what we serve:");
            PizzaSelection[] pizzaSelections = PizzaSelection.values();
            for (int i = 0; i < pizzaSelections.length; i++) {
                System.out.println((i + 1) + ". " + pizzaSelections[i].toString());
            }
            System.out.println("6. Custom Pizza with a maximum of 10 toppings that you choose");
    
            
            System.out.print("Please enter your choice (1 - 6): ");
            int pizzaChoice = scanner.nextInt();
    
            if (pizzaChoice >= 1 && pizzaChoice <= 5) {
                
                PizzaSelection selectedPizza = pizzaSelections[pizzaChoice - 1];
                pizzasOrdered[pizzaIndex++] = selectedPizza.toString();
                totalOrderPrice += selectedPizza.getPrice();
            } else if (pizzaChoice == 6) {
                
                System.out.println("Available toppings:");
                PizzaToppings[] toppings = PizzaToppings.values();
                for (int i = 0; i < toppings.length; i++) {
                    System.out.println((i + 1) + ". " + toppings[i].toString());
                }
    
                double customPizzaPrice = PIZZA_BASE_PRICE;
                StringBuilder customPizzaDescription = new StringBuilder("Custom Pizza with ");
                System.out.print("Enter the number of toppings (max 10): ");
                int numToppings = scanner.nextInt();
                for (int i = 0; i < numToppings && i < 10; i++) {
                    System.out.print("Choose topping " + (i + 1) + ": ");
                    int toppingChoice = scanner.nextInt();
                    if (toppingChoice >= 1 && toppingChoice <= toppings.length) {
                        PizzaToppings selectedTopping = toppings[toppingChoice - 1];
                        customPizzaDescription.append(selectedTopping.getTopping()).append(", ");
                        customPizzaPrice += selectedTopping.getToppingPrice();
                    }
                }
    
    
                if (customPizzaDescription.length() > 0) {
                    customPizzaDescription.setLength(customPizzaDescription.length() - 2);
                }
    
                customPizzaDescription.append(", for €").append(customPizzaPrice);
                pizzasOrdered[pizzaIndex++] = customPizzaDescription.toString();
                totalOrderPrice += customPizzaPrice;
            }
    
    
            System.out.println("Choose your pizza size:");
            PizzaSize[] sizes = PizzaSize.values();
            for (int i = 0; i < sizes.length; i++) {
                System.out.println((i + 1) + ". " + sizes[i].toString());
            }
            System.out.print("Enter your choice (1 - 3): ");
            int sizeChoice = scanner.nextInt();
            if (sizeChoice >= 1 && sizeChoice <= sizes.length) {
                PizzaSize selectedSize = sizes[sizeChoice - 1];
                pizzasSizeOrdered[pizzaIndex - 1] = selectedSize.getPizzaSize();
                totalOrderPrice += selectedSize.getAddToPizzaPrice();
            }
    
    
            System.out.println("Choose your side dish:");
            SideDish[] sideDishes = SideDish.values();
            for (int i = 0; i < sideDishes.length; i++) {
                System.out.println((i + 1) + ". " + sideDishes[i].toString());
            }
            System.out.print("Enter your choice (1 - 4): ");
            int sideDishChoice = scanner.nextInt();
            if (sideDishChoice >= 1 && sideDishChoice <= sideDishes.length) {
                SideDish selectedSideDish = sideDishes[sideDishChoice - 1];
                sideDishesOrdered[sideDishIndex++] = selectedSideDish.getSideDishName();
                totalOrderPrice += selectedSideDish.getAddToPizzaPrice();
            }
    
    
            System.out.println("Choose your drink:");
            Drinks[] drinks = Drinks.values();
            for (int i = 0; i < drinks.length; i++) {
                System.out.println((i + 1) + ". " + drinks[i].toString());
            }
            System.out.print("Enter your choice (1 - 3): ");
            int drinkChoice = scanner.nextInt();
            if (drinkChoice >= 1 && drinkChoice <= drinks.length) {
                Drinks selectedDrink = drinks[drinkChoice - 1];
                drinksOrdered[drinkIndex++] = selectedDrink.getDrinkName();
                totalOrderPrice += selectedDrink.getAddToPizzaPrice();
            }
        }
    
        @Override
        public String toString() {
            StringBuilder orderDetails = new StringBuilder("Thank you for dining with Slice-o-Heaven Pizzeria. Your order details are as follows:\n");
    
            for (int i = 0; i < pizzaIndex; i++) {
                orderDetails.append(i + 1).append(". ").append(pizzasOrdered[i]).append("\n");
                if (i < pizzasSizeOrdered.length && pizzasSizeOrdered[i] != null) {
                    orderDetails.append("Size: ").append(pizzasSizeOrdered[i]).append("\n");
                }
                if (i < sideDishesOrdered.length && sideDishesOrdered[i] != null) {
                    orderDetails.append("Side Dish: ").append(sideDishesOrdered[i]).append("\n");
                }
                if (i < drinksOrdered.length && drinksOrdered[i] != null) {
                    orderDetails.append("Drink: ").append(drinksOrdered[i]).append("\n");
                }
            }
    
            orderDetails.append("ORDER TOTAL: €").append(totalOrderPrice);
            return orderDetails.toString();
        }
    
}
    
