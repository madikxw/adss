package banking;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.UUID;

public class BankSystem {

    Scanner scanner = new Scanner(System.in);

    // Task 1
    LinkedList<BankAccount> accounts = new LinkedList<>();

    // Task 3
    Stack<String> history = new Stack<>();

    // Task 4
    Queue<String> billQueue = new LinkedList<>();

    // Task 5
    Queue<BankAccount> accountRequests = new LinkedList<>();

    // Task 6
    BankAccount[] fixedAccounts = new BankAccount[3];

    public BankSystem() {
        // Demo accounts for LinkedList
        accounts.add(new BankAccount("1", "Ali", 150000));
        accounts.add(new BankAccount("2", "Sara", 220000));

        // Predefined accounts for array task
        fixedAccounts[0] = new BankAccount("A101", "Nurlan", 100000);
        fixedAccounts[1] = new BankAccount("A102", "Aruzhan", 200000);
        fixedAccounts[2] = new BankAccount("A103", "Dias", 300000);
    }

    public void start() {
        mainMenu();
    }

    // ================= MAIN MENU =================
    public void mainMenu() {
        while (true) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Show physical array accounts");
            System.out.println("5 - Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            if (choice == 1) {
                bankMenu();
            } else if (choice == 2) {
                atmMenu();
            } else if (choice == 3) {
                adminMenu();
            } else if (choice == 4) {
                showArrayAccounts();
            } else if (choice == 5) {
                System.out.println("Program finished.");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // ================= BANK MENU =================
    public void bankMenu() {
        while (true) {
            System.out.println("\n========== BANK MENU ==========");
            System.out.println("1 - Add new account");
            System.out.println("2 - Display all accounts");
            System.out.println("3 - Search account by username");
            System.out.println("4 - Deposit money");
            System.out.println("5 - Withdraw money");
            System.out.println("6 - Add bill payment");
            System.out.println("7 - Display bill queue");
            System.out.println("8 - Submit account opening request");
            System.out.println("9 - Show last transaction");
            System.out.println("10 - Undo last transaction");
            System.out.println("11 - Back");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            if (choice == 1) {
                addAccount();
            } else if (choice == 2) {
                displayAllAccounts();
            } else if (choice == 3) {
                searchAccount();
            } else if (choice == 4) {
                depositMoney();
            } else if (choice == 5) {
                withdrawMoney();
            } else if (choice == 6) {
                addBillPayment();
            } else if (choice == 7) {
                displayBillQueue();
            } else if (choice == 8) {
                submitAccountRequest();
            } else if (choice == 9) {
                showLastTransaction();
            } else if (choice == 10) {
                undoLastTransaction();
            } else if (choice == 11) {
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // ================= ATM MENU =================
    public void atmMenu() {
        while (true) {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1 - Balance enquiry");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Back");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            if (choice == 1) {
                checkBalance();
            } else if (choice == 2) {
                atmWithdraw();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // ================= ADMIN MENU =================
    public void adminMenu() {
        while (true) {
            System.out.println("\n========== ADMIN MENU ==========");
            System.out.println("1 - View pending account requests");
            System.out.println("2 - Process next account request");
            System.out.println("3 - View bill payment queue");
            System.out.println("4 - Process next bill payment");
            System.out.println("5 - View all accounts");
            System.out.println("6 - Back");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            if (choice == 1) {
                displayPendingRequests();
            } else if (choice == 2) {
                processNextRequest();
            } else if (choice == 3) {
                displayBillQueue();
            } else if (choice == 4) {
                processNextBill();
            } else if (choice == 5) {
                displayAllAccounts();
            } else if (choice == 6) {
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // ================= TASK 1 =================
    public void addAccount() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (findAccount(username) != null) {
            System.out.println("Account with this username already exists.");
            return;
        }

        System.out.print("Enter balance: ");
        double balance = readDouble();

        String accountNumber = UUID.randomUUID().toString();
        BankAccount newAccount = new BankAccount(accountNumber, username, balance);
        accounts.add(newAccount);

        System.out.println("Account added successfully.");
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("\nAccounts List:");
        int i = 1;
        for (BankAccount account : accounts) {
            System.out.println(i + ". " + account.username + " - Balance: " + account.balance);
            i++;
        }
    }

    public void searchAccount() {
        System.out.print("Enter username to search: ");
        String username = scanner.nextLine();

        BankAccount account = findAccount(username);

        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.println("Account found:");
            System.out.println(account);
        }
    }

    // ================= TASK 2 =================
    public void depositMoney() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        BankAccount account = findAccount(username);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter deposit amount: ");
        double amount = readDouble();

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        account.balance += amount;
        history.push("Deposit " + amount + " to " + username);

        System.out.println("Money deposited successfully.");
        System.out.println("New balance: " + account.balance);
    }

    public void withdrawMoney() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        BankAccount account = findAccount(username);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter withdraw amount: ");
        double amount = readDouble();

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        if (account.balance >= amount) {
            account.balance -= amount;
            history.push("Withdraw " + amount + " from " + username);

            System.out.println("Money withdrawn successfully.");
            System.out.println("New balance: " + account.balance);
        } else {
            System.out.println("Not enough money.");
        }
    }

    // ================= TASK 3 =================
    public void showLastTransaction() {
        if (history.isEmpty()) {
            System.out.println("Transaction history is empty.");
        } else {
            System.out.println("Last transaction: " + history.peek());
        }
    }

    public void undoLastTransaction() {
        if (history.isEmpty()) {
            System.out.println("No transaction to undo.");
        } else {
            String removed = history.pop();
            System.out.println("Undo -> " + removed + " removed");
        }
    }

    // ================= TASK 4 =================
    public void addBillPayment() {
        System.out.print("Enter bill name: ");
        String bill = scanner.nextLine();

        billQueue.add(bill);
        history.push("Bill payment added: " + bill);

        System.out.println("Added: " + bill);
    }

    public void processNextBill() {
        if (billQueue.isEmpty()) {
            System.out.println("Bill queue is empty.");
        } else {
            String bill = billQueue.poll();
            history.push("Bill processed: " + bill);
            System.out.println("Processing: " + bill);
        }
    }

    public void displayBillQueue() {
        if (billQueue.isEmpty()) {
            System.out.println("Bill queue is empty.");
            return;
        }

        System.out.println("Bill Queue:");
        for (String bill : billQueue) {
            System.out.println("- " + bill);
        }
    }

    // ================= TASK 5 =================
    public void submitAccountRequest() {
        System.out.print("Enter username for request: ");
        String username = scanner.nextLine();

        System.out.print("Enter starting balance: ");
        double balance = readDouble();

        BankAccount requestAccount = new BankAccount("REQ", username, balance);
        accountRequests.add(requestAccount);

        System.out.println("Account opening request submitted.");
    }

    public void processNextRequest() {
        if (accountRequests.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        BankAccount request = accountRequests.poll();
        request.accountNumber = UUID.randomUUID().toString();
        accounts.add(request);

        System.out.println("Account request approved for: " + request.username);
    }

    public void displayPendingRequests() {
        if (accountRequests.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        System.out.println("Pending Requests:");
        for (BankAccount request : accountRequests) {
            System.out.println("Username: " + request.username + ", Balance: " + request.balance);
        }
    }

    // ================= TASK 6 =================
    public void showArrayAccounts() {
        System.out.println("\nPhysical Data Structure - Array Accounts:");
        for (int i = 0; i < fixedAccounts.length; i++) {
            System.out.println((i + 1) + ". " + fixedAccounts[i]);
        }
    }

    // ================= ATM =================
    public void checkBalance() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        BankAccount account = findAccount(username);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Balance: " + account.balance);
    }

    public void atmWithdraw() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        BankAccount account = findAccount(username);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = readDouble();

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        if (account.balance >= amount) {
            account.balance -= amount;
            history.push("ATM withdraw " + amount + " from " + username);
            System.out.println("Done. New balance: " + account.balance);
        } else {
            System.out.println("Not enough money.");
        }
    }

    // ================= HELPER METHODS =================
    public BankAccount findAccount(String username) {
        for (BankAccount account : accounts) {
            if (account.username.equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }

    public int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number.");
            scanner.nextLine();
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine();
        }

        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}