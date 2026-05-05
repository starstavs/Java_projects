package homework0405;


public class MaximumElement {
    public static void main(String[] args) {
        int intArray[];
        intArray = new int[50];
        int maxElement = 0, indexPosition = 0, duplicate = 0, oddElement = 0, evenElement = 0;


        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) (Math.random() * 100);

        }
        intArray[15] = 99;
        intArray[49] = intArray[15];
        //System.out.println("The array have " + intArray.length + " elements.");
       /* for(int number:intArray) {
            System.out.println(number);
        }*/
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] % 2 == 0) oddElement++;
            else evenElement++;
            if (intArray[i] >= maxElement) {
                if (intArray[i] > maxElement) {
                    maxElement = intArray[i];
                    indexPosition = i;
                    duplicate = 1;
                } else duplicate++;
            }
        }
        System.out.println("This array contains " + intArray.length + " elements.");
        System.out.println("Maximal element is " + maxElement + ". Ist position in array is " + indexPosition + ".");
        System.out.println("It occurs " + duplicate + " times.");
        System.out.println("Number of odd element is "+ oddElement+".");
        System.out.println("Number of even element is "+ evenElement+".");
    }
}
