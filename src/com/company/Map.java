package com.company;

import java.util.ArrayList;

/**
 * This class represents the main map of the game.
 * @author Leili
 */
public class Map {
    private char[][] map; //a 2D char array represents the map
    private ArrayList<Stone> stones; //an ArrayList of all the stones

    /**
     * Creates a new Map.
     */
    public Map(){
        this.map=new char[6][6];
        setMap();
        this.stones=new ArrayList<>();
    }

    /**
     * Sets the map of the game.(sets all the places to 0)
     */
    public void setMap(){
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                map[i][j]='0';
            }
        }
    }

    /**
     * Updates the map of the game.
     * It will check all the stones in stones ArrayList and place their char in their right place in the map.
     */
    public  void updateMap(){
        setMap(); //first set all the places to 0
        for(Stone stone:stones){
            map[stone.getRow()][stone.getColumn()]=stone.getType();
        }

    }

    /**
     * Prints the map of the game.
     */
    public void printMap(){
        int k=0;
        for(int i=0;i<3;i++){
            k=0;
            for(int j=0;j<6;j++){
                if(map[i][j]=='\u25CF'){
                    System.out.print("\033[0;31m\u25CF  ");
                    System.out.print("\033[0m");
                }
                else if(map[i][j]=='0'){
                   System.out.print("\033[0;36m0  ");
                   System.out.print("\033[0m");
                }
                else{
                    System.out.print(map[i][j]+"  ");
                }
                k++;
                if(k==3){
                    System.out.print("\033[0;33m|  ");
                    System.out.print("\033[0m");
                }
            }
            System.out.println();
        }
        System.out.println("\033[0;33m-------------------");
        System.out.print("\033[0m");
        k=0;
        for(int i=3;i<6;i++){
            k=0;
            for(int j=0;j<6;j++){
                if(map[i][j]=='\u25CF'){
                    System.out.print("\033[0;31m\u25CF  ");
                    System.out.print("\033[0m");
                }
                else if(map[i][j]=='0'){
                    System.out.print("\033[0;36m0  ");
                    System.out.print("\033[0m");
                }
                else{
                    System.out.print(map[i][j]+"  ");
                }
                k++;
                if(k==3){
                    System.out.print("\033[0;33m|  ");
                    System.out.print("\033[0m");
                }
            }
            System.out.println();
        }
    }

    /**
     * Adds a new stone to the stones ArrayList.
     * @param stoneToAdd a new stone
     */
    public void addStone(Stone stoneToAdd){
        stones.add(stoneToAdd);
    }

    /**
     * Checks that the map is full or not.
     * @return true or false
     */
    public  boolean isFull(){
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(map[i][j]=='0'){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the char in the given place.
     * @param row the row number
     * @param column the column number
     * @return a char in the given place
     */
    public char returnChar(int row,int column){
        return map[row][column];
    }

    /**
     * Gets the stones ArrayList
     * @return stones field
     */
    public ArrayList<Stone> getStones() {
        return stones;
    }
}
