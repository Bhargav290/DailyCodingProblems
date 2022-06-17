from typing import List, Optional, Tuple


def get_itinerary(
    flights: List[Tuple[str, str]],
    current_position: str,
    current_itinerary: List[str] = [],)\
        -> Optional[List[str]]:
    if not flights and current_itinerary:
        return current_itinerary + [current_position]
    elif not flights:
        return None

    resulatant_itinerary = None
    # generating the itinerary
    for index, (src, dest) in enumerate(flights):
        # the is constructed using the current position (using DFS)
        if current_position == src:
            child_itinerary = get_itinerary(
                flights[:index] + flights[index + 1 :], dest, current_itinerary + [src]
            )
            if child_itinerary and (
                not resulatant_itinerary or child_itinerary < resulatant_itinerary
            ):
                resulatant_itinerary = child_itinerary
    return resulatant_itinerary


if __name__ == "__main__":
    print(
        get_itinerary(
            [("SFO", "HKO"), ("YYZ", "SFO"), ("YUL", "YYZ"), ("HKO", "ORD")], "YUL"
        )
    )