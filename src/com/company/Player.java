package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents a player.
 * @author Leili
 */
public class Player {
    private ArrayList<Stone> stones; //an ArrayList of player's stones
    private char stoneType; //the player's stone type
    private Map map; //the main map

    /**
     * Creates a new player with a given stone type and the main map of the game.
     * @param stoneType the type of stones
     * @param map the main map
     */
    public Player(char stoneType,Map map){
        this.stoneType=stoneType;
        this.map=map;
        this.stones=new ArrayList<>();
    }

    /**
     * Gets the player's stones
     * @return stones field
     */
    public ArrayList<Stone> getStones() {
        return stones;
    }

    /**
     * Implements the methods in each turn.
     */
    public void playerTurn(){
        newStone(); //scan a new stone
        map.updateMap(); //update the map
        map.printMap(); //print the map
        if(checkStones()){
            //The player wins the game.
            return;
        }
        rotateBlock(); //rotate a block
        map.updateMap(); //update the map
        map.printMap(); //print the map
    }

    /**
     * Scans the row number and the column number of the new stone which player wants to add and
     * adds the new stone to the list of player's stones and to the map.
     * If the inputs are invalid,it will print an error message and won't add the new stone.
     * If the position is invalid,it will print an error message and won't add the new stone.
     * If the selected place is occupied,it will print an error message and won't add the new stone.
     */
    public void newStone(){
        Scanner a=new Scanner(System.in);
        System.out.println("Enter the row and the column number of the place with a space between them.Exp: 0 2");
        String line=a.nextLine();
        if(line.length()!=3){
            System.out.println("Wrong input!");
            return;
        }
        int row=line.charAt(0)-48; //the row number
        int column=line.charAt(2)-48; //the column number
        if(row<0 || row>=6 || column<0 || column>=6){
            System.out.println("Wrong position!");
            return;
        }
        if(map.returnChar(row,column)!='0'){
            System.out.println("This place is occupied!");
            return;
        }
        Stone stone=new Stone(stoneType,row,column);
        stones.add(stone);
        map.addStone(stone);
    }

    /**
     * Rotates the selected block.
     * It will scan a number and a way for rotating and call the method for the selected block.
     * If the inputs are invalid, it will print an error message and won't rotate any block!
     */
    public void rotateBlock(){
        Scanner a=new Scanner(System.in);
        System.out.println("Enter the number of the block and the way you want to rotate it.Exp: 2 anti-clockwise or 2 clockwise");
        String line=a.nextLine();
        int block=line.charAt(0)-48; //the block number
        String s[]=line.split(" ");
        if(s.length!=2){
            System.out.println("wrong input!");
            return;
        }
        String direction=s[1];
        if(direction.equals("clockwise") || direction.equals("anti-clockwise")){
            if(block==1){
                rotateBlock1(direction,map.getStones());
                return;
            }
            if(block==2){
                rotateBlock2(direction,map.getStones());
                return;
            }
            if(block==3){
                rotateBlock3(direction,map.getStones());
                return;
            }
            if(block==4){
                rotateBlock4(direction,map.getStones());
                return;
            }
        }
        System.out.println("Wrong input!");
    }

