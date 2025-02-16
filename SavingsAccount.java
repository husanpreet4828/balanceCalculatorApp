package BalanceCalculatorApp;

public class SavingsAccount extends Account {
    private double monthlyInterestRate;
    private double monthlyInterestPayment;

    public SavingsAccount(double balance, double monthlyInterestRate) {
        super(balance);
        this.monthlyInterestRate = monthlyInterestRate;
        calculateInterestPayment(); // Calculate interest when the object is created
    }

    public void calculateInterestPayment() {
        this.monthlyInterestPayment = balance * monthlyInterestRate;
        balance += monthlyInterestPayment; // Add the interest to the balance
    }

    public double getMonthlyInterestPayment() {
        return monthlyInterestPayment;
    }
}
