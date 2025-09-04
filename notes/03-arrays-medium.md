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

## 2. Spiral Matrix II

**Problem**:  
Given a positive integer `n`, generate an `n × n` matrix filled with elements from `1` to `n²` in **spiral order**.

---

**Approach**:

- Use four boundaries: `top`, `bottom`, `left`, `right`
- Initialize a counter `num = 1`
- Fill the matrix in the following spiral order:
  1. Left → Right (top row)
  2. Top → Bottom (right column)
  3. Right → Left (bottom row)
  4. Bottom → Top (left column)
- After each direction, shrink the corresponding boundary
- Continue until all numbers from `1` to `n²` are placed

---

**Complexity**:

- **Time**: O(n²) – each cell filled once
- **Space**: O(n²) – output matrix of size `n × n`

---

**Example**:

```text
Input: n = 3

Step-by-step:
→ Fill top row: [1,2,3]
→ Fill right col: [4,5]
→ Fill bottom row: [6,7]
→ Fill left col: [8]
→ Center cell: [9]

Output:
[[1,2,3],
 [8,9,4],
 [7,6,5]]
```

---

**Key Takeaway**:

- This is a classic **simulation** problem.
- Requires precise boundary control and directional traversal.
- Mirrors the logic of Spiral Matrix I, but builds instead of reads.

---

**Pattern**:

- Matrix construction
- Spiral layer filling
- Boundary shrinking

---

**Edge Cases**:

- `n = 1` → return `[[1]]`
- Large `n` → handled efficiently with loop logic
- No need for direction arrays — direct control via boundaries

🔗 [LeetCode – Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii)

---

## 3. Spiral Matrix III

**Problem**:  
Given a grid of size `rows × cols` and a starting position `(rStart, cStart)`, simulate a **clockwise spiral walk** that visits every cell.  
You may temporarily walk _outside_ the grid, but only record positions **inside** the grid.

---

**Approach**:

- Use a direction array: `→ ↓ ← ↑` → `dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}}`
- Start at `(rStart, cStart)` and initialize `steps = 1`
- For each spiral layer:
  - Move in current direction for `steps` steps
  - After every **two directions**, increment `steps`
- Only record positions that are **within bounds**
- Continue until `rows × cols` positions are recorded

---

**Complexity**:

- **Time**: O(rows × cols) — each valid cell visited once
- **Space**: O(rows × cols) — result array

---

**Dry Run Example**:

```text
Input: rows = 5, cols = 6, rStart = 1, cStart = 4

Spiral path:
→ 1 step → [1,5]
↓ 1 step → [2,5]
← 2 steps → [2,4], [2,3]
↑ 2 steps → [1,3], [0,3]
→ 3 steps → [0,4], [0,5], [3,5]
...

Output: 30 coordinates in spiral order
```

---

**Key Takeaway**:

- This is a **simulation** problem with expanding spiral logic.
- Unlike Spiral Matrix I/II, the spiral can temporarily go _outside_ the grid.
- You must **filter** out-of-bound positions while continuing the walk.

---

**Pattern**:

- Spiral traversal
- Direction cycling
- Step expansion every two turns
- Boundary filtering

---

**Edge Cases**:

- `rows = 1`, `cols = 1` → single cell
- Start at corner or edge → spiral expands asymmetrically
- Large grids → efficient due to directional control

🔗 [LeetCode – Spiral Matrix III](https://leetcode.com/problems/spiral-matrix-iii)

---
