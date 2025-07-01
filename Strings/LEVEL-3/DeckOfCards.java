import java.util.Scanner;

public class DeckOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int numOfCards = suits.length * ranks.length;
        String[] deck = initializeDeck(suits, ranks);
        shuffleDeck(deck);
        System.out.print("Enter number of players: ");
        int players = sc.nextInt();
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = sc.nextInt();
        if (players * cardsPerPlayer > deck.length) {
            System.out.println("Not enough cards to distribute.");
        } else {
            String[][] distributed = distributeCards(deck, players, cardsPerPlayer);
            printPlayersCards(distributed);
        }
    }

    static String[] initializeDeck(String[] suits, String[] ranks) {
        int totalCards = suits.length * ranks.length;
        String[] deck = new String[totalCards];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {
        String[][] playerCards = new String[players][cardsPerPlayer];
        int cardIndex = 0;
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerCards[i][j] = deck[cardIndex++];
            }
        }
        return playerCards;
    }

    static void printPlayersCards(String[][] playerCards) {
        for (int i = 0; i < playerCards.length; i++) {
            System.out.println("Player " + (i + 1) + " cards:");
            for (int j = 0; j < playerCards[i].length; j++) {
                System.out.println("  " + playerCards[i][j]);
            }
            System.out.println();
        }
    }
}
