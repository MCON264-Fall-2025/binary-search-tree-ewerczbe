package bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private TreeNode<T> insertRecursive(TreeNode<T> node, T value) {
        if (node == null) {
            return new TreeNode<>(value);
        }
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = insertRecursive(node.left, value);
        } else if (cmp > 0) {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    // ---------------------------------------------------------
    // RECURSIVE TRAVERSALS
    // ---------------------------------------------------------

    public List<T> preorderRecursive() {
        List<T> result = new ArrayList<>();
        preorderRecursive(root, result);
        return result;
    }

    private void preorderRecursive(TreeNode<T> node, List<T> out) {
        if (node == null) return;
        out.add(node.value);
        preorderRecursive(node.left, out);
        preorderRecursive(node.right, out);
    }

    public List<T> inorderRecursive() {
        List<T> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    private void inorderRecursive(TreeNode<T> node, List<T> out) {
        if (node == null) return;
        inorderRecursive(node.left, out);
        out.add(node.value);
        inorderRecursive(node.right, out);
    }

    public List<T> postorderRecursive() {
        List<T> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }

    private void postorderRecursive(TreeNode<T> node, List<T> out) {
        if (node == null) return;
        postorderRecursive(node.left, out);
        postorderRecursive(node.right, out);
        out.add(node.value);
    }

    // ---------------------------------------------------------
    // ITERATIVE TRAVERSALS
    // ---------------------------------------------------------

    public List<T> preorderIterative() {
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

    public List<T> inorderIterative() {
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

    public List<T> postorderIterative() {
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

    public List<T> levelOrder() {
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


    // ---------------------------------------------------------
    // UNIFIED API
    // ---------------------------------------------------------

    public List<T> getByTraversal(TraversalType type) {
        return switch (type) {
            case PREORDER -> preorderRecursive();
            case INORDER -> inorderRecursive();
            case POSTORDER -> postorderRecursive();
            case LEVEL_ORDER -> levelOrder();
        };

    }
}