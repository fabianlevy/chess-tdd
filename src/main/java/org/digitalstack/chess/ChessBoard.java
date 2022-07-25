package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (isLegalBoardPosition(xCoordinate,yCoordinate)) {
            Pawn currentPawn = pieces[xCoordinate][yCoordinate];
            if (xCoordinate != 6 || (currentPawn != null && currentPawn.getPieceColor() == pieceColor)) {
                pawn.setXCoordinate(-1);
                pawn.setYCoordinate(-1);
            }else {
                pawn.setXCoordinate(xCoordinate);
                pawn.setYCoordinate(yCoordinate);
                pieces[xCoordinate][yCoordinate] = pawn;
            }
        }else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (xCoordinate > 6 || xCoordinate < 0 || yCoordinate < 0 || yCoordinate > 6) ? false:true;
    }

    private void invalidatePawn(Pawn pawn)
    {
        pawn.setXCoordinate(-1);
        pawn.setYCoordinate(-1);
    }
}
