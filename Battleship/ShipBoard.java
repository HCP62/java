/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Battleship;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author ameya
 */
/**
 * A ~ means empty water, a O means a ship, and an Row means a hit ship
 * @author ameya
 */
public class ShipBoard{
    public String[][] board;
   
    
    public ShipBoard(){
        placeShips();
    }
    
    private void placeShips(){
        Scanner reader = new Scanner(System.in);
        initBoard();
        int shipsPlaced = 0;
        int r;
        int c;
        while(shipsPlaced != Battleship.SHIPS){  
            print();
            System.out.println("Row coord: ");
            String row = reader.next();
            System.out.println("Columns coord: ");
            String column = reader.next();
            try{
                r = Integer.parseInt(row);
                c = Integer.parseInt(column);
            }
            catch(Exception e){
                System.out.println("That's not a number!");
                continue;
            }          
            System.out.print("Horizontal or Vertical (H or V)? "); 
            String direction = reader.next();
            if(validPlacement(r, c, direction)){ //validPlacement prints proper error info if applicable
                placeShip(r, c, direction);
                shipsPlaced++;
                System.out.println("Ship placed! (" + shipsPlaced + "/" + Battleship.SHIPS + ")");
            }   
        }       
    }
    
    /*
    Checks the following conditions:
        1. Ensure that direction is either "H" or "V"
        2. Ensure that the entire ship is in bounds
        3. Ensures that the ship is not going to overlap with any previously placed ship    
    */
    private boolean validPlacement(int x, int y, String direction){
        
        return validString(direction) && validInt(x,y, direction) && noOverlap(x,y,direction);
        
    }
    
    
    
    private boolean validString(String str){
        
        if (str.equals("H") || str.contains("V")){
            return true;
        }
        else{
            System.out.println("Invalid direction");
            return false;
        }
        
    }
    /**
     * 
     * @param x only go downwards
     * @param y only go right
     * @param direction
     * @return 
     */
    private boolean validInt(int x, int y, String direction){   
        if (direction.equals("H")){
            for (int i = 0; i < Battleship.SIZE; i++){
                if(!inBounds(x, y+i)){
                    System.out.println("Out of bounds");
                    return false;
                }
            }
        }
        if (direction.equals("V")){
            for (int i = 0; i < Battleship.SIZE; i++){
                if(!inBounds(x+i, y)){
                    System.out.println("Out of bounds");
                    return false;
                }
            }
        }        
        return true;
    }
    
    private boolean inBounds(int x, int y){
        
        return x < Battleship.ROWS && y < Battleship.COLUMNS;
        
    }
    
    private boolean noOverlap(int x, int y, String direction){
        
        for (int i = 0; i < Battleship.SIZE; i++){
            if (direction.equals("V")){
                if (board[x+i][y].equals("O")){
                    System.out.println("Overlaps a previously placed ship");
                    return false;
                }
            }
            if (direction.equals("H")){
                if (board[x][y+i].equals("O")){
                    System.out.println("Overlaps a previously placed ship");
                    return false;
                }
            }
            
        }
        return true;
        
    }
    
    private void placeShip(int x, int y, String direction){
        
        if (direction.equals("H")){
            for (int i = 0; i < Battleship.SIZE; i++){
                board[x][y + i] = "O";
                
            }
        }
        else if(direction.equals("V")){
            for (int j = 0; j < Battleship.SIZE; j++){
                board[x+j][y] = "O";
            }
        }
        
    }
    
    private void initBoard(){
        board = new String[Battleship.ROWS + 1][Battleship.COLUMNS + 1];
        // fill with ~
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = "~";
            }
        }
    }
    
    public void print(){
        System.out.println("Ship Board");   
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
    
    public boolean processG(Guess g){
        
        if (board[g.r][g.c].equals("O")){
            board[g.r][g.c] = "X";
            return true;
        }
        return false;
        
    }
    
}
