import org.junit.Test;
import static org.junit.Assert.*;

public class InsertionSortTest {

    @Test
    public void testInsertionSort() {
        Card [] cards = new Card[5];
        Card [] expectedResult = new Card[5];

        cards[0] = new Card(3, 2);
        cards[1] = new Card(2, 1);
        cards[2] = new Card(10, 0);
        cards[3] = new Card(1, 3);
        cards[4] = new Card(8, 2);

        expectedResult[0] = new Card(3, 3);
        expectedResult[1] = new Card(2, 1);
        expectedResult[2] = new Card(3, 2);
        expectedResult[3] = new Card(8, 2);
        expectedResult[4] = new Card(10, 0);

        Insertionsort sort = new Insertionsort();

        cards = sort.insertionSort(cards);

//        assertEquals(expectedResult, cards);

        for(int i=0; i<5; i++) {
            assertEquals(expectedResult[i].toString(), cards[i].toString());
        }


        }
}
