import javax.swing.*;

public class WarGame {
    private final DeckOfCards player1;

    private final DeckOfCards player2;

    private final DeckOfCards table;

    public WarGame() {
        player1 = new DeckOfCards(DeckOfCards.NUMBER_OF_CARDS);
        player2 = new DeckOfCards(DeckOfCards.NUMBER_OF_CARDS);
        table = new DeckOfCards(0);

        player1.shuffle();
        player2.shuffle();
    }

    private String dialogInfo(Card card1, Card card2) {
        return "Player 1 has: " + card1.toString() + "\n" +
               "Player 2 has: " + card2.toString() + "\n";
    }

    private boolean startWar() {
        boolean isWin = false;

        for (int i = 0; i < 2; i++) {
            Card card1 = player1.dealCard(),
                 card2 = player2.dealCard();
            isWin = table.addCard(card1) | table.addCard(card2);
            if (isWin) {
                return isWin;
            }
            JOptionPane.showMessageDialog(null, dialogInfo(card1, card2));
        }
        return isWin;
    }

    private void whoWon() {
        if (player1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Player1 has won the game!");
        } else {
            JOptionPane.showMessageDialog(null, "Player2 has won the game!");
        }
    }

    public void playWarGame() {
        boolean isWin;

        while (true) {
            Card card1 = player1.dealCard(),
                 card2 = player2.dealCard();

            isWin = table.addCard(card1) | table.addCard(card2);
            if (isWin) {
                whoWon();
                return;
            }

            JOptionPane.showMessageDialog(null, dialogInfo(card1, card2));
            if (DeckOfCards.getFaceValue(card1) == DeckOfCards.getFaceValue(card2)) {
                isWin = startWar();
                if (isWin) {
                    whoWon();
                    return;
                }
            } else if (DeckOfCards.getFaceValue(card1) > DeckOfCards.getFaceValue(card2)) {
                player1.addDeck(table);
                JOptionPane.showMessageDialog(null, "Player1 has won the round!");
            } else {
                player2.addDeck(table);
                JOptionPane.showMessageDialog(null, "Player2 has won the round!");
            }
        }
    }
}
