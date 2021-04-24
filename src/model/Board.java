package model;

public class Board {
    Cell[] cellList;
    private final int rowNumber; //liczba wierszy w tablicy
    private final int colNumber; //liczba kolumn w tablicy

    public Board(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.cellList = new Cell[rowNumber * colNumber]; //iloczyn wymiarów = liczba komórek w tablicy
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColNumber() {
        return colNumber;
    }
    /**metoda dodająca komórki do listy komórek*/
    public void addCell(Cell cell) {
        int rowCoord = cell.getRowCoord();
        int colCoord = cell.getColCoord();
        int position = rowCoord * this.colNumber + colCoord;//indeksacja
        assert this.cellList[position] == null : "This position is not empty";
        this.cellList[position] = cell;
    }
    /**metoda zwracająca komórkę po indeksach*/
    public Cell getCell(int rowCoord, int colCoord) {
        int position = rowCoord * this.colNumber + colCoord; //indeksacja
        return this.cellList[position];
    }

    /**metoda dodająca komórkę do planszy Board*/
    public void addCell(Cell c, int rowCoord, int colCoord){
        int position = rowCoord * this.colNumber + colCoord; //
        this.cellList[position] = c;
    }
}
