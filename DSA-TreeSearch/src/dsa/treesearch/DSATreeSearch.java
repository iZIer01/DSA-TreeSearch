package dsa.treesearch;

import java.util.Scanner;

class Node {
    int value;
    Node left, right;

    Node(int val) {
        value = val;
        left = right = null;
    }
}

// Tree class with all tree operations
class Tree {
    Node root;

    // Insert a number into the tree
    Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.value) {
            root.left = insert(root.left, val);
        } else if (val > root.value) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Postorder traversal will be from  (left -> right -> root)
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Inorder traversal will be from (left -> root -> right)
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    // Delete a number from the tree
    Node delete(Node root, int val) {
        if (root == null) return null;

        if (val < root.value) {
            root.left = delete(root.left, val);
        } else if (val > root.value) {
            root.right = delete(root.right, val);
        } else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Node with two children: get inorder successor (smallest in right subtree)
            root.value = findMin(root.right);
            root.right = delete(root.right, root.value);
        }
        return root;
    }

    // Find the smallest value in a subtree
    int findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.value;
    }
}

public class DSATreeSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tree tree = new Tree();

        // Initial tree elements
        int[] initialValues = {7, 5, 9, 4, 6, 8, 13, 2};
        for (int val : initialValues) {
            tree.root = tree.insert(tree.root, val);
        }

        // Menu-driven loop
        while (true) {
            System.out.println("\n================= TREE MENU =================");
            System.out.println("1. Insert a number");
            System.out.println("2. Show Postorder Traversal");
            System.out.println("a. Show current tree (Inorder)");
            System.out.println("b. Delete a number");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = input.next();

            switch (choice) {
                case "1":
                    System.out.print("Enter number to insert: ");
                    int numToInsert = input.nextInt();
                    tree.root = tree.insert(tree.root, numToInsert);
                    System.out.println(" Number inserted!");
                    break;

                case "2":
                    System.out.print(" Postorder Traversal: ");
                    tree.postorder(tree.root);
                    System.out.println();
                    break;

                case "a":
                    System.out.print("Current Tree (Inorder): ");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;

                case "b":
                    System.out.print("Enter number to delete: ");
                    int numToDelete = input.nextInt();
                    tree.root = tree.delete(tree.root, numToDelete);
                    System.out.println(" Number deleted (if it existed).");
                    break;

                case "3":
                    System.out.println(" Exiting the program. Goodbye!");
                    input.close();
                    return;

                default:
                    System.out.println(" Invalid choice! Please try again.");
            }
        }
    }
}
