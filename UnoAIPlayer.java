import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UnoAIPlayer extends UnoPlayer {
    private final Random random = new Random();

    public UnoAIPlayer(String name, UnoDeck deck, List<UnoCard> discardPile) {
        super(name, deck, discardPile);
    }

    @Override
    protected UnoCard chooseCard(List<UnoCard> hand,UnoCard topCard) {
        List<UnoCard> validCards = new ArrayList<>();

        for (UnoCard card : hand) {
            if (card.matches(topCard)) {
                validCards.add(card);
            }
        }

        int choice = random.nextInt(validCards.size());
        UnoCard chosenCard = validCards.get(choice);
        hand.remove(chosenCard);
        return chosenCard;
    }

    // AI 回合的整體流程（chooseCard()) ,對外提供的接口，啟動AI的回合
    // 確保 UNOAIPlayer 符合 Player 抽象類別的要求
    @Override
    public UnoCard chooseCard() {
        return playTurn(discardPile.get(discardPile.size() - 1));
    }
}