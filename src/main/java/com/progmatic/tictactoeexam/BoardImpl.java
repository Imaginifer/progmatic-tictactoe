/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progmatic.tictactoeexam;

import com.progmatic.tictactoeexam.enums.PlayerType;
import com.progmatic.tictactoeexam.exceptions.CellException;
import com.progmatic.tictactoeexam.interfaces.Board;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author imaginifer
 */
public class BoardImpl implements Board{
    
    private Cell[][] cells;
    
    public BoardImpl(){
        cells= new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j]=new Cell(i, j);
            }
        }
        
    }

    @Override
    public PlayerType getCell(int rowIdx, int colIdx) throws CellException {
        if( rowIdx<0 || colIdx<0 || rowIdx>2 || colIdx>2){
            throw new CellException(rowIdx, colIdx, "outside of board");
        }
        return cells[rowIdx][colIdx].getCellsPlayer();
    }

    @Override
    public void put(Cell cell) throws CellException {
        if( cell.getRow()<0 || cell.getCol()<0 || cell.getRow()>2 || cell.getCol()>2){
            throw new CellException(cell.getRow(), cell.getCol(), "outside of board");
        } else if (cells[cell.getRow()][cell.getCol()].getCellsPlayer()!=PlayerType.EMPTY){
            throw new CellException(cell.getRow(), cell.getCol(), "field occulpied");
        }
        cells[cell.getRow()][cell.getCol()].setCellsPlayer(cell.getCellsPlayer());
    }

    @Override
    public boolean hasWon(PlayerType p) {
        for (int i = 0; i < 3; i++) {
            if(cells[i][0].getCellsPlayer()==p
                    && cells[i][1].getCellsPlayer()==p
                    && cells[i][2].getCellsPlayer()==p){
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if(cells[0][j].getCellsPlayer()==p
                    && cells[1][j].getCellsPlayer()==p
                    && cells[2][j].getCellsPlayer()==p){
                return true;
            }
        }
        if(cells[0][0].getCellsPlayer()==p
                    && cells[1][1].getCellsPlayer()==p
                    && cells[2][2].getCellsPlayer()==p){
                return true;
            }
        if(cells[0][2].getCellsPlayer()==p
                    && cells[1][1].getCellsPlayer()==p
                    && cells[2][0].getCellsPlayer()==p){
                return true;
            }
        return false;
    }

    @Override
    public List<Cell> emptyCells() {
        List<Cell> empt=new ArrayList<>();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if(cells[i][j].getCellsPlayer()==PlayerType.EMPTY){
                    empt.add(cells[i][j]);
                }
            }
        }
        return empt;
    }
    
}
