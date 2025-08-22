# 🧮 Math Revision Notes

---

## 1. Subtract Product and Sum of Digits of an Integer

**Problem**:  
Given an integer `n`, return the difference between the product of its digits and the sum of its digits.

**Approach**:

- Initialize `product = 1`, `sum = 0`.
- While `n > 0`:
    - Extract digit: `digit = n % 10`
    - Update: `product *= digit`, `sum += digit`
    - Reduce `n = n / 10`
- Return `product - sum`

**Complexity**:

- Time: O(log n)
- Space: O(1)

**Example**:

```text
Input:  n = 234  
Output: 15  
Explanation: Product = 2×3×4 = 24, Sum = 2+3+4 = 9, Result = 24 - 9 = 15
```

**Key Takeaway**:

- Classic digit extraction using modulo and division.
- Efficient and intuitive for digit-level math operations.

**Pattern**:

- Digit Processing / Math Operations

**Space Complexity**:

- O(1) — This problem is naturally space-efficient as it doesn't use an array or auxiliary data structures.

**Edge Cases**:

- Single-digit number → product and sum are equal
- Input = 0 → product = 1 (initial value), sum = 0 → result = 1
- Negative numbers → not valid per problem constraints

**Why It Matters**:

- This technique is foundational for problems like:
    - Reversing an integer  
    - Checking for a palindrome number  
    - Counting even/odd digits  
    - Digit sum-based conditions (e.g., Harshad numbers)

🔗 [LeetCode Link](https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/)
