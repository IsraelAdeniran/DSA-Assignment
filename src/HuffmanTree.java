/**
 * Date: 20/11/2024
 * Project: DSA Project
 * Author: Adefolajuwon Adeniran
 * Description: This class implements a Huffman Tree for encoding characters using Huffman coding.
 *              It builds the tree based on the frequency of each character and provides methods to
 *              generate and retrieve binary codes for each character.
 */
public class HuffmanTree {
    // Top node of the Huffman Tree
    private TreeNode root;
    // This array stores the binary codes for each letter A-Z
    private String[] codes;

    // Constructor initializes the array for storing codes
    public HuffmanTree() {
        codes = new String[26];
    }

    // Builds the Huffman Tree using a table of frequencies
    public void buildTree(ListArrayBased freqTable) {
        // Build the tree until only one node is left
        while (freqTable.size() > 1) {
            // Remove the two nodes with the smallest frequency from the table
            TreeNode left = freqTable.remove(0);
            TreeNode right = freqTable.remove(0);

            // Combine these two nodes under a new parent node
            TreeNode parent = new TreeNode(left.getFreq() + right.getFreq(), '*', left, right);

            // Add the new parent node back into the frequency table
            freqTable.add(parent);
        }

        // The last node left is the root of the Huffman Tree
        root = freqTable.get(0);
    }

    // Assigns binary codes to characters by traversing the tree
    public void traverseWithCodes(TreeNode node, String code) {
        if (node != null) {
            // Check if this is a leaf node, which means it represents a character
            if (node.getLeft() == null && node.getRight() == null) {
                // Calculate the position in the array for the character
                int index = node.getSymbol() - 'A';
                // Save the binary code in the array
                codes[index] = code;
            } else {
                // Recurse to the left child and add '0' to the code
                traverseWithCodes(node.getLeft(), code + "0");
                // Recurse to the right child and add '1' to the code
                traverseWithCodes(node.getRight(), code + "1");
            }
        }
    }

    //  Retrieves the binary code for a given character
    public String getCode(char c) {
        // Convert the character to an array index
        int index = c - 'A';
        // Return the code from the array
        return codes[index];
    }

    // Returns the root of the Huffman Tree
    public TreeNode getRoot() {
        return root;
    }
}
