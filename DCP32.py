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
