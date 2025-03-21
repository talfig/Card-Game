import java.security.SecureRandom;
import java.util.ArrayList;

public class DeckOfCards { // In this class we define and handle different methods and concepts for our deck
    private static final SecureRandom randomNumbers = new SecureRandom();

    public static final int NUMBER_OF_CARDS = 52;

    private final ArrayList<Card> deck = new ArrayList<>(NUMBER_OF_CARDS);

    private static final String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven",
                                           "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

    private static final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

    public DeckOfCards(int numberOfCards) {
        for (int count = 0; count < numberOfCards; count++) {
            deck.add(new Card(faces[count % 13], suits[count / 13]));  // Fixed add() usage
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void shuffle() {
        for (int first = 0; first < NUMBER_OF_CARDS; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            // Fixed indexing for ArrayList
            Card temp = deck.get(first);
            deck.set(first, deck.get(second));
            deck.set(second, temp);
        }
    }

    public Card dealCard() {
        if (!deck.isEmpty()) {
            Card temp = deck.get(0);
            deck.remove(0);
            return temp;
        }
        return null;  // Return null when no more card
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    public boolean addCard(Card card) {
        if (card != null) {
            deck.add(card);
            return false;
        }
        return true;
    }

    public void addDeck(DeckOfCards other) {
        while (!other.deck.isEmpty()) {
            deck.add(other.dealCard());
        }
    }

    public static int getFaceValue(Card card) {
        for (int i = 0; i < faces.length; i++) {
            if (faces[i].equals(card.getFace())) {
                return i + 1;
            }
        }
        return -1;
    }
}
