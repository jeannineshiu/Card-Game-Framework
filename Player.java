import java.util.ArrayList;
import java.util.List;

public abstract class Player<T extends Card> implements PokerPlayer{
    protected String name;
    protected List<T> hand = new ArrayList<>();
    protected int points;


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<T> getHand() {
        return hand;
    }

    public void receiveCard(T card) {
        hand.add(card);
    }

    public abstract T chooseCard();
    
    @Override
    public void addPoint() {
        points++;
    }

    @Override
    public int getPoints() {
        return points;
    }
}