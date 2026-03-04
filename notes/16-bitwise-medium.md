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

## 3. Single Number II

**Problem**:  
Given an integer array `nums` where every element appears **three times** except for one, which appears exactly once, return that single element.  
Constraints: linear runtime, constant extra space.

---

### 🔍 Core Idea: Bitwise State Machine

- Maintain two bitmasks:
  - `ones` → bits that have appeared once.
  - `twos` → bits that have appeared twice.
- For each number:
  - Update `ones` and `twos` using XOR and masking.
  - Ensure bits are cleared when they appear three times.
- At the end, `ones` contains the unique number.

---

### 🧠 Algorithm Breakdown (Method 1: Bitwise State Tracking)

#### Step 1: Initialize

- `ones = 0`, `twos = 0`.

#### Step 2: Traverse Array

- For each `num`:
  - `ones = (ones ^ num) & ~twos`
  - `twos = (twos ^ num) & ~ones`

#### Step 3: Return Result

- Return `ones`.

---

### ✅ Example Walkthrough

```text
nums = [2,2,3,2]

→ num=2: ones=2, twos=0
→ num=2: ones=0, twos=2
→ num=3: ones=3, twos=2
→ num=2: ones=3, twos=0
→ Result = 3 ✅
```

```text
nums = [0,1,0,1,0,1,99]

→ All 0s and 1s cancel out in triples
→ Result = 99 ✅
```

---

### 📐 Complexity

| Aspect    | Value                       |
| --------- | --------------------------- |
| Time      | O(n) (single pass)          |
| Space     | O(1) (constant extra space) |
| Technique | Bitwise state machine       |

---

### 🚀 Alternative Approach (Method 2: Bit Count)

- Count occurrences of each bit across all numbers.
- If count % 3 ≠ 0 → that bit belongs to the unique number.
- Build result from these bits.
- Time: O(32·n), Space: O(32).
- More intuitive but less elegant.

---

### 🔁 Pattern

- Extension of **Single Number I** (XOR trick).
- Generalized to handle numbers appearing k times.
- Uses bitwise logic to simulate finite state transitions.

---

### ⚠️ Edge Cases

- Array length = 1 → return that element.
- Negative numbers → handled correctly (bitwise operations work on signed ints).
- Large input (up to \(3 \times 10^4\)) → efficient with O(n).

