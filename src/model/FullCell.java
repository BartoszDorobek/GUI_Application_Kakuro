package model;

public class FullCell extends Cell {
    int rowSum;
    int columnSum;

    public FullCell(int rowSum, int columnSum, int rowCoord, int colCoord) {
        super(rowCoord, colCoord);
        this.rowSum = rowSum;
        this.columnSum = columnSum;
        this.type = "full";
    }

    @Override
    public int getRowSum() {
        return rowSum;
    }

    @Override
    public int getColumnSum() {
        return columnSum;
    }
}
