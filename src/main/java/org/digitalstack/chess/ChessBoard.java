package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        // check if we are inside the chessboard boundaries and not already occupied
        // and then place the pawn and set the coordinates and color for it
        if (isLegalBoardPosition(xCoordinate, yCoordinate) && pieces[xCoordinate][yCoordinate] == null ) {
            pieces[xCoordinate][yCoordinate] = pawn;
            pawn.setPieceColor(pieceColor);
            pawn.setChessBoard(this);
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
        } else { //  invalidate the pawn's coordinates
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }


    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        // check if we are inside the chessboard boundaries
        return (xCoordinate >= 0 && xCoordinate < BOARD_WIDTH) && (yCoordinate >= 0 && yCoordinate < BOARD_HEIGHT);
    }

    // checking the state of a specific position on the chessboard
    public Pawn getPieceAt(int x, int y) {
        if (isLegalBoardPosition(x, y)) {
            return pieces[x][y];
        }
        return null;
    }

}
