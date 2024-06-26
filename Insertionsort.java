public class Insertionsort {
    // INSERTION sort to sort the data in any hand of cards
    // Insertion sort is best when sorting a small amount of data and is better than selection sort
    // Returns sorted cards according to their rank
    public Card[] insertionSort(Card[] cards) {
        // length of array
        int n = cards.length;

//      Initialize card and check to perform further opertation
        Card card = new Card();

        Card check = new Card();

        for (int i=1; i<n; i++) {
            card = cards[i];
            int j = i-1;

//            System.out.println(card.getRankPosition(cards[i]));
//            System.out.println(check.getRankPosition(card));

            while (j>=0 && card.getRankPosition(cards[j]) >= check.getRankPosition(card)) {
                cards[j+1] = cards[j];
                j = j-1;
            }
            cards[j+1] = card;
//            System.out.println(card);
        }
        return cards;
    }
}
