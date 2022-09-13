package implementing_BT;

public class BalancedBT {
	Node root;

	public int isBalanced(Node node) {
		if (node == null) {
			return 0;
		}
		int leftSubTreeHeight = isBalanced(node.left); // recursive call basically until node == null
		if (leftSubTreeHeight == -1)
			return -1;
		int rightSubTreeHeight = isBalanced(node.right);
		if (rightSubTreeHeight == -1)
			return -1;

		if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) // difference in height of left\right subtrees
			return -1;

		return (Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1);
	}

	public static void main(String[] args) {
		BalancedBT myTree = new BalancedBT();
		myTree.root = new Node(10);
		myTree.root.left = new Node(8);
		myTree.root.right = new Node(11);
		myTree.root.left.left = new Node(7);
		myTree.root.left.right = new Node(9);
		// myTree.root.left.left.left = new Node(5);

		if (myTree.isBalanced(myTree.root) != -1)
			System.out.println("This is a Balanced BT!");
		else
			System.out.println("This is not a Balanced BT!");
	}
}