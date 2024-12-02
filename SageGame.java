import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

/**
 * @author Matt Rueben
 */
public class SageGame
{
    private final int TOP_ROW = 0;
    private final int MIDDLE_ROW = 1;
    private final int BOTTOM_ROW = 2;

    private final int LEFT_COLUMN = 0;
    private final int MIDDLE_COLUMN = 1;
    private final int RIGHT_COLUMN = 2;

    public class SageBoard
    {
        private List<List<Stack<PlayingCard>>> pileGrid;
        private PlayingCard trumpCard;
        private int numOfTrashes = 2;

        public void dealCards(Deck deck)
        {
            this.pileGrid = new ArrayList<List<Stack<PlayingCard>>>();

            this.pileGrid.add(new ArrayList<Stack<PlayingCard>>(3));  // TOP_ROW
            // // // // // // //
            this.pileGrid.get(TOP_ROW).add(new Stack<PlayingCard>());  // LEFT_COLUMN
            deck.selectPile(this.pileGrid.get(TOP_ROW).get(LEFT_COLUMN));
            deck.setNumberOfCardsToDeal(8);
            deck.dealPile();
            // // // // // // //
            this.pileGrid.get(TOP_ROW).add(new Stack<PlayingCard>());  // MIDDLE_COLUMN
            deck.selectPile(this.pileGrid.get(TOP_ROW).get(MIDDLE_COLUMN));
            deck.setNumberOfCardsToDeal(8);
            deck.dealPile();
            // // // // // // //
            this.pileGrid.get(TOP_ROW).add(new Stack<PlayingCard>());  // RIGHT_COLUMN
            deck.selectPile(this.pileGrid.get(TOP_ROW).get(RIGHT_COLUMN));
            deck.setNumberOfCardsToDeal(8);
            deck.dealPile();

            this.pileGrid.add(new ArrayList<Stack<PlayingCard>>(3));  // MIDDLE_ROW
            // // // // // // //
            this.pileGrid.get(MIDDLE_ROW).add(new Stack<PlayingCard>());  // LEFT_COLUMN
            deck.selectPile(this.pileGrid.get(MIDDLE_ROW).get(LEFT_COLUMN));
            deck.setNumberOfCardsToDeal(7);
            deck.dealPile();
            // // // // // // //
            this.pileGrid.get(MIDDLE_ROW).add(new Stack<PlayingCard>());  // MIDDLE_COLUMN
            deck.selectPile(this.pileGrid.get(MIDDLE_ROW).get(MIDDLE_COLUMN));
            deck.setNumberOfCardsToDeal(6);
            deck.dealPile();
            // // // // // // //
            this.pileGrid.get(MIDDLE_ROW).add(new Stack<PlayingCard>());  // RIGHT_COLUMN
            deck.selectPile(this.pileGrid.get(MIDDLE_ROW).get(RIGHT_COLUMN));
            deck.setNumberOfCardsToDeal(5);
            deck.dealPile();

            this.pileGrid.add(new ArrayList<Stack<PlayingCard>>(3));  // BOTTOM_ROW
            // // // // // // //
            this.pileGrid.get(BOTTOM_ROW).add(new Stack<PlayingCard>());  // LEFT_COLUMN
            deck.selectPile(this.pileGrid.get(BOTTOM_ROW).get(LEFT_COLUMN));
            deck.setNumberOfCardsToDeal(4);
            deck.dealPile();
            // // // // // // //
            this.pileGrid.get(BOTTOM_ROW).add(new Stack<PlayingCard>());  // MIDDLE_COLUMN
            deck.selectPile(this.pileGrid.get(BOTTOM_ROW).get(MIDDLE_COLUMN));
            deck.setNumberOfCardsToDeal(3);
            deck.dealPile();
            // // // // // // //
            this.pileGrid.get(BOTTOM_ROW).add(new Stack<PlayingCard>());  // RIGHT_COLUMN
            deck.selectPile(this.pileGrid.get(BOTTOM_ROW).get(RIGHT_COLUMN));
            deck.setNumberOfCardsToDeal(2);
            deck.dealPile();

            this.trumpCard = deck.dealCard();
        }
    }

    private final SageBoard board = new SageBoard();

    public SageGame()
    {
        Deck deck = Deck.getNewUnshuffledDeck().shuffle();
        this.board.dealCards(deck);
    }
    
    //private void dealPile(int numCardsInPile) {
    //    
    //}

    public class Visualizer
    {

    }

}
