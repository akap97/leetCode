// basic iterative  
public class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}

// Morris (orignal morris)
// attach ancestors to right of left subtree
class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        while (root != null) {
            if (root.left != null) {
                TreeNode predecessor = root.left;
                while (predecessor.right != null) { // find rightmost
                    predecessor = predecessor.right;
                }
                predecessor.right = root; // put cur after the pre node
                TreeNode temp = root; // store cur node
                root = root.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops (restoration step)

            } else { // has a left subtree
                res.add(root.val);
                root = root.right; // move to next right node
            }
        }
        return res;
    }
}