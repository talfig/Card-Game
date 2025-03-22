/**
 * The Main class serves as the entry point for the WarGame application.
 * It initializes the WarGame object and starts the game by calling the playWarGame method.
 */
public class Main {
    /**
     * The main method is the entry point of the Java application.
     * It creates an instance of the WarGame class and starts the game.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        WarGame game = new WarGame();
        game.playWarGame();
    }
}