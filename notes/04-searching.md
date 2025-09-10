## 1. Find Smallest Letter Greater Than Target

**Problem**:  
Given a sorted array of characters `letters` and a character `target`, return the **smallest character** in `letters` that is **lexicographically greater** than `target`.  
If no such character exists, return the **first character** in `letters`.

---

**Approach**: Binary Search with Wrap-Around

- Use binary search to find the **first character greater than `target`**
- If `target < letters[mid]`, search left half
- Else, search right half
- After the loop, `start` points to the correct index
- Use `start % letters.length` to handle wrap-around (e.g., when `target` is greater than all letters)

---

**Complexity**:

- **Time**: O(log n) – binary search
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: letters = ['c','f','j'], target = 'c'

Step-by-step:
→ mid = 1 → letters[1] = 'f' > 'c' → move left
→ mid = 0 → letters[0] = 'c' == 'c' → move right

Final start = 1 → letters[1] = 'f'
Output: 'f'
```

---

**Key Takeaway**:

- This is a classic **binary search variant**.
- The `% length` trick elegantly handles the **wrap-around** case.
- Works even when multiple duplicates exist.

---

**Pattern**:

- Binary search
- Lexicographic comparison
- Circular array logic

---

**Edge Cases**:

- `target` < all letters → return first greater
- `target` ≥ all letters → wrap-around to letters[0]
- Multiple duplicates → still returns correct next letter

🔗 [LeetCode – Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target)

---

## 2. Find First and Last Position of Element in Sorted Array

**Problem**:  
Given a sorted array `nums`, find the **starting and ending index** of a given `target`.  
If the target is not found, return `[-1, -1]`.  
You must solve it in **O(log n)** time.

---

**Approach**: Dual Binary Search

- Perform **two binary searches**:
  1. First to find the **leftmost (first) index** of `target`
  2. Second to find the **rightmost (last) index** of `target`
- Modify the binary search condition:
  - If `target == nums[mid]`, store `mid` as potential answer
    - If searching for first index → move `end = mid - 1`
    - If searching for last index → move `start = mid + 1`

---

**Complexity**:

- **Time**: O(log n) – two binary searches
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: nums = [5,7,7,8,8,10], target = 8

First search (find first index):
→ mid = 2 → nums[2] = 7 < 8 → start = 3
→ mid = 4 → nums[4] = 8 → ans = 4, end = 3
→ mid = 3 → nums[3] = 8 → ans = 3, end = 2

Second search (find last index):
→ mid = 4 → nums[4] = 8 → ans = 4, start = 5

Output: [3,4]
```

---

**Key Takeaway**:

- This is a classic **boundary search** problem.
- Requires careful control of binary search direction.
- Efficiently finds both ends of a target range.

---

**Pattern**:

- Binary search variant
- Left/right boundary detection
- Conditional narrowing

---

**Edge Cases**:

- Target not found → return `[-1, -1]`
- Empty array → return `[-1, -1]`
- All elements are target → return `[0, n-1]`

🔗 [LeetCode – Find First and Last Position of Element in Sorted Array](https://leetcodethehardway.com/solutions/0000-0099/find-first-and-last-position-of-element-in-sorted-array-medium)

---
