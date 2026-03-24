import java.util.Objects;

public class UnoCard extends Card {
    enum Color { RED, BLUE, GREEN, YELLOW }

    private final Color color;
    private final int number;

    public UnoCard(Color color, int number) {
        this.color = color;
        this.number = number;
    }

    public Color getColor() { return color; }
    public int getNumber() { return number; }

    @Override
    public String toString() {
        return color + " " + number;
    }

    public boolean matches(UnoCard other) {
        return this.color == other.color || this.number == other.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UnoCard)) return false;
        UnoCard card = (UnoCard) o;
        return number == card.number && color == card.color;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(color, number);
    }
}

