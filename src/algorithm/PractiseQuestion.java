/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author hp
 */
public class PractiseQuestion {
    
}
  
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
     public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return original;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(cloned);
        
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            
            if (temp.val == target.val) {
                return  temp;
            }
            
            if (temp.left!=null) {
                q.add(temp.left);
            }
            
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        
        return null;
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
         int ans = 0;
         recursivePreorderTraversal(root, ans, low, high);
         
        
         return ans;
    }
    
    private static void recursivePreorderTraversal(TreeNode root, int ans, int low, int high) {
        if (root == null) {
            return;
        }
        
        recursivePreorderTraversal(root.left, ans, low, high);
        if (root.val>=low && root.val<=high) {
            ans+=root.val;
        }
        recursivePreorderTraversal(root.right, ans, low, high);
    }
}