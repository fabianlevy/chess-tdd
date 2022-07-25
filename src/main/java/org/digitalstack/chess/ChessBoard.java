package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;
    private int blackPawns;
    private int whitePawns;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH+1][BOARD_HEIGHT+1];
        blackPawns = 0;
        whitePawns = 0;
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if(pieces[xCoordinate][yCoordinate] == null && isLegalBoardPosition(xCoordinate, yCoordinate) && blackPawns < 7 && whitePawns < 7 ) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pawn.setPieceColor(pieceColor);
            if(PieceColor.BLACK.equals(pieceColor)){
                blackPawns++;
            } else {
                whitePawns++;
            }
            pieces[xCoordinate][yCoordinate] = pawn;

        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            pawn.setPieceColor(pieceColor);
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= 0 && xCoordinate <= BOARD_WIDTH && yCoordinate >= 0 && yCoordinate <= BOARD_HEIGHT;    }
}
