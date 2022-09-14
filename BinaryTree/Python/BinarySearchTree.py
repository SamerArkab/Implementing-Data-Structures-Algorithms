class Node:
    def __init__(self, data):
        self.data = data
        self.right = None
        self.left = None


def search(node, data):
    if node is None:
        print("No such node.")
        return
    if data == node.data:
        return node
    elif data < node.data:
        return search(node.left, data)
    else:
        return search(node.right, data)


def insert(node, data):
    if node is None:
        node = Node(data)
    elif data < node.data:
        node.left = insert(node.left, data)
    elif data > node.data:
        node.right = insert(node.right, data)
    else:
        print("BST already contains key " + str(data))
    return node


def delete(node, data):
    if node is None:
        return
    if data < node.data:
        node.left = delete(node.left, data)
    elif data > node.data:
        node.right = delete(node.right, data)
    elif node.left is None and node.right is None:
        node = None
    elif node.left is None:
        node = node.right
    elif node.right is None:
        node = node.left
    else:
        successor = find_min(node.right)
        node.data = successor.data
        node.right = delete(node.right, successor.data)
    return node


def find_min(node):
    while node.left is not None:
        node = node.left
    return node


def inorder(node):
    if node is None:
        return
    inorder(node.left)
    print(str(node.data) + " >> ", end='')
    inorder(node.right)


root = Node(3)
insert(root, 4)
insert(root, 1)
insert(root, 2)
insert(root, 6)
insert(root, 7)
insert(root, 5)
inorder(root)
print()

if search(root, 8) is not None:
    print("Found!")

delete(root, 4)
inorder(root)
print()

min_node = find_min(root)
print(min_node.data)