🔗 LeetCode – Single Number II: [(leetcode.com)](https://leetcode.com/problems/single-number-ii/description/)

---

## 4. Single Number III

**Problem**:  
Given an integer array `nums` where exactly two elements appear once and all others appear twice, return those two unique elements.  
Constraints: linear runtime, constant extra space.

---

### 🔍 Core Idea: XOR Partitioning

- XOR of all numbers = `XOR = a ^ b` (where `a` and `b` are the two unique numbers).
- Since `a ≠ b`, their XOR has at least one set bit.
- Use the **rightmost set bit** to partition numbers into two groups:
  - Group 1: numbers with that bit = 0.
  - Group 2: numbers with that bit = 1.
- Each group contains one unique number plus duplicates.
- XOR within each group → isolates the unique number.

---

### 🧠 Algorithm Breakdown

#### Step 1: XOR All Numbers

- `XOR = a ^ b`.

#### Step 2: Find Rightmost Set Bit

- `rightMostSetBit = (XOR & (XOR - 1)) ^ XOR`.
- Isolates the lowest set bit in `XOR`.

#### Step 3: Partition and XOR

- Initialize `n1 = 0`, `n2 = 0`.
- For each `num`:
  - If `(num & rightMostSetBit) == 0` → `n1 ^= num`.
  - Else → `n2 ^= num`.

#### Step 4: Return Result

- Return `[n1, n2]`.

---

### ✅ Example Walkthrough

```text
nums = [1,2,1,3,2,5]

→ XOR = 3 ^ 5 = 6 (binary 110)
→ rightMostSetBit = 2 (binary 010)

Partition:
Group 1 (bit=0): [1,1,5] → XOR = 5
Group 2 (bit=1): [2,2,3] → XOR = 3

Result = [5,3] ✅
```

```text
nums = [-1,0]

→ XOR = -1 ^ 0 = -1
→ Partition → [-1], [0]
→ Result = [-1,0] ✅
```

```text
nums = [0,1]

→ XOR = 1
→ rightMostSetBit = 1
→ Partition → [0], [1]
→ Result = [0,1] ✅
```

---

### 📐 Complexity

| Aspect    | Value                       |
| --------- | --------------------------- |
| Time      | O(n) (single pass)          |
| Space     | O(1) (constant extra space) |
| Technique | XOR partitioning            |

---

### 🔁 Pattern

- Extension of **Single Number I** (one unique) and **Single Number II** (one unique, others thrice).
- Uses XOR to cancel duplicates and isolate unique values.
- Partitioning trick is key when two uniques exist.

---

### 🚀 Alternative Approaches

- **HashMap/HashSet**: Track frequencies → O(n) time, O(n) space.
- **Sorting**: Compare adjacent elements → O(n log n).
- XOR partitioning is optimal (O(n), O(1)).

---

### ⚠️ Edge Cases

- Array length = 2 → return both elements.
- Negative numbers → handled correctly by bitwise operations.
- Large input (up to \(3 \times 10^4\)) → efficient with O(n).

🔗 LeetCode – Single Number III: [(leetcode.com)](https://leetcode.com/problems/single-number-iii/description/)

---

## 5. Divide Two Integers

**Problem**:  
Given two integers `dividend` and `divisor`, divide them without using multiplication, division, or modulo operators.  
The result should truncate toward zero.  
Constraints: must handle 32-bit signed integer overflow.

---

### 🔍 Core Idea: Bitwise Long Division

- Division can be simulated by repeated subtraction.
- To optimize, subtract the largest possible multiple of divisor (using bit shifts).
- Keep track of quotient by adding powers of two.
- Handle signs and overflow explicitly.

---

### 🧠 Algorithm Breakdown

#### Step 1: Handle Special Case

- If `dividend == divisor` → return `1`.

#### Step 2: Determine Sign

- Result is positive if both have same sign.
- Negative otherwise.

#### Step 3: Work with Absolute Values

- Convert `dividend` and `divisor` to positive (`long` to avoid overflow).

#### Step 4: Subtract Using Bit Shifts

- While `n >= div`:
  - Find largest shift `count` such that `(div << (count+1)) <= n`.
  - Add `(1 << count)` to quotient.
  - Subtract `(div << count)` from `n`.

#### Step 5: Handle Overflow

- If quotient exceeds 32-bit range, clamp to `Integer.MAX_VALUE` or `Integer.MIN_VALUE`.

#### Step 6: Apply Sign

- Return `ans` if positive, else `-ans`.

---

### ✅ Example Walkthrough

```text
dividend = 10, divisor = 3

→ n=10, div=3
→ Largest shift: 3 << 1 = 6 ≤ 10 → count=1
→ ans += 2, n -= 6 → n=4
→ Largest shift: 3 << 0 = 3 ≤ 4 → count=0
→ ans += 1, n -= 3 → n=1
→ Result = 3 ✅
```

```text
dividend = 7, divisor = -3

→ n=7, div=3
→ Largest shift: 3 << 1 = 6 ≤ 7 → count=1
→ ans += 2, n -= 6 → n=1
→ Result = -2 ✅
```

---

### 📐 Complexity

| Aspect    | Value                                            |
| --------- | ------------------------------------------------ |
| Time      | O(log n) (bit shifting reduces dividend quickly) |
| Space     | O(1)                                             |
| Technique | Bitwise long division                            |

---

### 🔁 Pattern

- Similar to **manual long division** but optimized with bit shifts.
- Common in problems where multiplication/division operators are restricted.
- Overflow handling is crucial.

---

### 🚀 Alternative Approaches

- **Naive subtraction**: subtract divisor repeatedly → O(n), too slow.
- **Binary search**: find quotient via search → O(log n).
- Current bit-shift approach is optimal.

---

### ⚠️ Edge Cases

- `divisor = 1` → return dividend.
- `divisor = -1` → handle overflow when dividend = `Integer.MIN_VALUE`.
- `dividend = 0` → return 0.
- Overflow → clamp to 32-bit range.

🔗 LeetCode – Divide Two Integers:[ (leetcode.com)](https://leetcode.com/problems/divide-two-integers/description/)

---

## 6. Gray Code

**Problem**:  
Given an integer `n`, return any valid n-bit Gray code sequence.  
Gray code sequence rules:

- Length = \(2^n\).
- First integer = 0.
- Each integer appears once.
- Adjacent integers differ by exactly one bit.
- First and last integers differ by exactly one bit.

---

### 🔍 Core Idea: Binary-to-Gray Conversion

- Gray code can be generated directly using formula:  
  \[
  \text{Gray}(i) = i \oplus (i >> 1)
  \]
- Iterate `i` from `0` to \(2^n - 1\).
- Apply formula to generate sequence.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- Create list `list = new ArrayList<>()`.

#### Step 2: Generate Sequence

- Loop `i` from `0` to `(1 << n) - 1`.
- Compute `i ^ (i >> 1)`.
- Add to list.

#### Step 3: Return Result

- Return list of integers.

---

### ✅ Example Walkthrough

```text
n = 2
→ i=0 → 0 ^ 0 = 0
→ i=1 → 1 ^ 0 = 1
→ i=2 → 2 ^ 1 = 3
→ i=3 → 3 ^ 1 = 2
→ Result = [0,1,3,2] ✅
```

```text
n = 1
→ i=0 → 0 ^ 0 = 0
→ i=1 → 1 ^ 0 = 1
→ Result = [0,1] ✅
```

---

### 📐 Complexity

| Aspect    | Value                       |
| --------- | --------------------------- |
| Time      | O(2^n) (generate all codes) |
| Space     | O(2^n) (store sequence)     |
| Technique | Bitwise XOR                 |

---

### 🔁 Pattern

- Gray code ensures only one bit changes between consecutive numbers.
- Useful in digital circuits, error correction, and combinatorial problems.
- Formula-based generation avoids recursion or backtracking.

---

### 🚀 Alternative Approaches

- **Recursive construction**:
  - Build (n-1)-bit sequence, then mirror and prefix with 1.
- **Backtracking**: Generate sequence by flipping bits one at a time.
- Current formula is optimal and concise.

---

### ⚠️ Edge Cases

- n = 1 → [0,1].
- n = 16 → sequence length = 65,536 (still feasible).
- Large n → memory usage grows exponentially.

🔗 LeetCode – Gray Code: [(leetcode.com)](https://leetcode.com/problems/gray-code/description/)

---
