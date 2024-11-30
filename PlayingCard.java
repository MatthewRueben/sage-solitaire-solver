
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

    private final Rank rank;
    private final Suit suit;

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
