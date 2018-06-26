package generic;

import java.util.ArrayList;

public class FindMin {

    public static <E extends Comparable<E>> E min(ArrayList<E> list) {
        E currentMin = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (currentMin.compareTo(list.get(i)) > 0) currentMin = list.get(i);
        }
        return currentMin;
    }

    public static void main(String[] args) {
        ArrayList<Rectangle> list = new ArrayList<>();
        list.add(new Rectangle(4, 5));
        list.add(new Rectangle(2, 6));
        list.add(new Rectangle(10, 2));
        list.add(new Rectangle(2, 5));
        System.out.println("Min = " + min(list));
    }
}
