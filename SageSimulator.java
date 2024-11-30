import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * Simulates Sage.
 *
 * @author Matt Rueben
 * @version Jul 23, 2023
 */

public class SageSimulator
{    
    private List<List<Stack<PlayingCard>>> pileGrid = new ArrayList<List<Stack<PlayingCard>>>();
    // ==========================
    private final int TOP_ROW = 0;
    private final int MIDDLE_ROW = 1;
    private final int BOTTOM_ROW = 2;
    // ==========================
    private final int LEFT_COLUMN = 0;
    private final int MIDDLE_COLUMN = 1;
    private final int RIGHT_COLUMN = 2;
    
    private PlayingCard trumpCard;
    
    public SageSimulator()
    {
    }

    private void dealNewGame()
    {
        Deck deck = Deck.getNewUnshuffledDeck().shuffle();

        pileGrid.add(new ArrayList<Stack<PlayingCard>>(3));  // TOP_ROW
        // // // // // // // 
        pileGrid.get(TOP_ROW).add(new Stack<PlayingCard>());  // LEFT_COLUMN
        deck.selectPile(pileGrid.get(TOP_ROW).get(LEFT_COLUMN));
        deck.setNumberOfCardsToDeal(8);
        deck.dealPile(); 
        // // // // // // // 
        pileGrid.get(TOP_ROW).add(new Stack<PlayingCard>());  // MIDDLE_COLUMN
        deck.selectPile(pileGrid.get(TOP_ROW).get(MIDDLE_COLUMN));
        deck.setNumberOfCardsToDeal(8);
        deck.dealPile(); 
        // // // // // // // 
        pileGrid.get(TOP_ROW).add(new Stack<PlayingCard>());  // RIGHT_COLUMN
        deck.selectPile(pileGrid.get(TOP_ROW).get(RIGHT_COLUMN));
        deck.setNumberOfCardsToDeal(8);
        deck.dealPile();
        

        pileGrid.add(new ArrayList<Stack<PlayingCard>>(3));  // MIDDLE_ROW
        // // // // // // // 
        pileGrid.get(MIDDLE_ROW).add(new Stack<PlayingCard>());  // LEFT_COLUMN
        deck.selectPile(pileGrid.get(MIDDLE_ROW).get(LEFT_COLUMN));
        deck.setNumberOfCardsToDeal(7);
        deck.dealPile(); 
        // // // // // // // 
        pileGrid.get(MIDDLE_ROW).add(new Stack<PlayingCard>());  // MIDDLE_COLUMN
        deck.selectPile(pileGrid.get(MIDDLE_ROW).get(MIDDLE_COLUMN));
        deck.setNumberOfCardsToDeal(6);
        deck.dealPile(); 
        // // // // // // // 
        pileGrid.get(MIDDLE_ROW).add(new Stack<PlayingCard>());  // RIGHT_COLUMN
        deck.selectPile(pileGrid.get(MIDDLE_ROW).get(RIGHT_COLUMN));
        deck.setNumberOfCardsToDeal(5);
        deck.dealPile();

        
        pileGrid.add(new ArrayList<Stack<PlayingCard>>(3));  // BOTTOM_ROW
        // // // // // // // 
        pileGrid.get(BOTTOM_ROW).add(new Stack<PlayingCard>());  // LEFT_COLUMN
        deck.selectPile(pileGrid.get(BOTTOM_ROW).get(LEFT_COLUMN));
        deck.setNumberOfCardsToDeal(4);
        deck.dealPile();
        // // // // // // // 
        pileGrid.get(BOTTOM_ROW).add(new Stack<PlayingCard>());  // MIDDLE_COLUMN
        deck.selectPile(pileGrid.get(BOTTOM_ROW).get(MIDDLE_COLUMN));
        deck.setNumberOfCardsToDeal(3);
        deck.dealPile(); 
        // // // // // // // 
        pileGrid.get(BOTTOM_ROW).add(new Stack<PlayingCard>());  // RIGHT_COLUMN
        deck.selectPile(pileGrid.get(BOTTOM_ROW).get(RIGHT_COLUMN));
        deck.setNumberOfCardsToDeal(2);
        deck.dealPile();
        
        
        trumpCard = deck.dealCard(); 
        
        System.out.println(deck.size());  // should be zero (cards left in the deck)! 
    }
    
    // STUFF TO IMPLEMENT:
    // visualize game board.
    // define hands.
    // find all manifest hands.
    // claim a hand.
    // reveal next card.
    // trash a card.
    
    //private void dealPile(int numCardsInPile) {
    //    
    //}
    
    public static void main(String[] args) {
        SageSimulator simulator = new SageSimulator();
        simulator.dealNewGame();
    }
}
