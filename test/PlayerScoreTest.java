import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerScoreTest {

    @Test
    public void testScore() {
        // Initialize 3 list
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList list3 = new LinkedList();

        // Add test values to list
        list1.add(new Card(3, 1));
        list1.add(new Card(4, 3));
        list1.add(new Card(5, 3));
        list1.add(new Card(7, 0));
        list1.add(new Card(8, 0));

        list2.add(new Card(5, 2));
        list2.add(new Card(8, 1));
        list2.add(new Card(9, 3));
        list2.add(new Card(10, 1));
        list2.add(new Card(12, 2));

        list3.add(new Card(3, 2));
        list3.add(new Card(8, 1));
        list3.add(new Card(9, 1));
        list3.add(new Card(10, 1));
        list3.add(new Card(12, 2));

        // Creating new instance of Player class
        Player player = new Player();

        // Calculate score and check with our expected output
        player.calculateScore(list1);
        assertEquals(4, player.getScore());

        player.calculateScore(list2);
        assertEquals(4, player.getScore());

        player.calculateScore(list3);
        assertEquals(5, player.getScore());

    }
}
