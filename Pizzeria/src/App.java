public class App {
    public static void main(String[] args) throws Exception {
        Pizza chickenPizza = new Pizza();
        chickenPizza.makePizza("cheese, yellow paparika, red paprika...");
        chickenPizza.takeOrder("1234", "cake", "cola", 20.00);
}
}