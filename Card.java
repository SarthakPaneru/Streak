import java.util.Random;

public class Card {

    private int rank;
    private int suit;

    private static final String [] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private Suits SUITS;
    private Random GENERATOR = new Random();

    public Card() {
        // Generate values for ranks and suits in our construction
        // We can use nextInt() method of our random number generator to request a rank value in the range from 0 to 12
        rank = GENERATOR.nextInt(RANKS.length);
        suit = GENERATOR.nextInt(SUITS.values().length);// to request values from 0 to 3

    }
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

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

    public int getSuit(Card card) {
        return card.suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }





    @Override
    public String toString() {
            return RANKS[rank] + " of " + SUITS.values()[suit];
    }
}
