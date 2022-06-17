from collections import deque
from typing import List


def calc_max_per_k_elems(arr: List[int], k: int) -> List[int]:
    length = len(arr)
    if not arr:
        return None
    if length <= k:
        return max(arr)
    # storing results (even though the problem states it can be directly printed)
    result = []
    dq = deque()
    # calculating the 1st element
    for i in range(k):
        while dq and arr[dq[-1]] < arr[i]:
            dq.pop()
        dq.append(i)
    result.append(arr[dq[0]])
    # generating the rest of the resultant elements
    for i in range(k, length):
        # removing all elements apart from the last k elements
        while dq and dq[0] <= i - k:
            dq.popleft()
        # removing the elements smaller than the current element
        while dq and arr[dq[-1]] < arr[i]:
            dq.pop()
        dq.append(i)
        result.append(arr[dq[0]])
    return result


if __name__ == "__main__":
    print(calc_max_per_k_elems([10, 5, 2, 7, 8, 7], 3))