def get_nearest_palindrome(string: str) -> str:
    if string[::-1] == string:
        return string
    # generating the closest palindrome possible
    length = len(string)
    if string[0] == string[-1]:
        return string[0] + get_nearest_palindrome(string[1 : length - 1]) + string[0]
    # incase the 1st characters are different, strings using both the characters are
    # generated
    pal_1 = string[0] + get_nearest_palindrome(string[1:]) + string[0]
    pal_2 = string[-1] + get_nearest_palindrome(string[: length - 1]) + string[-1]
    # if one of the string is shorter, it is returned
    if len(pal_1) != len(pal_2):
        return min(pal_1, pal_2, key=lambda x: len(x))
    # if both strings have the same length, the lexicographically earliest one is
    # returned
    return min(pal_1, pal_2)


if __name__ == "__main__":
    print(get_nearest_palindrome("race"))
    print(get_nearest_palindrome("google"))
