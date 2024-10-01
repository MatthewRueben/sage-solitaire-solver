
/**
 * Playing card.
 *
 * @author Matt Rueben
 * @version Jul 23, 2023
 */
public class PlayingCard
{
    // Things that define standard playing cards.
    public static String[] SUITS = {"S", "C", "H", "D"}; // spades, clubs, hearts, diamonds.
    public static int[] RANKS = {1,2,3,4,5,6,7,8,9,10,11,12,13};  // ace = 1, jack = 11, queen = 12, king = 13.
    public static int NUM_CARDS_IN_DECK = SUITS.length * RANKS.length;  // 52.  
    
    private int rank;
    private String suit;

    public PlayingCard(int rank, String suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString()
    {
        return rank + suit;
    }

    // Tests constructor and printing.
    public static void main(String[] args)
    {
        PlayingCard myCard = new PlayingCard(12, "S");
        System.out.println(myCard);
    }

}
