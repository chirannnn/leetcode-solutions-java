## 1. Sqrt(x)

**Problem**:  
Given a non-negative integer `x`, return the **integer part** of its square root (i.e., `⌊√x⌋`).  
You must not use built-in exponentiation functions like `pow()` or `x ** 0.5`.

---

**Approach**: Binary Search on Square Domain

- Search space: `start = 0`, `end = x`
- For each `mid`, compute `mid²` and compare with `x`
  - If `mid² == x` → return `mid`
  - If `mid² < x` → store `mid` as potential answer and move right
  - If `mid² > x` → move left
- Final answer is the largest `mid` such that `mid² ≤ x`

---

**Complexity**:

- **Time**: O(log x) – binary search
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: x = 8

Search space: [0, 8]
→ mid = 4 → 16 > 8 → move left
→ mid = 2 → 4 < 8 → store 2, move right
→ mid = 3 → 9 > 8 → move left

Final answer: 2
```

---

**Key Takeaway**:

- This is a classic **binary search on monotonic function**.
- Efficiently avoids floating-point math.
- Handles large inputs safely using `long` for squaring.

---

**Pattern**:

- Binary search over numeric domain
- Monotonic function evaluation
- Integer approximation

---

**Edge Cases**:

- `x = 0` → return 0
- `x = 1` → return 1
- Large `x` → avoid overflow by casting `mid * mid` to `long`

🔗 [LeetCode – Sqrt(x)](https://leetcode.com/problems/sqrtx)

---

## 2. Guess Number Higher or Lower

**Problem**:  
You're playing a number guessing game. The number is picked from `1` to `n`, and you must find it using a pre-defined API:

```java
int guess(int num)
```

which returns:

- `0` → correct guess
- `-1` → guess is too high
- `1` → guess is too low

Your task is to **find the picked number** using **as few guesses as possible**.

---

**Approach**: Binary Search with Feedback API

- Initialize `start = 1`, `end = n`
- While `start ≤ end`:
  - Compute `mid = start + (end - start) / 2`
  - Call `guess(mid)`:
    - If result is `0` → return `mid`
    - If result is `-1` → move left → `end = mid - 1`
    - If result is `1` → move right → `start = mid + 1`

---

**Complexity**:

- **Time**: O(log n) – binary search
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: n = 10, pick = 6

→ mid = 5 → guess = 1 → move right
→ mid = 8 → guess = -1 → move left
→ mid = 6 → guess = 0 → found

Output: 6
```

---

**Key Takeaway**:

- This is a classic **binary search with feedback loop**.
- Efficiently narrows down the search space using API hints.
- Common in interactive problems and system design simulations.

---

**Pattern**:

- Binary search
- Feedback-driven narrowing
- Midpoint probing

---

**Edge Cases**:

- `n = 1` → only one guess needed
- `pick = n` → search goes all the way to the end
- `pick = 1` → search ends early

🔗 [LeetCode – Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower)

---

## 3. First Bad Version

**Problem**:  
You're given `n` product versions `[1, 2, ..., n]`.  
One version fails the quality check, and **all versions after it are also bad**.  
Using the API `isBadVersion(version)`, find the **first bad version** with **minimal API calls**.

---

**Approach**: Binary Search for Transition Point

- Initialize `start = 1`, `end = n`
- While `start < end`:
  - Compute `mid = start + (end - start) / 2`
  - If `isBadVersion(mid)` is `true` → move left → `end = mid`
  - Else → move right → `start = mid + 1`
- Loop ends when `start == end`, which is the **first bad version**

---

**Complexity**:

- **Time**: O(log n) – binary search
- **Space**: O(1) – constant space
- **API calls**: minimized to log-scale

---

**Example**:

```text
Input: n = 5, bad = 4

→ mid = 3 → isBadVersion(3) = false → move right
→ mid = 4 → isBadVersion(4) = true → move left
→ start == end == 4 → return 4

Output: 4
```

---

**Key Takeaway**:

