enum Suit { CLUB, DIAMOND, HEART, SPADE }

class PokerCard extends Card {

    private final int rank;
    private final Suit suit;

    public PokerCard(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() { return rank; }
    public Suit getSuit() { return suit; }

    @Override
    public String toString() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        return ranks[rank - 2] + " of " + suit;
    }
}