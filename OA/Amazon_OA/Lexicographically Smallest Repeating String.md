https://www.desiqna.in/19282/amazon-sde-intern-questions-amazon-questions-kumar-july-2026

# Lexicographically Smallest Repeating String

## Problem Statement

You are given a lowercase English string `S` of length `N` and an integer `K`.

Your task is to construct the **lexicographically smallest** string `T` of length `K` such that repeating `T` enough times can generate the original string `S`.

Let

```
repeat = ceil(N / K)
```

If `T` is repeated `repeat` times, then for every character, the total number of occurrences in the repeated string must be **at least** its number of occurrences in `S`.

Return the lexicographically smallest valid string `T`.

---

## Input Format

- The first line contains a string `S`.
- The second line contains an integer `K`.

---

## Output Format

Print the lexicographically smallest string of length `K`.

---

## Constraints

- `1 ≤ K ≤ N ≤ 2 × 10^5`
- `S` consists only of lowercase English letters (`'a'`–`'z'`).

---

## Example 1

### Input

```
S = "abbbbcccdd"
K = 8
```

### Output

```
aaabbccd
```

### Explanation

The original string has the following frequencies:

| Character | Frequency |
|-----------|----------:|
| a | 1 |
| b | 4 |
| c | 3 |
| d | 2 |

Since

```
repeat = ceil(10 / 8) = 2
```

each copy of the answer must contain at least:

| Character | Required |
|-----------|---------:|
| a | ceil(1/2) = 1 |
| b | ceil(4/2) = 2 |
| c | ceil(3/2) = 2 |
| d | ceil(2/2) = 1 |

which gives

```
abbccd
```

This has length `6`, so we still need `2` more characters.

To obtain the lexicographically smallest string, prepend two `'a'` characters:

```
aaabbccd
```

Repeating it twice gives

```
aaabbccdaaabbccd
```

which contains enough occurrences of every character to construct the original string.

---

## Example 2

### Input

```
S = "aaaa"
K = 2
```

### Output

```
aa
```

---

## Example 3

### Input

```
S = "abc"
K = 3
```

### Output

```
abc
```

---

## Approach

1. Count the frequency of every character.
2. Compute

```
repeat = ceil(N / K)
```

3. For every character, include

```
ceil(freq / repeat)
```

copies in the answer.
4. If the answer length is still smaller than `K`, fill the remaining positions with `'a'` to obtain the lexicographically smallest string.
5. Return the sorted answer.

---

## Complexity Analysis

- **Time Complexity:** `O(N + 26)`
- **Space Complexity:** `O(26)`
