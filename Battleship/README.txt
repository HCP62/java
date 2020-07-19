README

How to run this program

You have to have all 5 programs within the same folder anywhere on your computer
This program runs from Battleship.java and is a battleship game using ASCII graphics in the run window. I used Apache Netbeans 11.2 to write this code, so it is advised that you place this entire package in
NetBeans in path C:\Users\<user name>\Documents\NetBeansProjects\<project name>\src\main\java
I also recommend you use NetBeans to run this code as it just makes life easier.

How to Play:

When the program runs for the first time, you will be shown a 10x10 board. All ships are a set size, 3. If you're looking to change the code up to maybe have a bigger board and bigger ships, go to Shipboard.java
You will be asked to choose a row number and a column number (ranging from 0 to 9), along with whether you would like it to be horizontal or vertical. Just note that horizontal only places 2 pieces to the left of the
coordinate you give as an input, while vertical places 2 pieces down from the give coordinate. You place 3 ships and then the second player places 3 ships. as soon as that happens you are sent to Guessboard, where you
will guess a location. If you hit water, it will appear on your Guessboard as an "O". If you hit something, then it will appear as an "X". Your Guessboard is a separate board that is shown below the Shipboard. If you hit
someone, it will show up as an "X" on both your Guessboard and their Shipboard, and vice versa. As basic rules of Battleship go, first one to destroy all of the other person's ship is the winner.