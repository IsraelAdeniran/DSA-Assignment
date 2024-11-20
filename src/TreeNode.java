/**
 * Date: 19/11/2024
 * Project: DSA Project
 * Author: Adefolajuwon Adeniran
 */
public class TreeNode {
    private int freq; // Frequency of the character
    private char symbol; // Character symbol
    private TreeNode leftChild; // Left child of the node
    private TreeNode rightChild; // Right child of the node

    // Constructor for a leaf node
    public TreeNode(int f, char s) {
        freq = f;
        symbol = s;
        leftChild = null;
        rightChild = null;
    }

    // Constructor for an internal node
    public TreeNode(int f, char s, TreeNode left, TreeNode right) {
        freq = f;
        symbol = s;
        leftChild = left;
        rightChild = right;
    }

    // Getter for frequency
    public int getFreq() {
        return freq;
    }

    // Setter for frequency
    public void setFreq(int f) {
        freq = f;
    }

    // Getter for symbol
    public char getSymbol() {
        return symbol;
    }

    // Setter for symbol
    public void setSymbol(char s) {
        symbol = s;
    }

    // Getter for left child
    public TreeNode getLeft() {
        return leftChild;
    }

    // Setter for left child
    public void setLeft(TreeNode left) {
        leftChild = left;
    }

    // Getter for right child
    public TreeNode getRight() {
        return rightChild;
    }

    // Setter for right child
    public void setRight(TreeNode right) {
        rightChild = right;
    }
}
