package homework0405;

public class Matrix {
    public static void main(String[] args) {
        int[][] intArray = new int[2][3];
        int n = 0;
        for (int j = 0; j < intArray[0].length; j++)
        {for (int i = 0; i < intArray.length; i++) {

                //intArray[i][j] = (int) (Math.random() * 100);
                intArray[i][j] = ++n;

            }
        }
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[0].length; j++) {


                System.out.print(intArray[i][j]+" ");
            }
            System.out.println();
        }

    }
}
