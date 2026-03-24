import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnoGame extends CardGame<UnoPlayer, UnoDeck> {
    private final List<UnoCard> discardPile = new ArrayList<>();
    //private final Scanner scanner = new Scanner(System.in); 

    @Override
    protected UnoDeck createDeck() {
        return new UnoDeck();
    }

    @Override
    protected UnoPlayer createAIPlayer(int index) {
        return new UnoAIPlayer("AI " + index,deck,discardPile);
    }

    @Override
    protected UnoPlayer createHumanPlayer(String name) {
        return new UnoHumanPlayer(name, new Scanner(System.in),deck,discardPile);
    }

    @Override
    protected int getInitialCardCount() {
        return 5;
    }

    @Override
    protected void playRounds() {
        discardPile.add(deck.drawCard());
        int turn = 0;
        while (true) {
            UnoPlayer currentPlayer = players.get(turn);
            System.out.println("Top card: " + discardPile.get(discardPile.size() - 1));
            UnoCard playedCard = currentPlayer.playTurn(discardPile.get(discardPile.size() - 1));

            if (playedCard != null) {
                discardPile.add(playedCard);
                System.out.println(currentPlayer.getName() + " played: " + playedCard);
            }else {
                System.out.println(currentPlayer.getName() + " has drawn a card.");
            }

            if (currentPlayer.hasWon()) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            turn = (turn + 1) % players.size();
        }
    }

    @Override
    protected void determineWinner() {
        System.out.println("Uno game ends when a player wins!");
    }


    // 主方法，啟動遊戲
    public static void main(String[] args) {
        // 創建 UNOGame 實例並開始遊戲
        UnoGame game = new UnoGame();
        game.start();  // 使用 CardGame 的 start 方法開始遊戲
    }
}