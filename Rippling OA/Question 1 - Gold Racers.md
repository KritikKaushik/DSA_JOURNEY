# 

## Problem Statement

The Redbird Sports Club wants to send a team for a relay race. There are `n` racers indexed from `0` to `n - 1`, each with a speed represented by the array `speed`.

The coach wants to send a contiguous segment of racers with the same speed to ensure a uniform team. To maximize the team size, the coach may remove **at most `k` racers** from the group.

Given the array of racer speeds and an integer `k`, find the **maximum possible number of racers in a contiguous segment with the same speed** after removing at most `k` racers.

---

## Example

**Input**

```
n = 6
k = 2
speed = [1, 4, 4, 2, 2, 4]
```

**Explanation**

The optimal strategy is to remove the two racers with speed `2`, resulting in:

```
[1, 4, 4, 4]
```

Now there are **3 contiguous racers** with speed `4`, which is the maximum possible.

**Output**

```
3
```

---

## Function Description

Complete the function:

```cpp
int getMaxRacers(vector<int> speed, int k)
```

### Parameters

- `speed`: An array containing the speeds of the racers.
- `k`: The maximum number of racers that can be removed.

### Returns

- `int`: The maximum number of racers that can be sent after removing at most `k` racers.

---

## Constraints

- `1 ≤ n ≤ 3 × 10^5`
- `1 ≤ k ≤ n`
- `1 ≤ speed[i] ≤ 10^5`

---

## Input Format (Custom Testing)

- First line: Integer `n`
- Next `n` lines: `speed[i]`
- Last line: Integer `k`

---

## Output Format

Print a single integer representing the maximum number of racers that can be sent.
