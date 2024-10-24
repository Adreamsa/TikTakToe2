
public class TicTacToeInverted extends TicTacToeNormal {

    public TicTacToeInverted(int boardSize, Player player1, Player player2) {
        super(boardSize, player1, player2);
    }

    @Override
    public boolean isGameOver() {
        if (board.isWinner()) {
            System.out.println("¡Jugador " + currentPlayer.getName() + " ha perdido!");
            return true;
        } else if (board.isBoardFull()) {
            System.out.println("¡Empate!");
            return true;
        }
        return false;
    }
}
