

public class PokerDeck extends Deck<PokerCard>{

    //enum Suit { CLUB, DIAMOND, HEART, SPADE }
    @Override
    protected void initializeDeck() {
        for (int rank = 2; rank <= 14; rank++) {
            for (Suit suit : Suit.values()) {
                cards.add(new PokerCard(rank, suit));
            }
        }
    }
}
