"""
Problem:
Suppose you are given a table of currency exchange rates, represented as a 2D array.
Determine whether there is a possible arbitrage: that is, whether there is some
sequence of trades you can make, starting with some amount A of any currency, so that
you can end up with some amount greater than A of that currency.
There are no transaction costs and you can trade fractional quantities.
"""
from math import log
from typing import Union

number = Union[int, float]


def arbitrage(table: number) -> bool:
    transformed_graph = [[-log(edge) for edge in row] for row in table]
    source = 0
    n = len(transformed_graph)
    min_dist = [float("inf")] * n
    min_dist[source] = 0
    for _ in range(n - 1):
        for v in range(n):
            for w in range(n):
                if min_dist[w] > min_dist[v] + transformed_graph[v][w]:
                    min_dist[w] = min_dist[v] + transformed_graph[v][w]
    for v in range(n):
        for w in range(n):
            if min_dist[w] > min_dist[v] + transformed_graph[v][w]:
                return True
    return False


if __name__ == "__main__":
    print(arbitrage([[1, 2], [0.5, 1]]))
    print(arbitrage([[1, 3, 4], [2, 1, 3], [5, 2, 1]]))
