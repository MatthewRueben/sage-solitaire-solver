
/**
 * Playing card.
 *
 * @author Matt Rueben
 * @version Jul 23, 2023
 */
public class PlayingCard
{
    public enum Rank
    {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE;

        boolean follows(Rank otherRank)
        {
            if (this.ordinal() > otherRank.ordinal()
                    && this.ordinal() - otherRank.ordinal() == 1)
                    return true;
            else if (this == ONE && otherRank == ACE) return true;
            else return false;
        }
    }

    public enum Suit
    {
        SPADES,
        CLUBS,
        HEARTS,
        DIAMONDS;
    }

    // Things that define standard playing cards.
    //public static String[] SUITS = {"S", "C", "H", "D"}; // spades, clubs, hearts, diamonds.
    //public static int[] RANKS = {1,2,3,4,5,6,7,8,9,10,11,12,13};  // ace = 1, jack = 11, queen = 12, king = 13.
    //public static int NUM_CARDS_IN_DECK = SUITS.length * RANKS.length;  // 52.
    
    private Rank rank;
    private Suit suit;

    public PlayingCard(Rank rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() { return rank + " of " + suit; }

    // Tests constructor and printing.
    public static void main(String[] args)
    {
        PlayingCard myCard = new PlayingCard(Rank.ACE, Suit.SPADES);
        System.out.println(myCard);
    }

}
