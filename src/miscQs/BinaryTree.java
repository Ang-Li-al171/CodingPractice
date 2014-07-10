package miscQs;

import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {
		BinaryTree BT = new BinaryTree();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Node root = null;
		for (int i = 0; i < n; i++) {
			root = BT.addToTree(root, in.nextInt());
		}
		System.out.println(findPredecessor(root, root.left).v);
	}

	private static void printBinaryTree(Node root) {
		if (root == null)
			return;
		// preorder
		System.out.println(root.v);
		printBinaryTree(root.left);
		printBinaryTree(root.right);
	}

	private static void postOrderTraversal(Node root) {
		if (root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.v);
	}

	private static void inOrderTraversal(Node root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.println(root.v);
		inOrderTraversal(root.right);
	}

	private Node addToTree(Node root, int v) {
		if (root == null) {
			return new Node(v);
		}
		Node curr = root;
		Node prev = null;
		int left = -1;
		while (curr != null) {
			if (curr.v < v) {
				prev = curr;
				curr = curr.right;
				left = 0;
			} else if (curr.v == v) {
				return root;
			} else {
				prev = curr;
				curr = curr.left;
				left = 1;
			}
		}
		if (left == 1) {
			prev.left = new Node(v);
		} else {
			prev.right = new Node(v);
		}
		return root;
	}

	private class Node {
		int v;
		Node left;
		Node right;

		public Node(int v) {
			this.v = v;
			left = null;
			right = null;
		}
	}

	private static Node search(Node r, int v) {
		Node curr = r;
		while (curr != null) {
			if (curr.v == v) {
				return curr;
			} else if (curr.v < v) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		return null;
	}

	private static Node findSuccessor(Node r, Node t) {
		if (t.right != null) {
			Node p = t.right;
			while (p.left != null) {
				p = p.left;
			}
			return p;
		} else {
			Node p = r;
			Node prev = null;
			while (p != t) {
				if (p == null)
					return null;
				if (p.v > t.v) {
					prev = p;
					p = p.left;
				} else {
					p = p.right;
				}
			}
			return prev.v>t.v?prev:null;
		}
	}

	private static Node findPredecessor(Node r, Node t) {
		if (t.left != null) {
			Node p = t.left;
			while (p.right != null) {
				p = p.right;
			}
			return p;
		} else {
			Node p = r;
			Node prev = null;
			while (p != t) {
				if (p == null)
					return null;
				if (p.v < t.v) {
					prev = p;
					p = p.right;
				} else {
					p = p.left;
				}
			}
			return prev.v<t.v?prev:null;
		}
	}

}
