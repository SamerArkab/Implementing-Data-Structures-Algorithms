package implementing_BT;

//Normal tree... not BT, etc.
public class TreeTraversal {
	Node root = null;

	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.data + " >> ");
		inorder(node.right);
	}

	public void preorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " >> ");
		preorder(node.left);
		preorder(node.right);
	}

	public void postorder(Node node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " >> ");
	}

	public static void main(String[] args) {
		TreeTraversal myTree = new TreeTraversal();
		// Build the tree like BT to demonstrate that In-order traversal can also
		// extract the data as sorted
		myTree.root = new Node(10);
		myTree.root.left = new Node(8);
		myTree.root.right = new Node(11);
		myTree.root.left.left = new Node(7);
		myTree.root.left.right = new Node(9);

		System.out.println("In-order traversal:");
		myTree.inorder(myTree.root);
		System.out.println();

		System.out.println("Pre-order traversal:");
		myTree.preorder(myTree.root);
		System.out.println();

		System.out.println("Post-order traversal:");
		myTree.postorder(myTree.root);
	}
}
