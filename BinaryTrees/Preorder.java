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

 // Basic Iterative
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<>();
        Deque<TreeNode> s = new ArrayDeque<>();
        if (root == null)
            return l;
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode t = s.pop();
            l.add(t.val);
            if (t.right != null)
                s.push(t.right);
            if (t.left != null)
                s.push(t.left);
        }
        return l;
    }
}


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

 // Morris
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // morris preorder
        List<Integer> l = new ArrayList<>(); 
        while (root != null) {
            if (root.left != null) { // if left of curr not null, go left
               TreeNode predecessor = root.left;
                while(predecessor.right != null && predecessor.right != root) { //then go right till you find null or curr
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) { // found null
                    l.add(root.val); //add val of curr
                    predecessor.right = root; // attach right to curr
                     root = root.left; // go left from curr
                }
                else {  // found curr
                    predecessor.right = null; // detach right from curr
                    root = root.right; // go right from curr
                }
            }
            else { // left is nuk;;
                l.add(root.val); //add val of curr
                root = root.right; // go right from curr
            }
        }
        return l;
    }
}