package homework1505.food;

public abstract class Orders {
    private String mealName;
    private double price;

    public Orders(String mealName, double price) {
        this.mealName = mealName;
        this.price = price;
    }

    public String getMealName() {
        return mealName;
    }

    public double getPrice() {
        return price;
    }

    public abstract void calculateOrder();

    public void displayOrderDetail() {
        System.out.println("Order n");
        System.out.println("You order " + mealName);
        System.out.println("Price");
    }

    ;


}
