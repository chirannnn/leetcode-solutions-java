## 1. 3Sum

**Problem**:  
Given an integer array `nums[]`, return all unique triplets `[nums[i], nums[j], nums[k]]` such that:

- \(i \neq j \neq k\)
- \(nums[i] + nums[j] + nums[k] = 0\)
- No duplicate triplets in the result.

---

### 🔍 Core Idea: Sort + Two-Pointer Search

- Sort the array to simplify duplicate handling and ordered scanning.
- Fix one number (`nums[i]`) and use two pointers (`j`, `k`) to find pairs that sum to `-nums[i]`.
- Skip duplicates to ensure unique triplets.

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Array

- `Arrays.sort(nums)` → ascending order.

#### Step 2: Iterate with Index `i`

- Skip duplicates (`nums[i] == nums[i-1]`).
- If `nums[i] > 0`, break (since all later numbers are positive, sum cannot be 0).

#### Step 3: Two-Pointer Search

- Initialize `j = i+1`, `k = n-1`.
- Compute `sum = nums[i] + nums[j] + nums[k]`.
  - If `sum == 0` → add triplet, move both pointers, skip duplicates.
  - If `sum > 0` → decrement `k`.
  - If `sum < 0` → increment `j`.

#### Step 4: Return Result

- Collect all valid triplets in a list.

---

### ✅ Example

```text
nums = [-1,0,1,2,-1,-4]

→ Sorted: [-4,-1,-1,0,1,2]

→ i=0 (-4): no valid triplets
→ i=1 (-1):
   j=2 (-1), k=5 (2) → sum=0 → [-1,-1,2]
   j=3 (0), k=4 (1) → sum=0 → [-1,0,1]
→ i=2 (-1): skipped (duplicate)
→ i=3 (0): no new triplets

→ Output: [[-1,-1,2], [-1,0,1]] ✅
```

---

### 📐 Complexity

| Aspect    | Value                                 |
| --------- | ------------------------------------- |
| Time      | O(n²) (outer loop + two-pointer scan) |
| Space     | O(1) (excluding result list)          |
| Technique | Sort + Two-Pointer                    |

---

### 🔁 Pattern

- Sorting for duplicate control
- Two-pointer scanning for pair sums
- Triplet uniqueness via skip logic

---

### 🚀 Alternative Approaches

- **HashSet-based**:
  - Use set to track complements → more overhead, harder to deduplicate.
- **Brute Force**:
  - Check all triplets → O(n³), inefficient.

---

### ⚠️ Edge Cases

- All zeros → return [[0,0,0]]
- No valid triplets → return empty list
- Duplicates → handled by skip logic

