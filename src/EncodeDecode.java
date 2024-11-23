/**
 * Date: 22/11/2024
 * Project: DSA-Assignment
 * Author: Adefolajuwon Adeniran
 * Description: This class provides methods for encoding and decoding messages using a Huffman coding tree.
 *              It expects a HuffmanTree object upon instantiation which contains the coding tree structure.
 */
public class EncodeDecode {
    private HuffmanTree huffmanTree;

    // Constructor: Accepts a HuffmanTree instance
    public EncodeDecode(HuffmanTree huffmanTree) {
        this.huffmanTree = huffmanTree;
    }

    // Encodes a message into a binary string
    public String encode(String message) {
        StringBuilder encodedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {

            // Retrieve the code for the character
            String code = huffmanTree.getCode(c);
            if (code != null) {
                encodedMessage.append(code);
            } else {
                throw new IllegalArgumentException("Character " + c + " not found in the Huffman Tree.");
            }
        }
        return encodedMessage.toString();
    }

    // Decodes a binary string back to the original message
    public String decode(String binaryString) {
        StringBuilder decodedMessage = new StringBuilder();

        // Start from the root of the tree
        TreeNode currentNode = huffmanTree.getRoot();

        for (char bit : binaryString.toCharArray()) {
            if (bit == '0') {
                currentNode = currentNode.getLeft();
            } else if (bit == '1') {
                currentNode = currentNode.getRight();
            } else {
                throw new IllegalArgumentException("Invalid binary character: " + bit);
            }

            // If it's a leaf node, append the character to the decoded message
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                decodedMessage.append(currentNode.getSymbol());

                // Reset to the root for the next character
                currentNode = huffmanTree.getRoot();
            }
        }

        return decodedMessage.toString();
    }
}

