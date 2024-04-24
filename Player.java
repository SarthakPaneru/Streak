public class Player {
    // Initialize name of player
    private String name;

    // Initialize score/max-streak a Player recieves
    private int score = 0;
//    private int [] currentScore = new int[10];
    private int high_score;

    // Default constructor
    public Player() {

    }

    // Getter method that returns name of player
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for score
    public int getScore() {
        return this.score;
    }

    // Setter method for score
    public void setScore(int score) {
        this.score = score;
    }

//    public int[] getCurrentScore() {
//        return currentScore;
//    }

//    public void setCurrentScore(int[] currentScore) {
//        this.currentScore = currentScore;
//    }

    // Getter for High score
    public int getHigh_score() {
        return high_score;
    }

    // Setter method for high score
    public void setHigh_score(int high_score) {
        this.high_score = high_score;
    }

    // Calculates max streak a player receives in current hand
    public void calculateScore(LinkedList list) {
        // Get first node of list
        Node head = list.getNode(1);

//        System.out.println("LEngth of node = " + list.lengthOfNode(head));    This is OK

//        int index = 0;

        // Store the rank and suit value in array for easier calculation
        int [] rank = new int[list.lengthOfNode(head)];
        int [] suit = new int[list.lengthOfNode(head)];

        // Loop until the end of the linked list and store rank and suit in their respective arrays
        for (int i=0;head != null; i++) {
            rank[i] = list.getNode(i+1).card.getRankPosition(head.card);
//            System.out.println("Rank = "+ rank[i]);
            suit[i] = list.getNode(i+1).card.getSuit(head.card);
            head = head.next;
        }
        // As head of the node is pointing at last element relocate it at first node
        head = list.getNode(1);

        // We assume streak to be at least of 1 for a single card
        int streak = 1;
        // Intial value of score is zero
        score = 0;
        int position = 0;
        // Bunch of temporary counters to determine suit streak extra points
        int temp1 = 1, temp2=1, temp3=1, temp4=1;

        // Assumes there is no streak at first
        boolean noStreak = true;

        // Linked list array calculation
        for (int i=0;head != null; i++) {
//            System.oureturn this.score;t.println("Suit = " + rank);

//            System.out.println("Before streak value: " + streak);
//            System.out.println("IS head.next null? " + head.next);    OK


            // Link list array specific index data calculation
            if(head.next != null) {
//                System.out.println("Rank sub: " + rank[i+1] + " -  " + rank[i] + " = "+ (rank[i + 1] - rank[i]));

                // the diff of rank of current and next card must be equal to 1 to initialize streak
                if ((rank[i + 1] - rank[i]) == 1) {
                    // since the above condition is true so there is Streak
                    noStreak = false;
//                    score++;
//                    System.out.println("sub 1");

                    // Increment the streak value by 1 and store the incremented value in score
                    streak++;
                    if (streak>score) {
                        score = streak;
                    }
//                    System.out.println(score);

                    // As the SUIT in SUIT enum has been especially placed such that HEARTS(0) and DIAMONDS(2)
                    // positon when modulo by 2 gives value 0
                    if (suit[i]%2 == suit[i+1]%2) {
                        // Since the suit of current and next card is of same color we increase the counter by 1
                        temp1++;

                        if (suit[i] == suit[i+1]) {
                            // Here we see the suits are same so we increase another counter by 1
                            temp2++;
                        }
                    }
                    // if the temp1 or temp2 counter value has been change then store it in new counters
                    if (temp1>temp3 || temp2>temp4) {
                        temp3 = temp1;
                        temp4 = temp2;
                    }

//                    System.out.println(streak + " position = " + i);
//                    System.out.println("from 1: " + score);
                } else {
//                    if (streak > score) {
//                        position = i;
//                    }
                    // if the condition is false then set counter streak, temp1, temp2 to their initial value
                    streak = 1;
                    temp1=1;
                    temp2=1;

                }

            }
            // change the pointer to next value
            head = head.next;
        }
//        System.out.println("Score value after loop: " + score);
        if (noStreak == true) {
            score = 1;
            streak = 1;
        }

        // If streak value changes and is greater than score change the score value to new strak
        // It is mostly used if there are more than one streak in one hand
        if (score < streak) {
            score = streak;
        }
//        System.out.println("Position = " + position);
//        System.out.println("Streak: " + streak);
//        System.out.println("Score: " + score);

//        System.out.println("Temp3 = " + temp3);
//        System.out.println("Temp4 = " + temp4);

        // If same color
        if ((temp3==score && (this.score != 1) )) {
            // If same SUIT
            if (temp4==score) {
                this.score++;
            }
            this.score++;
        }

//        System.out.println("Score value after checking color: " + score);

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
        return "Player {" +
                "Name='" + name + '\'' +
                ", Score=" + high_score +
                '}';
    }
}
