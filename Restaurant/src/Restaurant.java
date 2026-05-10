import java.sql.SQLOutput;
import java.util.Scanner;

public class Restaurant {
    static double orderSum;

    static boolean action = true;
    static Scanner scan = new Scanner(System.in);
    static Order[] order = new Order[50];
    static Menu[] menu = new Menu[20];
    static int scanQuantity;

    public static void main(String[] args) {

        int orderNumber = 0;
        int options;

        double sum;
        setMenus();
        System.out.println("Welcome in our restaurant.");
        System.out.println("*---*---*---*---*---*---*---*");


        do {

            System.out.println("Choose a dish from our menu.");
            System.out.println("*---*---*---*---*---*---*---*");

            getMenu();
            System.out.println("0 Total.");
            options = Integer.parseInt(scan.nextLine());

            switch (options) {

                case 1 -> {
                    addOrder(orderNumber, menu[0].name, menu[0].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 2 -> {
                    addOrder(orderNumber, menu[1].name, menu[1].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 3 -> {
                    addOrder(orderNumber, menu[2].name, menu[2].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 4 -> {
                    addOrder(orderNumber, menu[3].name, menu[3].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 5 -> {
                    addOrder(orderNumber, menu[4].name, menu[4].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 6 -> {
                    addOrder(orderNumber, menu[5].name, menu[5].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 7 -> {
                    addOrder(orderNumber, menu[6].name, menu[6].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 8 -> {
                    addOrder(orderNumber, menu[7].name, menu[7].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 9 -> {
                    addOrder(orderNumber, menu[8].name, menu[8].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 10 -> {
                    addOrder(orderNumber, menu[9].name, menu[9].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 11 -> {
                    addOrder(orderNumber, menu[10].name, menu[10].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 12 -> {
                    addOrder(orderNumber, menu[11].name, menu[11].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 13 -> {
                    addOrder(orderNumber, menu[12].name, menu[12].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 14 -> {
                    addOrder(orderNumber, menu[13].name, menu[13].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 15 -> {
                    addOrder(orderNumber, menu[14].name, menu[14].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 16 -> {
                    addOrder(orderNumber, menu[15].name, menu[15].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 17 -> {
                    addOrder(orderNumber, menu[16].name, menu[16].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 18 -> {
                    addOrder(orderNumber, menu[17].name, menu[17].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 19 -> {
                    addOrder(orderNumber, menu[18].name, menu[18].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }
                case 20 -> {
                    addOrder(orderNumber, menu[19].name, menu[19].price);
                    orderNumber++;
                    System.out.println("Insert quantity");
                    break;
                }

                case 0 -> {
                    System.out.println("Your order is ...");
                    sum = 0;
                    orderSum = 0;
                    for (int i = 0; i < order.length; i++) {

                        sum = order[i].price * order[i].quantity;
                        orderSum += sum;
                        System.out.println(order[i].dishNumber + " " + order[i].dishName + " " + order[i].price + "$ - " + order[i].quantity + ". Total " + sum);
                    }
                    System.out.println("Total to be paid: " + orderSum);
                    action = false;
                    break;
                }
                default -> {
                    System.out.println("Invalid parameter");
                    break;
                }
            }
        } while (action);


    }


    public static void getMenu() {
        System.out.println("Pizza");
        System.out.println("*---*---*---*---*---*---*---*");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i].number + " " + menu[i].name + " " + menu[i].price + "$");
        }
    }


    public static void setMenus() {
        for (int i = 0; i < 20; i++) {
            menu[i] = new Menu();
            menu[i].number = i + 1;
            menu[i].name = "Ton's Pizza" + i;
            menu[i].price = Math.round(Math.random() * 25 * 100) / 100.0;


        }
        for (int n=0; n<order.length; n++){
            order[n] = new Order();
        }
    }

    public static void addOrder(int ordNumber, String ordName, double ordPrice) {
        System.out.println("Insert quantity");
        scanQuantity = Integer.parseInt(scan.nextLine());
        //order[ordNumber] = new Order();
        order[ordNumber].dishNumber = ordNumber;
        order[ordNumber].quantity = scanQuantity;
        order[ordNumber].price = ordPrice;
    }

}
