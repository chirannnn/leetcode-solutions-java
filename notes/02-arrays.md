# 🚀 Arrays Revision Notes

---

## 1. Build Array from Permutation

**Problem**:  
Given an array `nums`, construct `ans` such that `ans[i] = nums[nums[i]]`.

**Approach**:

- Create a new array `ans[]`.
- For each index `i`, set `ans[i] = nums[nums[i]]`.

**Complexity**:

- Time: O(n)
- Space: O(n)

**Example**:

```text
Input:  nums = [0,2,1,5,3,4]  
Output: ans = [0,1,2,4,5,3]
```

**Key Takeaway**:

- Index-based mapping is a common transformation pattern.

**Pattern**:

- Array Transformation

**In-Place Possibility**:

- Yes, with careful encoding: store both old and new values using modular arithmetic (e.g., `nums[i] += n * (nums[nums[i]] % n)`).

**Edge Cases**:

- Empty array
- Values exceeding array bounds (shouldn’t happen if constraints are respected)

🔗 [LeetCode Link](https://leetcode.com/problems/build-array-from-permutation/)

---

## 2. Concatenation of Array

**Problem**:  
Return an array that is the concatenation of `nums` with itself.

**Approach**:

- Create `ans[]` of size `2 * n`.
- For each index `i`, set:
    - `ans[i] = nums[i]`
    - `ans[i + n] = nums[i]`

**Complexity**:

- Time: O(n)
- Space: O(n)

**Example**:

```text
Input:  nums = [1,2,1]  
Output: ans = [1,2,1,1,2,1]
```

**Key Takeaway**:

- Simple duplication logic; useful for cyclic or repeated patterns.

**Pattern**:

- Array Duplication / Simulation

**In-Place Possibility**:

- Not feasible unless modifying the original array format or using circular logic.

**Edge Cases**:

- Empty array
- Very large arrays (watch for memory limits)

🔗 [LeetCode Link](https://leetcode.com/problems/concatenation-of-array/)

---

## 3. Running Sum of 1D Array

**Problem**:  
Return an array where each element is the sum of all previous elements including itself.

**Approach**:

- Initialize `ans[]` with `ans[0] = nums[0]`.
- For each index `i ≥ 1`, set `ans[i] = ans[i - 1] + nums[i]`.

**Complexity**:

- Time: O(n)
- Space: O(n)

**Example**:

```text
Input:  nums = [1,2,3,4]  
Output: ans = [1,3,6,10]
```

**Key Takeaway**:

- Introduces prefix sum—essential for range queries and subarray problems.

**Pattern**:

- Prefix Sum / Cumulative Sum

**In-Place Possibility**:

- Yes. Modify `nums[]` directly: `nums[i] += nums[i - 1]`

**Edge Cases**:

- Empty array
- Negative numbers (still valid)
- Large integers (watch for overflow)

🔗 [LeetCode Link](https://leetcode.com/problems/running-sum-of-1d-array/)
