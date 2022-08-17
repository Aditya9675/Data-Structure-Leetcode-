/*

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
 
    if(root==null){
        return result;
    }
 
    LinkedList<TreeNode> nodeQueue = new LinkedList<>();
    LinkedList<Integer> levelQueue = new LinkedList<>();
 
    nodeQueue.offer(root);
    levelQueue.offer(1);
 
    while(!nodeQueue.isEmpty()){
        TreeNode node = nodeQueue.poll();
        int level = levelQueue.poll();
 
        List<Integer> l=null;
        if(result.size()<level){
            l = new ArrayList<>();
            result.add(l);
        }else{
            l = result.get(level-1);
        }
 
        l.add(node.val);
 
        if(node.left!=null){
            nodeQueue.offer(node.left);
            levelQueue.offer(level+1);
        }
 
        if(node.right!=null){
            nodeQueue.offer(node.right);
            levelQueue.offer(level+1);
        }
    }
 
    return result;
    }
}
