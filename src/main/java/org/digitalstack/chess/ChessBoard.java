package org.digitalstack.chess;


import java.util.Objects;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;
    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        this.isLegalBoardPosition(xCoordinate, yCoordinate);
        if(pawn != null){
            try {
                Pawn pawnTest = pieces[xCoordinate][yCoordinate];
                if(pawnTest != null){
                    pawn.setXCoordinate(-1);
                    pawn.setYCoordinate(-1);
                }
                else {
                    pawn.setXCoordinate(xCoordinate);
                    pawn.setYCoordinate(yCoordinate);
                    pieces[xCoordinate][yCoordinate] = pawn;
                }
            }catch (Exception e){
                pawn.setXCoordinate(-1);
                pawn.setYCoordinate(-1);
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
            if (xCoordinate < 0 || yCoordinate < 0) {
                System.out.println("Coordinates must not have a negative value.");
                return false;
            } else if (xCoordinate >= BOARD_WIDTH || yCoordinate >= BOARD_HEIGHT) {
                System.out.println("Coordinates must be in the limits of the chess board.");
                return false;
            } else {
                return true;
            }
    }
}
