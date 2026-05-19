package homework1505.food;

public class Pizzas extends Orders {

    private static final String[] PIZZAS_TOPPINGS = new String[]{"Extra cheese", "Extra sausage", "Ketchup", "Mayonnaise"};

    public Pizzas(String mealName, double price) {
        super(mealName, price);
    }

    @Override
    public void calculateOrder() {
        //calculateOrder
    }

    @Override
     public void displayOrderDetail(){
         System.out.println("Pizzas orders");
         super.displayOrderDetail();
     }

}
