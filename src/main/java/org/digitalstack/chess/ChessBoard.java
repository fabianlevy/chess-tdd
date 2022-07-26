package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;
    static int andrei;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        throw new UnsupportedOperationException("Need to implement ChessBoard.add()");
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
    }
}
