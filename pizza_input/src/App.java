public class App {

    public static void main(String[] args) throws Exception {
       Pizza pizza = new Pizza("1234", "Garlic", 10.00);
       pizza.takeOrder();
       pizza.specialOfTheDay("chickenPizza", "Bread", "$12.99");

    }
}
