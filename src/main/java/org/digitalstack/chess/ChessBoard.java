package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
       boolean isValidPosition = isLegalBoardPosition(xCoordinate, yCoordinate);
       pawn.setChessBoard(this);
       if(isValidPosition){
           if(yCoordinate <= 6){
               if(pieces[xCoordinate][yCoordinate] == null){
                   pawn.setYCoordinate(yCoordinate);
                   pawn.setXCoordinate(xCoordinate);
                   pieces[xCoordinate][yCoordinate] = pawn;
               }else{
                   setNegativePosition(pawn);
               }
           }else{
               setNegativePosition(pawn);
           }
       }else{
           setNegativePosition(pawn);
       }
        //throw new UnsupportedOperationException("Need to implement ChessBoard.add()");
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return 0<=xCoordinate && xCoordinate<=BOARD_WIDTH && 0<=yCoordinate && yCoordinate<=BOARD_HEIGHT;
        //throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
    }

    private void setNegativePosition(Pawn pawn){
        pawn.setXCoordinate(-1);
        pawn.setYCoordinate(-1);
    }
}
