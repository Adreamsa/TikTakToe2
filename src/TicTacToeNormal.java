public class TicTacToeNormal extends Game {
    private Board board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    public TicTacToeNormal(int boardSize, Player player1, Player player2) {
        this.board = new Board(boardSize);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;  // Empieza player1
    }

    @Override
    public void initializeGame() {
        board.initializeGame();
    }

    @Override
    public void nextTurn(Player player) {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    @Override
    public void isGameOver() {
        if (board.isWinner()) {
            System.out.println("¡Jugador " + currentPlayer.getName() + " ha ganado!");
        } else if (board.isBoardFull()) {
            System.out.println("¡Empate!");
        }
    }
}
