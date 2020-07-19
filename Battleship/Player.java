/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juni;

/**
 *
 * @author ameya
 */
public class Player{
    public ShipBoard shipBoard;
    public GuessBoard guessBoard;
    public String name;
    
    
    public Player(String name){
        this.name = name;
        guessBoard = new GuessBoard();
        shipBoard = new ShipBoard();
    }
}
