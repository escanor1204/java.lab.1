
package lab1.task6;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private final Map<String, Currency> currencies = new HashMap<>();

    public CurrencyConverter() {
        currencies.put("UAH", new Currency("UAH", 1.0));
        currencies.put("USD", new Currency("USD", 41.3));

    }

    public double convertCurrency(final String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Invalid input format.");
        }

        String[] parts = input.split(" ");
        if (parts.length != 4 || !parts[2].equalsIgnoreCase("into")) {
            throw new IllegalArgumentException("Invalid format. Use format '100 UAH into USD'.");
        }

        final double amount;
        try {
            amount = Double.parseDouble(parts[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The first part must be a number.");
        }

        final String fromCurrencyString = parts[1].toUpperCase();
        final String toCurrencyCodeString = parts[3].toUpperCase();

        Currency fromCurrency = currencies.get(fromCurrencyString);
        Currency toCurrency = currencies.get(toCurrencyCodeString);

        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Unknown currency: " + fromCurrencyString + " or " + toCurrencyCodeString);
        }

        final double amountInUAH = fromCurrency.convertToUAH(amount);
        return toCurrency.convertFromUAH(amountInUAH);
    }

}
