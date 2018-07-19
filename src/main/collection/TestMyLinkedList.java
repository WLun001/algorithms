package collection;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("America");
        list.add(0, "Canada");
        list.add("Russia");
        list.addLast("France");
        list.add(2, "Germany");
        list.add(5, "Norway");
        list.add(0, "Poland");
        list.remove(0);
        list.remove(2);
        list.remove(list.size() - 1);
        list.add("Russia");
        System.out.println(list);
        System.out.println(list.contains("America"));
        System.out.println(list.contains("Americas"));
        System.out.println(list.indexOf("Americas"));
        System.out.println(list.indexOf("Russia"));
        System.out.println(list.get(3));
        System.out.println(list.set(1, "Hello"));
        System.out.println(list);
        System.out.println(list.lastIndexOf("Russia"));

    }
}