    /**
     * Rotates block number 1 in the given direction.
     * @param direction the direction of rotating(clockwise or anti-clockwise)
     * @param allStones an ArrayList of all stones
     */
    public void rotateBlock1(String direction,ArrayList<Stone> allStones){
        for(Stone stone:allStones){
            if(stone.getBlockNumber()==1){
                displayPosition(stone);
                if(direction.equals("clockwise")){
                    if(stone.getColumn()==0){
                        stone.setColumn(2);
                    }
                    else if(stone.getColumn()==2){
                        stone.setColumn(0);
                    }
                }
                else if(direction.equals("anti-clockwise")){
                    if(stone.getRow()==0){
                        stone.setRow(2);
                    }
                    else if(stone.getRow()==2){
                        stone.setRow(0);
                    }
                }

            }
        }
    }
    /**
     * Rotates block number 2 in the given direction.
     * @param direction the direction of rotating(clockwise or anti-clockwise)
     * @param allStones an ArrayList of all stones
     */
    public void rotateBlock2(String direction,ArrayList<Stone> allStones){
        for(Stone stone:allStones){
            if(stone.getBlockNumber()==2){
                displayPosition(stone);
                if(direction.equals("anti-clockwise")){
                    if(stone.getColumn()==0){
                        stone.setColumn(3);
                    }
                    if(stone.getColumn()==1){
                        stone.setColumn(4);
                    }
                    if(stone.getColumn()==2){
                        stone.setColumn(5);
                    }
                    if(stone.getRow()==3){
                        stone.setRow(2);
                    }
                    if(stone.getRow()==4){
                        stone.setRow(1);
                    }
                    if(stone.getRow()==5){
                        stone.setRow(0);
                    }
                }
                else if(direction.equals("clockwise")){
                    if(stone.getRow()==3){
                        stone.setRow(0);
                    }
                    if(stone.getRow()==4){
                        stone.setRow(1);
                    }
                    if(stone.getRow()==5){
                        stone.setRow(2);
                    }
                    if(stone.getColumn()==2){
                        stone.setColumn(3);
                    }
                    if(stone.getColumn()==1){
                        stone.setColumn(4);
                    }
                    if(stone.getColumn()==0){
                        stone.setColumn(5);
                    }
                }

            }
        }
    }
    /**
     * Rotates block number 3 in the given direction.
     * @param direction the direction of rotating(clockwise or anti-clockwise)
     * @param allStones an ArrayList of all stones
     */
    public void rotateBlock3(String direction,ArrayList<Stone> allStones){
        for(Stone stone:allStones){
            if(stone.getBlockNumber()==3){
                displayPosition(stone);
                if(direction.equals("clockwise")){
                    if(stone.getColumn()==3){
                        stone.setColumn(2);
                    }
                    if(stone.getColumn()==4){
                        stone.setColumn(1);
                    }
                    if(stone.getColumn()==5){
                        stone.setColumn(0);
                    }
                    if(stone.getRow()==0){
                        stone.setRow(3);
                    }
                    if(stone.getRow()==1){
                        stone.setRow(4);
                    }
                    if(stone.getRow()==2){
                        stone.setRow(5);
                    }

                }
                else if(direction.equals("anti-clockwise")){
                    if(stone.getRow()==2){
                        stone.setRow(3);
                    }
                    if(stone.getRow()==1){
                        stone.setRow(4);
                    }
                    if(stone.getRow()==0){
                        stone.setRow(5);
                    }
                    if(stone.getColumn()==3){
                        stone.setColumn(0);
                    }
                    if(stone.getColumn()==4){
                        stone.setColumn(1);
                    }
                    if(stone.getColumn()==5){
                        stone.setColumn(2);
                    }
                }
            }
        }
    }
    /**
     * Rotates block number 4 in the given direction.
     * @param direction the direction of rotating(clockwise or anti-clockwise)
     * @param allStones an ArrayList of all stones
     */
    public void rotateBlock4(String direction,ArrayList<Stone> allStones){
        for(Stone stone:allStones){
            if(stone.getBlockNumber()==4){
                displayPosition(stone);
                if(direction.equals("clockwise")){
                    if(stone.getColumn()==3){
                        stone.setColumn(5);
                    }
                    else if(stone.getColumn()==5){
                        stone.setColumn(3);
                    }
                }
                else if(direction.equals("anti-clockwise")){
                    if(stone.getRow()==5){
                        stone.setRow(3);
                    }
                    else if(stone.getRow()==3){
                        stone.setRow(5);
                    }
                }
            }
        }
    }

    /**
     * Changes the row number to column number and the column number to row number.
     * @param stone a selected stone
     */
    public void displayPosition(Stone stone){
        int row=stone.getRow();
        int column=stone.getColumn();
        stone.setRow(column);
        stone.setColumn(row);
    }