- This is a classic **binary search on monotonic boolean function**.
- Efficiently finds the transition point from `false` to `true`.
- Optimized for minimal API usage — no redundant checks.

---

**Pattern**:

- Binary search
- Transition detection
- API-driven narrowing

---

**Edge Cases**:

- `n = 1` → only one version → return 1 if bad
- `bad = n` → search goes all the way to the end
- `bad = 1` → search ends early

🔗 [LeetCode – First Bad Version](https://leetcode.com/problems/first-bad-version)

---

## 4. Two Sum II – Input Array Is Sorted

**Problem**:  
Given a **1-indexed**, sorted array `numbers`, find two distinct elements that add up to a given `target`.  
Return their indices as `[index1, index2]` (1-based).  
You must use **constant extra space**.

---

**Approach**: Two-Pointer Scan

- Initialize two pointers:
  - `start = 0` (beginning of array)
  - `end = n - 1` (end of array)
- While `start < end`:
  - Compute `sum = numbers[start] + numbers[end]`
  - If `sum == target` → return `[start + 1, end + 1]`
  - If `sum > target` → move `end--` to reduce sum
  - If `sum < target` → move `start++` to increase sum

---

**Complexity**:

- **Time**: O(n) – single pass
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: numbers = [2,3,4], target = 6

→ start = 0, end = 2 → sum = 2 + 4 = 6 → match

Output: [1,3]
```

---

**Key Takeaway**:

- This is a classic **two-pointer pattern** for sorted arrays.
- Efficiently finds the pair without extra space or hash maps.
- Guaranteed to find a solution due to problem constraints.

---

**Pattern**:

- Two-pointer traversal
- Sorted array optimization
- Sum comparison logic

---

**Edge Cases**:

- Negative numbers → handled naturally
- Duplicates → not reused due to `start < end`
- Only one valid pair → loop exits early

🔗 [LeetCode – Two Sum II](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted)

---

## 5. Valid Perfect Square

**Problem**:  
Given a positive integer `num`, return `true` if it is a **perfect square**, else return `false`.  
You must not use built-in functions like `sqrt()` or exponentiation.

---

**Approach**: Binary Search on Square Domain

- Search space: `start = 1`, `end = num`
- For each `mid`, compute `mid²` using `long` to avoid overflow
  - If `mid² == num` → return `true`
  - If `mid² > num` → move left → `end = mid - 1`
  - If `mid² < num` → move right → `start = mid + 1`
- If loop ends without match → return `false`

---

**Complexity**:

- **Time**: O(log num) – binary search
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: num = 8

→ mid = 4 → 16 > 8 → move left
→ mid = 2 → 4 < 8 → move right
→ mid = 3 → 9 > 8 → move left

Loop ends → no match → return false
```

---

**Key Takeaway**:

- This is a classic **binary search on monotonic function**.
- Efficiently checks for perfect squares without floating-point math.
- Using `long` for squaring avoids overflow for large inputs.

---

**Pattern**:

- Binary search
- Integer approximation
- Overflow-safe arithmetic

---

**Edge Cases**:

- `num = 1` → return true
- `num = 0` → not allowed (positive integers only)
- Large `num` → safely handled via `long` casting

🔗 [LeetCode – Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square)

---

## 6. Arranging Coins

**Problem**:  
Given `n` coins, build a staircase with `k` rows such that the `i-th` row has exactly `i` coins.  
Return the number of **complete rows** that can be formed.  
The last row may be incomplete.

---

**Approach**: Binary Search on Triangular Sum

- Each complete row `i` requires `i` coins → total coins for `k` rows = `k(k+1)/2`
- Use binary search to find the **maximum `k`** such that:
  - `k(k+1)/2 ≤ n`
- If `mid` rows require more coins than `n`, move left
- If valid, store `mid` and move right to try for more rows

---

**Complexity**:

- **Time**: O(log n) – binary search
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: n = 8

Search space: [1, 8]
→ mid = 4 → 4×5/2 = 10 > 8 → move left
→ mid = 2 → 2×3/2 = 3 < 8 → move right
→ mid = 3 → 3×4/2 = 6 ≤ 8 → move right

Final answer: 3
```

---

**Key Takeaway**:

- This is a classic **binary search on monotonic math function**.
- Efficiently finds the largest `k` such that `k(k+1)/2 ≤ n`.
- Avoids brute-force iteration and handles large `n` safely using `long`.

---

**Pattern**:

- Binary search over numeric domain
- Triangular number evaluation
- Integer approximation

---

**Edge Cases**:

- `n = 0` → return 0
- `n = 1` → return 1
- Large `n` → safely handled via `long` casting

🔗 [LeetCode – Arranging Coins](https://leetcode.com/problems/arranging-coins)

---

## 7. Find Smallest Letter Greater Than Target

**Problem**:  
Given a sorted array of characters `letters`, return the **smallest character** that is **lexicographically greater** than a given `target`.  
If no such character exists, return the **first character** in the array (wraparound behavior).

---

**Approach**: Binary Search with Wraparound

- Use binary search to find the **first character greater than `target`**
- If `letters[mid] > target` → move left → `end = mid - 1`
- Else → move right → `start = mid + 1`
- After loop ends, `start` points to the smallest character greater than `target`
- Use `start % letters.length` to handle wraparound (e.g., when `target ≥ all letters`)

---

**Complexity**:

- **Time**: O(log n) – binary search
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: letters = ['c','f','j'], target = 'c'

→ mid = 1 → letters[1] = 'f' > 'c' → move left
→ mid = 0 → letters[0] = 'c' == 'c' → move right

Loop ends → start = 1 → letters[1] = 'f'

Output: 'f'
```

---

**Key Takeaway**:

- This is a **binary search for upper bound**.
- The `% letters.length` trick elegantly handles wraparound.
- Works even with duplicate characters and edge targets.

---

**Pattern**:

- Binary search for next-greater element
- Wraparound indexing
- Lexicographic comparison

---

**Edge Cases**:

- `target < letters[0]` → return letters[0]
- `target ≥ letters[n-1]` → wraparound → return letters[0]
- Duplicates → handled naturally
- All characters same → return first character

🔗 [LeetCode – Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target)

---

## 8. Kth Missing Positive Number

**Problem**:  
Given a strictly increasing array `arr` of positive integers and an integer `k`, return the **kth missing positive number** that is not present in `arr`.

---

**Approach**: Binary Search on Missing Count

- For each index `i`, the number of missing elements before `arr[i]` is:
  - `missing = arr[i] - (i + 1)`
- Use binary search to find the **first index** where `missing ≥ k`
  - If `missing < k` → move right → `start = mid + 1`
  - If `missing ≥ k` → move left → `end = mid - 1`
- After the loop, `start` is the number of elements present before the kth missing
- Final answer: `start + k`

---

**Complexity**:

- **Time**: O(log n) – binary search
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: arr = [2,3,4,7,11], k = 5

→ mid = 2 → arr[2] = 4 → missing = 4 - (2 + 1) = 1 → move right
→ mid = 3 → arr[3] = 7 → missing = 7 - 4 = 3 → move right
→ mid = 4 → arr[4] = 11 → missing = 11 - 5 = 6 → move left

Loop ends → start = 3 → answer = 3 + 5 = 8

Output: 9
```

---

**Key Takeaway**:

- This is a clever **binary search on the difference between expected and actual values**.
- Efficiently finds the kth missing number without scanning all gaps.
- Works even when `k` exceeds the last element in `arr`.

---

**Pattern**:

- Binary search on derived metric
- Gap analysis
- Index-based simulation

---

**Edge Cases**:

- `k` is smaller than first element → return `k` directly
- `k` is larger than all missing before last element → handled by `start + k`
- Array starts at 1 → missing count = 0 at index 0

🔗 [LeetCode – Kth Missing Positive Number](https://leetcode.com/problems/kth-missing-positive-number)

---
