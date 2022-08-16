/*

Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 
 */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         
    ArrayList<Integer> result = new ArrayList<>();    
    Stack<TreeNode> stack = new Stack<>();
 
    TreeNode p = root;
    while(p!=null){
        stack.push(p);
        p=p.left;
    }
 
    while(!stack.isEmpty()){            
        TreeNode t = stack.pop();
        result.add(t.val);
 
        t = t.right;
        while(t!=null){
            stack.push(t);
            t = t.left;
        }
    }
 
    return result;
    }
}
