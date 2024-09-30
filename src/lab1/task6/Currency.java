package lab1.task6;

public class Currency {
    private final String name;
    private final double toUAHRate;

    public Currency(String name, double toUAHRate) {
        this.name = name;
        this.toUAHRate = toUAHRate;
    }

    public String getName() {
        return name;
    }

    public double getToUAHRate() {
        return toUAHRate;
    }

    public double convertToUAH(double amount) {
        return amount * toUAHRate;
    }

    public double convertFromUAH(double amountInUAH) {
        return amountInUAH / toUAHRate;
    }
}