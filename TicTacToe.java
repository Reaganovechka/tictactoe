import java.awt.Point;

public interface TicTacToe {
    public static enum Choice {X, O, OPEN};
    public static enum GameState {X_WON, O_WON, IN_PROGRESS, TIE};

    /**
     * Resets the game to a blank slate.
     * All positions are OPEN, there are no moves, and the game is in progress.
     */
    public void newGame();

    /**
     * Checks if the move can be made. If move is valid, claim it for that player.
     * If the move is the winning or final move, end the game.
     * 
     * @param player expecting Choice.X or Choice.O
     * @param row row to claim, value of 0-2
     * @param col col to claim, value of 0-2
     * @return true if the choice was valid, false if not
     */
    public boolean validChoice(Choice player, int row, int col);

    /**
     * Return true if either player has achieved 3 in a row, or if all positions have been claimed
     * withourt a winner.
     * 
     * @return true if game is over, else false.
     */
    public boolean gameOver();

    /**
     * Returns the winner if game is over, or IN_PROGRESS if the game is not over
     * 
     * @return the winner of the game, or IN_PROGRESS
     */
    public GameState getGameState();

    /**
     * Get the current game board. Each position is marked either X, O, or OPEN.
     * Return a copy of the data.
     * 
     * @return array of the current game board
     */
    public Choice[][] getGameGrid();

    /**
     * Get the total sequence of moves. Even indexes are the first player, odd indexes are the second player.
     * Return a copy of the moves.
     * 
     * @return array containing the sequence of claimed spaces.
     */
    public Point[] getMoves();

    /**
     * Get the previous move. 
     * 
     * @return position of the last move and who made it.
     */
    public Point[] lastMove();
}