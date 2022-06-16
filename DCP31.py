def get_string_distance(str1: str, str2: str) -> int:
    n = len(str1)
    m = len(str2)
    dp = [[0 for x in range(m + 1)] for x in range(n + 1)]
    for i in range(n + 1):
        for j in range(m + 1):
            if i == 0:
                dp[i][j] = j
            elif j == 0:
                dp[i][j] = i
            elif str1[i - 1] == str2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1]
            else:
                dp[i][j] = 1 + min(
                    dp[i][j - 1],       # insertion
                    dp[i - 1][j],       # deletion
                    dp[i - 1][j - 1],   # replacement
                )
    return dp[n][m]


if __name__ == "__main__":
    print(get_string_distance("kitten", "sitting"))