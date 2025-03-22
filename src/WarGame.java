import javax.swing.*;

/**
 * WarGame simulates a card game between two players where cards are dealt and compared.
 * If two players draw cards with the same value, a "war" is triggered.
 * The game continues until one player wins or all cards are drawn, resulting in a draw.
 */
public class WarGame {
    private final DeckOfCards player1;

    private final DeckOfCards player2;

    // Represents the table where cards are placed during a round
    private final DeckOfCards table;

    /**
     * Initializes the game with two players' decks and a table deck.
     * Both players' decks are shuffled at the beginning of the game.
     */
    public WarGame() {
        player1 = new DeckOfCards(DeckOfCards.NUMBER_OF_CARDS);
        player2 = new DeckOfCards(DeckOfCards.NUMBER_OF_CARDS);
        table = new DeckOfCards(0);

        // Shuffle the cards for both players
        player1.shuffle();
        player2.shuffle();
    }

    /**
     * Returns a string containing the cards of player 1 and player 2 for the current round.
     *
     * @param card1 The card dealt to player 1.
     * @param card2 The card dealt to player 2.
     * @return A string showing the cards of both players.
     */
    private String roundInfo(Card card1, Card card2) {
        return "Player 1 has: " + card1.toString() + "\n" +
               "Player 2 has: " + card2.toString() + "\n";
    }

    /**
     * Displays the current number of cards each player has in their deck.
     */
    public void playersInfo() {
        JOptionPane.showMessageDialog(null, "Player1 contains " + player1.getDeck().size()
                + " cards!" + "\n" + "Player2 contains " + player2.getDeck().size() + " cards!");
    }

    /**
     * Simulates a war between the two players. If both players draw cards with the same value,
     * the war begins and each player draws additional cards. The first two cards are placed on the
     * table without being compared, and the third card drawn by each player will determine the winner
     * of the war.
     *
     * @return True if a player wins the game, otherwise false.
     */
    private boolean startWar() {
        boolean isWin = false;

        // During a war, each player draws two cards
        for (int i = 0; i < 2; i++) {
            Card card1 = player1.dealCard(),
                 card2 = player2.dealCard();
            isWin = table.addCard(card1) | table.addCard(card2);  // Add the cards to the table
            if (isWin) {
                return isWin;
            }
            JOptionPane.showMessageDialog(null, roundInfo(card1, card2));
        }
        return isWin;
    }

    /**
     * Displays the result of the game.
     * This could be a win for either player or a draw if both players run out of cards.
     */
    private void whoWon() {
        if (player1.isEmpty() && player2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The game has ended in a draw!");
        } else if (player1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Player1 has won the game!");
        } else {
            JOptionPane.showMessageDialog(null, "Player2 has won the game!");
        }
    }

    /**
     * Simulates the main loop of the War card game.
     * Each player draws a card and the winner of each round is determined by the card values.
     * If there is a tie, a war is triggered where both players draw additional cards.
     * The game continues until one player runs out of cards.
     */
    public void playWarGame() {
        boolean isWin;

        // Display initial info about the number of cards for each player
        playersInfo();

        while (true) {
            // Both players deal one card
            Card card1 = player1.dealCard(),
                 card2 = player2.dealCard();

            // Add the cards to the table and check if there's a winner
            isWin = table.addCard(card1) | table.addCard(card2);
            if (isWin) {
                whoWon();
                return;  // End the game if there is a winner
            }

            // Display the cards dealt in the round
            JOptionPane.showMessageDialog(null, roundInfo(card1, card2));

            // If the cards are equal, trigger a war
            if (DeckOfCards.getFaceValue(card1) == DeckOfCards.getFaceValue(card2)) {
                JOptionPane.showMessageDialog(null, "Starting a war!");
                isWin = startWar();
                if (isWin) {
                    whoWon();
                    return;  // End the game if there is a winner
                }
                continue;  // Continue to the next round if no winner
            }
            // Determine the winner based on the card values
            else if (DeckOfCards.getFaceValue(card1) > DeckOfCards.getFaceValue(card2)) {
                player1.addDeck(table);  // Player 1 wins the round
                JOptionPane.showMessageDialog(null, "Player1 has won the round!");
            } else {
                player2.addDeck(table);  // Player 2 wins the round
                JOptionPane.showMessageDialog(null, "Player2 has won the round!");
            }

            // Display the updated number of cards for each player
            playersInfo();
        }
    }
}
