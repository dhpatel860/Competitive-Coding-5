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

 /*
  * Do BFS traversal to get level by level elements and get the max out of all in that level
    TC: O(n) -> iterate over all the nodes
    SC: O(n) -> n/2 leaf elements at max in the queue at a time, but 2 doesnt matter so O(n)
  * DFS: Pass depth of the node as a parameter to the recursive function and check whether the result size is equal to depth
    - if equal, add that element to the list
    - if not, that means there already an element present, so check that element with the currently encountered element
    TC: O(n) -> iterate over all the nodes
    SC: O(h) -> height of the tree -> recursive stack
  */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if(root == null)
            return res;
        
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);

                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }

            res.add(max);
        }
        return res;
    }
}


