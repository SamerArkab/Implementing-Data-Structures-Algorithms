package implementing_BT;

//Full Binary Tree
//Perfect Binary Tree
//Complete Binary Tree
public class BinaryTree {
	Node root;

	// Check if this is a Full BT
	public boolean isFullBT(Node node) {
		if (node == null)
			return true;
		if (node.left == null && node.right == null)
			return true;
		if (node.left != null && node.right != null)
			return isFullBT(node.left) && isFullBT(node.right);

		return false;
	}

	public int calculateDepth(Node node) {
		int d = -1;
		while (node != null) {
			d++;
			node = node.left;
		}
		return d;
	}

	// Check if this is a Perfect BT
	public boolean isPerfectBT(Node node, int depth, int level) {
		if (node == null)
			return true;
		if (node.left == null && node.right == null)
			return depth == level + 1;
		if (node.left == null || node.right == null)
			return false;

		return isPerfectBT(node.left, depth, level + 1) && isPerfectBT(node.right, depth, level + 1);
	}

	public int countNode(Node node) {
		if (node == null)
			return 0;
		return 1 + countNode(node.left) + countNode(node.right);
	}

	// Check if this is a Complete BT
	public boolean isCompleteBT(Node node, int i, int numNodes) {
		if (node == null)
			return true;
		if (i >= numNodes)
			return false;

		return isCompleteBT(node.left, (2 * i) + 1, numNodes) && isCompleteBT(node.right, (2 * i) + 2, numNodes);
	}

	public static void main(String[] args) {
		BinaryTree myTree = new BinaryTree();
		myTree.root = new Node(10);
		myTree.root.left = new Node(8);
		myTree.root.right = new Node(11);
		myTree.root.left.left = new Node(7);
		myTree.root.left.right = new Node(9);

		if (myTree.isFullBT(myTree.root))
			System.out.println("This is a Full BT!");
		else
			System.out.println("This is not a Full BT!");

		int treeDepth = myTree.calculateDepth(myTree.root);
		if (myTree.isPerfectBT(myTree.root, treeDepth, 0))
			System.out.println("This is a Perfect BT!");
		else
			System.out.println("This is not a Perfect BT!");

		int numNodes = myTree.countNode(myTree.root);
		if (myTree.isCompleteBT(myTree.root, 0, numNodes))
			System.out.println("This is a Complete BT!");
		else
			System.out.println("This is not a Complete BT!");
	}
}