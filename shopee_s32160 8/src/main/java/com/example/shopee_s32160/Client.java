public class Client {
    private String name;
    private double balance;

    public Client(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public boolean canAfford(double amount) {
        return balance >= amount;
    }

    public void deductBalance(double amount) {
        if (canAfford(amount)) {
            balance -= amount;
        } else {
            System.out.println("Niewystarczające środki.");
        }
    }
}
