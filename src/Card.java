// Card class represents a playing card

public class Card {
    private final String face; // Face of card ("Ace", "Deuce", …)
    private final String suit; // Suit of card ("Hearts", "Diamonds", …)

    // Two-argument constructor initializes card's face and suit
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace; // Initialize face of card
        this.suit = cardSuit; // Initialize suit of card
    }

    public String getFace() {
        return face;
    }

    // Return String representation of Card
    public String toString() {
        return face + " of " + suit;
    }
}