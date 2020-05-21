/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    LinkedList<Integer> list = new LinkedList<Integer>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        //now list has all elements in ascending order
        return list.get(k - 1); 
    }
    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right); 
    }
}