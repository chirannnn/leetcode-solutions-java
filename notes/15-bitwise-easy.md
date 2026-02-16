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

## 3. Reverse Bits

**Problem**:  
Given a 32-bit signed integer `n`, return the integer obtained by reversing its bits.

---

### 🔍 Core Idea: Bitwise Manipulation

- Traverse all 32 bits of the integer.
- At each step:
  - Shift the result left (`rev << 1`).
  - Add the least significant bit of `n` (`n & 1`).
  - Shift `n` right (`n >>> 1`) to process the next bit.
- After 32 iterations, `rev` contains the reversed bit pattern.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `rev = 0`.

#### Step 2: Loop 32 Times

- For each bit position `i` (0 to 31):
  - `rev = (rev << 1) | (n & 1)` → append current bit.
  - `n >>>= 1` → move to next bit.

#### Step 3: Return Result

- Return `rev`.

---

### ✅ Example Walkthrough

```text
n = 43261596
Binary: 00000010100101000001111010011100

→ Reverse process:
   Result = 00111001011110000010100101000000
→ Decimal = 964176192 ✅
```

```text
n = 2147483644
Binary: 01111111111111111111111111111100

→ Reverse process:
   Result = 00111111111111111111111111111110
→ Decimal = 1073741822 ✅
```

---

### 📐 Complexity

| Aspect    | Value                       |
| --------- | --------------------------- |
| Time      | O(32) → O(1) (fixed loop)   |
| Space     | O(1) (constant extra space) |
| Technique | Bitwise shifting            |

---

### 🔁 Pattern

- Common in bit manipulation problems.
- Similar to reversing digits but at the binary level.
- Useful in low-level programming, cryptography, and graphics.

---

### 🚀 Alternative Approaches

- **Precomputation**: If function is called many times, precompute reversed values for 8-bit chunks (0–255).
  - Then combine 4 chunks to form the 32-bit result.
  - Optimizes repeated calls.
- **Library functions**: Some languages provide built-in bit reversal, but manual implementation is more instructive.

---

### ⚠️ Edge Cases

- n = 0 → result = 0.
- n = 1 → result = \(2^{31}\).
- Large values → handled correctly since loop always runs 32 times.
- Negative numbers → treated as 32-bit signed, but bitwise operations still valid.

🔗 LeetCode – Reverse Bits: [(leetcode.com)](https://leetcode.com/problems/reverse-bits/description/)

---

## 4. Number of 1 Bits (Hamming Weight)

**Problem**:  
Given a positive integer `n`, return the number of set bits (`1`s) in its binary representation.

---

### 🔍 Core Idea: Brian Kernighan’s Algorithm

- Each iteration removes the **lowest set bit** from `n`.
- Operation:  
  \[
  n = n \ \& \ (n - 1)
  \]  
  This clears the rightmost `1` bit.
- Count how many times this operation can be applied until `n = 0`.
- Result = number of set bits.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `count = 0`.

#### Step 2: Loop Until n = 0

- Increment `count`.
- Update `n = n & (n - 1)` → removes one set bit.

#### Step 3: Return Result

- Return `count`.

---

### ✅ Example Walkthrough

```text
n = 11
Binary = 1011

→ Iteration 1: n=1011 → n&(n-1)=1010 → count=1
→ Iteration 2: n=1010 → n&(n-1)=1000 → count=2
→ Iteration 3: n=1000 → n&(n-1)=0000 → count=3
→ Result = 3 ✅
```

```text
n = 128
Binary = 10000000

→ Only one set bit
→ Result = 1 ✅
```

```text
n = 2147483645
Binary = 1111111111111111111111111111101

→ 30 set bits
→ Result = 30 ✅
```

---

### 📐 Complexity

| Aspect    | Value                                     |
| --------- | ----------------------------------------- |
| Time      | O(k), where k = number of set bits (≤ 32) |
| Space     | O(1)                                      |
| Technique | Bit manipulation                          |

---

### 🔁 Pattern

- Classic bit manipulation technique.
- Similar to problems like **counting bits**, **power of two check**, or **parity check**.
- Efficient compared to naive bit-by-bit shifting.

---

### 🚀 Alternative Approaches

- **Naive shifting**: Check each bit with `(n >> i) & 1` → O(32).
- **Lookup table**: Precompute bit counts for 8-bit chunks (0–255) → faster for repeated calls.
- **Built-in functions**: Some languages provide `Integer.bitCount(n)`.

---

### ⚠️ Edge Cases

- n = 0 → result = 0.
- Large values (up to \(2^{31}-1\)) → handled correctly.
- Negative numbers not considered (constraint: positive integer).

🔗 LeetCode – Number of 1 Bits: [(leetcode.com)](https://leetcode.com/problems/number-of-1-bits/description/)

---

## 5. Counting Bits

**Problem**:  
Given an integer `n`, return an array `ans` of length `n+1` where `ans[i]` is the number of `1`s in the binary representation of `i`.

---

### 🔍 Core Idea: Dynamic Programming + Bitwise

- The number of set bits in `i` can be derived from:  
  \[
  \text{ans}[i] = \text{ans}[i >> 1] + (i \& 1)
  \]
- Explanation:
  - `i >> 1` → right shift (divide by 2), discards the least significant bit.
  - `(i & 1)` → checks if the least significant bit is `1`.
  - So, count of bits in `i` = count of bits in half of `i` + last bit.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `ans = new int[n+1]`.

#### Step 2: Fill Array

- For each `i` from 0 to `n`:
  - `ans[i] = ans[i >> 1] + (i & 1)`.

#### Step 3: Return Result

- Return `ans`.

---

### ✅ Example Walkthrough

```text
n = 2
→ ans[0] = 0
→ ans[1] = ans[0] + 1 = 1
→ ans[2] = ans[1] + 0 = 1
→ Result = [0,1,1] ✅
```

```text
n = 5
→ ans[0] = 0
→ ans[1] = 1
→ ans[2] = 1
→ ans[3] = 2
→ ans[4] = 1
→ ans[5] = 2
→ Result = [0,1,1,2,1,2] ✅
```

---

### 📐 Complexity

| Aspect    | Value               |
| --------- | ------------------- |
| Time      | O(n) (single pass)  |
| Space     | O(n) (result array) |
| Technique | DP + bitwise        |

---

### 🔁 Pattern

- Builds on **Number of 1 Bits** problem.
- Uses recurrence relation for efficient computation.
- Avoids recomputation by reusing previous results.

---

### 🚀 Alternative Approaches

- **Naive method**: For each number, count bits → O(n log n).
- **Brian Kernighan’s trick**: For each number, repeatedly clear lowest set bit → O(k) per number.
- Current DP approach is optimal (O(n)).

---

### ⚠️ Edge Cases

- n = 0 → result = [0].
- Large n (up to \(10^5\)) → efficient with O(n).
- Works for all non-negative integers.

🔗 LeetCode – Counting Bits: (https://leetcode.com/problems/counting-bits/description/)

---
