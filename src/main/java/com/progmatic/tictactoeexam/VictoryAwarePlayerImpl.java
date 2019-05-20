/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progmatic.tictactoeexam;

import com.progmatic.tictactoeexam.enums.PlayerType;
import com.progmatic.tictactoeexam.exceptions.CellException;
import com.progmatic.tictactoeexam.interfaces.AbstractPlayer;
import com.progmatic.tictactoeexam.interfaces.Board;
import java.util.*;

/**
 *
 * @author imaginifer
 */
public class VictoryAwarePlayerImpl extends AbstractPlayer{

    public VictoryAwarePlayerImpl(PlayerType p) {
        super(p);
    }

    @Override
    public Cell nextMove(Board b) {
        List<Cell> x = b.emptyCells();
        if(x.isEmpty()){
            return null;
        }
        try {
            for (Cell cell : x) {
                if((cell.getRow()==1 
                        && b.getCell(0, cell.getCol())==myType
                        && b.getCell(2, cell.getCol())==myType)
                        || (cell.getRow()==0
                        && b.getCell(1, cell.getCol())==myType
                        && b.getCell(2, cell.getCol())==myType)
                        || (cell.getRow()==2
                        && b.getCell(0, cell.getCol())==myType
                        && b.getCell(1, cell.getCol())==myType)
                        || (cell.getCol()==0
                        && b.getCell(cell.getRow(), 1)==myType
                        && b.getCell(cell.getRow(), 2)==myType)
                        || (cell.getCol()==1
                        && b.getCell(cell.getRow(), 0)==myType
                        && b.getCell(cell.getRow(), 1)==myType)
                        || (cell.getCol()==2
                        && b.getCell(cell.getRow(), 1)==myType
                        && b.getCell(cell.getRow(), 0)==myType)
                        || (cell.getCol()==1 && cell.getRow()==1
                        && b.getCell(0, 0)==myType
                        && b.getCell(2, 2)==myType)
                        || (cell.getCol()==1 && cell.getRow()==1
                        && b.getCell(0, 2)==myType
                        && b.getCell(2, 0)==myType)
                        || (cell.getCol()==0 && cell.getRow()==0
                        && b.getCell(1, 1)==myType
                        && b.getCell(2, 2)==myType)
                        || (cell.getCol()==2 && cell.getRow()==2
                        && b.getCell(0, 0)==myType
                        && b.getCell(1, 1)==myType)
                        || (cell.getCol()==2 && cell.getRow()==0
                        && b.getCell(1, 1)==myType
                        && b.getCell(2, 0)==myType)
                        || (cell.getCol()==0 && cell.getRow()==2
                        && b.getCell(1, 1)==myType
                        && b.getCell(0, 2)==myType)){
                    return new Cell(cell.getRow(), cell.getCol(), myType);
                } 
            }
            for (Cell cell : x) {
                if((cell.getCol()==0 || cell.getCol()==2) 
                        && b.getCell(cell.getRow(), 1)==myType
                        || (cell.getRow()==0 || cell.getRow()==2)
                        && b.getCell(1, cell.getCol())==myType
                        || cell.getCol()==1 
                        && (b.getCell(cell.getRow(), 0)==myType
                        || b.getCell(cell.getRow(), 2)==myType)
                        || cell.getRow()==1 
                        && (b.getCell(0, cell.getCol())==myType
                        || b.getCell(2, cell.getCol())==myType)){
                    return new Cell(cell.getRow(), cell.getCol(), myType);
                }
            }
        } catch (CellException e) {
            e.getMessage();
        }
        return new Cell(x.get(0).getRow(), x.get(0).getCol(), myType);
    }
    
}
