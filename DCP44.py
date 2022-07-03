from typing import List, Tuple


def merge(part_a: List[int], part_b: List[int]) -> Tuple[List[int], int]:
    # helper function for merge sort
    i, j = 0, 0
    merged_array = []
    a, a_inv = part_a
    b, b_inv = part_b
    inversions = a_inv + b_inv
    length_a, length_b = len(a), len(b)
    # merging the arrays
    while i < length_a and j < length_b:
        if a[i] < b[j]:
            merged_array.append(a[i])
            i += 1
        else:
            merged_array.append(b[j])
            inversions += length_a - i
            j += 1
    while i < length_a:
        merged_array.append(a[i])
        i += 1
    while j < length_b:
        merged_array.append(b[j])
        j += 1
    return merged_array, inversions


def merge_sort(arr: List[int]) -> Tuple[List[int], int]:
    length = len(arr)
    if length in (0, 1):
        return arr, 0

    mid = length // 2
    merged_array, inversions = merge(merge_sort(arr[:mid]), merge_sort(arr[mid:]))
    return merged_array, inversions


def count_inversions(arr: List[int]) -> int:
    _, inversions = merge_sort(arr)
    return inversions


if __name__ == "__main__":
    print(count_inversions([1, 2, 3, 4, 5]))
    print(count_inversions([2, 1, 3, 4, 5]))