public class HighScore {
    private int position = 0;
    private static Player [] player = new Player[10];

    public HighScore() {

    }

    public void setPlayer(Player player) {
        HighScore.player[position] = new Player();
        this.getPlayer(position);
        HighScore.player[position].setName(player.getName());
        HighScore.player[position].setScore(player.getScore());

        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public Player getPlayer(int position) {
        return player[position];
    }



    public void selectionSort() {
        System.out.println("Selection: " + position);
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
