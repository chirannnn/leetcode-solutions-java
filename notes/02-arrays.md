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

---

## 4. Richest Customer Wealth

**Problem**:  
Given an `m x n` integer grid `accounts` where `accounts[i][j]` is the amount of money the `i`th customer has in the `j`th bank. Return the wealth that the richest customer has.

**Approach**:

- For each customer (row), calculate the sum of all their accounts.
- Keep track of the maximum wealth seen so far.
- Return the maximum wealth after checking all customers.

**Complexity**:

- Time: O(m × n) where m = customers, n = accounts per customer
- Space: O(1)

**Example**:

```text
Input:  accounts = [[1,2,3],[3,2,1]]
Customer 1 wealth = 1 + 2 + 3 = 6
Customer 2 wealth = 3 + 2 + 1 = 6
Output: 6 (maximum wealth)
```

**Key Takeaway**:

- Straightforward row-sum with maximum tracking.
- Useful example of combining matrix traversal with aggregation.

**Pattern**:

- Matrix Traversal
- Aggregation + Max

**In-Place Possibility**:

- Not applicable — we only calculate sums.

**Edge Cases**:

- Single customer → sum of that row.
- All zeros → result = 0.
- Large values → may require bigger integer type.

🔗 [LeetCode Link](https://leetcode.com/problems/richest-customer-wealth/)

---

## 5. Shuffle the Array

**Problem**:  
Given array `nums` of `2n` elements in form `[x1,x2,...,xn,y1,y2,...,yn]`. Return array in form `[x1,y1,x2,y2,...,xn,yn]`.

**Approach**:

- Create new array `ans[]` of size `2n`.
- For each index `i` from `0` to `n-1`:
  - Place `nums[i]` at `ans[2*i]` (even positions)
  - Place `nums[i+n]` at `ans[2*i+1]` (odd positions)

**Complexity**:

- Time: O(n)
- Space: O(n)

**Example**:

```text
Input:  nums = [2,5,1,3,4,7], n = 3
x = [2,5,1], y = [3,4,7]
ans[0] = nums[0] = 2, ans[1] = nums[3] = 3
ans[2] = nums[1] = 5, ans[4] = nums[4] = 4
ans[4] = nums[2] = 1, ans[5] = nums[5] = 7
Output: [2,3,5,4,1,7]
```

````

**Key Takeaway**:

- Array interleaving pattern using index mapping.
- First half and second half elements are paired alternately.

**Pattern**:

- Array Rearrangement
- Index Mapping

**In-Place Possibility**:

- Complex but possible using encoding technique or cyclic replacements.
- Standard approach uses O(n) extra space for clarity.

**Edge Cases**:

- Minimum case: n = 1 → [x1,y1]
- Array length not exactly 2n (violates constraint)
- Large arrays (memory considerations)

🔗 [LeetCode Link](https://leetcode.com/problems/shuffle-the-array/)

```

```
````

## 6. Kids With the Greatest Number of Candies

**Problem**:  
Given array `candies` where `candies[i]` represents candies the `i`th kid has, and `extraCandies` you have. Return boolean array where `result[i]` is `true` if giving the `i`th kid all `extraCandies` makes them have the greatest number among all kids.

**Approach**:

- Find the maximum number of candies any kid currently has.
- For each kid, check if `candies[i] + extraCandies >= max`.
- Add the boolean result to the result list/array.

**Complexity**:

- Time: O(n) - two passes through the array
- Space: O(n) - for the result array

**Example**:

```text
Input:  candies = [2,3,5,1,3], extraCandies = 3
Max candies currently = 5
Kid 0: 2 + 3 = 5 >= 5 → true
Kid 1: 3 + 3 = 6 >= 5 → true
Kid 2: 5 + 3 = 8 >= 5 → true
Kid 3: 1 + 3 = 4 >= 5 → false
Kid 4: 3 + 3 = 6 >= 5 → true
Output: [true,true,true,false,true]
```

**Key Takeaway**:

- Two-pass algorithm: find maximum first, then compare each element.
- Multiple kids can have the greatest number simultaneously.

**Pattern**:

- Max Finding + Comparison
- Boolean Array Generation

**In-Place Possibility**:

- Not applicable - need to return boolean array of results.
- Could reuse input array if allowed to modify it.

**Edge Cases**:

- All kids have same candies → all true
- Single kid → always true
- extraCandies = 0 → only current max holders are true

🔗 [LeetCode Link](https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/)
