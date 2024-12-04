package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (!isLegalBoardPosition(xCoordinate, yCoordinate)) {
            setPawnToInvalidPosition(pawn);
            return;
        }

        if (pieces[xCoordinate][yCoordinate] != null) {
            setPawnToInvalidPosition(pawn);
            return;
        }

        pieces[xCoordinate][yCoordinate] = pawn;
        pawn.setXCoordinate(xCoordinate);
        pawn.setYCoordinate(yCoordinate);
        pawn.setChessBoard(this);
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if (xCoordinate < 0 || xCoordinate >= BOARD_WIDTH) {
            return false;
        }
        if (yCoordinate < 0 || yCoordinate >= BOARD_HEIGHT) {
            return false;
        }
        return true;
    }

    private void setPawnToInvalidPosition(Pawn pawn) {
        pawn.setXCoordinate(-1);
        pawn.setYCoordinate(-1);
    }
}
