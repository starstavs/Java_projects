package homework0405;

public class SumOfDiagonal {
    public static void main(String[] args) {
        int[][] intArray = new int[3][3];
        int sum = 0, element = 0;
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[i].length; j++) {
                intArray[i][j] = ++element;

            }
        }
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[i].length; j++) {
                System.out.println(intArray[i][j]);

            }
        }
        for (int i = 0; i < intArray.length; i++) {
            sum += intArray[i][i];


        }
        System.out.println("Sum of the main diagonal " + sum);
    }


}

