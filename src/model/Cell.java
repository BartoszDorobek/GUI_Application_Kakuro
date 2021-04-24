package model;

public abstract class Cell {
    String type;
    int rowCoord;
    int colCoord;

    public Cell(int rowCoord, int colCoord) {
        this.rowCoord = rowCoord;
        this.colCoord = colCoord;
    }

    public String getType() {
        return type;
    }

    public int getRowCoord() {
        return rowCoord;
    }

    public int getColCoord() {
        return colCoord;
    }

    public int getColumnSum() {
        System.out.println("not implemented in Cell class");
        return -1;
    }

    public int getRowSum() {
        System.out.println("not implemented in Cell class");
        return -1;
    }

    public int getValue() {
        System.out.println("not implemented in Cell class");
        return -1;
    }

    public int getUserValue() {
        System.out.println("not implemented in Cell class");
        return -1;
    }

    public void setUserValue(int userValue) {
        System.out.println("not implemented in Cell class");
    }

    public boolean correct() {
        System.out.println("not implemented in Cell class");
        return false;
    }
}
