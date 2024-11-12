package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (isLegalBoardPosition(xCoordinate, yCoordinate) && pieces[xCoordinate][yCoordinate] == null ) {
            pawn.setChessBoard(this);
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pawn.setPieceColor(pieceColor);
            pieces[xCoordinate][yCoordinate] = pawn;
            System.out.println("Added pawn of color "+pieceColor+" to position ("+pawn.getXCoordinate()+","+pawn.getYCoordinate()+")");

        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            //System.out.println("Incorrect positions. Pawn cannot be added");
            System.out.println("Pawn cannot be added to position ("+xCoordinate+","+yCoordinate+")");
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if (xCoordinate < 0 || yCoordinate < 0) {
            System.out.println("None of the coordinates can have a negative value. The coordinates must have positive values.");
            return false;
        } else if (xCoordinate >= ChessBoard.BOARD_WIDTH || yCoordinate >= ChessBoard.BOARD_HEIGHT) {
            System.out.println("The coordinates can not be outside the chess board limit. The coordinates must be " +
                    "in the open range ("+ChessBoard.BOARD_WIDTH+","+ChessBoard.BOARD_HEIGHT+")");
            return false;
        } else {
            return true;
        }
    }
}
