/**
 * Date: 19/11/2024
 * Project: DSA Project
 * Author: Adefolajuwon Adeniran
 * Description: This class implements an array-based sorted list of TreeNode objects,
 *              maintaining order by frequency to facilitate Huffman Tree construction.
 */

import java.util.ArrayList;

public class ListArrayBased {
    // List to store TreeNode objects
    private ArrayList<TreeNode> list;

    // Constructor: Initializes the internal list
    public ListArrayBased() {
        list = new ArrayList<>();
    }

    // Adds a TreeNode to the list and sorts it by frequency
    public void add(TreeNode node) {
        list.add(node);
        sort(); // Ensure the list remains sorted
    }

    // Removes a TreeNode from the specified index
    public TreeNode remove(int index) {
        return list.remove(index);
    }

    // Retrieves a TreeNode at the specified index
    public TreeNode get(int index) {
        return list.get(index);
    }

    // Returns the current size of the list
    public int size() {
        return list.size();
    }

    // Sorts the list by frequency in ascending order
    public void sort() {
        list.sort((a, b) -> Integer.compare(a.getFreq(), b.getFreq()));
    }
}
