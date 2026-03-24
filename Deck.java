import java.util.*;
public abstract class Deck <T extends Card> {
    protected List<T> cards;
    protected Random random = new Random();
    
    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }
    
    protected abstract void initializeDeck(); // 讓子類別決定如何初始化
    
    public void shuffle() {
        Collections.shuffle(cards, random);
    }
    
    public T drawCard() {
        return cards.isEmpty() ? null : cards.remove(0);
    }
    
    public boolean isEmpty() {
        return cards.isEmpty();
    }
    
    public void addCards(List<T> newCards) {
        cards.addAll(newCards);
        shuffle();
    }
}