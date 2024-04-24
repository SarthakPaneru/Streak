import java.util.Random;

public class Card {

    // Instance variable rank and stack
    private int rank;
    private int suit;

    // Our rank is going to be one of the set of values that we can define as an array..
    private static final String [] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    // Define an array containing the values for the various suits.
    private Suits SUITS;
    private Random GENERATOR = new Random();

    // Default constructor
    public Card() {
        // Generate values for ranks and suits in our construction
        // We can use nextInt() method of our random number generator to request a rank value in the range from 0 to 12
        rank = GENERATOR.nextInt(RANKS.length);
        suit = GENERATOR.nextInt(SUITS.values().length);// to request values from 0 to 3

    }

    // Parameterized constructor
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Getter for rank
    public int getRank() {
        return rank;
    }

    // setter for rank
    public void setRank(int rank) {
        this.rank = rank;
    }

    // Returns the index of RANK in array
    public int getRankPosition(Card card) {
        int position = 0;
        String str = card.toString();
        char ch = str.charAt(0);

        for (int i=0; i<RANKS.length; i++) {
            if (ch == RANKS[i].charAt(0)) {
                position = i;
                break;
            }
        }
        return position;
    }

    // getter for suit
    public int getSuit(Card card) {
        return card.suit;
    }

    // setter for suit
    public void setSuit(int suit) {
        this.suit = suit;
    }




    //define toString() as being a method which overrides the default
    @Override
    // toString() method to return a String representation of the card
    public String toString() {
            return RANKS[rank] + " of " + SUITS.values()[suit];
    }
}
