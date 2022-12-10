public class Deck {
    private static final int TOTALCARD = 52;
    private int remainingCard = TOTALCARD;
    private static final Card [] DECK = new Card[TOTALCARD];

    public Deck() {
        for(int thisCard = 0; thisCard<TOTALCARD; thisCard++) {
            this.DECK[thisCard] = new Card(thisCard % 13, thisCard / 13);
        }
    }

    public int showAllCardsInDeck() {
        int cards = 0;
        for(int i = 0; i<TOTALCARD; i++) {
            System.out.println(DECK[i]);
            cards++;
        }
        return cards;
    }

    public Card getCardInDeck(int index) {
//        for (int i=0; i<TOTALCARD; i++) {
//            return
//        }
        return DECK[index];
    }

    public void shuffle() {
        for (int i=0; i<TOTALCARD; i++) {
            // Math.random() fives value between 0 and 1.
            // So we get all value when multiplied with deck length
            int index = (int) (Math.random() * DECK.length);
            Card temp = DECK[index];
            this.DECK[index] = this.DECK[i];
            this.DECK[i] = temp;
        }
    }

//    public Card [] insertionSort(Card [] cards) {
//        int n = cards.length;
//
//        Card check = new Card();
//
//        for (int i=2; i<n; i++) {
//            Card card = cards[i];
//            int j = i-1;
//
//            while (j>0 && check.getRankPosition(cards[i]) > check.getRankPosition(card)) {
//                cards[j+1] = cards[j];
//                j = j-1;
//            }
//            cards[j+1] = card;
//        }
//
//    }

}
