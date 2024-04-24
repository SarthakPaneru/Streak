public class HighScore {
    // Initialize index of Player array to store player value
    private int position = 0;

    // Static player array can be choosen accessed from different instance of HighScore class.
    private static Player [] player = new Player[20];

    // Default constructor
    public HighScore() {

    }

    // Setter method for Player
    public void setPlayer(Player player) {
        HighScore.player[position] = new Player();
        this.getPlayer(position);
        HighScore.player[position].setName(player.getName());
        HighScore.player[position].setScore(player.getScore());

        this.position++;
    }

    // returns the index of Player array currently at
    public int getPosition() {
        return position;
    }

    // Getter method to get Player value
    public Player getPlayer(int position) {
        return player[position];
    }

    // SELECTION sort to sort High Score in Descending order
    // Here, we choose selection sort as it is best for fewer datas and most of whose value are sorted
    public void selectionSort() {
//        System.out.println("Selection: " + position);
        for (int i = 0; i<position-1; i++ ) {
            int maxIndex = i;
            for (int j = i+1; j<position; j++) {
                if (player[j].getScore()>player[maxIndex].getScore()) {
                    maxIndex = j;

                }
            }
            Player temp;
            temp = player[maxIndex];
            this.player[maxIndex] = player[i];
            this.player[i] = temp;
        }
    }

    // Displays TOP 5 High Score along with Player name
    public void showHighScore() {
        System.out.println();
        System.out.println("High Scores");
        System.out.println("-----------");
        // SELECTION Sort
        this.selectionSort();
        for (int i = 0; i<position && i<5; i++) {
            System.out.println(player[i].getName() + ": " + player[i].getScore());
        }
    }
}
