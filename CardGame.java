import java.util.*;

@SuppressWarnings("rawtypes")
abstract class CardGame<P extends Player, D extends Deck> {
    protected List<P> players = new ArrayList<>();
    protected D deck;
    protected Scanner scanner = new Scanner(System.in); // 單一的 Scanner 實例

    public void start() {
        deck = createDeck();
        setupPlayers();
        dealCards();
        playRounds();
        determineWinner();
    }

    protected void setupPlayers() {
        for (int i = 1; i <= 4; i++) {
            System.out.print("Enter name for Player " + i + " (or 'AI' for computer): ");
            String name = scanner.nextLine();
            players.add(name.equalsIgnoreCase("AI") ? createAIPlayer(i) : createHumanPlayer(name));
        }
    }

    @SuppressWarnings("unchecked")
    protected void dealCards() {
        int cardsPerPlayer = getInitialCardCount();
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (P player : players) {
                player.receiveCard(deck.drawCard());
            }
        }
    }

    protected abstract void playRounds();
    protected abstract void determineWinner();
    protected abstract D createDeck();
    protected abstract P createAIPlayer(int index);
    protected abstract P createHumanPlayer(String name);
    protected abstract int getInitialCardCount();
}