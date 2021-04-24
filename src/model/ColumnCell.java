package model;

public class ColumnCell extends Cell {
    int columnSum;

    public ColumnCell(int columnSum, int rowCoord, int colCoord) {
        super(rowCoord, colCoord);
        this.columnSum = columnSum;
        this.type = "column";
    }

    @Override
    public int getColumnSum() {
        return columnSum;
    }
}
