import java.util.Scanner;

public class LCA {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node LowestAncestor(Node root, Node n1, Node n2) {
        while (root != null) {
            if (root.data > n1.data && root.data > n2.data) {
                root = root.left;
            } else if (root.data < n1.data && root.data < n2.data) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    private static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    private static Node find(Node root, int value) {
        while (root != null) {
            if (value < root.data) {
                root = root.left;
            } else if (value > root.data) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        int value1 = sc.nextInt();
        int value2 = sc.nextInt();

        Node n1 = find(root, value1);
        Node n2 = find(root, value2);

        if (root == null || n1 == null || n2 == null) {
            System.out.println("One or both nodes not found in the tree.");
        } else {
            LCA solver = new LCA();
            Node ancestor = solver.LowestAncestor(root, n1, n2);
            if (ancestor != null) {
                System.out.println(ancestor.data);
            } else {
                System.out.println("Lowest common ancestor not found.");
            }
        }
        sc.close();
    }
}
