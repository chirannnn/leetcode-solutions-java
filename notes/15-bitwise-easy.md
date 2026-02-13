## 1. Add Binary

**Problem**:  
Given two binary strings `a` and `b`, return their sum as a binary string.

---

### 🔍 Core Idea: Manual Binary Addition

- Binary addition works like decimal addition but with base 2.
- Traverse both strings from right to left.
- Add corresponding digits plus carry.
- Append result digit (`sum & 1`) to output.
- Update carry (`sum >> 1`).
- Reverse the result at the end.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- Pointers `i = m-1`, `j = n-1`.
- `carry = 0`.
- `StringBuilder res`.

#### Step 2: Traverse

- While `i >= 0 || j >= 0 || carry > 0`:
  - Compute `sum = (a[i] - '0') + (b[j] - '0') + carry`.
  - Append `(sum & 1)` to result.
  - Update `carry = sum >> 1`.
  - Decrement `i`, `j`.

#### Step 3: Reverse Result

- Reverse `res` and return as string.

---

### ✅ Example Walkthrough

```text
a = "11", b = "1"

→ i=1, j=0
   sum = 1+1+0 = 2 → digit=0, carry=1
→ i=0, j=-1
   sum = 1+0+1 = 2 → digit=0, carry=1
→ i=-1, j=-1
   sum = 0+0+1 = 1 → digit=1, carry=0
→ Result = "100" ✅
```

```text
a = "1010", b = "1011"

→ Result = "10101" ✅
```

---

### 📐 Complexity

| Aspect    | Value                                      |
| --------- | ------------------------------------------ |
| Time      | O(max(m, n)) (linear scan of both strings) |
| Space     | O(max(m, n)) (result storage)              |
| Technique | Digit-by-digit addition                    |

---

### 🔁 Pattern

- Similar to **Add Strings** or **Add Two Numbers (Linked List)** problems.
- Manual addition with carry is a recurring technique in string/number manipulation.

---

### 🚀 Alternative Approaches

- **BigInteger** (Java built-in): Convert to integers, add, then convert back → not optimal for very large inputs.
- **Bitwise simulation**: More complex, less readable.
- Current approach is optimal and clean.

---

### ⚠️ Edge Cases

- One string empty → return the other.
- Different lengths → handled by carry loop.
- Large inputs (up to \(10^4\)) → efficient with O(n).
- Leading zeros → avoided by constraints.

🔗 LeetCode – Add Binary: [(leetcode.com)](https://leetcode.com/problems/add-binary/description/)

---

## 2. Single Number

**Problem**:  
Given an integer array `nums` where every element appears twice except for one, return the element that appears only once.  
Constraints require **linear runtime** and **constant extra space**.

---

### 🔍 Core Idea: XOR Property

- XOR (`^`) has two key properties:
  1. \(x \oplus x = 0\) (same numbers cancel out).
  2. \(x \oplus 0 = x\).
- Therefore, XOR-ing all numbers in the array leaves only the unique number (since duplicates cancel out).

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `unique = 0`.

#### Step 2: Traverse Array

- For each `num` in `nums`:
  - `unique ^= num`.

#### Step 3: Return Result

- After traversal, `unique` holds the single number.

---

### ✅ Example Walkthrough

```text
nums = [2,2,1]

→ unique = 0
→ 0 ^ 2 = 2
→ 2 ^ 2 = 0
→ 0 ^ 1 = 1
→ Result = 1 ✅
```

```text
nums = [4,1,2,1,2]

→ unique = 0
→ 0 ^ 4 = 4
→ 4 ^ 1 = 5
→ 5 ^ 2 = 7
→ 7 ^ 1 = 6
→ 6 ^ 2 = 4
→ Result = 4 ✅
```

```text
nums = [1]

→ unique = 0 ^ 1 = 1 ✅
```

---

### 📐 Complexity

| Aspect    | Value                       |
| --------- | --------------------------- |
| Time      | O(n) (single pass)          |
| Space     | O(1) (constant extra space) |
| Technique | Bitwise XOR                 |

---

### 🔁 Pattern

- XOR trick is common in problems involving pairs and uniqueness.
- Similar to "Find missing number" or "Find two unique numbers" problems.
- Efficient and elegant compared to HashMap or sorting approaches.

---

### 🚀 Alternative Approaches

- **HashSet**: Track seen numbers → O(n) time, O(n) space.
- **Sorting**: Compare adjacent elements → O(n log n) time.
- XOR is optimal (O(n), O(1)).

---

### ⚠️ Edge Cases

- Array length = 1 → return that element.
- Negative numbers → XOR works fine.
- Large input (up to \(3 \times 10^4\)) → efficient with O(n).

🔗 LeetCode – Single Number: [(leetcode.com)](https://leetcode.com/problems/single-number/description/)

---
