import java.util.Stack;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Standard deck of cards. 
 * It's a Stack, but with one of each card 
 * and the option to start out shuffled.
 *
 * @author Matt Rueben
 * @version Jul 23, 2023
 */
public class DeckOfCards extends Stack<PlayingCard>
{
    public static final int ORDERED = 1;
    public static final int SHUFFLED = 2;
    
    public DeckOfCards()
    {
        generateShuffledDeck();
    }
    
    public DeckOfCards(int requestedOrder)
    {
        if (requestedOrder == ORDERED) generateOrderedDeck(); 
        else if (requestedOrder == SHUFFLED) generateShuffledDeck();
    }
    
    public PlayingCard dealCard() {  // renames pop() to dealCard()
        return this.pop();
    }
    
    private void generateOrderedDeck()
    {
        for (String suit : PlayingCard.SUITS) {
            for (int rank : PlayingCard.RANKS) {
                this.push(new PlayingCard(rank, suit));
            }
        }
    }
    private static Random random;

    private void generateShuffledDeck()
    {
        ArrayList<PlayingCard> cardList = new ArrayList<PlayingCard>(PlayingCard.NUM_CARDS_IN_DECK);
        for (String suit : PlayingCard.SUITS) {
            for (int rank : PlayingCard.RANKS) {
                cardList.add(new PlayingCard(rank, suit));
            }
        }
        
        if (random == null) random = new Random();
        
        // randomly draw from ordered cards to build a shuffled deck.
        int randomIndex;
        PlayingCard randomCard;
        while (!cardList.isEmpty()) {
            randomIndex = random.nextInt(cardList.size());
            randomCard = cardList.remove(randomIndex);
            this.push(randomCard); 
        }
    }
    
    private Stack<PlayingCard> targetPile;
    private int numberOfCardsToDeal;
    
    public void selectPile(Stack<PlayingCard> pile) {
        this.targetPile = pile;
    }
        
    public void setNumberOfCardsToDeal(int numberOfCardsToDeal) {
        this.numberOfCardsToDeal = numberOfCardsToDeal;
    }
    
    public void dealPile() {
        PlayingCard currentCard;
        for (int i = 0; i < this.numberOfCardsToDeal; i++) {  
            currentCard = this.pop();  // take next card from top of deck ... 
            this.targetPile.push(currentCard);  // ... and put it on top of pile.
        }
    }
    
    // Tests generateShuffledDeck().
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        while (!deck.empty()) {System.out.println(deck.pop());}
    }
}
