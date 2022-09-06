def is_empty(front_r):
    return front_r[0] == -1


def is_full(front_rear_r, queue_size):
    return (front_rear_r[1] + 1) % queue_size == front_rear_r[0]
    # front_rear_r[1] + 1 since queue_size - 1 generates an error in case queue_size == 1 (of course can't modulo 0)


def enqueue(q, enqueue_element, queue_size, front_rear_r):
    if is_full(front_rear_r, queue_size):
        print("Queue is full.")
        return
    print("New element enqueued: " + str(enqueue_element))
    if is_empty(front_rear_r):
        front_rear_r[0] = 0
        front_rear_r[1] = 0
        q[front_rear_r[1]] = enqueue_element
    else:
        front_rear_r[1] = (front_rear_r[1] + 1) % queue_size
        q[front_rear_r[1]] = enqueue_element


def dequeue(q, front_rear_r, queue_size):
    if is_empty(front_rear_r):
        print("Queue is empty.")
        return
    if front_rear_r[0] == front_rear_r[1] + 1:
        dequeued = q[front_rear_r[0]]
        front_rear_r[0] = -1
        front_rear_r[1] = -1
        return dequeued
    else:
        dequeued = q[front_rear_r[0]]
        front_rear_r[0] = (front_rear_r[0] + 1) % queue_size
        return dequeued


def peek(q, front_r):
    if is_empty(front_r):
        print("Queue is empty. ", end='')
        return
    return q[front_r[0]]


def print_queue(q, front_rear_r, queue_size):
    if is_empty(front_rear_r):
        print("Queue is empty.")
        return
    print("Print queue: ", end='')
    if front_rear_r[1] >= front_rear_r[0]:  # Simply print from front to rear
        for element in range(front_rear_r[0], front_rear_r[1] + 1):
            print(str(q[element]) + "    ", end='')
        print()
    else:  # Print from front to end of queue, then from index 0 to rear (circular printing)
        for element in range(front_rear_r[0], queue_size):
            print(str(q[element]) + "    ", end='')
        for element in range(front_rear_r[1] + 1):
            print(str(q[element]) + "    ", end='')
        print()


size = int(input("Please enter queue size: "))
queue = [None] * size  # Need to create a fixed sized list for circular queue (in order to work with indexes)
front_rear = [-1, -1]  # List to pass by reference through methods

print(is_empty(front_rear))
print(is_full(front_rear, size))

enqueue(queue, 1, size, front_rear)

enqueue(queue, 2, size, front_rear)

enqueue(queue, 3, size, front_rear)

print(is_empty(front_rear))
print(is_full(front_rear, size))

print_queue(queue, front_rear, size)

enqueue(queue, 4, size, front_rear)

print("Dequeued from queue: " + str(dequeue(queue, front_rear, size)))
enqueue(queue, 5, size, front_rear)
print_queue(queue, front_rear, size)

print("Peek first in queue: " + str(peek(queue, front_rear)))
