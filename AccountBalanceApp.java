package BalanceCalculatorApp;

import java.util.Scanner;

public class AccountBalanceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create scanner object

        try {
            // Creating accounts
            Account checkingAccount = new CheckingAccount(1000, 1); // Monthly fee $1
            Account savingsAccount = new SavingsAccount(1000, 0.01); // 1% monthly interest

            System.out.println("Welcome to the Account application");
            System.out.println("Starting Balances");
            System.out.println("Checking: $" + checkingAccount.getBalance());
            System.out.println("Savings: $" + savingsAccount.getBalance());

            boolean continueTransactions = true;
            while (continueTransactions) {
                System.out.println("\nEnter the transactions for the month");

                // Asking for withdrawal or deposit
                System.out.print("Withdrawal or deposit? (w/d): ");
                String action = scanner.nextLine();

                // Asking for account type
                System.out.print("Checking or savings? (c/s): ");
                String accountType = scanner.nextLine();

                // Asking for the amount
                System.out.print("Amount?: ");
                double amount = Double.parseDouble(scanner.nextLine());

                // Perform deposit or withdrawal
                if (action.equals("w")) {
                    if (accountType.equals("c")) {
                        checkingAccount.withdraw(amount);
                    } else if (accountType.equals("s")) {
                        savingsAccount.withdraw(amount);
                    }
                } else if (action.equals("d")) {
                    if (accountType.equals("c")) {
                        checkingAccount.deposit(amount);
                    } else if (accountType.equals("s")) {
                        savingsAccount.deposit(amount);
                    }
                }

                // Check if the user wants to continue
                System.out.print("Continue? (y/n): ");
                String continueChoice = scanner.nextLine();
                if (continueChoice.equals("n")) {
                    continueTransactions = false;
                }
            }

            // Apply monthly fees and interest
            ((CheckingAccount) checkingAccount).subtractFee(); // Subtract fee for checking account
            ((SavingsAccount) savingsAccount).calculateInterestPayment(); // Apply interest for savings account

            // Show final balances
            System.out.println("\nMonthly Payments and Fees");
            System.out.println("Checking fee: $1.00");
            System.out.println("Savings interest payment: $" + ((SavingsAccount) savingsAccount).getMonthlyInterestPayment());
            System.out.println("\nFinal Balances");
            System.out.println("Checking: $" + checkingAccount.getBalance());
            System.out.println("Savings: $" + savingsAccount.getBalance());
        } finally {
            // Close the scanner object to avoid resource leak
            scanner.close();
        }
    }
}
