def heapify(arr, size, i):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2
    if left < size and arr[i] < arr[left]:
        largest = left
    if right < size and arr[i] < arr[right]:
        largest = right
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  # Swap
        heapify(arr, size, largest)


def insert(arr, num):
    size = len(arr)
    if size == 0:
        arr.append(num)
    else:
        arr.append(num)
        for i in range(size // 2, -1, -1):  # From size//2 to 0 in steps of -1
            heapify(arr, size + 1, i)


def delete(arr, num):
    size = len(arr)
    i = 0
    for i in range(0, size):
        if num == arr[i]:
            break
    arr[i], arr[size - 1] = arr[size - 1], arr[i]  # Swap
    arr.remove(num)
    for i in range(size // 2, -1, -1):
        heapify(arr, size - 1, i)


def peek(arr):
    print(arr[0])


def extract(arr):
    ret = arr[0]
    delete(arr, arr[0])
    return ret


my_heap = []

for j in range(0, 10):
    insert(my_heap, j)
for k in range(1, 5, 2):
    delete(my_heap, k)

print(my_heap)

peek(my_heap)
print(extract(my_heap))
