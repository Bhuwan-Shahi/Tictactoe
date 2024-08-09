import java.sql.*;
import java.util.Date;
import java.util.InputMismatchException;
import  java.util.Scanner;


public  class Tic {
   static int count;
    Tic(){
        this.count = 0;
    }


    private  static  final Scanner sc = new Scanner(System.in);
    private  char Player1_choice;
    private  char Player2_choice;
    private  final char [][] board = new  char[3][3];
    private boolean won = false;




//STARTING THE BOARD
    public  void Start(){
        try {
            System.out.println("Enter 1 to start:");
            int Start = sc.nextInt();
            if(Start!=1){
                System.out.println("Please Enter 1 to start!");
                Start();
            }
        }
        catch (InputMismatchException e){
            e.getMessage();
        }

    }
    //MAKING CHOOSE BETWEEN O AND X
    public  void SelectOX(){
        System.out.println("Enter 1 for O and 2 for X");
        int intchoice1 = sc.nextInt();
        if(intchoice1 == 1){
            Player1_choice = 'O';
            Player2_choice = 'X';
        } else if (intchoice1 ==2) {
            Player1_choice = 'X';
            Player2_choice = 'O';
        }
        else {
            System.out.println("Enter the valid choice!");
            SelectOX();
        }


    }
    //INITALISING THE BOARD WITH BLANKS
    public  void InitailBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] ='_';

            }
        }
    }
    //DISPLAYING THE INITIAL BOARD
    public  void DisplayBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }


//CHOOSING THE CURRENT POSITION AND MARKING ON THE BOARD FOR PALYER ONE
    public  void PlayeronecurrentChoice(){
        System.out.println("Player Enter your column and rows(For player one!):");
        int row = sc.nextInt();
        int col = sc.nextInt();

        if(board[row][col]== '_'){
            board[row][col] = Player1_choice;
        }else if (row > 2 && col >2){
            System.out.println("Brackets out of bound");
        }
        else {
            System.out.println("The spot is already taken!");
            PlayeronecurrentChoice();
        }

        DisplayBoard();


    }
    //CHOOSING THE CURRENT POSITION AND MARKING ON THE BOARD FOR PALYER TWO

    public  void PlayertwoCurrentChoice(){
        System.out.println("Player Enter your column and rows(For player two!):");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        if(board[rows][cols]== '_'){
            board[rows][cols] = Player2_choice;
        }
        else if (rows > 2 && cols >2){
            System.out.println("Brackets out of bound");
            
        }
        else {
            System.out.println("The spot is already taken!");
            PlayertwoCurrentChoice();
        }

        DisplayBoard();

    }


    public boolean fixed(char PublicChoice) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == PublicChoice && board[i][1] == PublicChoice && board[i][2] == PublicChoice) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == PublicChoice && board[1][j] == PublicChoice && board[2][j] == PublicChoice) {
                return true;
            }
        }
        if (board[0][0] == PublicChoice && board[1][1] == PublicChoice && board[2][2] == PublicChoice) {
            return true;
        }
        if (board[0][2] == PublicChoice && board[1][1] == PublicChoice && board[2][0] == PublicChoice) {
            return true;
        }
        return false;
    }
    public void over() {
        while (!won) {
            DisplayBoard();
            PlayeronecurrentChoice();
            if (fixed(Player1_choice)) {
                System.out.println("Player one won");
                count++;
                won = true;
                break;
            }
            PlayertwoCurrentChoice();
            if (fixed(Player2_choice)) {
                System.out.println("Player  two won");
                count ++;
                won = true;
                break;
            }
        }
    }

     
}