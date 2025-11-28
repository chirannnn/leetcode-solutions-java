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
Given an array of intervals `intervals[i] = [start, end]` where each `start` is unique, return an array of indices representing the **right interval** for each interval.

- A right interval for `i` is an interval `j` such that `start[j] >= end[i]` and `start[j]` is minimized.
- If no right interval exists, return `-1` for that index.

---

### 🔍 Core Idea: Sort Starts + Binary Search

- Each interval’s **end** needs to be matched with the **smallest start ≥ end**.
- Store all starts with their original indices.
- Sort starts by value.
- For each interval, binary search in the sorted starts to find the smallest start ≥ current end.
- Return the corresponding index, or `-1` if none exists.

---

### 🧠 Algorithm Breakdown

#### Step 1: Preprocess Starts

- Build array `starts[i] = [startValue, originalIndex]`.
- Sort by `startValue`.

#### Step 2: For Each Interval

- Let `currEnd = intervals[i][1]`.
- Binary search in `starts` for smallest `start ≥ currEnd`.
- If found → record its original index.
- Else → record `-1`.

#### Step 3: Return Result

- Collect results into `ans[]`.

---

### ✅ Example Walkthrough

```text
intervals = [[3,4],[2,3],[1,2]]

→ starts = [[3,0],[2,1],[1,2]]
→ Sorted: [[1,2],[2,1],[3,0]]

Check each interval:
- [3,4]: need start ≥ 4 → none → -1
- [2,3]: need start ≥ 3 → found [3,0] → index=0
- [1,2]: need start ≥ 2 → found [2,1] → index=1

→ Output: [-1,0,1] ✅
```

```text
intervals = [[1,4],[2,3],[3,4]]

→ starts = [[1,0],[2,1],[3,2]]
→ Sorted: [[1,0],[2,1],[3,2]]

Check each interval:
- [1,4]: need start ≥ 4 → none → -1
- [2,3]: need start ≥ 3 → found [3,2] → index=2
- [3,4]: need start ≥ 4 → none → -1

→ Output: [-1,2,-1] ✅
```

---

### 📐 Complexity

| Aspect    | Value                                             |
| --------- | ------------------------------------------------- |
| Time      | O(n log n) (sorting + binary search per interval) |
| Space     | O(n) (starts array + result)                      |
| Technique | Sorting + Binary Search                           |

---

### 🔁 Pattern

- Preprocess values with original indices
- Sort for ordered search
- Binary search for minimal satisfying condition
- Common in interval scheduling and range queries

---

### 🚀 Alternative Approaches

- **Brute Force**:
  - For each interval, scan all others → O(n²).
- **TreeMap (Java)**:
  - Store starts in TreeMap, use `ceilingKey(end)` → O(n log n).
- **Heap-based**:
  - Less direct, but can be adapted.

---

### ⚠️ Edge Cases

- Single interval → always `-1`.
- No valid right interval → `-1` for that index.
- Multiple intervals with overlapping ends → binary search ensures smallest valid start is chosen.

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

## 9. Maximum Value at a Given Index in a Bounded Array

**Problem**:  
Construct an array `nums` of length `n` such that:

- `nums[i]` is a positive integer
- Adjacent values differ by at most 1 → `|nums[i] - nums[i+1]| ≤ 1`
- Total sum ≤ `maxSum`
- Maximize `nums[index]`

Return the **maximum value** at `nums[index]` that satisfies all constraints.

---

### 🔍 Core Idea: Simulate a Mountain

- The array forms a **mountain** centered at `index`
- Values decrease by 1 to the left and right
- If the peak is too small to fill all positions, pad remaining spots with `1`s
- Use **binary search** to find the highest peak that fits within `maxSum`

---

### 🧠 Algorithm Breakdown

#### Step 1: Binary Search on Peak Value

- Search range: `start = 1` to `end = maxSum`
- For each `mid` (candidate peak), calculate total sum of the mountain
- If sum ≤ `maxSum` → try higher peak
- If sum > `maxSum` → try lower peak

#### Step 2: Calculate Total Sum Efficiently

- Split array into:
  - Left slope: from `index - 1` to `0`
  - Peak: `nums[index] = mid`
  - Right slope: from `index + 1` to `n - 1`
- Use **arithmetic series** formulas:
  - If peak > side length → full decreasing sequence
  - Else → partial slope + padding with `1`s

---

### 📐 Complexity

- **Time**: O(log maxSum) × O(1) → efficient binary search with constant-time math
- **Space**: O(1)

---

### ✅ Example

```text
Input: n = 4, index = 2, maxSum = 6

Try peak = 3 → sum = 7 → too high
Try peak = 2 → sum = 6 → valid

Output: 2
```

