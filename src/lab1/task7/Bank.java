package lab1.task7;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final String name;
    private final Map<String, Double> exchangeRates;

    public Bank(String name) {
        this.name = name;
        this.exchangeRates = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, Double> getExchangeRates() {
        return exchangeRates;
    }

    public void addExchangeRate(String currency, double rate) {
        if (rate <= 0) {
            throw new IllegalArgumentException("Exchange rate must be positive.");
        }
        exchangeRates.put(currency, rate);
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return amount;
        }

        Double fromRate = exchangeRates.get(fromCurrency);
        Double toRate = exchangeRates.get(toCurrency);

        if (fromRate == null || toRate == null) {
            throw new IllegalArgumentException("Exchange rate not found for one of the currencies");
        }

        return amount * (toRate / fromRate);
    }
}