package homework1505.food;

public class Burgers extends Orders {


    public Burgers(String mealName, double price) {
        super(mealName, price);
    }

    @Override
    public void calculateOrder() {
        //calculateOrder
    }

    @Override
    public void displayOrderDetail(){
        System.out.println("Burgers orders");
        super.displayOrderDetail();
    }
}
