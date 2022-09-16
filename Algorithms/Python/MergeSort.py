def merge_sort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        first_h = arr[:mid]
        second_h = arr[mid:]

        merge_sort(first_h)
        merge_sort(second_h)

        i = j = k = 0
        while i < len(first_h) and j < len(second_h):
            if first_h[i] < second_h[j]:
                arr[k] = first_h[i]
                i += 1
            else:
                arr[k] = second_h[j]
                j += 1
            k += 1

        while i < len(first_h):
            arr[k] = first_h[i]
            i += 1
            k += 1
        while j < len(second_h):
            arr[k] = second_h[j]
            j += 1
            k += 1


array = [5, 4, 9, 8, 44, 0, 100]
merge_sort(array)
print(array)
