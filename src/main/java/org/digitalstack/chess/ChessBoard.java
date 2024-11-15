package org.digitalstack.chess;

import static org.digitalstack.chess.PieceColor.BLACK;
import static org.digitalstack.chess.PieceColor.WHITE;

@SuppressWarnings("ALL")
public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    //1.check if the coordinates are game board.
    //2.check if there is already a piece at the position of the received coordinates.
    //3.if there is no piece, we place the pawn on the respective position.
    
    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        throw new UnsupportedOperationException("Need to implement ChessBoard.add()");
        if (isLegalBoardPosition(xCoordinate, yCoordinate) && pieces[xCoordinate][yCoordinate] == null) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        } else {
            {
                pawn.setXCoordinate(xCoordinate);
                pawn.setYCoordinate(yCoordinate);
                pieces[xCoordinate][yCoordinate] = pawn;
                if (pieceColor.equals(BLACK)) {
                    pawn.equals(BLACK);
                    pawn.setPieceColor(BLACK);
                } else {
                    pawn.setPieceColor(WHITE);
                }
            }
        }
    }




    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
        if(xCoordinate < 0 || yCoordinate < 0 || xCoordinate > 6 || yCoordinate > 6){
            return false;
        }
        return true;
    }
}
