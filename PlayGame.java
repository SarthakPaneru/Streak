import java.util.Scanner;


// To display and choose cards in output
enum Letter {
    A, B, C, D, E, F, G, H, I, J
}


public class PlayGame {

    Player player1 = new Player();
    Player player2 = new Player();

    HighScore highScore = new HighScore();

    private static int index = 0;
    private static int noOfCards;

    private String [] replacedCard;

    private LinkedList initialList;

    private LinkedList []list;

    public void playGame() {
        Deck deck = new Deck();
//        deck.showAllCardsInDeck();
        // To display and choose cards in output
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n");
            System.out.println("           STREAK          ");
            System.out.println("---------------------------");
            System.out.println(
                    "1. Single Player game\n" +
                            "2. 2-Player game\n" +
                            "3. View High Score Table\n" +
                            "4. Exit");
            int choice = s.nextInt();
            s.nextLine(); // To accept the enter character pressed
            String name;
            switch (choice) {
                case 1:
//                    deck.showAllCardsInDeck();
//                    deck.shuffle();
//                    System.out.println("\n\n");
//                    deck.showCardsInDeck();
                    System.out.println("How many cards do you want to play with (5-10)");
                    noOfCards = s.nextInt();
                    s.nextLine();
                    if (noOfCards<5 || noOfCards>10) {
                        System.out.println("Sorry, you can only choose 5-10 number of cards");
                        continue;
                    }

                    System.out.println("Enter Player 1 name: ");
                    name = s.nextLine();
                    player1.setName(name);

                    player(player1, noOfCards);
                    highScore.setPlayer(player1);

                    replay(player1);


                    break;

                case 2:

                    System.out.println("How many cards do you want to play with (5-10)");
                    noOfCards = s.nextInt();
                    s.nextLine();
                    if (noOfCards<5 || noOfCards>10) {
                        System.out.println("Sorry, you can only choose 5-10 number of cards");
                        continue;
                    }

                    System.out.println("Enter Player 1 name: ");
                    name = s.nextLine();
                    player1.setName(name);

                    System.out.println("Enter Player 2 name: ");
                    name = s.nextLine();
                    player2.setName(name);

                    int player1HighScore = 0;
                    int player2HighScore = 0;


                    for (int i = 1; i<=3; i++) {

                        System.out.println("****************");
                        System.out.println("Round " + i + " of 3");
                        System.out.println("****************");

                        player(player1, noOfCards);
                        highScore.setPlayer(player1);

                        player(player2, noOfCards);
                        highScore.setPlayer(player2);

                        System.out.println("\n**************");
                        System.out.println("End of Round " + i);
                        System.out.println();
                        System.out.println(player1.getName() + ": " + player1.getScore());
                        System.out.println(player2.getName() + ": " + player2.getScore());
                        System.out.println();
                        System.out.println("MATCH SCORE");
                        player1HighScore += player1.getScore();
                        player1.setHigh_score(player1HighScore);
                        player2HighScore += player2.getScore();
                        player2.setHigh_score(player2HighScore);


                        System.out.println(player1.getName() + ": " + player1HighScore);
                        System.out.println(player2.getName() + ": " + player2HighScore);
                        System.out.println();
                    }
                    if (player1HighScore == player2HighScore) {
                        System.out.println("TIED");
                    } else if (player1HighScore > player2HighScore) {
                        System.out.println(player1 + " wins\n");
                    } else if (player1HighScore < player2HighScore) {
                        System.out.println(player2 + " wins\n");
                    }


                    break;

                case 3:
                    highScore.showHighScore();
                    break;

                case 4:
                    System.out.println("\n******* Good Bye *******");
                    return;

                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }

    public void player(Player player, int noOfCards) {

        Deck deck = new Deck();
        Scanner s = new Scanner(System.in);



//        System.out.println("Enter Player 1 name: ");
//        String name = s.nextLine();
//        player.setName(name);

        // gives position of shuffle deck of cards
        this.index = 0;

        initialList = new LinkedList();

        list = new LinkedList[noOfCards+1];

        Card [] tempArr = new Card[noOfCards];
        Card [] tempArr1 = new Card[noOfCards];

        String decision;
        replacedCard = new String[noOfCards+1];

        deck.shuffle();
        for(int i=0; i<noOfCards+1; i++) {

            list[i] = new LinkedList();

            System.out.println(player.getName());

            if (i == 0) {
                for (int j = 0; j < noOfCards; j++) {
                    tempArr[j] = deck.getCardInDeck(index);
                    index++;    // We are increasing the index of the cards in deck
                }
            } else {
                for (int j = 0; j < noOfCards; j++) {
                    tempArr[j] = list[i-1].getNode(j+1).card;
                }
            }

//                        for (int j=0; j<noOfCards; j++) {
//                            System.out.println(tempArr[j].toString());
//                        }

            Insertionsort sort = new Insertionsort();

            tempArr1 = sort.insertionSort(tempArr);

            for (int j = 0; j < noOfCards; j++) {
//                            System.out.println(tempArr1[j].toString());
                LinkedList temp = new LinkedList();
                list[i].add(tempArr1[j], j);
                if (i == 0) {
                    initialList.add(tempArr1[j], j);
                }
//                            index++; // We are increasing the index of cards in deck
            }


            for (int j = 0; j < noOfCards; j++) {
                System.out.println(Letter.values()[j] + ": " + list[i].getNode(j + 1).card);
            }


            player.calculateScore(list[i]);

            System.out.println("Max streak value is " + player.getScore());
            System.out.println();

            // We want to display initial list and every hand
            if (i+1==noOfCards+1) {
                break;
            }

            System.out.println(i+1 + " of " + noOfCards + ": Choose card to change or X to exit: ");
            decision = s.nextLine();

            if (decision.equals("X") || decision.equals("x")) {
                i = noOfCards;
                continue;
            }
            int counter1 = 0, counter2 = 0;
            for (int j=0; j<noOfCards; j++) {
//                            System.out.println(noOfCards);
                Letter [] letters = Letter.values();
                if (decision.equals(letters[j].toString())) {
//                                if (i==0) {
//                                    replacedCard[i] = initialList.getNode(j + 1).card.toString();
//                                }
                    replacedCard[i] = list[i].getNode(j + 1).card.toString();
                    list[i].deleteNode(j+2);   // IDK j+2 only seems to delete our node correctly
                    list[i].add(deck.getCardInDeck(index), j);
                    index++;

                } else {
                    counter2++;
                }
            }

            if (counter2 == noOfCards) {
                System.out.println("Wrong input");
                i--;
                continue;
            }
            System.out.println("\n");
        }
        System.out.println("*******************");
        System.out.println("Streak value is: " + player.getScore());
        System.out.println("*******************");
        System.out.println();
    }

    public void replay(Player player) {
        Scanner s = new Scanner(System.in);



        System.out.println();
        System.out.println("See replay? (y/n) ");
        String replay = s.nextLine();

        if (replay.equals("y") || replay.equals("Y")) {
            System.out.println();
            System.out.println("REPLAY");
            System.out.println("------");
            for (int i = 0; i < index - noOfCards + 1; i++) {
//                            System.out.println(list[i+1].getNodeStr(1));
                System.out.println();
                System.out.println(player.getName());
                if (i == 0) {
                    System.out.println("Initial list");
                    for (int j = 0; j < noOfCards; j++) {
                        System.out.println(Letter.values()[j] + ": " + initialList.getNode(j + 1).card);
                    }
                } else {
                    for (int j = 0; j < noOfCards; j++) {
                        System.out.println(Letter.values()[j] + ": " + list[i - 1].getNode(j + 1).card);
                    }
                }
                System.out.println("Selection was " +replacedCard[i]);
                s.nextLine();
            }
        }
    }
}
