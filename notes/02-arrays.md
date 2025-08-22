# Arrays Revision Notes

1. **Build Array from Permutation**

   - Use new array `ans[]`
   - For each i → set `ans[i] = nums[nums[i]]`
   - Complexity: O(n), Space O(n)
   - [LeetCode Link](https://leetcode.com/problems/build-array-from-permutation/)

2. **Concatenation of Array**

   - Create `ans[]` of size 2\*n
   - For each i → `ans[i] = nums[i]`, `ans[i+n] = nums[i]`
   - Complexity: O(n), Space O(n)
   - [LeetCode Link](https://leetcode.com/problems/concatenation-of-array/)

3. **Running Sum of 1D Array**
   - Maintain `ans[]` → `ans[0] = nums[0]`, for i ≥ 1 → `ans[i] = ans[i-1] + nums[i]`
   - Complexity: O(n), Space O(n)
   - [LeetCode Link](https://leetcode.com/problems/running-sum-of-1d-array/)
