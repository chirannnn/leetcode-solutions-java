## 1. Subsets (Power Set)

**Problem**:  
Given an integer array `nums` of unique elements, return all possible subsets (the power set).  
The solution must not contain duplicate subsets.

---

### 🔍 Core Idea: Bitmask Enumeration

- Each subset can be represented by a binary mask of length `n`.
- If the `j`‑th bit of mask `i` is set, include `nums[j]` in the subset.
- Iterate through all masks from `0` to \(2^n - 1\).
- Collect subsets accordingly.

---

### 🧠 Algorithm Breakdown

#### Step 1: Total Subsets

- For `n` elements, total subsets = \(2^n\).
- Loop `i` from `0` to `(1 << n) - 1`.

#### Step 2: Build Subset

- For each mask `i`:
  - Traverse bits.
  - If bit is set → include corresponding element.
- Add subset to result list.

#### Step 3: Return Result

- Return list of all subsets.

---

### ✅ Example Walkthrough

```text
nums = [1,2,3]

Masks:
000 → []
001 → [1]
010 → [2]
011 → [1,2]
100 → [3]
101 → [1,3]
110 → [2,3]
111 → [1,2,3]

Result = [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]] ✅
```

```text
nums = [0]

Masks:
0 → []
1 → [0]

Result = [[],[0]] ✅
```

---

### 📐 Complexity

| Aspect    | Value                                  |
| --------- | -------------------------------------- |
| Time      | O(n · 2^n) (each subset built in O(n)) |
| Space     | O(n · 2^n) (to store all subsets)      |
| Technique | Bitmask enumeration                    |

---

### 🔁 Pattern

- Classic **power set generation** problem.
- Can also be solved with **backtracking recursion**.
- Bitmask approach is iterative and efficient for small `n` (≤ 10).

---

### 🚀 Alternative Approaches

- **Backtracking**: Recursively include/exclude each element.
- **Iterative expansion**: Start with empty set, for each element add it to all existing subsets.
- Current bitmask method is clean and intuitive.

---

### ⚠️ Edge Cases

- Empty array → result = `[[]]`.
- Single element → `[[], [x]]`.
- Negative numbers → handled normally (no restriction).
- n ≤ 10 → feasible since \(2^{10} = 1024\) subsets.

🔗 LeetCode – Subsets: (leetcode.com)(https://leetcode.com/problems/subsets/description/)

---

## 2. Subsets II

**Problem**:  
Given an integer array `nums` that may contain duplicates, return all possible subsets (the power set).  
The solution must not contain duplicate subsets.

---

### 🔍 Core Idea: Bitmask + Duplicate Filtering

- Each subset can be represented by a binary mask of length `n`.
- Iterate through all masks from `0` to \(2^n - 1\).
- Build subsets based on set bits.
- Use a `Set<List<Integer>>` to avoid duplicates.
- Sorting `nums` ensures duplicates are grouped, making subsets consistent.

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Input

- `Arrays.sort(nums)` → ensures duplicates are adjacent.

#### Step 2: Generate Subsets

- Loop `i` from `0` to `(1 << n) - 1`.
- For each mask, build subset by checking bits.
- Add subset to `Set` to avoid duplicates.

#### Step 3: Collect Results

- Convert `Set` to `List` → final answer.

---

### ✅ Example Walkthrough

```text
nums = [1,2,2]

Masks:
000 → []
001 → [1]
010 → [2]
011 → [1,2]
100 → [2]
101 → [1,2]
110 → [2,2]
111 → [1,2,2]

After removing duplicates:
[[], [1], [2], [1,2], [2,2], [1,2,2]] ✅
```

```text
nums = [0]

Masks:
0 → []
1 → [0]

Result = [[], [0]] ✅
```

---

### 📐 Complexity

| Aspect    | Value                          |
| --------- | ------------------------------ |
| Time      | O(n · 2^n) (subset generation) |
| Space     | O(n · 2^n) (result storage)    |
| Technique | Bitmask + HashSet              |

---

### 🔁 Pattern

- Extension of **Subsets I** (unique elements).
- Requires duplicate handling.
- Sorting + Set ensures uniqueness.

---

### 🚀 Alternative Approaches

- **Backtracking recursion**:
  - Skip duplicates by checking adjacent elements after sorting.
  - More memory-efficient, avoids explicit Set.
- **Iterative expansion**:
  - For each element, add it to existing subsets.
  - Handle duplicates by controlling expansion range.

---

### ⚠️ Edge Cases

- Empty array → `[[]]`.
- All elements same → subsets are powers of one element.
- Negative numbers → handled normally.
- n ≤ 10 → feasible since \(2^{10} = 1024\) subsets.

🔗 LeetCode – Subsets II: [(leetcode.com)](https://leetcode.com/problems/subsets-ii/description/)

---
