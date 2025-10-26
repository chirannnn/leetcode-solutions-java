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
