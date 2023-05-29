package org.digitalstack.chess;

import java.util.Arrays;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];

    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
       //the presumption that the piece does not exist and we need to add it
        boolean mustMove = false;

        //verify if the piece exist
           if (pieces[pawn.getXCoordinate()][pawn.getYCoordinate()] == pawn)
           {
               //the piece exist
               mustMove = true;

               //verify if the new position is empty
               if (pieces[xCoordinate][yCoordinate] == null)
               {
                   //the new position is empty
                   // we can move the piece and the piece will be removed from the current position
                   pieces[pawn.getXCoordinate()][pawn.getYCoordinate()] = null;
               }
           }

          //if is a legal board position and the new position is empty we add/move the piece
           if (this.isLegalBoardPosition(xCoordinate,yCoordinate) && pieces[xCoordinate][yCoordinate] == null ) {
               pawn.setChessBoard(this);
               pawn.setXCoordinate(xCoordinate);
               pawn.setYCoordinate(yCoordinate);
               this.pieces[xCoordinate][yCoordinate] = pawn;
           }
           //if the position isn't empty or the position is illegal we will not put the pawn on the table
           // if the pawn should be moved but the conditions to move was not satisfied, the pawn it remains on the same position
        // if the pawn should be added but the conditions to move was not satisfied, the coordinates will be set to -1
           else if (!mustMove) {
               pawn.setXCoordinate(-1);
               pawn.setYCoordinate(-1);
           }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if(xCoordinate < 0 || yCoordinate < 0 || xCoordinate > 6 || yCoordinate > 6)
        {
            return false;
        }
        return true;
    }
}
