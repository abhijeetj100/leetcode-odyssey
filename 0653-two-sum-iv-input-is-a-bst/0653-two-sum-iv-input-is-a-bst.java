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
    public HashSet<Integer> hs = new HashSet<>();
    // public boolean found = false;
    public boolean findTarget(TreeNode root, int k) {
        // inorder(root, k);
        // preorder traversal
        if(root == null) return false;

        int j = k-root.val;
        if(hs.contains(j)) return true;
        hs.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
        // return found;
    }

    // public void inorder(TreeNode root, int k){
    //     if(root == null) return;

    //     inorder(root.left, k);

    //     int j = k - root.val;
    //     if(hs.contains(j)) found = true;
    //     hs.add(root.val);

    //     inorder(root.right, k);
    // }
}