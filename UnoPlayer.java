import java.util.ArrayList;
import java.util.List;


public abstract class UnoPlayer extends Player<UnoCard> {
    protected UnoDeck deck;
    protected List<UnoCard> discardPile;

    public UnoPlayer(String name, UnoDeck deck, List<UnoCard> discardPile) {
        super(name);
        this.deck = deck;
        this.discardPile = discardPile;
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }

    public UnoCard playTurn(UnoCard topCard) {
        List<UnoCard> validCards = new ArrayList<>();
        for (UnoCard card : hand) {
            if (card.matches(topCard)) {
                validCards.add(card);
            }
        }

        if (validCards.isEmpty()) {
            drawCard();
            return null;
        } else {
            return chooseCard(hand,topCard);
        }
    }

    protected abstract UnoCard chooseCard(List<UnoCard> hand,UnoCard topCard);


    private void drawCard() {
        if (deck.isEmpty() && discardPile.size() > 1) {
            UnoCard lastCard = discardPile.remove(discardPile.size() - 1);
            deck.addCards(discardPile);
            discardPile.clear();
            discardPile.add(lastCard);
        }
        UnoCard card = deck.drawCard();
        if (card != null) hand.add(card);
    }
}