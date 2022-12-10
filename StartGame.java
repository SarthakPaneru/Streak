import java.util.Scanner;

public class StartGame {

    // To display and choose cards in output
    enum Letter {
        A, B, C, D, E, F, G, H, I, J
    }

    public static void main(String [] args) {
        Deck deck = new Deck();
//        deck.showAllCardsInDeck();

        Scanner s = new Scanner(System.in);
        Player player = new Player();
//        LinkedList list1 = new LinkedList();


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

            switch (choice) {
                case 1:
//                    deck.showAllCardsInDeck();
//                    deck.shuffle();
//                    System.out.println("\n\n");
//                    deck.showCardsInDeck();

                    System.out.println("How many cards do you want to play with (5-10)");
                    int noOfCards = s.nextInt();
                    s.nextLine();

                    System.out.println("Enter Player 1 name: ");
                    String name = s.nextLine();
                    player.setName(name);

                    // gives position of shuffle deck of cards
                    int index = 0;

                    LinkedList [] storeList = new LinkedList[noOfCards];

                    LinkedList [] list = new LinkedList[noOfCards];

                    Card [] tempArr = new Card[noOfCards];
                    Card [] tempArr1 = new Card[noOfCards];

                    deck.shuffle();
                    for(int i=0; i<noOfCards; i++) {

                        list[i] = new LinkedList();





                        System.out.println(player.getName());

                        if (i == 0) {
                            for (int j = 0; j < noOfCards; j++) {
                                tempArr[j] = deck.getCardInDeck(index);
                                index++;
                            }
                        } else {
                            for (int j = 0; j < noOfCards; j++) {
                                tempArr[j] = list[i-1].getNode(j+1).card;
//                                System.out.println(tempArr[j]);
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
//                            index++; // We are increasing the index of cards in deck
//                            System.out.println(list1.getNode(index).card);
                        }

                        for (int j=0; j<noOfCards; j++) {
                            System.out.println(Letter.values()[j] + ": " + list[i].getNode(j+1).card);
                        }

                        player.calculateScore(list[i]);

                        System.out.println("Max streak value is " + player.getScore());
                        System.out.println();

//                        list[i][i].insertionSort(list[i][i]);

//                        for (int j=0; j<noOfCards; j++) {
//                            System.out.println(Letter.values()[j] + ": " + list[i][i].getNode(j+1).card);
//                        }


//                        System.out.println("\n" + list1.showList(list1.getHead()));

//                        index = 0;
//                        for (int j=0; j<noOfCards; j++) {
//                            list1.add(deck.getCardInDeck(index));
//                            index++;
//
//                            System.out.println(Letter.values()[j] + ": " + list1.getNode(index));
//                        }

                        System.out.println(i+1 + " of " + noOfCards + ": Choose card to change or X to exit: ");
                        String decision = s.nextLine();

                        if (decision.equals("X") || decision.equals("x")) {
                            i = noOfCards;
                            continue;
                        }
//                        System.out.println("swapping values");
                        int counter1 = 0, counter2 = 0;
                        for (int j=0; j<noOfCards; j++) {
//                            System.out.println(noOfCards);
                            Letter [] letters = Letter.values();
                            if (decision.equals(letters[j].toString())) {
                                list[i].deleteNode(j+2);   // IDK j+2 only seems to delete our node correctly
                                list[i].add(deck.getCardInDeck(index), j);
                                index++;
//                                list[i][i].swapCard(deck.getCardInDeck(index++), j);

                            } else {
                                counter2++;
                            }
                            // It is implemented above
//                            tempArr[j] = list[i].getNode(j+1).card;
//                            System.out.println(j);
//                            System.out.println(tempArr[j]);
                        }

                        if (counter2 == noOfCards) {
                            System.out.println("Wrong input");
                            i--;
                            continue;
                        }
//                        for (int j=0; j<noOfCards; j++) {
//                            System.out.println(Letter.values()[j] + ": " + list[i].getNode(j+1).card);
//                        }
                        System.out.println("\n");

                    }
                    break;

                case 2:
                    System.out.println("2-Player game is being built");
                    break;

                case 3:
                    System.out.println("Under Construction");
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}
