package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Aditya Jain
 */
public class TreeTraversal {
    
    
    public void traversal(Tree root) {
        // recursive preorder
        List<Integer> preorderList = new ArrayList<>();
        recursivePreorderTraversal(root, preorderList);
        
        // recursive inorder
        List<Integer> inorderList = new ArrayList<>();
        recursiveInorderTraversal(root, inorderList);
        
        // recursive postorder
        List<Integer> postOrderList = new ArrayList<>();
        recursivePostorderTraversal(root, postOrderList);
    }
    
    // Preorder Traversal
    private void recursivePreorderTraversal(Tree root, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        list.add(root.getValue());
        recursivePreorderTraversal(root.getLeft(), list);
        recursivePreorderTraversal(root.getRight(), list);
    }
    
    // iterative Preorder
    private void iterativePreorderTraversal(Tree root, List<Integer> list) {
        Stack<Tree> s = new Stack();
        
        while (root != null || !s.empty()) {
            while (root !=null) {
                list.add(root.getValue());
                s.push(root);
                root = root.getLeft();
            }
            
            root = s.pop();
            root = root.getRight();
        }
    }
    
    // Iterative InOrder
    private void iterativeInorderTraversal(Tree root, List<Integer> list) {
        Stack<Tree> s = new Stack();
        
        while (root != null || !s.empty()) {
            while (root !=null) {
                 s.push(root);
                root = root.getLeft();
            }
            
            root = s.pop();
            list.add(root.getValue());
            root = root.getRight();
        }
    }
    
    // Iterative Post Order Using 2 stack
    private void iterativePostorderTraversal(Tree root, List<Integer> list) {
        Stack<Tree> s1 = new Stack();
        Stack<Tree> s2 = new Stack();
        
        while (root != null || !s1.empty()) {
            while (root !=null) {
                s2.push(root);
                s1.push(root);
                root = root.getRight();
            }
            
            root = s1.pop();
            root = root.getLeft();
        }
        
        while (!s2.empty()) {
            list.add(s2.pop().getValue());
        }
    }
    
    // Iterative Post Order Using 1 stack
    private void iterativePostorderTraversalUsingSingleStack(Tree root, List<Integer> list) {
        Stack<Tree> s1 = new Stack();
        
        // Defining pre variable as in post we traverse like (left, right , element) 
        // so after adding the right child in the list when we came back to element, 
        // we should know that it's right child has been processed no need to go 
        // in that direction again.
        Tree pre = null;
        while (root != null || !s1.empty()) {
            // Here traversing till left child is null and adding every element to stack
            while (root !=null) {
                s1.push(root);
                root = root.getLeft();
            }
           
            // Taking top element
            root = s1.peek();
            
            // checking if it's right is null or if it's right was the last elemt which we have added
            // If yes then removing that object from satck and adding it to list and updating pre with the current root.
            if (root.getRight() == null || root.getRight() == pre) {
                s1.pop();
                list.add(root.getValue());
                pre = root;
                root = null;
            } else {
                root = root.getRight();
            }
        }
    }
    
    // Inorder Traversal
    private void recursiveInorderTraversal(Tree root, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        recursiveInorderTraversal(root.getLeft(), list);
        list.add(root.getValue());
        recursiveInorderTraversal(root.getRight(), list);
    }
    
    // Postorder Traversal
    private void recursivePostorderTraversal(Tree root, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        recursivePostorderTraversal(root.getLeft(), list);
        recursivePostorderTraversal(root.getRight(), list);
        list.add(root.getValue());
    }
}

class Tree {
    private int value;
    private Tree left, right;
    
    public Tree() {
        
    }
    
    public Tree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public Tree getLeft() {
        return this.left;
    }
    public Tree getRight() {
        return this.right;
    }
    
}
