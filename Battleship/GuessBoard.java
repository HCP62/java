/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Battleship;
import java.util.*;
/**
 *
 * @author ameya
 */
public class GuessBoard {
   String[][] board;

    public GuessBoard(){
        board = new String[Battleship.ROWS][Battleship.COLUMNS];
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[r].length; c++){               
                board[r][c] = "~";               
            }
        }       
    }
    
    public void print(){
        System.out.println("GuessBoard");
        for (int i = 0; i < board.length; i++){
            String row = "";
            for(int j = 0; j < board[i].length; j++){
                row += (board[i][j] + " ");
            }
            System.out.println(row);
        } 
        System.out.println("");
    }
    
    public void set(int r, int c, String s){
        board[r][c] = s;
    }
    
    public Guess makeGuess(){
        Scanner reader = new Scanner(System.in);
        System.out.print("Guess a Row: ");
        String row = reader.next();
        System.out.print("Guess a Column: ");
        String column = reader.next();
        
        if (isValid(row, column)){
            return new Guess(Integer.parseInt(row), Integer.parseInt(column));
        }
        return makeGuess();
        
    }
    
    private boolean isValid(String row, String column){
        
        return areNumbers(row, column) && newGuess(row, column) && inBounds(row, column);
        
    }
    
    private boolean areNumbers(String row, String column){
        
        
            try{
              int r = Integer.parseInt(row);
              int c = Integer.parseInt(column);
              return true;
            }
            catch(Exception e){
                System.out.println("That's not a number!");
                return false;
            }
    }
    
    private boolean inBounds(String x, String y){
        
        int r = Integer.parseInt(x);
        int c = Integer.parseInt(y);
        
        if (r < Battleship.ROWS && c < Battleship.COLUMNS){
            return true;
        }
        else{
            System.out.println("Not in Bounds of the Board");
            return false;
        }
        
    }
    
    private boolean newGuess(String row, String column){
        
        if(!(board[Integer.parseInt(row)][Integer.parseInt(column)].equals("~"))){
            
            System.out.println("You already guessed here");
            return false;
            
        }
        return true;
        
    }
      
}
