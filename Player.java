public class Player {
    private String name;
    private int score = 0;
    private int [] currentScore = new int[10];
    private int high_score;

    public Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int[] getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int[] currentScore) {
        this.currentScore = currentScore;
    }

    public int getHigh_score() {
        return high_score;
    }

    public void setHigh_score(int high_score) {
        this.high_score = high_score;
    }

    public void calculateScore(LinkedList list) {
        Node head = list.getNode(1);

//        System.out.println("LEngth of node = " + list.lengthOfNode(head));    This is OK

        int index = 0;
        int [] rank = new int[list.lengthOfNode(head)];
        int [] suit = new int[list.lengthOfNode(head)];

        for (int i=0;head != null; i++) {
            rank[i] = list.getNode(i+1).card.getRankPosition(head.card);
//            System.out.println("Rank = "+ rank[i]);
            suit[i] = list.getNode(i+1).card.getSuit(head.card);
            head = head.next;
        }
        head = list.getNode(1);
        int streak = 1;
        int position = 0;
        int temp1 = 1, temp2=1, temp3=1, temp4=1;
        int temp = 1;

        for (int i=0;head != null; i++) {
//            System.oureturn this.score;t.println("Suit = " + rank);

//            System.out.println("Before streak value: " + streak);
//            System.out.println("IS head.next null? " + head.next);    OK
            if(head.next != null) {
                System.out.println("Rank sub: " + rank[i+1] + " -  " + rank[i] + " = "+ (rank[i + 1] - rank[i]));
                if ((rank[i + 1] - rank[i]) == 1) {
//                    score++;
                    streak++;
                    score = streak;
                    System.out.println(score);

                    // Lets try something new
                    if (suit[i]%2 == suit[i+1]%2) {
                        temp1++;

                        if (suit[i] == suit[i+1]) {
                            temp2++;
                        }
                    }
                    if (temp1>temp3 || temp2>temp4) {
                        temp3 = temp1;
                        temp4 = temp2;
                    }

//                    System.out.println(streak + " position = " + i);
//                    System.out.println("from 1: " + score);
                } else {
                    if (streak > score) {
                        position = i;
                    }
                    streak = 1;
                    temp1=1;
                    temp2=1;

                }

            }

            head = head.next;
        }
        if (score < streak) {
            score = streak;
        }
        System.out.println("Position = " + position);
        System.out.println("Streak: " + streak);
        System.out.println("Score: " + score);

        // If same color
        if ((temp3==score)) {
            // If same SUIT
            if (temp4==score) {
                score++;
            }
            score++;
        }

        head = list.getNode(1);
//        int temp1 = 0, temp2=0, temp3=0;
//        for (int j=position; j<score; j++) {
//            if (suit[j]%2 != 0) {
//                temp1++;
//
//            } else {
//                temp2++;
//
//            }
//            if (head.next != null) {
//                if (suit[j] == suit[j + 1]) {
//                    temp3++;
//                }
//            }
//        }
//        if ((temp1==streak || temp2==streak) && streak != 0) {
//            score++;
//        }
//        if ((temp3 == streak) && streak != 0) {
//            score++;
//        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", high_score=" + high_score +
                '}';
    }
}
