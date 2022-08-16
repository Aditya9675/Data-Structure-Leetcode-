/*

Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [3,2,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 
 */

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
           
    List<Integer> res = new ArrayList<Integer>();
 
    if(root==null) {
        return res;
    }
 
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
 
    while(!stack.isEmpty()) {
        TreeNode temp = stack.peek();
        if(temp.left==null && temp.right==null) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
        }
        else {
            if(temp.right!=null) {
                stack.push(temp.right);
                temp.right = null;
            }
 
            if(temp.left!=null) {
                stack.push(temp.left);
                temp.left = null;
            }
        }
    }
 
    return res;
    }
}
