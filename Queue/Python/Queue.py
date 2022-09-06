def is_empty(front_r):
    return front_r == -1


def is_full(rear_r, queue_size):
    return rear_r == queue_size - 1


def enqueue(q, enqueue_element, queue_size, front_rear_r):
    if is_full(front_rear_r[1], queue_size):
        print("Queue is full.")
        return
    print("New element enqueued: " + str(enqueue_element))
    if is_empty(front_rear_r[0]):
        front_rear_r[0] = 0
    q.append(enqueue_element)
    front_rear_r[1] += 1


def dequeue(q, front_rear_r):
    if is_empty(front_rear_r[0]):
        print("Queue is empty.")
        return
    dequeued = q.pop(0)  # pop(0) complexity is O(n) since it moves all elements after popping -> FIXED in CircularQueue
    front_rear_r[1] -= 1
    if front_rear_r[0] == front_rear_r[1] + 1:
        front_rear_r[0] = -1
        front_rear_r[1] = -1
    return dequeued


def peek(q, front_r):
    if is_empty(front_r):
        print("Queue is empty. ", end='')
        return
    return q[0]


def print_queue(q, front_rear_r):
    if is_empty(front_rear_r[0]):
        print("Queue is empty.")
        return
    print("Print queue: ", end='')
    for front_r in range(front_rear_r[1] - front_rear_r[0] + 1):
        print(str(q[front_r]) + "    ", end='')
    print()


size = int(input("Please enter queue size: "))
queue = []
front_rear = [-1, -1]  # List to pass by reference through methods

print(is_empty(front_rear[0]))
print(is_full(front_rear[1], size))

enqueue(queue, 1, size, front_rear)
enqueue(queue, 2, size, front_rear)
enqueue(queue, 3, size, front_rear)

print(is_empty(front_rear[0]))
print(is_full(front_rear[1], size))

print_queue(queue, front_rear)

enqueue(queue, 4, size, front_rear)

print("Dequeued from queue: " + str(dequeue(queue, front_rear)))

print_queue(queue, front_rear)

print("Peek first in queue: " + str(peek(queue, front_rear[0])))
