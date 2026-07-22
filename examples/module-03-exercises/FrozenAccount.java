public class FrozenAccount extends Account {
    public FrozenAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        return false;                 // refuse every withdrawal, no super call
    }

    @Override
    public String getAccountType() {
        return "Frozen";
    }
}