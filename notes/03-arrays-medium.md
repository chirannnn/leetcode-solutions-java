## 1. Spiral Matrix

**Problem**:  
Given an `m × n` matrix, return all elements of the matrix in **spiral order** — starting from the top-left and moving clockwise layer by layer.

---

**Approach**:

- Use four boundaries: `top`, `bottom`, `left`, `right`
- Traverse in the following order:
  1. Left → Right (top row)
  2. Top → Bottom (right column)
  3. Right → Left (bottom row)
  4. Bottom → Top (left column)
- After each traversal, shrink the boundary inward
- Continue until all boundaries collapse

---

**Complexity**:

- **Time**: O(m × n) – each element visited once
- **Space**: O(1) – aside from output list

---

**Example**:

```text
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]

Step-by-step:
→ Top row: [1,2,3]
→ Right col: [6,9]
→ Bottom row: [8,7]
→ Left col: [4]
→ Inner layer: [5]

Output: [1,2,3,6,9,8,7,4,5]
```

---

**Key Takeaway**:

- This is a classic **simulation** problem.
- Requires careful boundary management to avoid overstepping.
- Works for rectangular and square matrices.

---

**Pattern**:

- Matrix traversal
- Layer-by-layer simulation
- Boundary shrinking

---

**Edge Cases**:

- Single row → traverse left to right
- Single column → traverse top to bottom
- Empty matrix → return empty list

🔗 [LeetCode – Spiral Matrix](https://leetcode.com/problems/spiral-matrix)

---
