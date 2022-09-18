class Node:
    def __init__(self):
        self.data = None
        self.priority = None
        self.next = None


def new_node(d, p):
    tp = Node()
    tp.data = d
    tp.priority = p
    tp.next = None
    return tp


def peek(head):
    return head.data


def delete(head):
    head = head.next
    return head


def insert(head, d, p):
    start = head
    tp = new_node(d, p)
    if head.priority > p:
        tp.next = head
        head = tp
    else:
        while start.next is not None and start.next.priority < p:
            start = start.next
        tp.next = start.next
        start.next = tp
    return head


def is_empty(head):
    if head is None:
        return True
    return False


pq = new_node(4, 1)
pq = insert(pq, 3, 3)
pq = insert(pq, 2, 0)
pq = insert(pq, 1, 0)

while not is_empty(pq):
    print(peek(pq), end=' ')
    pq = delete(pq)

