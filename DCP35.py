from typing import List


def segregate(arr: List[str]) -> None:
    length = len(arr)
    pos = 0
    # pass for segregating "R"s
    for i in range(length):
        if arr[i] == "R":
            arr[i], arr[pos] = arr[pos], arr[i]
            pos += 1
    # pass for segregating "G"s
    for i in range(pos, length):
        if arr[i] == "G":
            arr[i], arr[pos] = arr[pos], arr[i]
            pos += 1


if __name__ == "__main__":
    arr = ["G", "B", "R", "R", "B", "R", "G"]
    segregate(arr)
    print(arr)