🔗 [LeetCode – 3Sum](https://leetcode.com/problems/3sum)

---

## 2. 3Sum Closest

**Problem**:  
Given an integer array `nums[]` and a target value, find three integers in `nums` whose sum is **closest** to the target.  
Return the sum of those three integers.  
Constraint: Exactly one solution exists.

---

### 🔍 Core Idea: Sort + Two-Pointer Search

- Sort the array to simplify scanning.
- Fix one number (`nums[i]`) and use two pointers (`j`, `k`) to find pairs that minimize the difference between `sum` and `target`.
- Track the closest sum found so far.
- Adjust pointers based on whether the current sum is greater or smaller than target.

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Array

- `Arrays.sort(nums)` → ascending order.

#### Step 2: Initialize Closest

- Start with `closest = nums[0] + nums[1] + nums[2]`.

#### Step 3: Iterate with Index `i`

- For each `i`, set `j = i+1`, `k = n-1`.
- While `j < k`:
  - Compute `sum = nums[i] + nums[j] + nums[k]`.
  - If `|sum - target| < |closest - target|` → update `closest`.
  - If `sum > target` → decrement `k`.
  - If `sum < target` → increment `j`.
  - If `sum == target` → return `target` immediately (perfect match).

#### Step 4: Return Closest

- After scanning all possibilities, return `closest`.

---

### ✅ Example

```text
nums = [-1,2,1,-4], target = 1

→ Sorted: [-4,-1,1,2]
→ Initial closest = -4 + -1 + 1 = -4
→ i=0 (-4): sums checked → closest updated to 2
→ i=1 (-1): sums checked → closest remains 2
→ Final result = 2 ✅
```

```text
nums = [0,0,0], target = 1

→ Sorted: [0,0,0]
→ Initial closest = 0
→ Only possible sum = 0
→ Result = 0 ✅
```

---

### 📐 Complexity

| Aspect    | Value                                 |
| --------- | ------------------------------------- |
| Time      | O(n²) (outer loop + two-pointer scan) |
| Space     | O(1)                                  |
| Technique | Sort + Two-Pointer                    |

---

### 🔁 Pattern

- Sorting for ordered scanning
- Two-pointer technique for sum problems
- Closest value tracking with absolute difference

---

### 🚀 Alternative Approaches

- **Brute Force**:
  - Check all triplets → O(n³), inefficient.
- **Binary Search**:
  - Fix two numbers, binary search for third → O(n² log n).

---

### ⚠️ Edge Cases

- All zeros → result = 0
- Exact match → return target immediately
- Negative + positive mix → handled naturally by sorting

🔗 [LeetCode – 3Sum Closest](https://leetcode.com/problems/3sum-closest)

---

## 3. 4Sum

**Problem**:  
Given an integer array `nums[]` and a target value, return all **unique quadruplets** `[nums[a], nums[b], nums[c], nums[d]]` such that:

- \(a, b, c, d\) are distinct indices
- \(nums[a] + nums[b] + nums[c] + nums[d] = target\)
- No duplicate quadruplets in the result

---

### 🔍 Core Idea: Sort + Two-Pointer Extension

- Sort the array to simplify duplicate handling and ordered scanning.
- Fix two numbers (`nums[i]`, `nums[j]`) and use two pointers (`k`, `l`) to find pairs that complete the quadruplet.
- Skip duplicates to ensure uniqueness.
- Use `long` for sum to avoid integer overflow.

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Array

- `Arrays.sort(nums)` → ascending order.

#### Step 2: Outer Loop for First Element

- Iterate `i` from `0` to `n-4`.
- Skip duplicates (`nums[i] == nums[i-1]`).

#### Step 3: Inner Loop for Second Element

- Iterate `j` from `i+1` to `n-3`.
- Skip duplicates (`nums[j] == nums[j-1]`).

#### Step 4: Two-Pointer Search

- Initialize `k = j+1`, `l = n-1`.
- While `k < l`:
  - Compute `sum = nums[i] + nums[j] + nums[k] + nums[l]`.
  - If `sum == target` → add quadruplet, move both pointers, skip duplicates.
  - If `sum > target` → decrement `l`.
  - If `sum < target` → increment `k`.

#### Step 5: Return Result

- Collect all valid quadruplets in a list.

---

### ✅ Example

```text
nums = [1,0,-1,0,-2,2], target = 0

→ Sorted: [-2,-1,0,0,1,2]

→ i=-2, j=-1:
   k=0, l=5 → sum= -2 + -1 + 0 + 2 = -1 → k++
   k=1, l=5 → sum= -2 + -1 + 0 + 2 = -1 → k++
   k=2, l=5 → sum= -2 + -1 + 1 + 2 = 0 → add [-2,-1,1,2]
   k=3, l=4 → sum= -2 + -1 + 0 + 1 = -2 → k++
→ i=-2, j=0:
   k=1, l=5 → sum= -2 + 0 + 0 + 2 = 0 → add [-2,0,0,2]
→ i=-1, j=0:
   k=2, l=5 → sum= -1 + 0 + 1 + 2 = 2 → l--
   k=2, l=4 → sum= -1 + 0 + 1 + 1 = 1 → l--
   k=2, l=3 → sum= -1 + 0 + 0 + 1 = 0 → add [-1,0,0,1]

→ Output: [[-2,-1,1,2], [-2,0,0,2], [-1,0,0,1]] ✅
```

---

### 📐 Complexity

| Aspect    | Value                                       |
| --------- | ------------------------------------------- |
| Time      | O(n³) (two nested loops + two-pointer scan) |
| Space     | O(1) (excluding result list)                |
| Technique | Sort + Two-Pointer                          |

---

### 🔁 Pattern

- Sorting for duplicate control
- Two-pointer scanning for sum problems
- Extension of 3Sum → generalized to 4Sum

---

### 🚀 Alternative Approaches

- **HashSet-based**:
  - Track pairs and check complements → more overhead, harder to deduplicate.
- **General k-Sum recursion**:
  - Reduce problem recursively (k-Sum → (k-1)-Sum) with two-pointer base case.

---

### ⚠️ Edge Cases

- All identical values (e.g., `[2,2,2,2,2]`, target=8) → return [[2,2,2,2]]
- No valid quadruplets → return empty list
- Large numbers → handled safely with `long` sum

🔗 [LeetCode – 4Sum](https://leetcode.com/problems/4sum)

---
