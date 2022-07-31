package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;


    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {

        pawn.setPieceColor(pieceColor);

        if(isEmpty(xCoordinate,yCoordinate) && isLegalBoardPosition(xCoordinate,yCoordinate)){
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate]=pawn;

        }else{
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    private boolean isEmpty(int xCoordinate,int yCoordinate){return this.pieces[xCoordinate][yCoordinate]== null;}

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (xCoordinate <=7 && xCoordinate>=0) && (yCoordinate <=7 && yCoordinate >=0);
    }
}
