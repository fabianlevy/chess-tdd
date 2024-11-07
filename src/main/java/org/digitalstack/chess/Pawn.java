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

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if ((movementType == MovementType.MOVE) && isLegalMove(newX, newY)) {
            chessBoard.getPieces()[yCoordinate][xCoordinate] = null;
            this.setYCoordinate(newY);
            chessBoard.getPieces()[newY][xCoordinate] = this;
        } else if ((movementType == MovementType.CAPTURE) && isLegalCapture(newX, newY)) {
            chessBoard.getPieces()[yCoordinate][xCoordinate] = null;
            this.setXCoordinate(newX);
            this.setYCoordinate(newY);
            chessBoard.getPieces()[newY][newX] = this;
        }
    }

    public boolean isLegalMove(int newX, int newY) {
        if (!chessBoard.isLegalBoardPosition(newX, newY)) {
            return false;
        }
        if ((chessBoard.getPieces()[newY][newX] == null) && (newX == this.xCoordinate)) {
            if (this.pieceColor == PieceColor.BLACK) {
                return (newY - this.yCoordinate) == -1;
            }
            if (this.pieceColor == PieceColor.WHITE) {
                return (newY - this.yCoordinate) == 1;
            }
        }
        return false;
    }

    public boolean isLegalCapture(int newX, int newY) {
        if (!chessBoard.isLegalBoardPosition(newX, newY)) {
            return false;
        }
        if ((chessBoard.getPieces()[newY][newX] != null) && (chessBoard.getPieces()[newY][newX].getPieceColor() != this.pieceColor)) {
            if (this.pieceColor == PieceColor.BLACK) {
                return (newY - this.yCoordinate == -1 && (newX - this.xCoordinate == 1 || newX - this.xCoordinate == -1));
            }
            if (this.pieceColor == PieceColor.WHITE) {
                return (newY - this.yCoordinate == 1 && (newX - this.xCoordinate == 1 || newX - this.xCoordinate == -1));
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}
