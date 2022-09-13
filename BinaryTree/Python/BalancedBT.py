class Node:
    def __init__(self, data):
        self.data = data
        self.right = None
        self.left = None


def is_balanced(node):
    if node is None:
        return 0
    left_subtree_height = is_balanced(node.left)
    if left_subtree_height == -1:
        return -1
    right_subtree_height = is_balanced(node.right)
    if right_subtree_height == -1:
        return -1

    if abs(left_subtree_height - right_subtree_height) > 1:
        return -1

    return max(left_subtree_height, right_subtree_height) + 1


root = Node(10)
root.left = Node(8)
root.right = Node(11)
root.left.left = Node(7)
root.left.right = Node(9)
# root.left.left.left = Node(5)

if is_balanced(root) != -1:
    print("This is a Balanced BT!")
else:
    print("This is not a Balanced BT!")
