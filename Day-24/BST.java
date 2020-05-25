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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode ptr = root;
        for(int i = 1; i < preorder.length; i++) {
            TreeNode temp = new TreeNode(preorder[i]); //made a node
            ptr = root;
            int flag = 0;
            while(flag != 1)
            {
                if(ptr.val > temp.val)
                {
                    if(ptr.left != null)
                    {
                        ptr = ptr.left;
                    }
                    else
                    {
                        ptr.left = temp;
                        flag = 1;
                        break;
                    }
                }
                //checking condition
                else if(ptr.val < temp.val)
                {
                    if(ptr.right != null)
                    {
                        ptr = ptr.right;
                    }
                    else
                    {
                        ptr.right = temp;
                        flag = 1;
                        break;
                    }
                }
            }            
        }
        return root;
    }
}