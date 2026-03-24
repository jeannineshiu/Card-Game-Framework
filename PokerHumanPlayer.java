
import java.util.*;
public class PokerHumanPlayer extends Player<PokerCard> {

    private final Scanner scanner;  // 將 Scanner 設為類別層級的變數

    public PokerHumanPlayer(String name, Scanner scanner){
        super(name);
        this.scanner = scanner;
    }

    @Override
    public PokerCard chooseCard() {
        
        while (true) {  // 不斷要求輸入，直到玩家輸入正確的索引
            System.out.println(name + "'s HandCards: " + hand);
            System.out.print("Choose a card: ");

            String input = scanner.nextLine(); // 讀取整行輸入
            try {
                int index = Integer.parseInt(input); // 轉換為數字
                if (index >= 0 && index < hand.size()) {  // 確保索引合法
                    return hand.remove(index);  // 成功選擇後移除並返回該牌
                } else {
                    System.out.println("Invalid index! Please enter a number between 0 and " + (hand.size() - 1) + ".");
                }
            } catch (NumberFormatException e) {  // 處理非數字輸入的錯誤
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
        
    }
    
}
