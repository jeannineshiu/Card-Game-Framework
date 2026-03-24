import java.util.List;
import java.util.Scanner;

public class UnoHumanPlayer extends UnoPlayer{

    private final Scanner scanner;  // 將 Scanner 設為類別層級的變數
    

    public UnoHumanPlayer(String name, Scanner scanner,UnoDeck deck, List<UnoCard> discardPile) {
        super(name, deck, discardPile);
        this.scanner = scanner;  // 接受外部傳入的 scanner 實例
    }

    @Override
    protected UnoCard chooseCard(List<UnoCard> hand,UnoCard topCard) {
        System.out.println("Hand cards: " + hand);
        System.out.println("Choose a card to play (index): ");

        while (true) {
            // 檢查是否有有效的整數輸入
            if (scanner.hasNextInt()) {
                try {
                    int choice = scanner.nextInt();
                    if (choice >= 0 && choice < hand.size()) {
                        UnoCard chosenCard = hand.get(choice);
                        if (chosenCard.matches(topCard))
                        {
                            hand.remove(chosenCard);
                            return chosenCard;
                        }else {
                            System.out.println("Invalid card. Please choose again.");
                        }

                    } else {
                        System.out.println("Invalid index. Please choose a valid index.");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // 清除錯誤的輸入
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // 清除錯誤的輸入
            }
        }
    }

    @Override
    public UnoCard chooseCard() {
        return playTurn(discardPile.get(discardPile.size() - 1));
    }
}
