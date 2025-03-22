/**
 * The Card class represents a playing card with a face and a suit.
 * It provides methods to get the card's face, suit, and a string representation.
 */
public class Card {
    private final String face; // Face of card ("Ace", "Deuce", …)
    private final String suit; // Suit of card ("Hearts", "Diamonds", …)

    /**
     * Two-argument constructor initializes the card's face and suit.
     *
     * @param face the face of the card (e.g., "Ace", "Deuce", etc.)
     * @param suit the suit of the card (e.g., "Hearts", "Diamonds", etc.)
     */
    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    /**
     * Gets the face of the card.
     *
     * @return the face of the card (e.g., "Ace", "King", etc.)
     */
    public String getFace() {
        return face;
    }

    /**
     * Provides a string representation of the card in the format:
     * "Face of Suit" (e.g., "Ace of Hearts").
     *
     * @return a string representation of the card
     */
    public String toString() {
        return face + " of " + suit;
    }
}