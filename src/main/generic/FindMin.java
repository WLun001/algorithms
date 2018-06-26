package generic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

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

        Comparator<Rectangle> rectangleComparator = (o1, o2) -> Double.compare(o2.getPerimeter(), o1.getPerimeter());

        list.sort(rectangleComparator);
        //using iterator
        Iterator<Rectangle> iterable = list.iterator();
        while (iterable.hasNext()) System.out.println(iterable.next());
        //using lambda
        list.forEach(System.out::println);
    }
}
