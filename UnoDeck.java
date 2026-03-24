public class UnoDeck extends Deck<UnoCard> {

    @Override
    protected void initializeDeck() {
        for (UnoCard.Color color : UnoCard.Color.values()) {
            for (int num = 0; num <= 9; num++) {
                cards.add(new UnoCard(color, num));
            }
        }
    }
}