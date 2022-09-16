def binary_search(arr, to_find, low_pointer, high_pointer):
    if high_pointer >= low_pointer:
        mid = (low_pointer + high_pointer) // 2
        if arr[mid] == to_find:
            return mid
        if arr[mid] > to_find:
            return binary_search(arr, to_find, low_pointer, mid - 1)
        return binary_search(arr, to_find, mid + 1, high_pointer)
    return -1


test_arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
find_val = 3
result = binary_search(test_arr, find_val, 0, len(test_arr) - 1)
if result == -1:
    print("The value (" + str(find_val) + ") was not found.")
else:
    print("The value (" + str(find_val) + ") was found!")
