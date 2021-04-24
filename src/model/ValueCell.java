package model;

public class ValueCell extends Cell {
    int value;
    int userValue;

    public ValueCell(int value, int rowCoord, int colCoord) {
        super(rowCoord, colCoord);
        this.value = value;
        this.type = "value";
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public int getUserValue() {
        return userValue;
    }

    @Override
    public void setUserValue(int userValue) {
        this.userValue = userValue;
    }

    @Override
    public boolean correct() {
        return this.userValue == this.value;
    }
}
