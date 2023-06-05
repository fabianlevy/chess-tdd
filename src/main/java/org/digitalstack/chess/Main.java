package org.digitalstack.chess;

public class Main {
    public static void main(String[] args) {


        Pawn pawn1 = new Pawn(2, 2, PieceColor.BLACK);
        Pawn inheritedPawn = new Pawn(pawn1, PieceColor.WHITE);
        Pawn pawn = new Pawn(PieceColor.BLACK);

        System.out.println(pawn.currentPositionAsString());
        System.out.println(pawn1.currentPositionAsString());
        System.out.println(inheritedPawn.currentPositionAsString());

        ChessBoard chessBoard = new ChessBoard();

        System.out.println(chessBoard.pieces[0][0]);
        chessBoard.add(pawn1, 1, 1, pawn1.getPieceColor());
        System.out.println(chessBoard.pieces[1][1]);
    }

}
