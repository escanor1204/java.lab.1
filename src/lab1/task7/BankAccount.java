package lab1.task7;

public class BankAccount {
    private final String accountNumber;
    private final Bank bank;
    private final String currency;
    private final String owner;
    private double balance;

    public BankAccount(String accountNumber, Bank bank, String currency, String owner, double initialBalance) {
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.currency = currency;
        this.owner = owner;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Bank getBank() {
        return bank;
    }

    public String getCurrency() {
        return currency;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        balance -= amount;
    }

    public void transferTo(BankAccount targetAccount, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive.");
        }

        double commission = calculateCommission(targetAccount);
        double finalAmount = amount - (amount * commission);
        double convertedAmount = bank.convertCurrency(finalAmount, currency, targetAccount.getCurrency());

        withdraw(amount);
        targetAccount.deposit(convertedAmount);

        System.out.println("Transfer completed: " + amount + " " + currency + " -> "
                + convertedAmount + " " + targetAccount.getCurrency()
                + " with a commission of " + (commission * 100) + "%.");
    }

    private double calculateCommission(BankAccount targetAccount) {
        if (owner.equals(targetAccount.getOwner())) {
            if (bank.getName().equals(targetAccount.getBank().getName())) {
                return 0.0;
            } else {
                return 0.02;
            }
        } else {
            if (bank.getName().equals(targetAccount.getBank().getName())) {
                return 0.03;
            } else {
                return 0.06;
            }
        }
    }
}