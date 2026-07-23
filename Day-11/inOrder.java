import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class inOrder {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public List<Integer> inOrderTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        // Loop until current node is null AND the stack is empty
        while (current != null || !stack.isEmpty()) {
            // 1. Traverse to the leftmost node, pushing each node onto the stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 2. Current is null here. Pop the top node from the stack
            current = stack.pop();

            // 3. Add the popped node's value to the result list
            result.add(current.data);

            // 4. Move to the right child to process the right subtree
            current = current.right;
        }

        return result;
    }

    private static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        inOrder solution = new inOrder();
        List<Integer> traversal = solution.inOrderTree(root);
        for (int value : traversal) {
            System.out.print(value + " ");
        }
        System.out.println();
        sc.close();
    }
}
