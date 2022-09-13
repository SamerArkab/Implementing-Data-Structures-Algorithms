# Full Binary Tree
# Perfect Binary Tree
# Complete Binary Tree

class Node:
    def __init__(self, data):
        self.data = data
        self.right = None
        self.left = None


def is_full_bt(node):
    if node is None:
        return True
    if node.left is None and node.right is None:
        return True
    if node.left is not None and node.right is not None:
        return is_full_bt(node.left) and is_full_bt(node.right)
    return False


def calculate_depth(node):
    d = -1  # Initialize
    while node is not None:
        d += 1
        node = node.left
    return d


def is_perfect_bt(node, d, level=0):  # Default level value is 0
    if node is None:
        return True
    if node.left is None and node.right is None:
        return d == level + 1
    if node.left is None or node.right is None:
        return False
    return is_perfect_bt(node.left, d, level + 1) and is_perfect_bt(node.right, d, level + 1)


def count_node(node):
    if node is None:
        return 0
    return 1 + count_node(node.left) + count_node(node.right)


def is_complete_bt(node, num_nodes, index=0):  # Default index values is 0
    if node is None:
        return True
    if index >= num_nodes:
        return False
    return is_complete_bt(node.left, num_nodes, 2 * index + 1) and is_complete_bt(node.right, num_nodes, 2 * index + 2)


root = Node(10)
root.left = Node(8)
root.right = Node(11)
root.left.left = Node(7)
root.left.right = Node(9)

if is_full_bt(root):
    print("This is a Full BT!")
else:
    print("This is not a Full BT!")

tree_depth = calculate_depth(root)
if is_perfect_bt(root, tree_depth):
    print("This is a Perfect BT!")
else:
    print("This is not a Perfect BT!")

num_of_nodes = count_node(root)
if is_complete_bt(root, num_of_nodes):
    print("This is a Complete BT!")
else:
    print("This is not a Complete BT!")
