package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (xCoordinate < BOARD_WIDTH && pieces[xCoordinate][yCoordinate] == null) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        }

        else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }


//        throw new UnsupportedOperationException("Need to implement ChessBoard.add()");
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if(xCoordinate>7||yCoordinate>7) {
            return false;
        }

        if(xCoordinate<0||yCoordinate<0) {
            return false;
        }

        return true;

//        throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
    }
}
