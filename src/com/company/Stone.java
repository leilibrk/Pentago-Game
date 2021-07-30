package com.company;

/**
 * This class represent a stone.
 * @author Leili
 */
public class Stone {
    private char type; //the stone's type
    private int row; //the stone's row number
    private int column; //the stone's column number
    private int blockNumber; //the stone's block number

    /**
     * Creates a new stone with a given type,row number and column number
     * @param type stone's type
     * @param row stone's row number
     * @param column stone's column number
     */

    public Stone(char type,int row,int column){
        this.type=type;
        this.row=row;
        this.column=column;
        setBlockNumber();
    }

    /**
     * Gets the row number
     * @return row field
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column number
     * @return column field
     */
    public int getColumn() {
        return column;
    }

    /**
     * Gets the stone's type
     * @return type filed
     */
    public char getType() {
        return type;
    }
    /**
     * Gets the block number of the stone
     * @return blockNumber field
     */
    public int getBlockNumber() {
        return blockNumber;
    }
    /**
     * Sets the column number
     * @param column the column number
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Sets the row number
     * @param row the row number
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Sets the block number of the stone
     */
    public void setBlockNumber(){
        if(row<3 && column<3){
            this.blockNumber=1;
        }
        if(row<3 && column>=3){
            this.blockNumber=2;
        }
        if(row>=3 && column<3){
            this.blockNumber=3;
        }
        if(row>=3 && column>=3){
            this.blockNumber=4;
        }
    }

}
