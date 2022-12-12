import org.junit.Before;
import org.junit.Test;

public class MyTest {
    private static int position = 0;
    private Player [] player = new Player[10];

    public MyTest() {
        for (int i = 0; i<10; i++) {
            player[i] = new Player();
            player[i].setName(Letter.values()[i].toString());
            player[i].setScore((i+5)%2);
            position++;
        }
    }

    public void setPlayer(Player player) {
        this.player[position++] = player;
    }

    public int getPosition() {
        return position;
    }

    public Player getPlayer(int position) {
        return player[position];
    }



    @Before
    public void selectionSort() {
        System.out.println("Selection sort" + position);
        for (int i = 0; i<this.position-1; i++ ) {
            int maxIndex = i;
            for (int j = i+1; j<position; j++) {
                System.out.println(this.getPlayer(j) + " - " + this.getPlayer(i));
                if (this.getPlayer(j).getScore()>this.getPlayer(i).getHigh_score()) {
                    maxIndex = j;

                }
            }
            Player temp;
            temp = this.getPlayer(i);
            this.player[i] = this.getPlayer(maxIndex);
            this.player[maxIndex] = temp;
        }
    }

    @Test
    public void showHighScore() {
        System.out.println();
        System.out.println("High Scores");
        System.out.println("-----------");
        // SELECTION Sort
        this.selectionSort();
        for (int i = 0; i<5; i++) {
            System.out.println(this.getPlayer(i).getName() + ": " + this.getPlayer(i).getScore());
        }
    }
}
