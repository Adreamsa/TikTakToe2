import java.util.Scanner;

public class TicTacToeNormal implements Game {
    private Board board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    public TicTacToeNormal(int boardSize, Player player1, Player player2) {
        this.board = new Board(boardSize);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    @Override
    public void initializeGame() {
        board.initializeGame();
    }

    public void playGame() {
        board.drawBoard();
        while (true) {
            int[] input = validateInput();
            board.updateBoard(input[0], input[1], currentPlayer.getSymbol());
            board.drawBoard();
            if (isGameOver()) {
                break;
            }

            nextTurn(currentPlayer);
        }
    }

    public int[] validateInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Jugador " + currentPlayer.getName() + ", ingresa tu movimiento (fila y columna): ");
            String inputRow = scanner.next();
            String inputCol = scanner.next();
            //if original
            //if (validateRange(inputRow, inputCol) && validateRange(inputRow, inputCol) && validatePull(inputRow, inputCol)) {
            // if update
            if (validatePull(inputRow, inputCol)) {
                return new int[]{Integer.parseInt(inputRow) - 1, Integer.parseInt(inputCol) - 1};
            } else {
                System.out.println("Datos incorrectos intenta de nuevo");
            }
        }
    }

    //you don't use the method anywhere
    /*private boolean isNumber(String inputRow, String inputCol) {
        return inputRow.matches("\\d+") || inputCol.matches("\\d+");
    }*/

    /*private boolean validateRange(String inputRow, String inputCol) {
        int intRow = Integer.parseInt(inputRow);
        int intCol = Integer.parseInt(inputCol);
        return (intRow >= 1 && intRow <= board.getSize()) && (intCol >= 1 && intCol <= board.getSize());

    }

    private boolean validatePull(String inputRow, String inputCol) {
        int intRow = Integer.parseInt(inputRow) - 1;
        int intCol = Integer.parseInt(inputCol) - 1;
        return board.getBoard()[intRow][intCol] == '-';
    }*/

    //Simplify the two previous methods since your operations could be done in joints
    private boolean validatePull(String inputRow, String inputCol) {
        int intRow = Integer.parseInt(inputRow) - 1;
        int intCol = Integer.parseInt(inputCol) - 1;
        return intRow >= 0 && intRow <= board.getSize() && intCol >= 0 && intCol <= board.getSize() && board.getBoard()[intRow][intCol] == '-';
    }

    @Override
    public void nextTurn(Player player) {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    @Override
    public boolean isGameOver() {
        if (board.isWinner()) {
            System.out.println("¡Jugador " + currentPlayer.getName() + " ha ganado!");
            return true;
        } else if (board.isBoardFull()) {
            System.out.println("¡Empate!");
            return true;
        }
        return false;
    }
}
