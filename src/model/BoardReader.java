package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class BoardReader {

    private static final String BOARD_PATH = System.getProperty("user.dir") + "\\boards\\";

    String pathToEasy = "/boards/easy/";
    String pathToMedium = "/boards/medium/";
    String pathToHard = "/boards/hard/";

    /**
     * funkcja odczytująca z pliku macierz typu String
     */
    private static String[][] readBoardString(Scanner inputStream, int rows_number, int columns_number) {
        inputStream.next();
        String[][] data = new String[rows_number][columns_number];
        for (int i = 0; i < rows_number; i++) {
            String[] row = inputStream.next().split(",");
            System.arraycopy(row, 0, data[i], 0, row.length);
        }
        return data;
    }

    /**
     * funkcja odczytująca z pliku macierz typu Integer
     */
    private static int[][] readBoardInt(Scanner inputStream, int rows_number, int columns_number) {
        inputStream.next();
        int[][] data = new int[rows_number][columns_number];
        for (int i = 0; i < rows_number; i++) {
            String[] row = inputStream.next().split(",");
            for (int j = 0; j < row.length; j++) {
                data[i][j] = Integer.parseInt(row[j]);
            }
        }
        return data;
    }

    /**
     * moetody wybierające losowy plik csv z folderu
     */
    public String getRandomFilePath(String level) {
        String boardPath = BOARD_PATH + level;
        File dir = new File(boardPath);
        List<String> filesList = Arrays.asList(Objects.requireNonNull(dir.list()));
        Random rand = new Random();
        return boardPath + "\\" + filesList.get(rand.nextInt(filesList.size()));
    }

    public Board loadBoard(String filePath) {
        File file = new File(filePath);
        Board board = null;
        try {
            Scanner inputStream = new Scanner(file);
            String[] matrix_sizes = inputStream.next().split(",");
            int rowNumber = Integer.parseInt(matrix_sizes[0]);
            int colNumber = Integer.parseInt(matrix_sizes[1]);
            board = new Board(rowNumber, colNumber);

            String[][] types = readBoardString(inputStream, rowNumber, colNumber);
            int[][] values = readBoardInt(inputStream, rowNumber, colNumber);
            int[][] columns = readBoardInt(inputStream, rowNumber, colNumber);
            int[][] rows = readBoardInt(inputStream, rowNumber, colNumber);

            for (int colCoord = 0; colCoord < colNumber; colCoord++) {
                for (int rowCoord = 0; rowCoord < rowNumber; rowCoord++) {
                    Cell c = null;
                    switch (types[rowCoord][colCoord]) {
                        case "x":
                            c = new EmptyCell(rowCoord, colCoord);
                            break;
                        case "c":
                            c = new ColumnCell(columns[rowCoord][colCoord], rowCoord, colCoord);
                            break;
                        case "r":
                            c = new RowCell(rows[rowCoord][colCoord], rowCoord, colCoord);
                            break;
                        case "v":
                            c = new ValueCell(values[rowCoord][colCoord], rowCoord, colCoord);
                            break;
                        case "f":
                            c = new FullCell(rows[rowCoord][colCoord], columns[rowCoord][colCoord], rowCoord, colCoord);
                            break;
                    }
                    board.addCell(c, rowCoord, colCoord);
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        }
        return board;
    }
}