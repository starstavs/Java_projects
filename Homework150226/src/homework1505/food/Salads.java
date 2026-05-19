package homework1505.food;

public class Salads extends Orders {
    public Salads(String mealName, double price) {
        super(mealName, price);
    }

    @Override
    public void calculateOrder() {
        //calculateOrder
    }

    @Override
    public void displayOrderDetail(){
        System.out.println("Salads orders");
        super.displayOrderDetail();
    }
}
