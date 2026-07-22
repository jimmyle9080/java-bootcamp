public class SavingsAccount extends Account {
    public SavingsAccount(double initialBalance) {
        super(initialBalance);          // call parent constructor
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}