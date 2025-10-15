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

## 3. Search in Rotated Sorted Array

**Problem**:  
Given a sorted array `nums` that’s been **rotated at an unknown pivot**, return the index of a given `target`.  
If the target is not found, return `-1`.  
You must solve this in **O(log n)** time.

---

**Approach**: Pivot Detection + Binary Search

1. **Find the pivot index**:

   - Pivot is the index where the rotation occurs (i.e., the largest element).
   - Use binary search to detect the point where `arr[mid] > arr[mid + 1]` or `arr[mid - 1] > arr[mid]`.

2. **Binary search in the correct half**:

   - If `target == arr[pivot]` → return pivot
   - If `target ≥ arr[0]` → search in left half `[0, pivot - 1]`
   - Else → search in right half `[pivot + 1, n - 1]`

3. If no pivot is found (array is not rotated), perform standard binary search.

---

**Complexity**:

- **Time**: O(log n) – binary search for pivot + binary search for target
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: nums = [4,5,6,7,0,1,2], target = 0

Step 1: Find pivot → index = 3 (value = 7)

Step 2: target < nums[0] → search in right half [4,6]

Binary search → target found at index 4

Output: 4
```

---

**Key Takeaway**:

- This is a classic **Binary search on rotated array**.
- Efficiently narrows down the search space by detecting rotation.
- Handles both rotated and non-rotated arrays seamlessly.

---

**Pattern**:

- Pivot detection
- Conditional binary search
- Rotation-aware logic

---

**Edge Cases**:

- Array not rotated → fallback to standard binary search
- Single element → check directly
- Target not present → return `-1`

🔗 [LeetCode – Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

---

## 4. Search in Rotated Sorted Array II

**Problem**:  
Given a sorted array `nums` (possibly with duplicates) that’s been **rotated at an unknown pivot**, determine whether a given `target` exists in the array.  
You must minimize the number of operations — ideally achieving **O(log n)** time when possible.

---

**Approach**: Pivot Detection + Binary Search with Duplicate Handling

1. **Find the pivot index**:

   - Use modified binary search to locate the rotation point.
   - Handle duplicates by cautiously shrinking the search space when `arr[start] == arr[mid] == arr[end]`.

2. **Binary search in the correct half**:

   - If `target == arr[pivot]` → return `true`
   - If `target ≥ arr[0]` → search in left half `[0, pivot - 1]`
   - Else → search in right half `[pivot + 1, n - 1]`

3. If no pivot is found (array not rotated), perform standard binary search.

---

**Complexity**:

- **Time**:
  - **Best/Average**: O(log n)
  - **Worst (due to duplicates)**: O(n)
- **Space**: O(1)

---

**Example**:

```text
Input: nums = [2,5,6,0,0,1,2], target = 0

Step 1: Find pivot → index = 3 (value = 0)

Step 2: arr[pivot] == target → return true

Output: true
```

---

**Key Takeaway**:

- This is a **robust binary search** problem.
- Duplicates introduce ambiguity in pivot detection, requiring cautious boundary shrinking.
- Efficient for most inputs, but worst-case can degrade to linear time.

---

**Pattern**:

- Binary search with rotation
- Duplicate-aware pivot detection
- Conditional search partitioning

---

**Edge Cases**:

- All elements same → fallback to linear scan
- Target at pivot → early exit
- Target not present → return `false`
- No rotation → standard binary search

🔗 [LeetCode – Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii)

---

## 5. Find Minimum in Rotated Sorted Array

**Problem**:  
You’re given a **rotated sorted array** of **unique integers**.  
Return the **minimum element** in the array.  
Must run in **O(log n)** time.

**What’s a rotated array?**  
An array like `[0,1,2,4,5,6,7]` rotated 4 times becomes `[4,5,6,7,0,1,2]`.

---

**Approach**: Binary Search on Rotation Break

- Initialize `start = 0`, `end = n - 1`
- While `start < end`:
  - Compute `mid = start + (end - start) / 2`
  - If `nums[mid] > nums[end]` → minimum is in **right half**
  - If `nums[mid] < nums[end]` → minimum is in **left half or at mid**
  - If `nums[mid] == nums[end]` → shrink search space (only needed for duplicates)
- When loop ends, `start == end` → minimum found

---

**Example**:

```text
Input: nums = [4,5,6,7,0,1,2]

→ mid = 3 → nums[3] = 7 > nums[6] = 2 → move right
→ mid = 5 → nums[5] = 1 < nums[6] = 2 → move left
→ mid = 4 → nums[4] = 0 < nums[5] = 1 → move left

Loop ends → start == 4 → nums[4] = 0 → minimum
```

---

**Why Binary Search Works**:

- The array is **partially sorted** — either left or right half is always sorted.
- The **rotation pivot** breaks the order — the minimum lies at or near the pivot.
- Binary search exploits this structure to eliminate half the search space each time.

**Key Observations**:

- If `nums[mid] > nums[end]` → pivot is to the right
- If `nums[mid] < nums[end]` → pivot is to the left or at mid
- No need to check `nums[start]` — comparison with `nums[end]` is sufficient

**Complexity**:

- **Time**: O(log n)
- **Space**: O(1)

---

**Pattern**:

- Binary search on rotated array
- Pivot detection
- Minimum element localization

---

**Edge Cases**:

- No rotation → minimum is `nums[0]`
- Rotation at last index → minimum is `nums[n-1]`
- Array of length 1 → return `nums[0]`
- Duplicates → not applicable here (but handled via `end--` if needed)

🔗 [LeetCode – Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array)

---

## 6. Find Peak Element

**Problem**:  
Given a 0-indexed array `nums`, find a **peak element** — one that is **strictly greater than its neighbors**.  
Return its index. If multiple peaks exist, return **any one**.  
You must solve this in **O(log n)** time.

**Definition**:

- A peak is `nums[i]` such that:
  - `nums[i] > nums[i - 1]` (if `i > 0`)
  - `nums[i] > nums[i + 1]` (if `i < n - 1`)
- You can assume `nums[-1] = nums[n] = -∞` for edge comparison.

---

**Approach**: Binary Search on Slope Direction

- Initialize `start = 0`, `end = n - 1`
- While `start < end`:
  - Compute `mid = start + (end - start) / 2`
  - If `nums[mid] > nums[mid + 1]` → you're on a **descending slope** → peak is on the **left**
    - Move `end = mid`
  - Else → you're on an **ascending slope** → peak is on the **right**
    - Move `start = mid + 1`
- When loop ends, `start == end` → peak found

---

**Example**:

```text
Input: nums = [1,2,1,3,5,6,4]

