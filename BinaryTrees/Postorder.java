public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;
        
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            } 
        }
        return ans;
    }
}

// non hacky way
public class Solution {
    // Important, when you pop a node, ensure its children are traversed.
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode cur = root;
        
        while (cur != null || !s.empty()) {
            while (!isLeaf(cur)) { // 1) push curr and go all left
                s.push(cur);
                cur = cur.left;
            }
            
            if (cur != null) ans.add(cur.val); // 2) add left then add right
            
            while (!s.empty() && cur == s.peek().right) { // makes sure right child is processed before popping the root
                cur = s.pop();
                ans.add(cur.val); // 4) add root finally
            }
            
            if (s.empty()) cur = null; // terminating condition
            else cur = s.peek().right; // 3) go right
        }
        
        return ans;
    }
    
    private boolean isLeaf(TreeNode r) {
        if (r == null) return true;
        return r.left == null && r.right == null;
    }
}