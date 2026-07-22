public class Account {
    private double balance;                       // hidden from outside code

    public Account(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative");
        }
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {                        // reject non-positive
            System.out.println(
                    "Deposit rejected: amount must be positive.");
            return;
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {    // non-positive OR insufficient
            System.out.println("Withdrawal rejected.");
            return false;
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {                  // read-only accessor
        return balance;
    }

    // Exercise 3 will override this method
    public String getAccountType() {
        return "Account";
    }
}