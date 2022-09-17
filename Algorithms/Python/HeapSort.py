def heap_sort(arr):
    length = len(arr)
    for i in range(length//2, -1, -1):
        heapify(arr, length, i)

    for i in range(length - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0)


def heapify(arr, length, i):
    largest = i
    left_child = 2 * i + 1
    right_child = 2 * i + 2
    if left_child < length and arr[left_child] > arr[largest]:
        largest = left_child
    if right_child < length and arr[right_child] > arr[largest]:
        largest = right_child
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, length, largest)


my_array = [0, 5, 50, 47, 80, 1, 99, 5]
heap_sort(my_array)
print(my_array)
