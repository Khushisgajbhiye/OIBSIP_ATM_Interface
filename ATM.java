import java.util.Scanner;

public class ATM {
    private static final String USER_ID = "123456";
    private static final String USER_PIN = "7890";
    private static double balance = 1000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter User PIN: ");
        String userPin = scanner.nextLine();

        if (authenticateUser(userId, userPin)) {
            System.out.println("Authentication Successful!");
            showMenu();
        } else {
            System.out.println("Authentication Failed. Exiting...");
        }
    }

    private static boolean authenticateUser(String userId, String userPin) {
        return userId.equals(USER_ID) && userPin.equals(USER_PIN);
    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }

    private static void showTransactionHistory() {
        System.out.println("Transaction History:");
        // Code to display transaction history
    }

    private static void withdraw() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        }
    }

    private static void deposit() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        balance += amount;
        System.out.println("Deposit successful. Updated balance: " + balance);
    }

    private static void transfer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter recipient's account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Transfer successful. Remaining balance: " + balance);
        }
    }
}

