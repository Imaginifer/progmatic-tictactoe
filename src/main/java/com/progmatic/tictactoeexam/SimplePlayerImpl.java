/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progmatic.tictactoeexam;

import com.progmatic.tictactoeexam.enums.PlayerType;
import com.progmatic.tictactoeexam.interfaces.AbstractPlayer;
import com.progmatic.tictactoeexam.interfaces.Board;
import java.util.*;

/**
 *
 * @author imaginifer
 */
public class SimplePlayerImpl extends AbstractPlayer{

    public SimplePlayerImpl(PlayerType p) {
        super(p);
    }
    
    @Override
    public Cell nextMove(Board b) {
        List<Cell> x = b.emptyCells();
        if(x.isEmpty()){
            return null;
        }
        
        return new Cell(x.get(0).getRow(), x.get(0).getCol(), myType);
    }
    
}
