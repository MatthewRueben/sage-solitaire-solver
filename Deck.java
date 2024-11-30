import java.util.Stack;
import java.util.Random;

/**
 * Standard deck of cards. 
 * It's a Stack, but with one of each card 
 * and shuffling and dealing.
 *
 * @author Matt Rueben
 */
public class Deck extends Stack<PlayingCard>
{
    private Deck() { super(); } // Private so people don't use expecting a full deck.

    public static Deck getNewUnshuffledDeck()
    {
        Deck deck = new Deck();
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            for (PlayingCard.Rank rank : PlayingCard.Rank.values()) {
                deck.push(new PlayingCard(rank, suit));
            }
        }
        return deck;
    }

    private static Random random;
    public Deck shuffle()
    {
        Deck shuffled = new Deck();

        if (random == null) random = new Random();
        while (!this.isEmpty()) {
            PlayingCard randomCard = this.remove(random.nextInt(this.size()));
            shuffled.push(randomCard);
        }
        return shuffled;
    }

    public PlayingCard dealCard() {  // renames pop() to dealCard()
        return this.pop();
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

    // Tests shuffling.
    public static void main(String[] args) {
        Deck deck = getNewUnshuffledDeck().shuffle();
        System.out.println(deck.size());
        while (!deck.empty()) {System.out.println(deck.pop());}
    }
}
