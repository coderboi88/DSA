/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head, first = head;
        
        for (int i=0;i<n;i++) {
            temp = temp.next;
        }
        
        if (temp == null) {
            head = head.next;
            return head;
        }
        
        while(temp.next!=null) {
            first = first.next;
            temp = temp.next;
        }
        
        first.next = first.next.next;
        
        return head;
    }
    
    public ListNode deleteMiddle(ListNode head) {
     ListNode slow = head, fast = head, prev = null;
     
     while(fast!=null && fast.next!=null) {
         prev = slow;
         slow = slow.next;
         fast = fast.next.next;
     } 
     
     prev.next = slow.next;
     
     return head;
    }
    
    public ListNode middleNode(ListNode head) {
    
        if (head.next == null) {
            return head.next;
        } else if (head.next.next == null) {
            return head.next;
        }
        ListNode slow = head, fast = head, prev = null;
     
     while(fast!=null && fast.next!=null) {
         prev = slow;
         slow = slow.next;
         fast = fast.next.next;
     } 

     
     return slow;
    }
    
    public int pairSum(ListNode head) {
        if (head.next.next == null) {
            return head.val + head.next.val;
        }
        
      ListNode slow = head, fast = head, prev = null;
     
     while(fast!=null && fast.next!=null) {
         prev = slow;
         slow = slow.next;
         fast = fast.next.next;
     } 
     
     prev.next = null;
     slow = reverseLinkedList(slow);
     int ans = 0;
     while(head!=null) {
         int temp = head.val + slow.val;
         
         if (temp>ans) {
             ans = temp;
         }
     }
     
     return ans;
     
    }
    
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode net = null;
        
        if (head.next == null) {
            return head;
        }
        
        while(head!=null) {
            net = head.next;
            head.next = prev;
            prev = head;
            head = net;
        }
        
        head = prev;
        
        return head;
    }
    
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        
        while (l<r) {
            if (s.charAt(l) != s.charAt(r)) {
                
                // if left +1, and r makes palindrome
                if (checkPalindrome(s, l+1, r)) {
                    return true;
                }
                
                // if left, and r-1 makes palindrome
                if (checkPalindrome(s, l, r-1)) {
                    return true;
                }
                
                // If neither return false
                return false;
            }
            
            l++;
            r--;
        }
        
        return true;
    }
    
    public String firstPalindrome(String[] words) {
        int n = words.length;
        
        
        for (int i=0;i<n;i++) {
            if (checkPalindrome(words[i])) {
                return words[i];
            }
        }
        
        return "";
    }
    
    public boolean isPalindrome(String s) {
        String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String ans = "";
        for (int i=0;i<s.length();i++) {
            if (Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))) {
                ans += Character.toLowerCase(s.charAt(i));
            }
        }
        
        return checkPalindrome(ans);
    }
    
    private boolean checkPalindrome(String a) {
        int n = a.length();
        int i=0, j= n-1;
        
        while(i<=j) {
            if (a.charAt(i)!=a.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
    
    private boolean checkPalindrome(String a, int i, int j) {
        while(i<=j) {
            if (a.charAt(i)!=a.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int score=0, max_score =0, left = 0, right = tokens.length - 1;
        
        while(left<right) {
            if (power>=tokens[left]) {
                power-=tokens[left];
                score++;
                left++;
                
                if (score>max_score) {
                    max_score = score;
                }
            } else if (score>0) {
                power+=tokens[right];
                score--;
                right--;
            } else {
                break;
            }
        }
        
        return max_score;
    }
    
    
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
     
     public int[] sortedSquares(int[] nums) {
     int len = nums.length;
     
     int ans[] = new int[len];
     
     int i =0, j=len-1;
     int e = len-1;
     while (i<=j) {
         if (Math.abs(nums[i])>Math.abs(nums[j])) {
             ans[e] = nums[i]*nums[i];
             i++;
         } else {
             ans[e] = nums[j]*nums[j];
             j--;
         }
         
         e--;
     }
     
     return ans;
    }
     
    public int romanToInt(String s) {
     int n= s.length();
     int ans =0;
     for (int i=0;i<n;i++) {
         if (i+1<n && checkIftrivislCase(s.substring(i, i+2))) {
             ans+= convertNumber(s.substring(i, i+2));
             i++;
         } else {
             ans+= convertSIngleNumber(s.substring(i, i+1));
         }
     }
     
     return ans;
    }
    
    public int romanToInt2(String s) {
     int n= s.length();
     
     Map<Character, Integer> map = new HashMap<>();
     map.put('I', 1);
     map.put('V', 5);
     map.put('X', 10);
     map.put('L', 50);
     map.put('C', 100);
     map.put('D', 500);
     map.put('M', 1000);
     
     int ans =0;
     for (int i=0;i<n;i++) {
         if (i+1<n && map.get(s.charAt(i))< map.get(s.charAt(i+1))) {
             ans-=map.get(s.charAt(i));
         } else {
             ans+= map.get(s.charAt(i));
         }
     }
     
     return ans;
    }
    
    public int removeElement(int[] nums, int val) {
        int index = 0;
        
        for (int i=0;i<nums.length;i++) {
            if (nums[i]!=val) {
                nums[index] = nums[i];
                index++;
            }
        }
        
        return index;
    }
    
    private int convertNumber(String s) {
        switch (s) {
            case "IX" : return 9;
            case "IV" : return 4;
            case "IL" : return 40;
            case "IC" : return 90;
            case "ID" : return 400;
            case "IM" : return 900;
            default:return 0;
        }
    }
    
    private int convertSIngleNumber(String s) {
        switch (s) {
            case "I" : return 1;
            case "V" : return 5;
            case "X" : return 10;
            case "L" : return 50;
            case "C" : return 100;
            case "D" : return 500;
            case "M" : return 1000;
            default:return 0;
        }
    }
    
    private boolean checkIftrivislCase(String s) {
        switch (s) {
            case "IX" : return true;
            case "IV" : return true;
            case "IL" : return true;
            case "IC" : return true;
            case "ID" : return true;
            case "IM" : return true;
            default:return false;
        }
    }
     
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i=0;i<n;i++) {
            int temp = target - nums[i];
            
            if (map.containsKey(temp)) {
                return new int[] {i, map.get(temp)};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[]{};
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