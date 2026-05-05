package homework0405;

public class SortArray {
    public static void main(String[] args) {
        int intArray[] = new int[50];
        int newArray[] = new int[50];
        int temp, number=50;
        boolean sorting = false;


        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = --number;

        }
        for (int i = 1; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
        System.out.println("Sorting...");
        while (!sorting) {
            temp = 0;
            for (int i = 1; i < intArray.length; i++) {
                if (intArray[i] < intArray[i - 1]) {
                    temp = intArray[i - 1];
                    intArray[i - 1] = intArray[i];
                    intArray[i] = temp;
                    temp = 1;
                }

            }
            if (temp == 0) sorting = true;
        }
        for (int i = 1; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
