/**
 * Date: 20/11/2024
 * Project: DSA Project
 * Author: Adefolajuwon Adeniran
 * Description: This class implements a Huffman Tree for encoding characters using Huffman coding.
 *
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

}
