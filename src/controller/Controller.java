package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Board;
import model.BoardReader;
import model.Cell;

public class Controller {

    int sceneWidth = 400;
    int sceneHeight = 300;
    int gridWidth = 300;
    int gridHeight = sceneHeight-10;
    private Board board;
    String mapNo;
    String fileName;
    String level;
    GridPane gridPane;

    @FXML
    private Button easyBtn;
    @FXML
    private Button mediumBtn;
    @FXML
    private Button hardBtn;
    @FXML
    private Button solveBtn;

    public Controller() {
        level = "hard";//<--------------------------------------LEVEL
        loadBoard(level);
        gridPane = new GridPane();
        loadBoardOnGridPane(true);//<---------------------SOLVER
    }

    private void loadBoard(String level) {
        BoardReader br = new BoardReader();
        String filePath = br.getRandomFilePath(level);
        String[] split = filePath.split("\\\\");
        fileName = split[split.length - 1];
        mapNo = fileName.replace(".csv", "");
        board = br.loadBoard(filePath);
    }

    @FXML
    private void solve(ActionEvent event) {
        System.out.println("SOLVE");
        loadBoardOnGridPane(true);
    }

    @FXML
    private void loadEasy(ActionEvent event) {
        level = "easy";
        System.out.println(level);
        loadBoard(level);
        loadBoardOnGridPane(false);
    }

    @FXML
    private void loadMedium(ActionEvent event) {
        level = "medium";
        System.out.println(level);
        loadBoard(level);
        loadBoardOnGridPane(false);
    }

    @FXML
    private void loadHard(ActionEvent event) {
        level = "hard";
        System.out.println(level);
        loadBoard(level);
        loadBoardOnGridPane(false);
    }

    public void loadBoardOnGridPane(boolean solve) {
        int rowNumber = board.getRowNumber();
        int colNumber = board.getColNumber();
        for (int colCoord = 0; colCoord < colNumber; colCoord++) {
            for (int rowCoord = 0; rowCoord < rowNumber; rowCoord++) {
                Cell cell = board.getCell(rowCoord, colCoord);
                String type = cell.getType();
                TextField textField = null;
                int colSum = -2;
                int rowSum = -2;
                int value = -2;

                switch (type) {
                    case "empty":
                        textField = new TextField();
                        textField.setEditable(false);
                        textField.setStyle("-fx-background-color: darkgray;");
                        break;
                    case "column":
                        colSum = board.getCell(rowCoord, colCoord).getColumnSum();
                        textField = new TextField(colSum + "\\");
                        textField.setEditable(false);
                        textField.setStyle("-fx-background-color: lightgrey;");
                        break;
                    case "row":
                        rowSum = board.getCell(rowCoord, colCoord).getRowSum();
                        textField = new TextField("\\" + rowSum);
                        textField.setEditable(false);
                        textField.setStyle("-fx-background-color: lightgrey;");
                        break;
                    case "value":
                        value = board.getCell(rowCoord, colCoord).getValue();
                        if (solve)
                            textField = new TextField(String.valueOf(value));
                        else
                            textField = new TextField();
                        break;
                    case "full":
                        rowSum = board.getCell(rowCoord, colCoord).getRowSum();
                        colSum = board.getCell(rowCoord, colCoord).getColumnSum();
                        textField = new TextField(colSum + "\\" + rowSum);
                        textField.setEditable(false);
                        textField.setStyle("-fx-background-color: lightgrey;");
                        break;
                }
                if (textField != null) {
                    textField.setPrefWidth(gridWidth / colNumber);
                    textField.setPrefHeight(gridHeight / rowNumber);
                    textField.setAlignment(Pos.CENTER);
                    gridPane.add(textField, colCoord, rowCoord);
                }
            }
        }
        gridPane.setGridLinesVisible(true);
        gridPane.setPadding(new Insets(5, 5, 5, 5));
    }

    public GridPane getGridPane() {
        return gridPane;
    }
}
