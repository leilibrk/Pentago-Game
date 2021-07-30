package com.company;

/**
 * This program represents the Pentago game.
 * @author Leili
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Pentago game! The red disks are shown with \033[0;31m\u25CF\033[0m and the black disks are shown with \u25CB! ");
        System.out.println("Note: if your terminal's background is white, the black disks turns to white :)))");
        Map map=new Map(); //the main map
        map.printMap(); //prints the map

        //random initializing stones type for players
        double x=Math.random();
        char a;
        char b;
        if(x>0.5){
            a='\u25CF';
            b='\u25CB';
        }
        else{
            a='\u25CB';
            b='\u25CF';
        }
        Player player1=new Player(a,map); //the first player
        Player player2=new Player(b,map); //the second player

        while (true){
            System.out.println("Player 1 turn: ");
            player1.playerTurn(); //first player's turn
            if(endGame(player1,player2,map)){
                //the game is over.
                break;
            }
            System.out.println("Player 2 turn: ");
            player2.playerTurn(); //second player's turn
            if(endGame(player1,player2,map)){
                //the game is over.
                break;
            }
        }
    }

    /**
     * Checks that the game is over or not.
     * If both players have at least 5 stones in a vertical,horizontal or diagonal row, both of them
     * win the game and the game is over.
     * If one of the players has at least 5 stones in a vertical,horizontal or diagonal row, he/she wins
     * the game and the game is over.
     * If the map is full,either no one has won the game yet,the game is over with no winners.
     * @param player1 the first player
     * @param player2 the second player
     * @param map the main map
     * @return true or false
     */
    public static boolean endGame(Player player1,Player player2,Map map){
        if(player1.checkStones() && player2.checkStones()){
            System.out.println("Game is finished!Both of the players are the winners of the game!");
            return true;
        }
        if(player1.checkStones()){
            System.out.println("Game is finished!Player 1 is the winner!");
            return true;
        }
        if(player2.checkStones()){
            System.out.println("Game is finished!Player 2 is the winner!");
            return true;
        }
        if(map.isFull()){
            System.out.println("Game is finished with no winners!");
            return true;
        }
        return false;
    }


}
