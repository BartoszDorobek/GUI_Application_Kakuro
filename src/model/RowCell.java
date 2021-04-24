package model;

public class RowCell extends Cell {
    int rowSum;

    public RowCell(int rowSum, int rowCoord, int colCoord) {
        super(rowCoord, colCoord);
        this.rowSum = rowSum;
        this.type = "row";
    }

    @Override
    public int getRowSum() {
        return rowSum;
    }
}
