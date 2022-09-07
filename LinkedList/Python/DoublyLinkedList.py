class Node:
    def __init__(self, element):
        self.element = element
        self.next = None
        self.prev = None


class DoublyLinkedList:
    def __init__(self):
        self.head = None

    def insert_head(self, val):
        if self.head is None:
            self.head = Node(val)
            return
        temp_node = Node(val)
        temp_node.next = self.head
        self.head.prev = temp_node
        self.head = temp_node

    def insert_tail(self, val):
        temp_node = Node(val)
        if self.head is None:
            self.head = temp_node
            return
        iterate = self.head
        while iterate.next:
            iterate = iterate.next
        iterate.next = temp_node
        temp_node.prev = iterate

    def insert_after(self, insert_after, val):  # IDE suggests method to be static since "self" isn't used...
        if insert_after is None:
            print("Node to insert new data after cannot be null.")
            return
        temp_node = Node(val)
        temp_node.next = insert_after.next
        insert_after.next = temp_node
        temp_node.prev = insert_after
        if temp_node.next:
            temp_node.next.prev = temp_node

    def delete_by_position(self, position):
        if self.head is None:
            print("Can't delete a non existent LL.")
            return
        iterate = self.head
        if position == 0:
            self.head = iterate.next
            self.head.prev = None
        for _ in range(position - 1):
            iterate = iterate.next
        if iterate.next is None or iterate is None:  # Since next is the node to be deleted
            print("Node isn't in LL.")
            return
        new_next = iterate.next.next
        iterate.next = new_next
        if iterate.next is not None:
            iterate.next.prev = iterate.prev

    def search(self, val):
        iterate = self.head
        while iterate is not None:
            if iterate.element == val:
                return True
            iterate = iterate.next
        return False

    def sort(self):  # Use Bubble sort
        if self.head is None or self.head.next is None:
            print("Nothing to sort...")
            return
        temp_head = self.head
        next_to_curr = Node(None)
        while temp_head is not None:
            next_to_curr = temp_head.next
            while next_to_curr is not None:
                if temp_head.element > next_to_curr.element:
                    temp_head.element, next_to_curr.element = next_to_curr.element, temp_head.element
                next_to_curr = next_to_curr.next
            temp_head = temp_head.next

    def print_ll(self):
        iterate = self.head
        while iterate is not None:
            print(str(iterate.element) + "   ", end='')
            iterate = iterate.next
        print()


my_ll = DoublyLinkedList()
my_ll.insert_head(5)
my_ll.insert_after(my_ll.head, 10)
my_ll.insert_head(15)
my_ll.insert_tail(20)
my_ll.insert_after(my_ll.head.next.next.next, 25)

my_ll.print_ll()

my_ll.delete_by_position(2)
my_ll.delete_by_position(2)
my_ll.insert_after(my_ll.head.next, 500)
my_ll.print_ll()

my_ll.sort()
my_ll.print_ll()
