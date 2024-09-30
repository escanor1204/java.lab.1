package lab1.task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        SymbolClass[] counts = getCharacterCounts(input);

        for (SymbolClass charCount : counts) {
            System.out.println("Character: '" + charCount.getCharacter() + "', Count: " + charCount.getCount());
        }
    }

    private static SymbolClass[] getCharacterCounts(final String input) {
        final int ASCII_SIZE = 128;
        int[] frequency = new int[ASCII_SIZE];

        for (char c : input.toCharArray()) {
            frequency[c]++;
        }

        SymbolClass[] tempCounts = new SymbolClass[ASCII_SIZE];
        int count = 0;

        for (int i = 0; i < ASCII_SIZE; i++) {
            if (frequency[i] > 0) {
                tempCounts[count++] = new SymbolClass((char) i, frequency[i]);
            }
        }

        SymbolClass[] result = new SymbolClass[count];

        System.arraycopy(tempCounts, 0, result, 0, count);

        return result;
    }

}