---

### 🔁 Pattern

- Binary search over answer space
- Simulation via math, not construction
- Arithmetic series for slope modeling

---

### ⚠️ Edge Cases

- Peak at edge → one slope is empty
- Peak too small → fill with `1`s
- maxSum too low → peak = 1

🔗 [LeetCode – Maximum Value at a Given Index in a Bounded Array](https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array)

---

## 10. Koko Eating Bananas

**Problem**:  
Given an array `piles` where each element is the number of bananas in a pile, and an integer `h` representing hours before the guards return, find the **minimum integer speed `k`** such that Koko can eat all bananas within `h` hours.

---

### 🔍 Core Idea: Binary Search on Speed

- Koko can eat `k` bananas per hour from **one pile per hour**
- If a pile has fewer than `k` bananas, she eats the whole pile in one hour
- We want the **smallest `k`** such that total hours ≤ `h`

---

### 🧠 Algorithm Breakdown

#### Step 1: Define Search Space

- Minimum speed = 1
- Maximum speed = max pile size (Koko never needs to eat faster than the largest pile)

#### Step 2: Binary Search

- Try mid-speed `k`
- Simulate total hours needed at speed `k`
- If hours ≤ `h` → try slower speed (move left)
- If hours > `h` → try faster speed (move right)

#### Step 3: Time Calculation

- For each pile:
  \[
  \text{hours} += \left\lceil \frac{\text{pile}}{k} \right\rceil = \frac{\text{pile} + k - 1}{k}
  \]
- This avoids floating-point division and rounds up efficiently

---

### ✅ Example

```text
Input: piles = [30,11,23,4,20], h = 6

→ Try k = 15 → total hours = 7 → too slow
→ Try k = 23 → total hours = 6 → valid
→ Try k = 22 → total hours = 6 → valid
→ Try k = 21 → total hours = 6 → valid
→ Try k = 20 → total hours = 7 → too slow

Final answer: 23
```

---

### 📐 Complexity

- **Time**: O(log maxPile × n)
- **Space**: O(1)

---

### 🔁 Pattern

- Binary search over answer space
- Greedy simulation
- Ceiling division for time modeling

---

### ⚠️ Edge Cases

- One pile → speed = ceil(pile / h)
- h = piles.length → must eat one pile per hour
- Large piles, small h → speed must be high

🔗 [LeetCode – Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas)

---

## 11. Minimum Absolute Sum Difference

**Problem**:  
Given two arrays `nums1` and `nums2` of equal length `n`, minimize the **total absolute sum difference** defined as:

\[
\text{Total} = \sum\_{i=0}^{n-1} |nums1[i] - nums2[i]|
\]

You may **replace at most one element** in `nums1` with **any other element from `nums1`** to reduce this total.  
Return the **minimum possible total**, modulo \(10^9 + 7\).

---

### 🔍 Core Idea: Maximize Reduction with One Smart Replacement

- **Step 1**: Compute the base total difference without any replacement.
- **Step 2**: For each index `i`, find the best possible replacement in `nums1` that minimizes `|nums1[i] - nums2[i]|`.
- **Step 3**: Track the **maximum reduction** across all indices.
- **Step 4**: Final answer = `baseTotal - maxReduction`, modulo \(10^9 + 7\)

---

### 🧠 Optimization Strategy

- **Sort a copy of `nums1`** → enables binary search for closest match to `nums2[i]`
- For each `i`:
  - `originalDiff = |nums1[i] - nums2[i]|`
  - `bestDiff = |closest(nums1) - nums2[i]|`
  - `reduction = originalDiff - bestDiff`
- Track the **maximum reduction** across all `i`

---

### 📐 Complexity

| Aspect    | Value         |
| --------- | ------------- |
| Time      | O(n log n)    |
| Space     | O(n)          |
| Technique | Binary Search |

---

### ✅ Example

```text
nums1 = [1,7,5]
nums2 = [2,3,5]

→ Base total = |1-2| + |7-3| + |5-5| = 1 + 4 + 0 = 5

→ Try replacing 7 with 1 or 5 → bestDiff = 2 → reduction = 2

→ Final answer = 5 - 2 = 3
```

---

### 🔁 Pattern

- Greedy optimization
- Binary search over sorted array
- One-shot replacement strategy

---

### ⚠️ Edge Cases

- Arrays already equal → return 0
- No better replacement → return base total
- Multiple candidates → pick one with **maximum reduction**

