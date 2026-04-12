import java.sql.SQLOutput;
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static class BankAccount {
        String accountNumber;
        String username;
        double balance;

        public BankAccount(String accountNumber, String username, double balance) {
            this.accountNumber = accountNumber;
            this.username = username;
            this.balance = balance;
        }
    }

    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Stack<String> history = new Stack<>();
    static Queue<String> bills = new LinkedList<>();
    static Queue<BankAccount> requests = new LinkedList<>();

    public static void main(String[] args) {

        // demo accounts
        accounts.add(new BankAccount("1", "Ali", 150000));
        accounts.add(new BankAccount("2", "Sara", 220000));

        mainMenu();
    }

    // ================= MAIN MENU =================
    static void mainMenu() {
        while (true) {
            System.out.println("\n1 – Bank\n2 – ATM\n3 – Admin\n4 – Exit");
            System.out.println("Enter your choice: ");
            int c = scanner.nextInt(); scanner.nextLine();

            if (c == 1) bankMenu();
            else if (c == 2) atmMenu();
            else if (c == 3) adminMenu();
            else break;
        }
    }

    // ================= BANK =================
    static void bankMenu() {
        while (true) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1 Add account");
            System.out.println("2 Deposit / Withdraw");
            System.out.println("3 Submit account request");
            System.out.println("4 Manage bills");
            System.out.println("5 View transactions");
            System.out.println("6 Back");
            System.out.println("Enter your choice: ");


            int c = scanner.nextInt(); scanner.nextLine();

            if (c == 1) addAccount();
            else if (c == 2) depositWithdraw();
            else if (c == 3) submitRequest();
            else if (c == 4) manageBills();
            else if (c == 5) showHistory();
            else break;
        }
    }

    static void addAccount() {
        System.out.print("Username: ");
        String u = scanner.nextLine();

        System.out.print("Balance: ");
        double b = scanner.nextDouble(); scanner.nextLine();

        accounts.add(new BankAccount(UUID.randomUUID().toString(), u, b));
        System.out.println("Account added");
    }

    static void depositWithdraw() {
        System.out.print("Username: ");
        String u = scanner.nextLine();
        BankAccount acc = find(u);

        if (acc == null) return;

        System.out.println("1 Deposit  2 Withdraw");
        int c = scanner.nextInt();

        System.out.print("Amount: ");
        double a = scanner.nextDouble(); scanner.nextLine();

        if (c == 1) {
            acc.balance += a;
            history.push("Deposit " + a + " to " + u);
        } else {
            if (acc.balance >= a) {
                acc.balance -= a;
                history.push("Withdraw " + a + " from " + u);
            } else {
                System.out.println("Not enough money");
            }
        }

        System.out.println("Balance: " + acc.balance);
    }

    static void submitRequest() {
        System.out.print("Username: ");
        String u = scanner.nextLine();

        System.out.print("Balance: ");
        double b = scanner.nextDouble(); scanner.nextLine();

        requests.add(new BankAccount("REQ", u, b));
        System.out.println("Request submitted");
    }

    static void manageBills() {
        System.out.println("1 Add bill  2 Process bill");
        int c = scanner.nextInt(); scanner.nextLine();

        if (c == 1) {
            System.out.print("Bill name: ");
            String bill = scanner.nextLine();
            bills.add(bill);
            history.push("Bill: " + bill);
        } else {
            if (!bills.isEmpty()) {
                System.out.println("Processing: " + bills.poll());
            }
        }
    }

    static void showHistory() {
        if (!history.isEmpty())
            System.out.println("Last: " + history.peek());
    }

    // ================= ATM =================
    static void atmMenu() {
        System.out.println("\n--- ATM ---");
        System.out.println("1 Check balance\n2 Withdraw");
        System.out.println("Enter your choice: ");


        int c = scanner.nextInt(); scanner.nextLine();

        System.out.print("Username: ");
        String u = scanner.nextLine();
        BankAccount acc = find(u);

        if (acc == null) return;

        if (c == 1) {
            System.out.println("Balance: " + acc.balance);
        } else {
            System.out.print("Amount: ");
            double a = scanner.nextDouble();

            if (acc.balance >= a) {
                acc.balance -= a;
                history.push("ATM withdraw " + a);
                System.out.println("Done");
            }
        }
    }

    // ================= ADMIN =================
    static void adminMenu() {
        while (true) {
            System.out.println("\n--- ADMIN ---");
            System.out.println("1 Process account requests");
            System.out.println("2 Process bills");
            System.out.println("3 View accounts");
            System.out.println("4 Back");
            System.out.println("Enter your choice: ");


            int c = scanner.nextInt(); scanner.nextLine();

            if (c == 1) {
                if (!requests.isEmpty()) {
                    accounts.add(requests.poll());
                    System.out.println("Account approved");
                }
            } else if (c == 2) {
                if (!bills.isEmpty()) {
                    System.out.println("Processed: " + bills.poll());
                }
            } else if (c == 3) {
                for (BankAccount a : accounts) {
                    System.out.println(a.username + " - " + a.balance);
                }
            } else break;
        }
    }

    // ================= HELPER =================
    static BankAccount find(String username) {
        for (BankAccount a : accounts) {
            if (a.username.equalsIgnoreCase(username)) return a;
        }
        System.out.println("Not found");
        return null;
    }
}