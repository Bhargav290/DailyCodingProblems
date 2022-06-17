from typing import List


def get_power_set(arr: List[int]) -> List[List[int]]:
    power_set = [[]]
    # generating the power set
    for elem in arr:
        # generating the new sets
        additional_sets = []
        for subset in power_set:
            subset_copy = [subset_elem for subset_elem in subset]
            subset_copy.append(elem)
            additional_sets.append(subset_copy)
        # adding the new sets to the power set
        power_set.extend(additional_sets)
    return power_set


if __name__ == "__main__":
    print(get_power_set([1, 2, 3]))