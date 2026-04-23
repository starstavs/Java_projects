import java.util.Scanner;

public class TempConverter {
    Scanner scanTemp = new Scanner(System.in);
double tempCelsius, tempFarengeit;

    public double getTemperature(){
       System.out.println("Enter temperature in Celsius");
       tempCelsius = scanTemp.nextDouble();
       tempFarengeit = tempCelsius * 9 / 5 + 32;
       return tempFarengeit;
    }
}
