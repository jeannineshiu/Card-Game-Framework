
import java.util.*;
public class PokerAIPlayer extends Player<PokerCard> {

    private Random random = new Random();

    public PokerAIPlayer(String name){
        super(name);
    } 

    @Override
    public PokerCard chooseCard(){
        return hand.remove(random.nextInt(hand.size()));
    }
    
}
