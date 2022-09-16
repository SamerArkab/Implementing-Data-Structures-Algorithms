def quick_sort(arr, low_p, high_p):
    if low_p < high_p:
        pivot = partition(arr, low_p, high_p)
        quick_sort(arr, low_p, pivot - 1)
        quick_sort(arr, pivot + 1, high_p)


def partition(arr, low_p, high_p):
    pivot = arr[high_p]
    i = low_p - 1

    for j in range(low_p, high_p):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i + 1], arr[high_p] = arr[high_p], arr[i + 1]
    return i + 1


array = [5, 4, 9, 8, 44, 0, 100]
quick_sort(array, 0, len(array) - 1)
print(array)
