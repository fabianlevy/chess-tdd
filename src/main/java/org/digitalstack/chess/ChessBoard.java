package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH + 1][BOARD_HEIGHT + 1];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if(pieceColor == PieceColor.BLACK && xCoordinate != 6){
            setIllegalCoordinates(pawn);
        } else if(pieceColor == PieceColor.WHITE && xCoordinate != 1){
            setIllegalCoordinates(pawn);
        } else if(pieces[xCoordinate][yCoordinate] != null){
            setIllegalCoordinates(pawn);
        } else {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        }
        //throw new UnsupportedOperationException("Need to implement ChessBoard.add()");
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= 0 && xCoordinate <= BOARD_WIDTH && yCoordinate >=0 && yCoordinate <= BOARD_HEIGHT;
        //throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
    }

    private void setIllegalCoordinates(Pawn pawn){
        pawn.setXCoordinate(-1);
        pawn.setYCoordinate(-1);
    }
}
