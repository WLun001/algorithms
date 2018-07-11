package collection;

public class TestMyArrayList {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();
        list.add("America");
        list.add("Canada");
        list.add("Russia");
        list.add("France");
        for (String s : list)
            System.out.print(s.toUpperCase() + " ");

        MyList<String> list2 = new MyArrayList<>();
        list2.add("Malaysia");

        boolean successAdd = ((MyArrayList<String>) list2).addAll(list);
        if (successAdd) {
            System.out.println("\nAdd All");
            for (String s : list2)
                System.out.print(s.toUpperCase() + " ");
        }

        boolean successRetain = ((MyArrayList<String>) list2).retainAll(list);
        if (successRetain) {
            System.out.println("\nRetain All");
            for (String s : list2)
                System.out.print(s.toUpperCase() + " ");
        }

        boolean successRemove = ((MyArrayList<String>) list2).removeAll(list);
        if (successRemove) {
            System.out.println("\nRemove All");
            for (String s : list2)
                System.out.print(s.toUpperCase() + " ");
        }
    }
}
