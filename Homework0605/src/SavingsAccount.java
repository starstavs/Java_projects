public class SavingsAccount {
    public static double annualInterestRate = 4;
    public double savingsBalance;
    public String userName;
    public int userAge;
    public double monthlyInterest;

    public final double calculateMonthlyInterest(double savingsBalance) {
        monthlyInterest = (savingsBalance * annualInterestRate / 100) / 12;

        return (monthlyInterest);
    }

    public static void modifyInterestRate(double newInterestRate) {
        annualInterestRate = newInterestRate;
    }


    @Override
    public String toString() {
        return "Depositor " + userName + ", " + userAge + ". Balance " + savingsBalance + ". Annual interest rate " + annualInterestRate;
    }

}