    /**
     * Checks the stones of the player to see if the player wins the game or not.
     * A player wins by getting five or more of their stones in a vertical,horizontal or diagonal row.
     * Either before or after the rotation.(explanation from wikipedia)
     * @return true or false
     */
    public boolean checkStones(){
        int counter;
        for(Stone main_stone:stones){
            //set a stone of the stones ArrayList as the"main_stone"
            for(Stone stone:stones){
                //set another stone to "stone"
                counter=1;
                if(stone.equals(main_stone)){
                    //the stone is same as main_stone
                    continue;
                }
                if(main_stone.getColumn()==stone.getColumn() && Math.abs(main_stone.getRow()-stone.getRow())==1){
                    //two stones are in the same column, with distance of 1.
                    int row1=main_stone.getRow();
                    for(int i=row1+1;i<6;i++){
                        //it goes forward from the main_stone and count the number of stones from the same type.
                        if(map.returnChar(i,main_stone.getColumn())==stoneType){
                            counter++;
                        }
                        else{
                            break;
                        }
                    }

                    for(int i=row1-1;i>=0;i--){
                        //it goes backward from the main_Stone and count the stones from the same type.
                        if(map.returnChar(i,main_stone.getColumn())==stoneType){
                            counter++;
                        }
                        else{
                            break;
                        }
                    }
                    if(counter>=5){
                        //their are at least 5 stones in the same column.
                        return true;
                    }
                }
                counter=1;
                if(main_stone.getRow()==stone.getRow() && Math.abs(main_stone.getColumn()-stone.getColumn())==1){
                    //two stones are in the same row, with distance of 1.
                    int column1=main_stone.getColumn();
                    for(int j=column1+1;j<6;j++){
                        //it goes forward from the main_stone and count the number of stones from the same type.
                        if(map.returnChar(main_stone.getRow(),j)==stoneType){
                            counter++;
                        }
                        else{
                            break;
                        }
                    }
                    for(int j=column1-1;j>=0;j--){
                        //it goes backward from the main_Stone and count the stones from the same type.
                        if(map.returnChar(main_stone.getRow(),j)==stoneType){
                            counter++;
                        }
                        else{
                            break;
                        }
                    }
                    if(counter>=5){
                        //their are at least 5 stones in the same column.
                        return true;
                    }
                }

                if(Math.abs(main_stone.getColumn()-stone.getColumn())==Math.abs(main_stone.getRow()-stone.getRow()) && Math.pow(main_stone.getColumn()-stone.getColumn(),2)+Math.pow(main_stone.getRow()-stone.getRow(),2)==2){
                    //two stones are in the dame diameter, with the space of sqrt 2.
                    boolean a=main_stone.getRow()>stone.getRow() && main_stone.getColumn()>stone.getColumn();
                    boolean b=main_stone.getRow()<stone.getRow() && main_stone.getColumn()<stone.getColumn();
                    int row=main_stone.getRow();
                    int column=main_stone.getColumn();
                    if(a || b){
                        counter=1;
                        int i=row+1;
                        int j=column+1;
                        while(i<6 && j<6){
                            //it goes forward from the main_stone and count the number of stones from the same type.
                            if(map.returnChar(i,j)==stoneType){
                                counter++;
                            }
                            else{
                                break;
                            }
                            i++;
                            j++;
                        }
                        i=row-1;
                        j=column-1;
                        while(i>=0 && j>=0){
                            //it goes backward from the main_Stone and count the stones from the same type.
                            if(map.returnChar(i,j)==stoneType){
                                counter++;
                            }
                            else{
                                break;
                            }
                            i--;
                            j--;
                        }
                        if(counter>=5){
                            //their are at least 5 stones in the same diameter.
                            return true;
                        }
                    }

                    else{
                        counter=1;
                        int i=row-1;
                        int j=column+1;
                        while(i>=0 && j<6){
                            //it goes backward from the main_Stone and count the stones from the same type.
                            if(map.returnChar(i,j)==stoneType){
                                counter++;
                            }
                            else{
                                break;
                            }
                            i--;
                            j++;
                        }
                        i=row+1;
                        j=column-1;
                        while (i<6 && j>=0){
                            //it goes forward from the main_stone and count the number of stones from the same type.
                            if(map.returnChar(i,j)==stoneType){
                                counter++;
                            }
                            else{
                                break;
                            }
                            i++;
                            j--;
                        }
                        if(counter>=5){
                            //their are at least 5 stones in the same diameter.
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
