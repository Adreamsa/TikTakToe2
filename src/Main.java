import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Player player1 = new Player(answerName(), 'X');
        Player player2 = new Player(answerName(), 'Y');
        if (answerRules()){
            TicTacToeInverted game = new TicTacToeInverted(answerSize(), player1, player2);
            game.initializeGame();
        } else {
            TicTacToeNormal game = new TicTacToeNormal(answerSize(), player1, player2);

        }
    }

    public static boolean answerRules() {
        String rules = "";
        while (true) {
            System.out.println("¿Desea jugar con las reglas especiales?\nSi.\nNo.\n");
            rules = scan.next();
            if ("Si".equalsIgnoreCase(rules) || "s".equalsIgnoreCase(rules)) {
                return true;
            } else if ("No".equalsIgnoreCase(rules) || "n".equalsIgnoreCase(rules)) {
                return false;
            } else {
                System.out.println("Entrada no valida intente de nuevo");
                continue;
            }
        }
    }

    public static int answerSize() {
        while (true) {
            System.out.println("Seleccione tamaño del juego: \n1.- 3x3 \n2.- 4x4\n");
            String input = scan.next();
            if (input.equals("1") || input.equals("3")) {
                return 3;
            } else if (input.equals("2") || input.equals("4")) {
                return 4;
            } else {
                System.out.println("Entrada no válida, intenta de nuevo.");
            }
        }
    }

    public static String answerName(){
        System.out.println("Escribe tu nombre: ");
        return scan.next();
    }
}


