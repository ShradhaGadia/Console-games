import java.util.Random;
import java.util.Scanner;

public class tictac{
    
    public static void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void boarddisplay(char[][] board){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
               System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        delay();
        delay();
    }

    public static boolean finished(char[][] board,char winner){
        for(int i=0;i<board.length;i++){
            if(board[i][0]==winner && board[i][1]==winner && board[i][2]==winner)  //for rows
            return true;
        }
        for(int i=0;i<board.length;i++){
            if(board[0][i]==winner && board[1][i]==winner && board[2][i]==winner)  //for columns
            return true;
        }

        if(board[0][0]==winner && board[1][1]==winner && board[2][2]==winner)   //for diagonals
        return true;

        if(board[0][2]==winner && board[1][1]==winner && board[2][0]==winner)
        return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        char[][] board=new char[3][3];
        System.out.println("We are about to play TIC-TAC-TOE...");
        delay();
        System.out.print("Choose between X or O.Enter your choice: ");   //user selection of character to play with
        String user=s.next();
        char user_char=user.charAt(0);
        char comp_char;
        if(user_char=='X'){                                                                    //computer selection of other character
            comp_char='O';
        }
        else 
            comp_char='X';
        delay();
        System.out.println("You chose "+user_char +" & I chose "+comp_char);
        delay();
        boolean game_over=false;
        for(int i=0;i<3;i++){                                                          //initial empty board display..
            for(int j=0;j<3;j++){
               board[i][j]='_';
            }
        }
        while (game_over != true) {                                             //repeating until one of the player wins
            System.out.println("Enter your move->");
            delay();
            System.out.print("Enter row number: ");
            int x = s.nextInt();
            delay();
            System.out.print("Enter column number: ");
            int y = s.nextInt();
            delay();
            while (board[x][y] != '_') {                                           //repeating until player doesn't enter an empty place to play at
                System.out.println("Invalid move! Already filled position. Enter a new position.");
                delay();
                System.out.print("Enter row number: ");
                x = s.nextInt();
                delay();
                System.out.print("Enter column number: ");
                y = s.nextInt();
                delay();
            }
            board[x][y] = user_char;
            game_over = finished(board, user_char);                                 //checking if player won?
            if (game_over) {
                System.out.println("YOU WON!!");
                delay();
                break;
            }
            boarddisplay(board);
            System.out.println("My move->");
            Random random = new Random();
            int comp_x = random.nextInt(3);                                            //computer's move
            int comp_y = random.nextInt(3);
            while (board[comp_x][comp_y] != '_') {
                comp_x = random.nextInt(3);
                comp_y = random.nextInt(3);
            }
            board[comp_x][comp_y] = comp_char;
            game_over = finished(board, comp_char);
            if (game_over){
            System.out.println("I WON!!");
            delay();
            break;}
            boarddisplay(board);
        }        
        System.out.println("FINAL BOARD WAS ~>");                       //final look at the board
        boarddisplay(board);
    }
}