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
Input:  nums = [0,2,1,5,3,4]
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
- Values exceeding array bounds (shouldn't happen if constraints are respected)

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
Input:  nums = [1,2,1]
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
Input:  nums = [1,2,3,4]
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
ans[2] = nums[1] = 5, ans[3] = nums[4] = 4
ans[4] = nums[2] = 1, ans[5] = nums[5] = 7
Output: [2,3,5,4,1,7]
```

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

---

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

---

## 7. Number of Good Pairs

**Problem**:  
Given an array of integers `nums`, return the number of **good pairs**.

A pair `(i, j)` is called good if:

- `nums[i] == nums[j]`
- `i < j`

**Approach**:

- Use two nested loops to check every possible pair `(i, j)` where `i < j`.
- If `nums[i] == nums[j]`, increment the count.
- Return the total number of good pairs.

**Complexity**:

- Time: O(n²) – brute-force comparison of all pairs
- Space: O(1) – no extra space used

**Example**:

```text
Input: nums = [1,2,3,1,1,3]
Good pairs:
(0,3), (0,4), (3,4), (2,5)
Output: 4
```

**Key Takeaway**:

- Brute-force is acceptable for small inputs and beginner practice.
- Focus is on understanding nested loops and pair comparison logic.
- Sets the stage for learning frequency-based optimizations.

**Pattern**:

- Pair Comparison
- Duplicate Detection

**In-Place Possibility**:

- Not applicable – counting pairs, not modifying array.
- Could optimize space if storing frequencies later.

**Edge Cases**:

- Empty array → 0 pairs
- All elements same → maximum number of good pairs
- No duplicates → 0 pairs
- Single element → 0 pairs

🔗 [LeetCode Link](https://leetcode.com/problems/number-of-good-pairs/)

---

## 8. Smaller Numbers Than Current

**Problem**:  
Given an array `nums`, for each `nums[i]`, count how many numbers in the array are smaller than it.  
Return the result as an array where `result[i]` is the count of numbers smaller than `nums[i]`.

**Approach**:

- Use a brute-force nested loop.
- For each `i`, loop through all `j` and count how many `nums[j] < nums[i]`.
- Store the count in the result array.

**Complexity**:

- Time: O(n²) – two nested loops over the array
- Space: O(n) – for the result array

**Example**:

```text
Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]

Explanation:
nums[0] = 8 → smaller: [1,2,2,3] → count = 4
nums[1] = 1 → smaller: [] → count = 0
nums[2] = 2 → smaller: [1] → count = 1
nums[3] = 2 → smaller: [1] → count = 1
nums[4] = 3 → smaller: [1,2,2] → count = 3
```

**Key Takeaway**:

- Brute-force is a great starting point for beginners.
- Builds intuition for comparison-based problems.
- Sets up for optimization using sorting or frequency arrays.

**Pattern**:

- Element-wise Comparison
- Count Accumulation

**In-Place Possibility**:

- Not applicable – result must be stored separately.
- Could optimize space with frequency-based tricks later.

**Edge Cases**:

- All elements same → all counts = 0
- Strictly increasing array → counts = [0,1,2,...]
- Strictly decreasing array → counts = [n-1, n-2,...]
- Empty array → return empty array

🔗 [LeetCode Link](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/)

---

## 9. Create Target Array in Given Order

**Problem**:  
Given two arrays `nums` and `index`, construct a target array by inserting `nums[i]` at position `index[i]` for each `i`.

Rules:

- Start with an empty array.
- For each `i`, insert `nums[i]` at position `index[i]`.
- Return the final target array.

It is guaranteed that all insertions are valid.

**Approach**:

- Use a dynamic list (e.g. `ArrayList`) to perform insertions.
- Loop through `nums` and `index` simultaneously.
- Insert `nums[i]` at `index[i]` using `list.add(index[i], nums[i])`.
- Convert the list to an array and return.

**Complexity**:

- Time: O(n²) – insertion at arbitrary index in ArrayList is O(n) in worst case
- Space: O(n) – for the target array

**Example**:

```text
Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]

Step-by-step:
Insert 0 at index 0 → [0]
Insert 1 at index 1 → [0,1]
Insert 2 at index 2 → [0,1,2]
Insert 3 at index 2 → [0,1,3,2]
Insert 4 at index 1 → [0,4,1,3,2]

