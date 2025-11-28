## 1. First Missing Positive

**Problem**:  
Given an unsorted integer array `nums[]`, return the smallest positive integer that is not present in the array.  
Constraints:

- Must run in **O(n)** time.
- Must use **O(1)** auxiliary space.

---

### 🔍 Core Idea: Cyclic Sort for `[1…n]`

- The smallest missing positive must lie in the range `[1…n+1]`.
- Ignore negatives, zeros, and numbers > n (they cannot be the answer).
- Place each valid number at its correct index (`num → num-1`).
- After rearrangement, the first index where `nums[index] ≠ index+1` gives the missing positive.
- If all positions are correct, the answer is `n+1`.

---

### 🧠 Algorithm Breakdown

#### Step 1: Rearrange with Cyclic Sort

- Traverse array with index `i`.
- If `nums[i]` is in range `[1…n]` and not at its correct position, swap it to `nums[nums[i]-1]`.
- Otherwise, move to next index.
- This ensures valid numbers are placed at their correct indices.

#### Step 2: Find First Missing Positive

- Scan array.
- If `nums[index] ≠ index+1`, return `index+1`.
- If all match, return `n+1`.

---

### ✅ Example Walkthrough

```text
nums = [3,4,-1,1]

→ Step 1: Rearrange
   Swap 3 → index 2 → [-1,4,3,1]
   Swap -1 → ignored
   Swap 4 → index 3 → [-1,1,3,4]
   Swap 1 → index 0 → [1,-1,3,4]

→ Step 2: Scan
   index 0 → nums[0]=1 → ok
   index 1 → nums[1]=-1 ≠ 2 → answer = 2 ✅
```

```text
nums = [1,2,0]

→ Rearranged: [1,2,0]
→ Scan:
   index 0 → 1 ok
   index 1 → 2 ok
   index 2 → 0 ≠ 3 → answer = 3 ✅
```

```text
nums = [7,8,9,11,12]

→ All values > n → ignored
→ Rearranged: [7,8,9,11,12]
→ Scan:
   index 0 → nums[0]=7 ≠ 1 → answer = 1 ✅
```

---

### 📐 Complexity

| Aspect    | Value                     |
| --------- | ------------------------- |
| Time      | O(n) (cyclic sort + scan) |
| Space     | O(1) (in-place)           |
| Technique | Cyclic Sort               |

---

### 🔁 Pattern

- Cyclic sort for `[1…n]` problems
- Index mismatch → missing/duplicate detection
- In-place rearrangement with constant space

---

### 🚀 Alternative Approaches

- **HashSet**:
  - Track seen numbers, then check `[1…n]`.
  - O(n) time, O(n) space.
- **Boolean Marking**:
  - Mark presence in array using index sign flips.
  - O(n) time, O(1) space.

---

### ⚠️ Edge Cases

- All numbers present → return `n+1`.
- All invalid numbers (negatives, zeros, >n) → return `1`.
- Single element arrays → handled naturally.

🔗 [LeetCode – First Missing Positive](https://leetcode.com/problems/first-missing-positive)

---
