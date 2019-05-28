package binarytree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 0; i < 20; i++)
            tree.insert((int) (Math.random() * i));
        for (int i : tree) System.out.println(i);
        System.out.println("Sum: " + findSum(tree));
        System.out.println("Is full binary tree: " + isFullTree(tree.root));
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

    /**
     * check if the binary tree is full tree
     * @param root binary tree root
     * @return return true if it is a full tree, otherwise false
     */
    public static <E extends Comparable<E>> boolean isFullTree(BinaryTree.TreeNode<E> root) {
        if (root == null) //if empty tree
            return true;
        if (root.left == null && root.right == null) //if leaf node
            return true;
        if (root.left != null && root.right != null) // if both subtree are full
            return (isFullTree(root) && isFullTree(root));
        return false; // if none works
    }

}
