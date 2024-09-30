package lab1.task4;

public class SymbolClass {
    private final char character;
    private final int count;

    public SymbolClass(char character, int count) {
        this.character = character;
        this.count = count;
    }

    public char getCharacter() {
        return character;
    }

    public int getCount() {
        return count;
    }
}