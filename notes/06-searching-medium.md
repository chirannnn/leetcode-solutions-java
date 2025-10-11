## 1. Find First and Last Position of Element in Sorted Array

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

🔗 [LeetCode – Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

---

## 2. Single Element in a Sorted Array

**Problem**:  
Given a sorted array where every element appears **exactly twice**, except for **one element** that appears **only once**, return that single element.  
Must run in **O(log n)** time and **O(1)** space.

---

**Approach**: Binary Search with Pair Indexing

- Every pair starts at an **even index**: `[0,1], [2,3], [4,5]...`
- Use binary search to find the **first index where this pairing breaks**
- At each `mid`:
  - If `mid` is even and `nums[mid] == nums[mid + 1]` → pairing is valid → move right
  - If `mid` is odd and `nums[mid] == nums[mid - 1]` → pairing is valid → move right
  - Else → pairing breaks → move left
- Loop ends when `start == end` → single element found

---

**Complexity**:

- **Time**: O(log n) – binary search
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: nums = [1,1,2,3,3,4,4,8,8]

→ mid = 4 → nums[4] = 3 == nums[3] → valid pair → move right
→ mid = 6 → nums[6] = 4 == nums[7] → valid pair → move right
→ mid = 7 → nums[7] = 8 == nums[8] → valid pair → move right
→ mid = 8 → end reached → single element is nums[2] = 2

Output: 2
```

---

**Key Takeaway**:

- This is a **binary search on index parity**.
- Efficiently skips over pairs to isolate the unpaired element.
- Works only because the array is sorted and all other elements appear exactly twice.

---

**Pattern**:

- Binary search
- Pair validation via index parity
- Unpaired element detection

---

**Edge Cases**:

- Single element at start or end → handled naturally
- Array length is odd → always one unique element
- No duplicates → not valid input per constraints

🔗 [LeetCode – Single Element in a Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array)

---