🔗 [LeetCode – Minimum Absolute Sum Difference](https://leetcode.com/problems/minimum-absolute-sum-difference)

---

## 12. Search a 2D Matrix

**Problem**:  
Given a matrix with the following properties:

- Each row is sorted in ascending order
- The first element of each row is greater than the last of the previous row  
  Determine if a given `target` exists in the matrix.  
  Must run in **O(log(m × n))** time.

---

### 🔍 Core Idea: Treat the Matrix as a Flattened 1D Array

- Because of the matrix’s structure, it behaves like a **sorted 1D array**
- We can apply **binary search** directly over the range `[0, m × n - 1]`
- Convert 1D index `mid` to 2D coordinates:
  - `row = mid / cols`
  - `col = mid % cols`

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize Search Space

- `start = 0`, `end = rows × cols - 1`

#### Step 2: Binary Search

- Compute `mid = (start + end) / 2`
- Convert `mid` to `matrix[mid / cols][mid % cols]`
- Compare with `target`:
  - If equal → return `true`
  - If less → search right
  - If greater → search left

#### Step 3: Return `false` if not found

---

### 📐 Complexity

| Aspect    | Value         |
| --------- | ------------- |
| Time      | O(log(m × n)) |
| Space     | O(1)          |
| Technique | Binary Search |

---

### ✅ Example

```text
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 3

→ Flattened array: [1,3,5,7,10,11,16,20,23,30,34,60]
→ Binary search finds 3 at index 1 → return true
```

---

### 🔁 Pattern

- Binary search on 2D grid
- Index mapping: 1D ↔ 2D
- Sorted matrix traversal

---

### ⚠️ Edge Cases

- Empty matrix → return false
- Target smaller than first or larger than last → return false
- Matrix with one row or one column → handled naturally

🔗 [LeetCode – Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix)

---

## 13. Find a Peak Element II

**Problem**:  
Given an `m × n` matrix `mat` where:

- Each cell is unique from its adjacent neighbors (no equal neighbors)
- A **peak** is a cell strictly greater than its **up, down, left, and right** neighbors  
  Find **any one** peak and return its coordinates `[i, j]`.

**Constraints**:

- The matrix is surrounded by a virtual border of `-1`s
- Must run in **O(m log n)** or **O(n log m)** time

---

### 🔍 Core Idea: Binary Search on Columns

Instead of checking every cell, we:

1. **Pick a middle column**
2. **Find the row with the maximum value** in that column
3. **Compare** that value with its left and right neighbors
   - If it's greater than both → it's a **peak**
   - If left neighbor is greater → move search to **left half**
   - If right neighbor is greater → move search to **right half**
4. Repeat until a peak is found

---

### 🧠 Why This Works

- The matrix has **no equal adjacent values**, so we’re guaranteed to move toward a peak
- At each step, we eliminate half the columns → **log(n)** steps
- Each step takes **O(m)** time to find the column max

---

### 📐 Complexity

| Aspect    | Value                    |
| --------- | ------------------------ |
| Time      | O(m log n)               |
| Space     | O(1)                     |
| Technique | Binary Search on Columns |

---

### ✅ Example

```text
Input: mat = [[10,20,15],
              [21,30,14],
              [7,16,32]]

→ midCol = 1 → column = [20,30,16]
→ maxRow = 1 → mat[1][1] = 30
→ left = 21, right = 14 → 30 > both → peak found

Output: [1,1]
```

---

### 🔁 Pattern

- 2D peak finding
- Binary search on matrix dimensions
- Greedy movement toward higher neighbor

---

### ⚠️ Edge Cases

- Single row or column → handled naturally
- Peak at edge → perimeter is `-1`, so edge values can be peaks
- Multiple peaks → return any one

🔗 [LeetCode – Find a Peak Element II](https://leetcode.com/problems/find-a-peak-element-ii)

---

## 14. Frequency of the Most Frequent Element

**Problem**:  
Given an array `nums` and an integer `k`, you can perform at most `k` operations.  
Each operation lets you **increment any element by 1**.  
Return the **maximum frequency** of any element you can achieve.

---

### 🔍 Core Idea: Make Elements Equal by Incrementing Smaller Ones

- You want to **maximize how many elements can become equal** to a target value
- You can only **increment**, not decrement
- So for each target value, try to **raise smaller elements** to match it using at most `k` operations

---

### 🧪 Brute Force Approach (Current)

- For each `nums[i]`, assume it’s the target
- Try to make other elements equal to it by incrementing
- Track how many elements you can match within `k` operations

---

### ✅ Example

```text
nums = [1,2,4], k = 5

→ Try target = 4:
  - 1 → needs 3 ops
  - 2 → needs 2 ops
  → total = 5 ops → frequency = 3

Output: 3
```

---

### 📐 Complexity

| Aspect    | Value       |
| --------- | ----------- |
| Time      | O(n²)       |
| Space     | O(1)        |
| Technique | Brute Force |

---

### 🔁 Pattern

- Frequency maximization
- Greedy increment strategy
- Brute force with future optimization potential

---

### 🚀 Optimization Plan (O(n log n) Sliding Window)

- **Sort `nums`** → makes it easier to work with increasing values
- Use a **sliding window** to find the largest group of elements that can be made equal to `nums[right]`
- Maintain a running cost:
  \[
  \text{cost} = \text{window size} \times nums[right] - \text{sum of window}
  \]
- If cost ≤ `k`, update max frequency

---

### ⚠️ Edge Cases

- All elements already equal → return `n`
- `k = 0` → return frequency of most frequent element
- Large `k` → can make all elements equal

🔗 [LeetCode – Frequency of the Most Frequent Element](https://leetcode.com/problems/frequency-of-the-most-frequent-element)

---

## 15. Find the Duplicate Number

**Problem**:  
Given an array `nums` of length `n + 1` where each number is in the range `[1, n]`, and **exactly one number is repeated**, return the duplicate.  
Constraints:

- **Do not modify** the array
- Use **constant extra space**
- Time complexity: better than O(n²)

---

### 🔍 Core Idea: Floyd’s Tortoise and Hare (Cycle Detection)

Treat the array as a **linked list**:

- Each index is a node
- Each value is a pointer to the next node
- Because of the duplicate, there’s a **cycle** in this graph

---

### 🧠 Algorithm Breakdown

#### Step 1: Detect Cycle

- Initialize `slow = nums[0]`, `fast = nums[0]`
- Move:
  - `slow = nums[slow]`
  - `fast = nums[nums[fast]]`
- Continue until `slow == fast` → cycle detected

#### Step 2: Find Cycle Entrance (Duplicate)

- Reset one pointer to start: `ptr1 = nums[0]`
- Keep other at meeting point: `ptr2 = slow`
- Move both one step at a time:
  - `ptr1 = nums[ptr1]`
  - `ptr2 = nums[ptr2]`
- When they meet again → that index is the **duplicate**

---

### ✅ Example

```text
nums = [1,3,4,2,2]

→ Linked list view:
  0 → 1 → 3 → 2 → 4 → 2 → (cycle)

→ slow and fast meet at 2
→ reset one pointer, move both → meet again at 2

Output: 2
```

---

### 📐 Complexity

| Aspect    | Value           |
| --------- | --------------- |
| Time      | O(n)            |
| Space     | O(1)            |
| Technique | Cycle Detection |

---

### 🔁 Pattern

- Linked list cycle detection
- Pointer-based traversal
- Graph modeling of array indices

---

### ⚠️ Edge Cases

- All elements same → cycle at start
- Duplicate at end → cycle loops back
- Multiple duplicates → not allowed by constraints

🔗 [LeetCode – Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number)

---

## 16. Capacity to Ship Packages Within D Days

**Problem**:  
Given an array `weights[]` representing package weights and an integer `days`, find the **minimum ship capacity** required to deliver all packages **in order** within `days` days.

---

### 🔍 Core Idea: Binary Search on Capacity

Instead of brute-forcing capacities, we:

- Define a **search space** from `max(weights)` to `sum(weights)`
- Use **binary search** to find the smallest capacity that allows shipping within `days`

---

### 🧠 Algorithm Breakdown

#### Step 1: Define Search Space

- **Minimum capacity** = `max(weights)` → must fit the heaviest package
- **Maximum capacity** = `sum(weights)` → can ship everything in one day

#### Step 2: Binary Search

- Try `mid` as candidate capacity
- Simulate shipping:
  - Accumulate weights until exceeding `mid`
  - Count how many days are needed
- If `daysNeeded > days` → capacity too small → move right
- Else → try smaller capacity → move left

#### Step 3: Return Final Capacity

- When `start == end`, we’ve found the **minimum valid capacity**

---

### ✅ Example

```text
weights = [1,2,3,1,1], days = 4

→ Search space: [3, 8]
→ mid = 5 → 3 days → valid → try smaller
→ mid = 4 → 3 days → valid → try smaller
→ mid = 3 → 4 days → valid → done

Output: 3
```

---

### 📐 Complexity

| Aspect    | Value                      |
| --------- | -------------------------- |
| Time      | O(n × log(sum(weights)))   |
| Space     | O(1)                       |
| Technique | Binary Search + Simulation |

---

### 🔁 Pattern

- Binary search over answer space
- Greedy simulation
- Load balancing with constraints

---

### ⚠️ Edge Cases

- One package per day → capacity = max(weights)
- All packages in one day → capacity = sum(weights)
- Large weights, small days → capacity must be high

🔗 [LeetCode – Capacity to Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days)

---
