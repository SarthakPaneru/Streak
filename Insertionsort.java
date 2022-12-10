public class Insertionsort {
    public Card[] insertionSort(Card[] cards) {
        int n = cards.length;
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
