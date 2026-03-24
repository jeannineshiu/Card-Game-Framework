import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokerGame extends CardGame<Player<PokerCard>, PokerDeck> {

    private final Scanner scanner = new Scanner(System.in); // 確保 Scanner 由遊戲統一管理

    @Override
    protected PokerDeck createDeck() {
        return new PokerDeck();
    }

    @Override
    protected Player<PokerCard> createAIPlayer(int index) {
        return new PokerAIPlayer("AI " + index);
    }

    @Override
    protected Player<PokerCard> createHumanPlayer(String name) {
        return new PokerHumanPlayer(name,scanner);
    }

    @Override
    protected int getInitialCardCount() {
        return 13;
    }

    @Override
    protected void playRounds() {
        for (int round = 1; round <= 13; round++) {
            System.out.println("\nRound " + round);
            List<PokerCard> playedCards = new ArrayList<>();
            Player<PokerCard> roundWinner = null;
            PokerCard highestCard = null;

            for (Player<PokerCard> player : players) {  // 泛型類型匹配
                PokerCard playedCard = player.chooseCard();
                System.out.println(player.getName() + " plays: " + playedCard);
                playedCards.add(playedCard);

                if (highestCard == null || 
                    playedCard.getRank() > highestCard.getRank() || 
                    (playedCard.getRank() == highestCard.getRank() && playedCard.getSuit().ordinal() > highestCard.getSuit().ordinal())) {
                    highestCard = playedCard;
                    roundWinner = player;
                }
            }

            if (roundWinner != null) {
                roundWinner.addPoint();
                System.out.println(roundWinner.getName() + " wins this round!");
            }
        }
    }

    @Override
    protected void determineWinner() {
        Player<PokerCard> winner = players.get(0);
        for (Player<PokerCard> player : players) {
            if (player.getPoints() > winner.getPoints()) {
                winner = player;
            }
        }
        System.out.println("\nGame Over! The winner is " + winner.getName() + " with " + winner.getPoints() + " points!");
    }

    public static void main(String[] args) {
        PokerGame game = new PokerGame();
        game.start();
    }
}