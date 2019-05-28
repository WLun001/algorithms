package binarytree;

class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class BinaryTreeV2 {
    // Root of the Binary Tree
    Node root;

    // To keep tract of previous node in Inorder Traversal
    Node prev;

    boolean isBST() {
        prev = null;
        return isBST(root);
    }

    /* Returns true if given search tree is binary
       search tree (efficient version) */
    public boolean isBST(Node node) {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (node != null) {
            if (!isBST(node.left))
                return false;

            // allows only distinct values node
            if (prev != null && node.data <= prev.data)
                return false;
            prev = node;
            return isBST(node.right);
        }
        return true;
    }

    /* this function checks if a binary tree is full or not */
    public boolean isFullTree(Node node)
    {
        // if empty tree
        if(node == null) return true;

        // if leaf node
        if(node.left == null && node.right == null )
            return true;

        // if both left and right subtrees are not null
        // the are full
        if((node.left!=null) && (node.right!=null))
            return (isFullTree(node.left) && isFullTree(node.right));

        // if none work
        return false;
    }

    public static void main(String args[])
    {
        BinaryTreeV2 tree = new BinaryTreeV2();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.right = new Node(40);
        tree.root.left.left = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.left.left.left = new Node(80);
        tree.root.right.right = new Node(70);
        tree.root.left.left.right = new Node(90);
        tree.root.left.right.left = new Node(80);
        tree.root.left.right.right = new Node(90);
        tree.root.right.left.left = new Node(80);
        tree.root.right.left.right = new Node(90);
        tree.root.right.right.left = new Node(80);
        tree.root.right.right.right = new Node(90);

        if(tree.isFullTree(tree.root))
            System.out.println("The binary tree is full");
        else
            System.out.println("The binary tree is not full");

        BinaryTreeV2 tree2 = new BinaryTreeV2();
        tree2.root = new Node(4);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(5);
        tree2.root.left.left = new Node(1);
        tree2.root.left.right = new Node(3);

        if (tree2.isBST())
            System.out.println("IS Binary Search Tree");
        else
            System.out.println("Not a BST");
    }
}
