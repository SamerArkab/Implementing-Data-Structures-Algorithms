package implementing_BT;

public class BinarySearchTree {
	Node root;

	public Node search(int data) {
		return search(root, data);
	}

	private Node search(Node node, int data) {
		if (node == null) {
			System.out.println("No such node.");
			return null;
		}
		if (data == node.data) // Found
			return node;
		else if (data < node.data)
			return search(node.left, data);
		else
			return search(node.right, data);
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if (node == null)
			node = new Node(data);
		else if (data < node.data)
			node.left = insert(node.left, data);
		else if (data > node.data)
			node.right = insert(node.right, data);
		else
			throw new IllegalArgumentException("BST already contains key " + data);
		return node;
	}

	public void delete(int data) {
		root = delete(root, data);
	}

	private Node delete(Node node, int data) {
		if (node == null)
			return null;
		// Find node to delete
		if (data < node.data)
			node.left = delete(node.left, data);
		else if (data > node.data)
			node.right = delete(node.right, data);
		else if (node.left == null && node.right == null)
			node = null; // Delete it, no children
		else if (node.left == null) // Has one child, make it the current node
			node = node.right;
		else if (node.right == null)
			node = node.left;
		else { // Node has two children
			Node successor = findMin(node.right);
			node.data = successor.data;
			node.right = delete(node.right, successor.data);
		}
		return node;
	}

	public Node findMin(Node node) {
		while (node.left != null)
			node = node.left;
		return node;
	}

	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.data + " >> ");
		inorder(node.right);
	}

	public static void main(String[] args) {
		BinarySearchTree myBST = new BinarySearchTree();
		myBST.insert(3);
		myBST.insert(4);
		myBST.insert(1);
		myBST.insert(2);
		myBST.insert(6);
		myBST.insert(7);
		myBST.insert(5);
		myBST.inorder(myBST.root);
		System.out.println();

		if (myBST.search(8) != null)
			System.out.println("Found!");

		myBST.delete(4);
		myBST.inorder(myBST.root);
		System.out.println();

		Node minNode = myBST.findMin(myBST.root);
		System.out.println(minNode.data);
	}
}