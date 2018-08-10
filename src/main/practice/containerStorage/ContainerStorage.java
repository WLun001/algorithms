package practice.containerStorage;

import sun.tools.jstat.ColumnFormat;

import java.util.HashMap;
import java.util.Stack;

public class ContainerStorage {
    public static final int ROW = 10;
    public static final int COLUMN = 10;
    public static final int MAX_CONTAINER = 10;
    private HashMap<String, Stack<Container>> cells;

    public ContainerStorage() {
        cells = new HashMap<>();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++)
                cells.put(generateId(i, j), new Stack<>());
        }
    }

    public void load(Container container, int row, int column) {

    }
    public void unload(String id, int row, int column) {

    }

    private String generateId(int row, int column) {
        return "R" + row + "C" + column;
    }
}
