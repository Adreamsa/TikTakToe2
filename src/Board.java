public class Board {
    private char[][] board;
    private int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new char[boardSize][boardSize];
        initializeGame();
        drawBoard();
    }

    // Inicializa el tablero
    public void initializeGame() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Dibuja el tablero
    public void drawBoard() {
        System.out.println("-------------");
        for (int i = 0; i < boardSize; i++) {
            System.out.print("| ");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Actualiza el tablero con el movimiento de un jugador
    public void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Verifica si el tablero está lleno
    public boolean isBoardFull() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Verifica si hay un ganador
    public boolean isWinner() {
        // Revisión de filas, columnas y diagonales
        for (int i = 0; i < boardSize; i++) {
            if (board[i][0] != '-' && allEqual(board[i][0], board[i])) {
                return true;
            }
        }

        for (int i = 0; i < boardSize; i++) {
            if (board[0][i] != '-' && allEqual(board[0][i], getColumn(i))) {
                return true;
            }
        }

        if (board[0][0] != '-' && allEqual(board[0][0], getDiagonal(true))) {
            return true;
        }

        if (board[0][boardSize - 1] != '-' && allEqual(board[0][boardSize - 1], getDiagonal(false))) {
            return true;
        }

        return false;
    }

    // Métodos auxiliares
    private boolean allEqual(char player, char[] line) {
        for (char cell : line) {
            if (cell != player) {
                return false;
            }
        }
        return true;
    }

    private char[] getColumn(int col) {
        char[] column = new char[boardSize];
        for (int i = 0; i < boardSize; i++) {
            column[i] = board[i][col];
        }
        return column;
    }

    private char[] getDiagonal(boolean mainDiagonal) {
        char[] diagonal = new char[boardSize];
        for (int i = 0; i < boardSize; i++) {
            diagonal[i] = mainDiagonal ? board[i][i] : board[i][boardSize - 1 - i];
        }
        return diagonal;
    }
}
