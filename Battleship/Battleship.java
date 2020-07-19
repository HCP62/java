/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juni;
import java.util.*;
/**
 *
 * @author ameya
 */
public class Battleship {
    /**
     * Print out the x in whichever spot the user chooses using a Scanner
     * Simulate a game in the console window
     * 
     */
    public Player player1;
    public Player player2;
    public Player winner; //default of null
    public static final int ROWS = 10;
    public static final int COLUMNS = 10;
    public static final int SIZE = 3;
    public static final int SHIPS = 3;
    
   public Battleship(){
       System.out.println("Setting up player 1: ");
       player1 = new Player("1");
       System.out.println("Setting up player 2: ");
       player2 = new Player("2");
       playGame(player1, player2);  
   }
   
   private void playGame(Player p1, Player p2){
       int turn = 1; 
       while(winner == null){
           if (turn % 2 == 1)
               takeTurn(p1, p2.shipBoard);
           else if (turn % 2 == 0)
               takeTurn(p2, p1.shipBoard);
           turn++;
       }
       finishGame();
   }
   
   private void finishGame(){
       System.out.println("Congratulations " + winner.name + ", you win");
   }
   
   
   private void takeTurn(Player p, ShipBoard sb){
       
       p.shipBoard.print();
       p.guessBoard.print();
       
       Guess g = p.guessBoard.makeGuess();
       
       if (sb.processG(g)){
           System.out.println("You hit your opponent!");
           p.guessBoard.set(g.r, g.c, "X");
       }
       else{
           System.out.println("You missed!");
           p.guessBoard.set(g.r,g.c, "|");
       }
   }
   
   
   public static void main(String[] args){
       Battleship game = new Battleship();      
   }
       
}





