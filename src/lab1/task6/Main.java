package lab1.task6;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("Enter conversion: ");
        final String input = scanner.nextLine();

        try {
            final double result = converter.convertCurrency(input);
            System.out.println("Converted amount: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}