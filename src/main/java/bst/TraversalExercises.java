package bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraversalExercises {

    // ---------------------------------------------------------
    // ITERATIVE PREORDER (DFS)
    // ---------------------------------------------------------
    public static <T extends Comparable<T>> List<T> preorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            result.add(node.value);

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return result;
    }

    // ---------------------------------------------------------
    // ITERATIVE INORDER (DFS)
    // ---------------------------------------------------------
    public static <T extends Comparable<T>> List<T> inorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        TreeNode<T> curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.value);
            curr = curr.right;
        }

        return result;
    }

    // ---------------------------------------------------------
    // ITERATIVE POSTORDER (DFS) — optional challenge
    // ---------------------------------------------------------
    public static <T extends Comparable<T>> List<T> postorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        TreeNode<T> lastVisited = null;
        TreeNode<T> curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode<T> peek = stack.peek();
                if (peek.right != null && lastVisited != peek.right) {
                    curr = peek.right;
                } else {
                    result.add(peek.value);
                    lastVisited = stack.pop();
                }
            }
        }

        return result;
    }

    // ---------------------------------------------------------
    // LEVEL ORDER (BFS)
    // ---------------------------------------------------------
    public static <T extends Comparable<T>> List<T> levelOrderUsingQueue(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            result.add(node.value);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return result;
    }
}