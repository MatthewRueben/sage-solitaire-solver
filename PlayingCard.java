
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
        TWO
        {
            @Override
            public Rank previous()
            {
                return ACE; // TWO is preceded by ACE.
            }
        },
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
        ACE
        {
            @Override
            public Rank next()
            {
                return TWO; // ACE is followed by TWO.
            }
        };

        private static final Rank[] RANKS = values();

        Rank previous()
        {
            return RANKS[this.ordinal() - 1]; // See override for TWO.
        }

        Rank next()
        {
            return RANKS[this.ordinal() + 1]; // See override for ACE.
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
