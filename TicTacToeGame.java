import java.awt.Point;

public class TicTacToeGame implements TicTacToe {
    private Choice[][] board; //Keeps track of board
    private Point[] moves; //History of moves
    private Choice lastPlayer; //Player who made the most recent move
    private GameState game; //Current state of the game
    private Point lastMove; //Most recent move
    private int moveCount;

    private static final int BOARD_DIM = 3;
    private static final int MAX_MOVES = 9;


    /**
     * Constructs a new TicTacToe game by creating a 2D array to reflect the game board and an array to keep track of the moves.
     * Calls newGame() method to initialize the new game.
     */
    public TicTacToeGame(){
        board = new Choice[BOARD_DIM][BOARD_DIM];
        moves = new Point[MAX_MOVES];
        newGame();
    }


    @Override
    public void newGame() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++){
                board[row][col] = Choice.OPEN;
            }
        }

        game = GameState.IN_PROGRESS;
        moveCount = 0;
        lastPlayer = Choice.OPEN;
    }

    @Override
    public boolean validChoice(TicTacToe.Choice player, int row, int col) {
        //verify the move can be made
        if ((((row < 0 ) || (row > 2)) || ((col < 0) || (col > 2))) && 
        (board[row][col] == Choice.OPEN) && 
        (lastPlayer != player) &&
        (game == GameState.IN_PROGRESS)) {
            moveCount += 1;
            board[row][col] = player;
            moves[moveCount] = new Point(row, col);
            lastPlayer = player;

            //Check for a win
            //Check rows
            for (row = 0; row < board.length; row++){
                if (((board[row][0]) == (board[row][1])) && (board[row][0]) == (board[row][2])){
                    if (board[row][0] == Choice.O){
                        game = GameState.O_WON;
                    }
                    if (board[row][0] == Choice.X){
                        game = GameState.X_WON;
                    }
                }
            }
            //Check cols
            for (col = 0; col < board.length; col++){
                if (((board[0][col]) == (board[1][col])) && (board[0][col]) == (board[2][col])){
                    if (board[0][col] == Choice.O){
                        game = GameState.O_WON;
                    }
                    if (board[0][col] == Choice.X){
                        game = GameState.X_WON;
                    }
                }
            }
            //Check Diagonals
            if (board[row])
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public TicTacToe.GameState getGameState() {

    }

    @Override
    public TicTacToe.Choice[][] getGameGrid() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGameGrid'");
    }

    @Override
    public Point[] getMoves() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMoves'");
    }

    @Override
    public Point[] lastMove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastMove'");
    }


    @Override
    public boolean gameOver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gameOver'");
    }
    
}
