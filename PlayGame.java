import java.util.Scanner;


// To display and choose cards in output
enum Letter {
    A, B, C, D, E, F, G, H, I, J
}


public class PlayGame {

    // Introduce two instance of Player class for single player as well as 2-player
    Player player1 = new Player();
    Player player2 = new Player();

    // Instance of High score class to store high scores achieved
    HighScore highScore = new HighScore();

    // Stores position of current card in deck;
    private static int index = 0;

    // It defines no of cards to be played in single hand
    private static int noOfCards;

    // Stores which cards were replaced to display in replay
    private String [] replacedCard;

    // Instance of LinkedList
    private LinkedList initialList;

    // Array of instance of LinkedList to store every list in every hands played
    private LinkedList []list;

    // Default constructor
    public void playGame() {
        Deck deck = new Deck();
//        deck.showAllCardsInDeck();
        // To display and choose cards in output
        Scanner s = new Scanner(System.in);

        // Run program infinitely until user terminates it
        while (true) {
            int choice = 0;
            boolean valid;
            do {
                valid = true;
                System.out.println("\n\n");
                System.out.println("           STREAK          ");
                System.out.println("---------------------------");
                System.out.println(
                        "1. Single Player game\n" +
                                "2. 2-Player game\n" +
                                "3. View High Score Table\n" +
                                "4. Exit");
                try {
                    choice = Integer.parseInt(s.nextLine());
//                    s.nextLine(); // To accept the enter character pressed
                } catch (NumberFormatException | NullPointerException e) {
                    System.out.println("Invalid input. ");
                    valid = false;
                }
            } while(!valid);
            String name;
            switch (choice) {
                // Single Player Game
                case 1:
//                    deck.showAllCardsInDeck();
//                    deck.shuffle();
//                    System.out.println("\n\n");
//                    deck.showCardsInDeck();

                    do {
                        valid = true;
                        try {
                            // Player can only choose between 5-10 cards
                            System.out.println("How many cards do you want to play with (5-10)");
                            noOfCards = Integer.parseInt(s.nextLine());
                            if (noOfCards < 5 || noOfCards > 10) {
                                System.out.println("Sorry, you can only choose 5-10 number of cards");
                                valid = false;
                            }
                        } catch (NumberFormatException | NullPointerException e) {
                            System.out.println("Sorry, you can only choose numbers from 5-10");
                            valid = false;
                        }

                    } while(!valid);

                    System.out.println("Enter Player 1 name: ");
                    name = s.nextLine();
                    player1.setName(name);

                    // function call player() function provided with arguements player1 and no of cards to be played
                    player(player1, noOfCards);
                    highScore.setPlayer(player1); // store the high score obtained in HighScore class

                    // Replay every hand played
                    replay(player1);


                    break;

                // 2-Player Game
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


                    // Play the game for 3 rounds for clead winner
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

                // Display high score of players
                case 3:
                    highScore.showHighScore();
                    break;

                // Exit the program
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

        // new instance of Deck class
        Deck deck = new Deck();
        // Scanner helps with receiving inputs from keyboards
        Scanner s = new Scanner(System.in);



//        System.out.println("Enter Player 1 name: ");
//        String name = s.nextLine();
//        player.setName(name);

        // gives position of shuffle deck of cards
        this.index = 0;

        initialList = new LinkedList();

        // Create the array of linked list
        // noOfCard for every card exchaged and +1 for initial list
        list = new LinkedList[noOfCards+1];

        Card [] tempArr = new Card[noOfCards];
        Card [] tempArr1 = new Card[noOfCards];

        String decision;
        replacedCard = new String[noOfCards+1];

        // Shuffle the cards in deck
        deck.shuffle();
        // run loop for no of cards the user has choosen
        for(int i=0; i<noOfCards+1; i++) {

            // create instance of every array elements of linked list
            list[i] = new LinkedList();

            System.out.println(player.getName());

            if (i == 0) {
                // Store list of cards in initial hand in temporary array
                for (int j = 0; j < noOfCards; j++) {
                    tempArr[j] = deck.getCardInDeck(index);
                    index++;    // We are increasing the index of the cards in deck
                }
            } else {
                // Store the previous list of card after exchanging
                for (int j = 0; j < noOfCards; j++) {
                    tempArr[j] = list[i-1].getNode(j+1).card;
                }
            }

//                        for (int j=0; j<noOfCards; j++) {
//                            System.out.println(tempArr[j].toString());
//                        }

            Insertionsort sort = new Insertionsort();

            // Sorting of cards in ascending order in array
            tempArr1 = sort.insertionSort(tempArr);

            // Add the sorted cards in Linked list
            for (int j = 0; j < noOfCards; j++) {
//                            System.out.println(tempArr1[j].toString());
                LinkedList temp = new LinkedList();
                list[i].add(tempArr1[j], j);
                if (i == 0) {
                    initialList.add(tempArr1[j], j);
                }
//                            index++; // We are increasing the index of cards in deck
            }

            // Display the contents of list
            for (int j = 0; j < noOfCards; j++) {
                System.out.println(Letter.values()[j] + ": " + list[i].getNode(j + 1).card);
            }

            // Calculate the max streak
            player.calculateScore(list[i]);

            // Display max streak
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
            // Exchanged card with new card from DECK
            for (int j=0; j<noOfCards; j++) {
//                            System.out.println(noOfCards);
                Letter [] letters = Letter.values();
                if (decision.equals(letters[j].toString())) {
//                                if (i==0) {
//                                    replacedCard[i] = initialList.getNode(j + 1).card.toString();
//                                }
                    // Store the replaced card so can be shown in replay
                    replacedCard[i] = list[i].getNode(j + 1).card.toString();
                    // Delete the current card from list
                    list[i].deleteNode(j+2);   // IDK j+2 only seems to delete our node correctly
                    // add new card in deck
                    list[i].add(deck.getCardInDeck(index), j);
                    index++;

                } else {
                    // Increase the counter if input value doesnot matches with diplayed card position
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

    // replay function which replays game in single player mode
    public void replay(Player player) {
        Scanner s = new Scanner(System.in);



        System.out.println();
        System.out.println("See replay? (y/n) ");
        String replay = s.nextLine();

        if (replay.equals("y") || replay.equals("Y")) {
            System.out.println();
            System.out.println("REPLAY");
            System.out.println("------");
            // here, index - noOfCards gives the increase index value
            // +1 to show initial list of cards;
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
