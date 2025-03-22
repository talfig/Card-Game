import java.security.SecureRandom;
import java.util.ArrayList;


/**
 * The DeckOfCards class represents a deck of playing cards and provides methods
 * to manipulate and deal cards. The deck contains 52 cards, each with a face and a suit.
 * This class includes methods to shuffle, deal, and manage the deck.
 */
public class DeckOfCards {
    private static final SecureRandom randomNumbers = new SecureRandom();

    public static final int NUMBER_OF_CARDS = 52;

    private final ArrayList<Card> deck = new ArrayList<>(NUMBER_OF_CARDS);

    // Array of faces for the cards (1, 2, 3, ... King)
    private static final String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven",
                                           "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

    // Array of suits for the cards (Hearts, Diamonds, Clubs, Spades)
    private static final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

    /**
     * Constructor that initializes the deck with the specified number of cards.
     * Each card is created using the faces and suits arrays.
     *
     * @param numberOfCards the number of cards to be added to the deck
     */
    public DeckOfCards(int numberOfCards) {
        for (int count = 0; count < numberOfCards; count++) {
            // Adds cards based on face and suit
            deck.add(new Card(faces[count % 13], suits[count / 13]));
        }
    }

    /**
     * Returns the current deck of cards.
     *
     * @return the list of cards in the deck
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Shuffles the cards in the deck using a random number generator.
     */
    public void shuffle() {
        for (int first = 0; first < NUMBER_OF_CARDS; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            // Swap the positions of the two cards in the deck
            Card temp = deck.get(first);
            deck.set(first, deck.get(second));
            deck.set(second, temp);
        }
    }

    /**
     * Deals one card from the deck. If the deck is empty, it returns null.
     *
     * @return the dealt card, or null if the deck is empty
     */
    public Card dealCard() {
        if (!deck.isEmpty()) {
            Card temp = deck.get(0);
            deck.remove(0);
            return temp;
        }
        return null;  // Return null when no more cards are available
    }

    /**
     * Checks whether the deck is empty.
     *
     * @return true if the deck is empty, false otherwise
     */
    public boolean isEmpty() {
        return deck.isEmpty();
    }

    /**
     * Adds a card to the deck if it is not null.
     *
     * @param card the card to be added to the deck
     * @return false if the card was successfully added, true if the card is null
     */
    public boolean addCard(Card card) {
        if (card != null) {
            deck.add(card);
            return false;
        }
        return true;  // Return true if the card was null and not added
    }

    /**
     * Adds all the cards from another deck to this deck.
     *
     * @param other the other deck whose cards will be added to this deck
     */
    public void addDeck(DeckOfCards other) {
        while (!other.deck.isEmpty()) {
            deck.add(other.dealCard());
        }
    }

    /**
     * Retrieves the face value of a card. The face value is represented by an integer
     * from 1 (Ace) to 13 (King).
     *
     * @param card the card whose face value is to be determined
     * @return the face value of the card, or -1 if the card face is invalid
     */
    public static int getFaceValue(Card card) {
        for (int i = 0; i < faces.length; i++) {
            if (faces[i].equals(card.getFace())) {
                return i + 1; // Return the corresponding face value (1 for Ace, 2 for Deuce, etc.)
            }
        }
        return -1;  // Return -1 if the face value is not found
    }
}
