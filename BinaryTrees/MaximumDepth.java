// Basic Recursion: Worst case, if tree is highly inbalanced O(N). Best case: tree completely balanced: O(logn)

class Solution {
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      } else {
        int left_height = maxDepth(root.left);
        int right_height = maxDepth(root.right);
        return java.lang.Math.max(left_height, right_height) + 1;
      }
    }
}

// Iteration. Space: O(2N)
class Solution {
    public int maxDepth(TreeNode root) {
      LinkedList<TreeNode> stack = new LinkedList<>();
      LinkedList<Integer> depths = new LinkedList<>();
      if (root == null) return 0;
  
      stack.add(root);
      depths.add(1);
  
      int depth = 0, current_depth = 0;
      while(!stack.isEmpty()) {
        root = stack.pop();
        current_depth = depths.po[();
        if (root != null) {
          depth = Math.max(depth, current_depth);
          stack.add(root.right);
          stack.add(root.left);
          depths.add(current_depth + 1);
          depths.add(current_depth + 1);
        }
      }
      return depth;
    }
  };

  // another recrusive approach: simplification of first approach

  public int maxDepth(TreeNode root) {
    if(root==null){
        return 0;
    }
    return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
}


// BFS

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int depth = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            depth++;
            while (size-- > 0) { // this is important: this will not let height increase at same depth
                TreeNode node = nodes.poll();
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
        }
        return depth;
    }
}