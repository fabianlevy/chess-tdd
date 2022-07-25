package org.digitalstack.chess;

import java.util.Arrays;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {

            int count = 0;
            for(int i = 0; i < 7; i++ )
                for(int j = 0; j < 7; j++ )
                    if(pieces[i][j] != null )
                        count ++;
            if(isLegalBoardPosition(xCoordinate, yCoordinate) && count < 7){
                if(pieces[xCoordinate][yCoordinate] == null){
                    pawn.setChessBoard(this);
                    pawn.setXCoordinate(xCoordinate);
                    pawn.setYCoordinate(yCoordinate);
                    pieces[xCoordinate][yCoordinate] = pawn;
                } else {
                    pawn.setXCoordinate(-1);
                    pawn.setYCoordinate(-1);
                }
            } else {
                pawn.setXCoordinate(-1);
                pawn.setYCoordinate(-1);
            }


     //   throw new UnsupportedOperationException("Need to implement ChessBoard.add()");
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= 0 && xCoordinate <= 7 && yCoordinate >= 0 && yCoordinate <= 7;
        //throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
    }
}
