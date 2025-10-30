## 1. Median of Two Sorted Arrays

**Problem**:  
Given two sorted arrays `nums1` and `nums2`, return the **median** of the combined array.  
Constraints:

- Must run in **O(log(min(m, n))** time
- Cannot merge the arrays

---

### 🔍 Core Idea: Binary Search on Partition Points

Instead of merging, we:

- **Partition both arrays** into left and right halves
- Ensure:
  - All elements in left ≤ all elements in right
  - Left half contains exactly half the total elements

---

### 🧠 Algorithm Breakdown

#### Step 1: Always Binary Search on Smaller Array

- Let `x = len(nums1)`, `y = len(nums2)`
- Search range: `start = 0`, `end = x`

#### Step 2: Partition Both Arrays

- `partitionX = (start + end) / 2`
- `partitionY = (x + y + 1) / 2 - partitionX`

#### Step 3: Identify Boundary Values

- `maxLeftX = nums1[partitionX - 1]` or `-∞` if empty
- `minRightX = nums1[partitionX]` or `+∞` if empty
- Same for `nums2`

#### Step 4: Check Valid Partition

- If `maxLeftX ≤ minRightY` and `maxLeftY ≤ minRightX`:
  - ✅ Valid split
  - If total length is even:
    \[
    \text{median} = \frac{\max(\text{maxLeftX}, \text{maxLeftY}) + \min(\text{minRightX}, \text{minRightY})}{2}
    \]
  - If odd:
    \[
    \text{median} = \max(\text{maxLeftX}, \text{maxLeftY})
    \]
- Else:
  - If `maxLeftX > minRightY` → move left
  - Else → move right

---

### ✅ Example

```text
nums1 = [1,3], nums2 = [2]

→ Total length = 3 → odd → median is middle element

→ partitionX = 1, partitionY = 1
→ Left: [1], [2] → max = 2
→ Right: [3], [] → min = ∞

Output: 2
```

---

### 📐 Complexity

| Aspect    | Value                       |
| --------- | --------------------------- |
| Time      | O(log(min(m, n))            |
| Space     | O(1)                        |
| Technique | Binary Search on Partitions |

---

### 🔁 Pattern

- Binary search over partition index
- Median extraction without merging
- Sorted array divide-and-conquer

---

### ⚠️ Edge Cases

- One array empty → median from the other
- Arrays of unequal length → handled naturally
- Total length even or odd → both cases supported

🔗 [LeetCode – Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays)

---

## 2. Find Minimum in Rotated Sorted Array II

**Problem**:  
Given a **rotated sorted array** `nums` that may contain **duplicates**, return the **minimum element**.  
You must minimize the number of operations — ideally better than linear scan.

---

### 🔍 Core Idea: Modified Binary Search

- The array is **sorted but rotated**, so the minimum lies near the **pivot**
- Duplicates make it harder to decide which half is sorted
- Use binary search with **careful comparisons** to narrow down the search space

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize Search Space

- `start = 0`, `end = n - 1`

#### Step 2: Binary Search Loop

- Compute `mid = (start + end) / 2`
- Compare `nums[mid]` with `nums[end]`:
  - If `nums[mid] > nums[end]` → minimum is in **right half**
  - If `nums[mid] < nums[end]` → minimum is in **left half or at mid**
  - If `nums[mid] == nums[end]` → cannot decide → shrink `end--`

#### Step 3: Return Result

- When `start == end`, we’ve found the minimum

---

### ✅ Example

```text
nums = [2,2,2,0,1]

→ mid = 2 → nums[2] = 2, nums[4] = 1 → 2 > 1 → move right
→ mid = 3 → nums[3] = 0, nums[4] = 1 → 0 < 1 → move left
→ mid = 3 → start == end → return nums[3] = 0
```

---

### 📐 Complexity

| Aspect    | Value                                      |
| --------- | ------------------------------------------ |
| Time      | O(log n) worst-case O(n) due to duplicates |
| Space     | O(1)                                       |
| Technique | Binary Search                              |

---

### 🔁 Pattern

- Binary search on rotated array
- Pivot detection with duplicates
- Shrinking search space cautiously

---

### ⚠️ Edge Cases

- No rotation → minimum is `nums[0]`
- All elements same → linear scan fallback
- Rotation at last index → minimum at end

🔗 [LeetCode – Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii)

---

## 3. Aggressive Cows

**Problem**:  
Given an array `stalls[]` of unique stall positions and an integer `k` (number of cows), place the cows such that the **minimum distance** between any two cows is **maximized**.

---

### 🔍 Core Idea: Binary Search on Minimum Distance

Instead of brute-forcing placements, we:

- Sort the stall positions
- Use binary search to find the **largest minimum distance** that allows placing all cows

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort the Stall Positions

- Ensures we can reason about distances linearly

#### Step 2: Define Search Space

- `start = 1` → smallest possible gap
- `end = stalls[n-1] - stalls[0]` → largest possible gap

#### Step 3: Binary Search Loop

- For each `mid` (candidate distance), check if we can place all cows with at least `mid` gap
- Use `canWePlace()` helper:
  - Place first cow at `stalls[0]`
  - For each stall, if `stalls[i] - lastPlaced ≥ mid`, place next cow
  - If `k` cows placed → return true

#### Step 4: Update Search

- If placement is possible → try larger distance (`start = mid + 1`)
- Else → try smaller (`end = mid - 1`)
- Track last successful `mid` as `ans`

---

### ✅ Example

```text
stalls = [1, 2, 4, 8, 9], k = 3

→ Sorted: [1, 2, 4, 8, 9]
→ Try mid = 4 → cows at 1, 4, 8 → valid
→ Try mid = 6 → not enough space
→ Final answer = 3
```

---

### 📐 Complexity

| Aspect    | Value                   |
| --------- | ----------------------- |
| Time      | O(n log(maxDistance))   |
| Space     | O(1)                    |
| Technique | Binary Search on Answer |

---

### 🔁 Pattern

- Binary search over feasible values
- Greedy placement with constraints
- Optimization of minimum distance

---

### ⚠️ Edge Cases

- `k > stalls.length` → return `-1`
- `k == stalls.length` → minimum distance = smallest gap
- Unsorted input → handled via initial sort

🔗 [Aggressive Cows – Binary Search Pattern](https://www.geeksforgeeks.org/problems/aggressive-cows/1/)

---

## 4. Magnetic Force Between Two Balls

**Problem**:  
Given `n` basket positions and `m` balls, place the balls such that the **minimum magnetic force** (i.e., absolute distance between any two balls) is **maximized**.

---

### 🔍 Core Idea: Binary Search on Minimum Force

- Magnetic force between two balls = `|x - y|`
- Goal: **maximize the smallest force** between any pair
- Use **binary search** to find the largest feasible minimum force

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Positions

- Ensures linear traversal and valid distance checks

#### Step 2: Define Search Space

- `start = 1` → smallest possible force
- `end = max(position) - min(position)` → largest possible force

#### Step 3: Binary Search

- For each `mid` (candidate force), check if we can place `m` balls with at least `mid` distance between them
- Use `canPlace()`:
  - Place first ball at `position[0]`
  - For each next position:
    - If `position[i] - lastPlaced ≥ mid`, place next ball
  - If `m` balls placed → return true

#### Step 4: Update Search

- If placement is possible → try larger force (`start = mid + 1`)
- Else → try smaller force (`end = mid - 1`)
- Track last successful `mid` as `ans`

---

### ✅ Example

```text
position = [1,2,3,4,7], m = 3

→ Sorted: [1,2,3,4,7]
→ Try mid = 3 → balls at 1, 4, 7 → valid
→ Try mid = 4 → not enough space
→ Final answer = 3
```

---

### 📐 Complexity

| Aspect    | Value                   |
| --------- | ----------------------- |
| Time      | O(n log(maxDistance))   |
| Space     | O(1)                    |
| Technique | Binary Search on Answer |

---

### 🔁 Pattern

- Binary search over feasible values
- Greedy placement with constraints
- Optimization of minimum pairwise distance

---

### ⚠️ Edge Cases

- `m == 2` → force = max(position) - min(position)
- `m == position.length` → force = smallest gap
- Unsorted input → handled via initial sort

🔗 [LeetCode – Magnetic Force Between Two Balls](https://leetcode.com/problems/magnetic-force-between-two-balls)

---

## 5. Book Allocation Problem

**Problem**:  
Given an array `arr[]` where each element represents the number of pages in a book, and an integer `k` representing the number of students, allocate books such that:

- Each student gets **at least one book**
- Each student gets a **contiguous sequence** of books
- No book is shared
- The goal is to **minimize the maximum number of pages** assigned to any student

If allocation is impossible (i.e., `k > arr.length`), return `-1`.

---

### 🔍 Core Idea: Binary Search on Maximum Pages

We’re searching for the **smallest possible value of the largest page count** any student receives.  
This is a classic **binary search on the answer space**.

---

### 🧠 Algorithm Breakdown

#### Step 1: Define Search Space

- **Minimum** possible max pages = `max(arr)` → no student can take less than the largest book
- **Maximum** possible max pages = `sum(arr)` → one student takes all books

#### Step 2: Binary Search

- For each `mid` (candidate max pages), simulate allocation:
  - Traverse books
  - Accumulate pages until exceeding `mid`
  - Then assign to next student
- Count how many students are needed

#### Step 3: Update Search

- If students needed > `k` → `mid` too small → move right
- Else → valid allocation → try smaller `mid`

#### Step 4: Final Answer

- When `start == end`, we’ve found the **minimum feasible max pages**

---

### ✅ Example

```text
arr = [12, 34, 67, 90], k = 2

→ Try mid = 146 → allocation possible
→ Try mid = 118 → allocation possible
→ Try mid = 104 → allocation fails
→ Final answer = 113
```

---

### 📐 Complexity

| Aspect    | Value                  |
| --------- | ---------------------- |
| Time      | O(n log(sum(arr)))     |
| Space     | O(1)                   |
| Technique | Binary Search + Greedy |

---

### 🔁 Pattern

- Binary search on feasible answer
- Greedy partitioning
- Contiguous allocation constraint

---

### ⚠️ Edge Cases

- `k > arr.length` → return `-1`
- One student → must take all books
- One book → must go to one student

🔗 [Book Allocation – Binary Search Pattern](https://www.geeksforgeeks.org/allocate-minimum-number-pages/)

---

## 6. Split Array – Minimize Largest Subarray Sum

**Problem**:  
Given an array `nums[]` and an integer `k`, split the array into `k` **contiguous subarrays** such that the **largest subarray sum** is **minimized**.

---

### 🔍 Core Idea: Binary Search on Feasible Maximum Sum

We’re searching for the **smallest possible value of the largest subarray sum** across all valid `k`-partitions.

---

### 🧠 Algorithm Breakdown

#### Step 1: Define Search Space

- **Minimum** possible max sum = `max(nums)` → no subarray can be smaller than the largest element
- **Maximum** possible max sum = `sum(nums)` → one subarray takes everything

#### Step 2: Binary Search

- For each `mid` (candidate max sum), simulate partitioning:
  - Traverse `nums`, accumulate sum
  - If `sum + num > mid` → start new subarray (`pieces++`)
- Count how many subarrays are formed

#### Step 3: Update Search

- If `pieces > k` → `mid` too small → move right
- Else → valid partitioning → try smaller `mid`

#### Step 4: Final Answer

- When `start == end`, we’ve found the **minimum feasible largest subarray sum**

---

### ✅ Example

```text
nums = [7,2,5,10,8], k = 2

→ Search space: [10, 32]
→ Try mid = 21 → valid split: [7,2,5,10], [8]
→ Try mid = 15 → too many splits
→ Try mid = 18 → valid ✅
→ Final answer = 18
```

---

### 📐 Complexity

| Aspect    | Value                  |
| --------- | ---------------------- |
| Time      | O(n log(sum(nums)))    |
| Space     | O(1)                   |
| Technique | Binary Search + Greedy |

---

### 🔁 Pattern

- Binary search on feasible answer
- Greedy partitioning
- Contiguous subarray constraint

---

### ⚠️ Edge Cases

- `k == 1` → entire array is one subarray → return `sum(nums)`
- `k == nums.length` → each element is its own subarray → return `max(nums)`
- Large values → handled via greedy simulation

🔗 [LeetCode – Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum)

---

## 7. Find in Mountain Array

**Problem**:  
Given a **mountain array** (strictly increasing then strictly decreasing), find the **minimum index** where `target` appears.  
You can only access the array via `MountainArray.get(index)` and `MountainArray.length()`.  
Minimize the number of calls — ideally within **O(log n)**.

---

### 🔍 Core Idea: Three-Phase Binary Search

We treat the mountain array as two sorted halves split by a peak:

- Left half: strictly increasing
- Right half: strictly decreasing

---

### 🧠 Algorithm Breakdown

#### Step 1: Find Peak Index

- Use binary search to locate the peak:
  - If `arr[mid] > arr[mid + 1]` → peak is left or at `mid`
  - Else → peak is right of `mid`
- When `start == end`, we’ve found the peak

#### Step 2: Binary Search on Ascending Side

- Search from `0` to `peak - 1`
- Use standard binary search (increasing order)

#### Step 3: Binary Search on Descending Side

- If not found on left, search from `peak + 1` to `n - 1`
- Use reversed binary search (decreasing order)

#### Step 4: Return Minimum Index

- If found on left → return index
- Else if found on right → return index
- Else → return `-1`

---

### ✅ Example

```text
mountainArr = [1,2,3,4,5,3,1], target = 3

→ Peak = 4 (value = 5)
→ Search left: [1,2,3,4] → found at index 2
→ Search right: [3,1] → also has 3 at index 5
→ Return minimum index = 2 ✅
```

---

### 📐 Complexity

| Aspect         | Value       |
| -------------- | ----------- |
| Time           | O(log n)    |
| Space          | O(1)        |
| Calls to get() | ≤ 3 × log n |

---

### 🔁 Pattern

- Binary search on mountain array
- Peak detection
- Dual-direction search
- Interactive access constraint

---

### ⚠️ Edge Cases

- Target at peak → return peak index
- Target on both sides → return smaller index
- Target not found → return `-1`
- Array too short (< 3) → invalid mountain

🔗 [LeetCode – Find in Mountain Array](https://leetcode.com/problems/find-in-mountain-array)

---
