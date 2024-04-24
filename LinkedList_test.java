import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedList_test {

    LinkedList list = new LinkedList();
    Node head = list.getNode(0);


    @Test
    public void insertion() {
        // We assume a dummy node for every list formed
        assertEquals(1, list.lengthOfNode(head));
        list.add(new Card(1, 2));
        assertEquals(2, list.lengthOfNode(head));
    }

    @Test
    public void deletion() {
        assertEquals(1, list.lengthOfNode(head));
        list.add(new Card(1, 2));
        assertEquals(2, list.lengthOfNode(head));
        list.deleteNode(2);
        assertEquals(1, list.lengthOfNode(head));
    }
}