→ mid = 3 → nums[3] = 3 < nums[4] = 5 → move right
→ mid = 4 → nums[4] = 5 < nums[5] = 6 → move right
→ mid = 5 → nums[5] = 6 > nums[6] = 4 → move left

Loop ends → start == 5 → peak = 6
```

---

**Why Binary Search Works**:

- The array may contain **multiple peaks**, but at least one peak **must exist** due to the boundary condition (`-∞`).
- By comparing `nums[mid]` and `nums[mid + 1]`, we can **guarantee** the direction of a peak.
- This is a **slope-based binary search**, not a value-based one.

**Key Observations**:

- You don’t need to check both neighbors — just `nums[mid]` vs `nums[mid + 1]` is enough.
- The peak can be at any index — even at the boundaries.

**Complexity**:

- **Time**: O(log n)
- **Space**: O(1)

---

**Pattern**:

- Binary search
- Slope detection
- Peak localization

---

**Edge Cases**:

- Single element → return index 0
- Peak at start or end → handled naturally
- Multiple peaks → any valid index is acceptable

🔗 [LeetCode – Find Peak Element](https://leetcode.com/problems/find-peak-element)

---

## 7. Find Right Interval

**Problem**:  
Given an array of intervals `[[start₀, end₀], [start₁, end₁], ...]`, return an array where each element is the **index of the "right interval"** for each interval.  
A "right interval" is one whose `start ≥ end` of the current interval, and among all such intervals, the one with the **smallest start**.

If no such interval exists, return `-1` for that position.

---

**Approach**: Brute Force Comparison

- For each interval `i`, extract its `end`
- Compare it with every other interval’s `start`
- Track the **smallest start ≥ end** and its index
- If no such interval exists, return `-1`

---

**Complexity**:

- **Time**: O(n²) – nested loop over all intervals
- **Space**: O(n) – result array

---

**Example**:

```text
Input: intervals = [[3,4],[2,3],[1,2]]

→ For [3,4]: no start ≥ 4 → -1
→ For [2,3]: [3,4] is valid → index 0
→ For [1,2]: [2,3] is valid → index 1

Output: [-1, 0, 1]
```

---

**Optimization Strategy**:

- **Preprocess**: Store each interval’s start and original index
- **Sort** the starts array
- For each interval’s `end`, use **binary search** to find the **smallest start ≥ end**
- This reduces time complexity to **O(n log n)**

**Why Binary Search Works**:

- Starts are unique and sorted → binary search gives the first valid right interval
- This is a classic **lower bound search** on a sorted array

---

**Optimized Complexity**:

- **Time**: O(n log n)
- **Space**: O(n)

---

**Pattern**:

- Interval matching
- Lower bound search
- Greedy + binary search hybrid

---

**Edge Cases**:

- Only one interval → always `-1`
- No valid right interval → return `-1`
- Right interval is the same interval → allowed (i == j)

🔗 [LeetCode – Find Right Interval](https://leetcode.com/problems/find-right-interval)

---

## 8. Reach a Number

**Problem**:  
You start at position `0` on an infinite number line.  
On the `i-th` move, you can go `i` steps left or right.  
Find the **minimum number of moves** needed to reach a given `target`.

---

**Approach**: Triangular Sum + Parity Check

### 🔢 Step 1: Normalize Target

- Convert `target` to positive → symmetry allows us to ignore direction.

### 🔢 Step 2: Find Minimum Moves `m` such that:

- Sum of first `m` natural numbers ≥ `target`
- Use formula:  
  \[
  \text{sum} = \frac{m(m+1)}{2}
  \]

### 🔢 Step 3: Check Parity

- If `(sum - target)` is **even**, we can flip some steps to reach `target`
- If **odd**, keep adding moves until the difference becomes even

---

**Complexity**:

- **Time**: O(√target) – grows slowly with target
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: target = 2

→ Try m = 1 → sum = 1 → not enough
→ Try m = 2 → sum = 3 → (3 - 2) = 1 → odd → not reachable
→ Try m = 3 → sum = 6 → (6 - 2) = 4 → even → reachable

Output: 3
```

---

**Key Takeaway**:

- This is a **simulation + math trick** problem.
- Uses **triangular number growth** and **parity flipping** to reach the target.
- Elegant solution avoids brute-force path tracking.

---

**Pattern**:

- Simulation
- Triangular number formula
- Parity-based correction

---

**Edge Cases**:

- Negative target → handled via absolute value
- Target = 0 → return 0
- Large target → handled efficiently via math

🔗 [LeetCode – Reach a Number](https://leetcode.com/problems/reach-a-number)

---
