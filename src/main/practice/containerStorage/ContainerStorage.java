package practice.containerStorage;

import java.util.HashMap;
import java.util.Stack;

public class ContainerStorage {
    public static final int ROW = 10;
    public static final int COLUMN = 10;
    public static final int MAX_STACK = 10;
    private HashMap<String, Stack<Container>> cells;

    public ContainerStorage() {
        cells = new HashMap<>();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++)
                cells.put(generateId(i, j), new Stack<>());
        }
    }

    public void load(Container container, int row, int column) {
        Stack<Container> cell = cells.get(generateId(row, column));
        if (cell.size() == MAX_STACK)
            throw new Error("Stack at " + generateId(row, column) + " is full");
        else
            cell.push(container);
    }

    public Container unload(String id, int row, int column) {
        Stack<Container> cell = cells.get(generateId(row, column));
        Stack<Container> tempStack = new Stack<>();
        while (!cell.empty()) {
            Container currentContainer = cell.pop();
            if (currentContainer.getId().equals(id)) {
                //push back all the not matching container
                while (!tempStack.empty())
                    cell.push(tempStack.pop());
                return currentContainer;
            } else tempStack.push(currentContainer);
        }
        return null;
    }

    private String generateId(int row, int column) {
        return "Row" + row + "Column" + column;
    }
}
