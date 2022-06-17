from typing import List


def get_unique(arr: List[int]) -> int:
    # Sum the bits in same positions for all the numbers modulo with 3 provides the
    # unique number's bit
    unique_elem = 0
    mask = 1
    # iterate through all the bits (considering a 64 bit integer)
    for _ in range(64):
        sum_i_pos_bits = 0
        # calculating the sum of the bits in the current position
        for elem in arr:
            if elem & mask != 0:
                sum_i_pos_bits = sum_i_pos_bits + 1
        # updating the unique element
        if sum_i_pos_bits % 3 == 1:
            unique_elem = unique_elem | mask
        # updating mask
        mask = mask << 1
    return unique_elem


if __name__ == "__main__":
    arr = [3, 3, 2, 3]
    print(get_unique(arr))