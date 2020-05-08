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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(checkLevel(root, x, 0) == checkLevel(root, y, 0)) { //i.e. on the same level
            if(IsSibling(root, x, y) == false) { //not same parents
                return true;
            }     
        }
        return false;
    }
    
    public int checkLevel(TreeNode root, int ptr, int l) {
        if(root == null) //not found in left/right subtree
            return 0;
        if(ptr == root.val) 
            return l;
        int lev = checkLevel(root.left, ptr, l + 1);
        if(lev != 0) //found in left subtree
            return lev;
        lev = checkLevel(root.right, ptr, l + 1);
        return lev; //assuming its found in right subtree
    }
    
    static boolean IsSibling(TreeNode node, int x, int y) 
    { 
    	boolean b = false;
        if (node == null) {
            return false; 
        }
        if(node.left == null && node.right == null) {
        	return false;
        }
        if (node.left != null && node.right != null) {
        	b = (node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x);
        	if(b == true) 
            	return b;
        }
        if(node.left != null) {
        	b = IsSibling(node.left, x, y);
        }
        if(b == true) 
        	return b;
        if(node.right != null) {
        	b = IsSibling(node.right, x, y);
        }
        return b; 
    }
}