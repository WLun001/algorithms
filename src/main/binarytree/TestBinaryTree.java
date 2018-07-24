package binarytree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 0; i < 20; i++)
            tree.insert((int) (Math.random() * i));
        for (int i : tree) System.out.println(i);
        System.out.println(findSum(tree) + "");

    }

    public static int findSum(BinaryTree tree) {
        return findSum(tree.root);
    }

    public static int findSum(BinaryTree.TreeNode root) {
        int sum = 0;
        if(root != null) {
            sum = Integer.parseInt(root.element.toString()) + findSum(root.left) + findSum(root.right);
        }
        return sum;
    }
}
