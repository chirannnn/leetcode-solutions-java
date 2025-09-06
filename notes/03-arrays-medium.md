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

## 4. Set Matrix Zeroes

**Problem**:  
Given an `m × n` integer matrix, if any element is `0`, set its **entire row and column** to `0`.  
You must perform this operation **in-place**, without using extra space for tracking.

---

**Approach**:

- Use the **first row and first column** as markers to flag which rows and columns should be zeroed.
- Track two booleans:
  - `firstRowZero` → whether the first row needs to be zeroed
  - `firstColZero` → whether the first column needs to be zeroed
- Traverse the matrix:
  - If `matrix[i][j] == 0`, mark `matrix[i][0] = 0` and `matrix[0][j] = 0`
- In a second pass, zero out cells based on these markers.
- Finally, zero out the first row and column if needed.

---

**Complexity**:

- **Time**: O(m × n) – full matrix traversal
- **Space**: O(1) – no extra space used beyond flags

---

**Example**:

```text
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]

Step-by-step:
→ Mark row 1 and column 1 for zeroing
→ Zero out row 1 and column 1
→ Final matrix: [[1,0,1],[0,0,0],[1,0,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]
```

---

**Key Takeaway**:

- This is a classic **in-place simulation** problem.
- Using the matrix itself as a marker avoids extra space.
- Careful handling of the first row/column is essential to avoid premature overwrites.

---

**Pattern**:

- Matrix mutation
- Flagging via sentinel cells
- In-place optimization

---

**Edge Cases**:

- Zeros in first row/column → must be tracked separately
- Multiple zeros → all affected rows/columns must be zeroed
- Empty matrix → return as-is

🔗 [LeetCode – Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes)

---

## 5. Product of Array Except Self

**Problem**:  
Given an integer array `nums`, return an array `answer` such that `answer[i]` is the product of **all elements except `nums[i]`**.  
You must solve it in **O(n)** time **without using division**.

---

**Approach**:

- Use a **two-pass strategy**:

  1. **Prefix pass**:
     - Build `result[i]` as the product of all elements to the **left** of index `i`.
  2. **Suffix pass**:
     - Traverse from the end, maintaining a running product of elements to the **right** of index `i`.
     - Multiply it with the existing `result[i]`.

- This way, each `result[i] = prefix[i] × suffix[i]`, giving the product of all elements except `nums[i]`.

---

**Complexity**:

- **Time**: O(n) – two linear passes
- **Space**: O(1) extra space (excluding output array)

---

**Example**:

```text
Input: nums = [1,2,3,4]

Prefix pass:
→ result = [1, 1, 2, 6]  // left products

Suffix pass:
→ suffix = 1 → result[3] = 6 × 1 = 6
→ suffix = 4 → result[2] = 2 × 4 = 8
→ suffix = 12 → result[1] = 1 × 12 = 12
→ suffix = 24 → result[0] = 1 × 24 = 24

Output: [24,12,8,6]
```

---

**Key Takeaway**:

- This is a classic **prefix-suffix product** problem.
- Avoids division by splitting the product into two independent parts.
- Efficient and elegant — no need for extra arrays or brute force.

---

**Pattern**:

- Prefix accumulation
- Suffix accumulation
- Multiplicative merging

---

**Edge Cases**:

- Contains zero → result will have zeros in affected positions
- Multiple zeros → entire result is zero
- Single element → not applicable (problem constraint: `n ≥ 2`)

🔗 [LeetCode – Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self)

---

## 8. Rotate Array

**Problem**:  
Given an integer array `nums`, rotate the array to the right by `k` steps.  
Rotation must be done **in-place**, and `k` is non-negative.

---

**Approach**: Reverse Trick (Optimal)

- Step 1: Reverse the entire array
- Step 2: Reverse the first `k` elements
- Step 3: Reverse the remaining `n - k` elements
- This simulates a right rotation without using extra space

---

**Complexity**:

- **Time**: O(n) – three passes over the array
- **Space**: O(1) – in-place reversal

---

**Example**:

```text
Input: nums = [1,2,3,4,5,6,7], k = 3

Step-by-step:
→ Reverse entire array: [7,6,5,4,3,2,1]
→ Reverse first 3: [5,6,7,4,3,2,1]
→ Reverse last 4: [5,6,7,1,2,3,4]

Output: [5,6,7,1,2,3,4]
```

---

**Key Takeaway**:

- This is a classic **array manipulation** problem.
- The reversal trick avoids shifting elements one by one.
- Efficient and elegant — no extra memory required.

---

**Pattern**:

- In-place reversal
- Modular arithmetic (`k % n`)
- Three-phase transformation

---

**Edge Cases**:

- `k = 0` → no rotation
- `k > n` → use `k % n`
- Empty array → return as-is

🔗 [LeetCode – Rotate Array](https://leetcode.com/problems/rotate-array)

---

## 9. Sort Colors (Dutch National Flag)

**Problem**:  
Given an array `nums` containing only `0`, `1`, and `2` (representing red, white, and blue), sort the array **in-place** so that all `0`s come first, followed by `1`s, then `2`s.  
You must not use built-in sort functions.

---

**Approach**:  
Use **three pointers** to partition the array in a single pass:

- `low` → boundary for 0s
- `mid` → current index
- `high` → boundary for 2s

**Logic**:

- If `nums[mid] == 0`:  
  → Swap with `nums[low]`, increment both `low` and `mid`
- If `nums[mid] == 2`:  
  → Swap with `nums[high]`, decrement `high` only
- If `nums[mid] == 1`:  
  → Just increment `mid`

---

**Complexity**:

- **Time**: O(n) – single pass
- **Space**: O(1) – in-place sorting

---

**Example**:

```text
Input: nums = [2,0,2,1,1,0]

Step-by-step:
→ mid = 0: 2 → swap with high → [0,0,2,1,1,2]
→ mid = 0: 0 → swap with low → [0,0,2,1,1,2]
→ mid = 1: 0 → swap with low → [0,0,2,1,1,2]
→ mid = 2: 2 → swap with high → [0,0,1,1,2,2]
→ mid = 2: 1 → move on
→ mid = 3: 1 → move on

Output: [0,0,1,1,2,2]
```

---

**Key Takeaway**:

- This is a classic **three-way partitioning** problem.
- Efficiently sorts 0s, 1s, and 2s in one pass.
- Avoids counting or multiple passes.

---

**Pattern**:

- Two-pointer / three-pointer technique
- In-place partitioning
- Conditional swapping

---

**Edge Cases**:

- Already sorted → no swaps
- All same color → minimal movement
- Single element → return as-is

🔗 [LeetCode – Sort Colors](https://leetcode.com/problems/sort-colors)

---
