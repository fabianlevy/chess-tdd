package org.digitalstack.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    public void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if(chessBoard.isLegalBoardPosition(newX,newY)){
            if(pieceColor==PieceColor.BLACK) /// starts at row 0
            {
                if (movementType.equals(MovementType.MOVE) && chessBoard.getPieces()[newX][newY] == null) {
                    if (newY == yCoordinate - 1 && newX== xCoordinate) {
                        xCoordinate = newX;
                        yCoordinate = newY;
                        System.out.println("Moved black pawn to (" + newX + ", " + newY + ")");
                    } else {
                        System.out.println("Invalid move");
                    }
                } else if (movementType.equals(MovementType.CAPTURE) && chessBoard.getPieces()[newX][newY].pieceColor == PieceColor.WHITE) {
                    if (newY == yCoordinate - 1 && Math.abs(newX - xCoordinate) == 1) {
                        xCoordinate = newX;
                        yCoordinate = newY;
                        System.out.println("Black piece captured a white one at position ");
                    }else{
                        System.out.println("Invalid capture");
                    }
                }
            } else if (pieceColor==PieceColor.WHITE) { ///start ar row 6
                if (movementType.equals(MovementType.MOVE) && chessBoard.getPieces()[newX][newY] == null) {
                    if (newY == yCoordinate + 1 && newX == xCoordinate) {
                        xCoordinate = newX;
                        yCoordinate = newY;
                        System.out.println("Moved white pawn to (" + newX + ", " + newY + ")");
                    } else {
                        System.out.println("Invalid move");
                    }
                } else if (movementType.equals(MovementType.CAPTURE) && chessBoard.getPieces()[newX][newY].pieceColor == PieceColor.BLACK) {
                    if (newY == yCoordinate + 1 && Math.abs(newX - xCoordinate) == 1) {
                        xCoordinate = newX;
                        yCoordinate = newY;
                        System.out.println("White piece captured a black one at position ");
                    }else{
                        System.out.println("Invalid capture");
                    }
                }
            }

        }
       // throw new UnsupportedOperationException("Need to implement Pawn.move()") ;
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}
