## 1. Find XOR Sum of All Pairs Bitwise AND

**Problem**:  
Given two arrays `arr1` and `arr2`, consider all pairs `(i, j)` and compute `arr1[i] & arr2[j]`. Return the XOR sum of this list.

---

### 🔍 Core Idea: Simplification Trick

- Direct approach: compute all pairs → O(n·m). Too slow for large arrays.
- Key property:  
  \[
  \bigoplus\_{i,j} (arr1[i] \ \& \ arr2[j]) = \left(\bigoplus_i arr1[i]\right) \ \& \ \left(\bigoplus_j arr2[j]\right)
  \]
- Explanation:
  - XOR distributes over AND.
  - Each bit position can be considered independently.
  - If a bit is set in both XORs, it contributes to the final result.

---

### 🧠 Algorithm Breakdown

#### Step 1: Compute XOR of arr1

- `XOR1 = arr1[0] ^ arr1[1] ^ ...`

#### Step 2: Compute XOR of arr2

- `XOR2 = arr2[0] ^ arr2[1] ^ ...`

#### Step 3: Final Result

- `Result = XOR1 & XOR2`

---

### ✅ Example Walkthrough

```text
arr1 = [1,2,3], arr2 = [6,5]

→ XOR1 = 1 ^ 2 ^ 3 = 0
→ XOR2 = 6 ^ 5 = 3
→ Result = 0 & 3 = 0 ✅
```

```text
arr1 = [12], arr2 = [4]

→ XOR1 = 12
→ XOR2 = 4
→ Result = 12 & 4 = 4 ✅
```

---

### 📐 Complexity

| Aspect    | Value                                      |
| --------- | ------------------------------------------ |
| Time      | O(n + m) (single pass through both arrays) |
| Space     | O(1)                                       |
| Technique | XOR distributive property                  |

---

### 🔁 Pattern

- This problem is a **bit manipulation identity**.
- Similar to problems where XOR distributes over other operations.
- Key insight: reduce pairwise operations to aggregate XORs.

---

### 🚀 Alternative Approaches

- **Naive nested loop**: O(n·m), not feasible for large arrays.
- **Bitwise analysis per position**: Equivalent to simplification, but more verbose.
- Current formula is optimal.

---

### ⚠️ Edge Cases

- Single element arrays → result = `arr1[0] & arr2[0]`.
- All zeros → result = 0.
- Large arrays (up to \(10^5\)) → efficient with O(n+m).

🔗 LeetCode – Find XOR Sum of All Pairs Bitwise AND: [ (leetcode.com)](https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and/description/)

---
