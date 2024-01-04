package org.digitalstack.chess;
public class Main {
    public static void main(String[] args) {
        ChessBoard testBoard = new ChessBoard();
        for (int i = 0; i < 10; i++) {

            Pawn whitePawn = new Pawn(PieceColor.WHITE);
            testBoard.add(whitePawn, i % ChessBoard.BOARD_WIDTH, 1);
            Pawn blackPawn = new Pawn(PieceColor.BLACK);
            testBoard.add(blackPawn, i % ChessBoard.BOARD_WIDTH, 5);
        }
        testBoard.printChessBoard();
        testBoard.getPawn(1, 1).move(MovementType.MOVE, 1, 2);
        testBoard.printChessBoard();
        testBoard.getPawn(1, 2).move(MovementType.MOVE, 1, 3);
        testBoard.printChessBoard();
        testBoard.getPawn(1, 3).move(MovementType.MOVE, 1, 4);
        testBoard.printChessBoard();
        testBoard.getPawn(1, 5).move(MovementType.MOVE, 1, 4);
        testBoard.printChessBoard();
        testBoard.getPawn(2, 5).move(MovementType.CAPTURE, 1, 4);
        testBoard.printChessBoard();
    }
}