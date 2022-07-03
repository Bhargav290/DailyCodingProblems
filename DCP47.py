from typing import List, Optional


def get_max_profit(arr: List[int]) -> Optional[int]:
    length = len(arr)
    if length < 2:
        return None

    min_element = arr[0]
    profit = max(0, arr[1] - arr[0])
    # generating the maximum profit
    for i in range(1, length):
        min_element = min(min_element, arr[i])
        profit = max(profit, arr[i] - min_element)
    return profit


if __name__ == "__main__":
    print(get_max_profit([9, 11, 8, 5, 7, 10]))
    print(get_max_profit([1, 2, 3, 4, 5]))
    print(get_max_profit([5, 4, 3, 2, 1]))