from random import randint
from typing import List

# implementation of a function that generates perfectly random numbers between 1 and k
def generate_random_number_in_range(k: int) -> int:
    return randint(1, k)


def swap() -> List[int]:
    # generating the card list
    cards = [card_no for card_no in range(1, 53)]
    # shuffling the cards
    for i in range(52):
        swap_position = generate_random_number_in_range(52) - 1
        cards[i], cards[swap_position] = cards[swap_position], cards[i]
    return cards


if __name__ == "__main__":
    print(*swap())
    print(*swap())