Output: [0,4,1,3,2]
```

**Key Takeaway**:

- This problem is about simulating array insertions.
- ArrayList is ideal for dynamic insertions.
- Time complexity can be improved with linked structures or preallocation.

**Pattern**:

- Simulation
- Index-based Insertion

**In-Place Possibility**:

- Not feasible with fixed-size arrays due to shifting.
- Requires dynamic structure like `ArrayList`.

**Edge Cases**:

- Empty input → return empty array
- All index values are increasing → behaves like append
- All index values are zero → reverse order insertion

🔗 [LeetCode Link](https://leetcode.com/problems/create-target-array-in-the-given-order/)

---

## 10. Sentence Is Pangram

**Problem**:  
A **pangram** is a sentence where every letter of the English alphabet appears at least once.  
Given a string `sentence` containing only lowercase English letters, return `true` if it is a pangram, otherwise return `false`.

**Approach**:

- Create a boolean array `seen[26]` to track each letter.
- Iterate through each character in the sentence.
- For every character `ch`, mark `seen[ch - 'a'] = true`.
- After processing, check if all entries in `seen` are `true`.
- If any letter is missing, return `false`; otherwise, return `true`.

**Complexity**:

- Time: O(n) – one pass through the sentence
- Space: O(1) – fixed size array of 26 letters

**Example**:

```text
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: Contains all 26 letters of the alphabet.

Input: sentence = "leetcode"
Output: false
Explanation: Missing several letters.
```

**Key Takeaway**:

- Pangram check is a classic character frequency problem.
- Boolean array is efficient for fixed-size alphabet tracking.
- Great intro to ASCII manipulation and character indexing.

**Pattern**:

- Character Frequency
- Boolean Tracking
- Set Membership Simulation

**In-Place Possibility**:

- Not applicable – sentence is read-only.
- Could optimize with bitmasking for advanced versions.

**Edge Cases**:

- Empty string → false
- Sentence with repeated letters but missing one → false
- Sentence with exactly 26 unique letters → true

🔗 [LeetCode Link](https://leetcode.com/problems/check-if-the-sentence-is-pangram/)

---

## 11. Count Items Matching a Rule

**Problem**:  
You're given a list of items, where each item is represented as a list of three strings: `[type, color, name]`.  
You're also given a rule in the form of `ruleKey` and `ruleValue`.  
Return the number of items that match the rule.

**Matching Criteria**:

- If `ruleKey == "type"`, match against `item[0]`
- If `ruleKey == "color"`, match against `item[1]`
- If `ruleKey == "name"`, match against `item[2]`

**Approach**:

- Map `ruleKey` to its corresponding index.
- Iterate through each item and check if `item[index] == ruleValue`.
- Count and return the number of matches.

**Complexity**:

- Time: O(n) – one pass through the items list
- Space: O(1) – no extra space beyond counters

**Example**:

```text
Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]]
       ruleKey = "color", ruleValue = "silver"
Output: 1

Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]]
       ruleKey = "type", ruleValue = "phone"
Output: 2
```

**Key Takeaway**:

- Simple mapping logic using index-based access.
- Great intro to structured data filtering.
- Can be extended to dynamic rule systems or object-based filtering.

**Pattern**:

- Array Filtering
- Rule-Based Matching
- Index Mapping

**Edge Cases**:

- Empty items list → return 0
- Invalid ruleKey → not applicable (assumed valid input)
- Multiple identical matches → all counted

**Optimizations**:

- Replace `if-else` with a `Map<String, Integer>` for cleaner index lookup.
- Use enhanced `for-each` loop for readability.

🔗 [LeetCode Link](https://leetcode.com/problems/count-items-matching-a-rule/)

---

## 12. Find the Highest Altitude

**Problem**:  
A biker starts a road trip at altitude `0`. You're given an array `gain[]` where `gain[i]` represents the net altitude change between point `i` and `i+1`.  
Return the **highest altitude** reached during the trip.

**Approach**:

- Initialize `currAlt = 0` and `maxAlt = 0`.
- Traverse the `gain[]` array:
  - Add each `gain[i]` to `currAlt`.
  - Update `maxAlt` if `currAlt` exceeds it.
- Return `maxAlt` after the loop.

**Complexity**:

- Time: O(n) – single pass through the array
- Space: O(1) – constant space for altitude tracking

**Example**:

```text
Input: gain = [-5,1,5,0,-7]
Altitudes: [0,-5,-4,1,1,-6]
Output: 1

Input: gain = [-4,-3,-2,-1,4,3,2]
Altitudes: [0,-4,-7,-9,-10,-6,-3,-1]
Output: 0
```

**Key Takeaway**:

- This is a classic **prefix sum** problem.
- Track cumulative values and update the max on-the-fly.
- Useful pattern for elevation, temperature, or profit tracking.

**Pattern**:

- Prefix Sum
- Running Maximum
- Cumulative Tracking

**Edge Cases**:

- All negative gains → highest altitude is 0
- Empty gain array → return 0 (starting point only)

**Optimizations**:

- Already optimal in time and space.
- Can be extended to return the point index of highest altitude if needed.

🔗 [LeetCode Link](https://leetcode.com/problems/find-the-highest-altitude/)

---
