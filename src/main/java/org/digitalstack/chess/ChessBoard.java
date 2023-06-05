package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    public final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if(xCoordinate >= 0 && xCoordinate < 7 && yCoordinate >= 0 && yCoordinate < 7){
            if(pawn.getPieceColor() == pieceColor && pieces[xCoordinate][yCoordinate] == null){
                pawn.setXCoordinate(xCoordinate);
                pawn.setYCoordinate(yCoordinate);
                pieces[xCoordinate][yCoordinate] = new Pawn(pieceColor);
            }
            else{
                pawn.setXCoordinate(-1);
                pawn.setYCoordinate(-1);
            }
        }
        else{
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }


    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if (xCoordinate <= 7 && xCoordinate >= 0 && yCoordinate <= 7 && yCoordinate >= 0) {
            return true;
        }
        return false;
    }
}
