package model;

public class EmptyCell extends Cell {
    public EmptyCell(int rowCoord, int colCoord) {
        super(rowCoord, colCoord);
        this.type = "empty";
    }
}
