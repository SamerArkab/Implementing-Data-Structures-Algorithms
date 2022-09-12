class Node:
    def __init__(self, data):
        self.data = data
        self.right = None
        self.left = None


def inorder(node):
    if node is None:
        return
    inorder(node.left)
    print(str(node.data) + " >> ", end='')
    inorder(node.right)


def preorder(node):
    if node is None:
        return
    print(str(node.data) + " >> ", end='')
    preorder(node.left)
    preorder(node.right)


def postorder(node):
    if node is None:
        return
    postorder(node.left)
    postorder(node.right)
    print(str(node.data) + " >> ", end='')


root = Node(10)
root.left = Node(8)
root.right = Node(11)
root.left.left = Node(7)
root.left.right = Node(9)

print("In-order traversal: ")
inorder(root)
print()

print("Pre-order traversal: ")
preorder(root)
print()

print("Post-order traversal: ")
postorder(root)
