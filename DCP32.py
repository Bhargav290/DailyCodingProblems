from typing import List, Optional


def target_sum(arr: List[int], k: int) -> Optional[List[int]]:
    if not arr:
        return None
    elem = arr[0]
    if elem == k:
        return [elem]
    # generating the subset
    possible_subset = target_sum(arr[1:], k - elem)
    if possible_subset is not None:
        return [elem] + possible_subset
    return target_sum(arr[1:], k)


if __name__ == "__main__":
    print(target_sum([12, 1, 61, 5, 9, 2], 24))