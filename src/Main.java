/**
 * Date: 22/11/2024
 * Project: DSA-Assignment
 * Author: Adefolajuwon Adeniran
 *  Description: This class demonstrates the use of Huffman coding by building a Huffman Tree,
 *               generating Huffman codes for a set of characters, and encoding and decoding a sample message.
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a frequency table from the file
        ListArrayBased freqTable = new ListArrayBased();
        try (Scanner scanner = new Scanner(new File("LetterCountAscending.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                char symbol = parts[0].charAt(0);
                int freq = Integer.parseInt(parts[1]);
                freqTable.add(new TreeNode(freq, symbol));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Build the Huffman Tree
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.buildTree(freqTable);
        huffmanTree.traverseWithCodes(huffmanTree.getRoot(), "");

        // Display Huffman codes
        System.out.println("Huffman Codes:");
        for (char c = 'A'; c <= 'Z'; c++) {
            String code = huffmanTree.getCode(c);
            if (code != null) {
                System.out.println(c + ": " + code);
            }
        }

        // Encode and decode a sample message
        EncodeDecode encodeDecode = new EncodeDecode(huffmanTree);
        String message = "HELLO";

        // Check for valid characters
        System.out.println("Message to encode: " + message);
        for (char c : message.toCharArray()) {
            System.out.println("Character: " + c + ", ASCII: " + (int) c);
        }

        // Encode the message
        String encodedMessage = encodeDecode.encode(message);
        System.out.println("\nEncoded Message: " + encodedMessage);

        // Decode the message
        String decodedMessage = encodeDecode.decode(encodedMessage);
        System.out.println("Decoded Message: " + decodedMessage);
    }
}
