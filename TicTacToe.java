import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) throws Exception{
        char[][] board = new char[3][3];
        initializeBoard(board);
        giveAdditionalSpace();
        printBoard(board);
        giveAdditionalSpace();
        char Player = 'X';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Character from X and O: ");
        while(true) {
            char P = scanner.next().charAt(0);
            if(P == 'x' || P == 'o') P = (char)(P - 32);
            if(P == 'X' || P == 'O') {
                Player = P;
                break;
            }else {
                System.out.println("Invalid Character");
            }
        }
        while(true) {
            System.out.println("Enter the coordinates of Player " +Player+": ");
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                if(row > 2 || col > 2) { System.out.println("Invalid Coordinates"); continue;}
                else if(board[row][col] != ' ') { System.out.println("Already Occupied"); continue;}
                else board[row][col] = Player;
            }catch(Exception e) {
                System.out.println("Invalid input. Please give integer between 0 and 2");
            }
            giveAdditionalSpace();
            printBoard(board);
            giveAdditionalSpace();
            if(checkWinner(board,Player)) {
                System.out.println("-------------------------Winner of the game is Player : "+Player+"-------------------------\n\n\n");
                break;
            }else if(!checkEmpty(board)) {
                System.out.println("Match Draw");
                break;
            }
            Player = (Player == 'X') ? 'O' : 'X';
        }
        scanner.close();
    }
    private static boolean checkWinner(char[][] board,char Player) {
        if(board[0][0] == Player && board[1][1] == Player && board[2][2] == Player) return true;
        if(board[0][2] == Player && board[1][1] == Player && board[2][0] == Player) return true;
        for(int i=0;i<board.length;i++) {
            if(board[0][i] == Player && board[1][i] == Player && board[2][i] == Player)
                return true;
            else if(board[i][0] == Player && board[i][1] == Player && board[i][2] == Player)
                return true;
        }
        return false;
    }
    private static void giveAdditionalSpace() {
        System.out.println("\n\n");
    }
    private static boolean checkEmpty(char[][] board) {
        for(char[] row: board) {
            for(char col: row) {
                if(col == ' ') return true;
            }
        }
        return false;
    }
    private static void initializeBoard(char[][] board) {
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++) {
                board[row][col] = ' ';
            }
        }
    }
    private static void printBoard(char[][] board) {
        System.out.println("--------------TicTacToe----------------\n\n");
        for(int row=0;row<board.length;row++) {
            System.out.print("\t\t\t\t\t");
            for(int col=0;col<board[row].length;col++) {
                System.out.print(board[row][col]);
                if(col < board[row].length-1 && row < board.length-1) System.out.print("_|_");
                else if(row == board.length-1 && col < board[row].length-1) System.out.print(" | ");
            }
            System.out.println();
        }
    }
}