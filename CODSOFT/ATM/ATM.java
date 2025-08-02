import java.util.Scanner;

// Class that represents the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("✅ Deposited ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawn ₹" + amount);
        }
    }

    public void checkBalance() {
        System.out.printf("💰 Current Balance: ₹%.2f\n", balance);
    }
}

// ATM machine class with UI
public class ATM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(1000.00);  // Starting with ₹1000

        System.out.println("🏧 Welcome to Simple ATM");

        boolean running = true;

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("👉 Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    userAccount.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = input.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = input.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }

        input.close();
    }
}
