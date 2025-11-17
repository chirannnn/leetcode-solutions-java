## 1. Merge Sorted Arrays (In-Place)

**Problem**:  
Given two sorted arrays `nums1` and `nums2`, merge them into a single sorted array **in-place** inside `nums1`.

- `nums1` has length `m + n`, with the last `n` elements set to `0` as placeholders
- `nums2` has length `n`
- The merged result should be stored in `nums1`

---

### 🔍 Core Idea: Reverse Merge from the End

Instead of merging from the front (which would overwrite values), we:

- Start from the **end of both arrays**
- Compare elements from the back
- Place the **larger** one at the end of `nums1`
- Move backwards until all elements from `nums2` are placed

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize Pointers

- `i = m - 1` → last valid element in `nums1`
- `j = n - 1` → last element in `nums2`
- `k = m + n - 1` → last position in `nums1`

#### Step 2: Merge in Reverse

- While `j >= 0`:
  - If `i >= 0 && nums1[i] > nums2[j]` → place `nums1[i]` at `nums1[k]`
  - Else → place `nums2[j]` at `nums1[k]`
  - Move pointers accordingly

#### Step 3: Done

- No need to handle leftover `nums1` elements — they’re already in place

---

### ✅ Example

```text
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6], n = 3

→ Start from end:
  Compare 3 and 6 → place 6 at nums1[5]
  Compare 3 and 5 → place 5 at nums1[4]
  Compare 3 and 2 → place 3 at nums1[3]
  Compare 2 and 2 → place 2 at nums1[2]
  Compare 2 and - → place 2 at nums1[1]
  Compare 1 and - → place 1 at nums1[0]

Output: [1,2,2,3,5,6]
```

---

### 📐 Complexity

| Aspect    | Value                     |
| --------- | ------------------------- |
| Time      | O(m + n)                  |
| Space     | O(1)                      |
| Technique | Reverse Two-Pointer Merge |

---

### 🔁 Pattern

- In-place merge
- Reverse traversal to avoid overwriting
- Two-pointer strategy

---

### ⚠️ Edge Cases

- `nums2` empty → `nums1` unchanged
- `nums1` empty (m = 0) → copy `nums2` into `nums1`
- All elements equal → stable merge

🔗 [LeetCode – Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array)

---

## 2. Majority Element

**Problem**:  
Given an array `nums[]`, return the element that appears **more than ⌊n / 2⌋ times**.  
You’re guaranteed that such an element **always exists**.

---

### 🔍 Core Idea: Boyer–Moore Majority Vote Algorithm

We don’t need to count every element — just track a **candidate** and its **net support**.  
If an element is the majority, it will survive all pairwise cancellations.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `count = 0` → net support
- `candidate = 0` → current majority guess

#### Step 2: Traverse Array

- If `count == 0` → pick new `candidate = num`
- If `num == candidate` → increment `count`
- Else → decrement `count`

#### Step 3: Return Final Candidate

- Guaranteed to be the majority due to problem constraints

---

### ✅ Example

```text
nums = [2,2,1,1,1,2,2]

→ candidate = 2, count = 1
→ candidate = 2, count = 2
→ candidate = 2, count = 1
→ candidate = 2, count = 0 → switch to 1
→ candidate = 1, count = 1
→ candidate = 1, count = 0 → switch to 2
→ candidate = 2, count = 1

Final candidate = 2 ✅
```

---

### 📐 Complexity

| Aspect    | Value            |
| --------- | ---------------- |
| Time      | O(n)             |
| Space     | O(1)             |
| Technique | Voting Algorithm |

---

### 🔁 Pattern

- Majority detection
- Pairwise cancellation
- Linear scan with constant space

---

### 🚀 Alternative Approach

- Sort and return `nums[n/2]` → works due to majority guarantee
- HashMap count → O(n) time, O(n) space

---

### ⚠️ Edge Cases

- All elements same → return that element
- Majority element at end → still detected
- Multiple candidates → only one will survive

🔗 [LeetCode – Majority Element](https://leetcode.com/problems/majority-element)

---

## 3. Contains Duplicate

**Problem**:  
Given an integer array `nums[]`, return `true` if any value appears **at least twice**, otherwise return `false`.

---

### 🔍 Core Idea: Sort and Scan for Adjacent Duplicates

By sorting the array:

- All duplicates (if any) will appear **next to each other**
- We can then scan linearly and compare adjacent elements

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort the Array

- Sorting brings duplicates together

#### Step 2: Linear Scan

- For each index `i` from `1` to `n - 1`:
  - If `nums[i] == nums[i - 1]` → duplicate found → return `true`

#### Step 3: Return `false` if No Duplicates Found

---

### ✅ Example

```text
nums = [1,2,3,1]

→ Sorted: [1,1,2,3]
→ Compare: 1 == 1 → return true
```

---

### 📐 Complexity

| Aspect    | Value                |
| --------- | -------------------- |
| Time      | O(n log n)           |
| Space     | O(1) (in-place sort) |
| Technique | Sort + Linear Scan   |

---

### 🔁 Pattern

- Duplicate detection
- Sorting-based adjacency check
- Early exit on match

---

### 🚀 Alternative Approaches

- **HashSet**:

  - Insert each element into a set
  - If already present → return `true`
  - Time: O(n), Space: O(n)

- **Brute Force**:
  - Compare every pair → O(n²)

---

### ⚠️ Edge Cases

- Empty array → return `false`
- One element → return `false`
- All elements same → return `true`

🔗 [LeetCode – Contains Duplicate](https://leetcode.com/problems/contains-duplicate)

---

## 4. Missing Number

**Problem**:  
Given an array `nums[]` containing `n` distinct numbers in the range `[0, n]`, return the **missing number** from the range.

---

### 🔍 Core Idea: Cyclic Sort for Index Alignment

We treat the array as a mapping from value → index.  
Using **cyclic sort**, we place each number at its correct index (`nums[i] → i`).  
After sorting:

- If `nums[i] ≠ i` → `i` is the missing number
- If all match → missing number is `n`

---

### 🧠 Algorithm Breakdown

#### Step 1: Cyclic Sort

- Traverse the array
- For each `nums[i]`, if it's in range and not at its correct index → swap it to its correct position
- Repeat until all elements are either in place or out of bounds

#### Step 2: Scan for Mismatch

- After sorting, scan from `0` to `n - 1`
- If `nums[i] ≠ i` → return `i`
- If all match → return `n`

---

### ✅ Example

```text
nums = [3,0,1]

→ After cyclic sort: [0,1,3]
→ Scan:
  nums[0] = 0 ✅
  nums[1] = 1 ✅
  nums[2] = 3 ❌ → return 2
```

---

### 📐 Complexity

| Aspect    | Value                    |
| --------- | ------------------------ |
| Time      | O(n)                     |
| Space     | O(1)                     |
| Technique | Cyclic Sort + Index Scan |

---

### 🔁 Pattern

- Index-based placement
- Cyclic sort for bounded range
- Mismatch detection

---

### 🚀 Alternative Approaches

- **Sum formula**:  
  \[
  \text{missing} = \frac{n(n+1)}{2} - \sum(nums)
  \]
  → O(n) time, O(1) space

- **XOR trick**:  
  XOR all indices and values → missing number remains

---

### ⚠️ Edge Cases

- Missing number is `n` → return `nums.length`
- Array starts at 0 → handled naturally
- Unsorted input → cyclic sort reorders correctly

🔗 [LeetCode – Missing Number](https://leetcode.com/problems/missing-number)

---

## 5. Intersection of Two Arrays

**Problem**:  
Given two integer arrays `nums1[]` and `nums2[]`, return an array of their **unique intersection**.  
Order doesn’t matter, but duplicates must be removed.

---

### 🔍 Core Idea: Sort + Two-Pointer Scan

By sorting both arrays:

- We can use two pointers to scan and compare elements
- When a match is found, we check for uniqueness before adding to result

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Both Arrays

- Ensures linear scan is valid

#### Step 2: Initialize Pointers

- `i = 0` → pointer for `nums1`
- `j = 0` → pointer for `nums2`

#### Step 3: Scan and Compare

- If `nums1[i] == nums2[j]`:
  - Check if it’s already in result → if not, add
  - Move both pointers
- If `nums1[i] < nums2[j]` → move `i`
- Else → move `j`

#### Step 4: Convert Result List to Array

---

### ✅ Example

```text
nums1 = [1,2,2,1], nums2 = [2,2]

→ Sorted: [1,1,2,2], [2,2]
→ Compare:
  1 < 2 → i++
  1 < 2 → i++
  2 == 2 → add 2
  2 == 2 → already added → skip

Output: [2]
```

---

### 📐 Complexity

| Aspect    | Value                                 |
| --------- | ------------------------------------- |
| Time      | O(n log n + m log m) (due to sorting) |
| Space     | O(n + m)                              |
| Technique | Sort + Two-Pointer                    |

---

### 🔁 Pattern

- Set intersection
- Duplicate filtering
- Sorted scan with uniqueness check

---

### 🚀 Alternative Approaches

- **HashSet**:

  - Store `nums1` in a set
  - Scan `nums2`, add matches to result set
  - Time: O(n + m), Space: O(n)

- **Brute Force**:
  - Nested loops with manual duplicate check → O(n × m)

---

### ⚠️ Edge Cases

- One array empty → return empty
- All elements same → return single element
- No common elements → return empty

🔗 [LeetCode – Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays)

---

## 6. Intersection of Two Arrays II

**Problem**:  
Given two integer arrays `nums1[]` and `nums2[]`, return an array of their **intersection**, where each element appears **as many times** as it occurs in both arrays.  
Order doesn’t matter.

---

### 🔍 Core Idea: Sort + Two-Pointer Frequency Match

By sorting both arrays:

- We can use two pointers to scan and match elements
- When a match is found, we add it to the result and move both pointers
- This naturally preserves frequency without extra bookkeeping

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Both Arrays

- Ensures linear scan is valid

#### Step 2: Initialize Pointers

- `i = 0` → pointer for `nums1`
- `j = 0` → pointer for `nums2`

#### Step 3: Scan and Compare

- If `nums1[i] == nums2[j]` → add to result, move both pointers
- If `nums1[i] < nums2[j]` → move `i`
- Else → move `j`

#### Step 4: Convert Result List to Array

---

### ✅ Example

```text
nums1 = [1,2,2,1], nums2 = [2,2]

→ Sorted: [1,1,2,2], [2,2]
→ Compare:
  1 < 2 → i++
  1 < 2 → i++
  2 == 2 → add 2
  2 == 2 → add 2

Output: [2,2]
```

---

### 📐 Complexity

| Aspect    | Value                                 |
| --------- | ------------------------------------- |
| Time      | O(n log n + m log m) (due to sorting) |
| Space     | O(n + m)                              |
| Technique | Sort + Two-Pointer                    |

---

### 🔁 Pattern

- Set intersection with frequency
- Sorted scan
- Multiplicity preservation

---

### 🚀 Alternative Approaches

- **HashMap Count**:

  - Count frequencies in `nums1`
  - Scan `nums2`, decrement counts and collect matches
  - Time: O(n + m), Space: O(n)

- **Brute Force**:
  - Nested loops with used flags → O(n × m)

---

### ⚠️ Edge Cases

- One array empty → return empty
- All elements same → return full match
- No common elements → return empty

🔗 [LeetCode – Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii)

---

## 7. Third Maximum Number

**Problem**:  
Given an integer array `nums[]`, return the **third distinct maximum** number.  
If fewer than three distinct values exist, return the **maximum** number.

---

### 🔍 Core Idea: Track Top 3 Distinct Maximum

We maintain three variables:

- `max1` → highest
- `max2` → second highest
- `max3` → third highest

We update them in a single pass, skipping duplicates.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- Set `max1`, `max2`, `max3` to `Long.MIN_VALUE` to handle edge cases

#### Step 2: Traverse Array

- For each `num`:
  - Skip if already equal to any of the three maxes
  - If `num > max1` → shift all down, update `max1`
  - Else if `num > max2` → shift `max2` and `max3`, update `max2`
  - Else if `num > max3` → update `max3`

#### Step 3: Return Result

- If `max3` was never updated → return `max1`
- Else → return `max3`

---

### ✅ Example

```text
nums = [2,2,3,1]

→ Unique values: [3,2,1]
→ max1 = 3, max2 = 2, max3 = 1
→ Return 1 ✅
```

---

### 📐 Complexity

| Aspect    | Value               |
| --------- | ------------------- |
| Time      | O(n)                |
| Space     | O(1)                |
| Technique | Rolling Max Tracker |

---

### 🔁 Pattern

- Top-k distinct tracking
- Duplicate skipping
- Constant space scan

---

### 🚀 Alternative Approaches

- **TreeSet**:

  - Add all elements to a set
  - Sort descending and pick third → O(n log n)

- **Sort + Dedup**:
  - Sort array, remove duplicates, return third from end → O(n log n)

---

### ⚠️ Edge Cases

- Less than 3 distinct values → return max
- All elements same → return that value
- Negative numbers → handled via `Long.MIN_VALUE`

🔗 [LeetCode – Third Maximum Number](https://leetcode.com/problems/third-maximum-number)

---

## 8. Assign Cookies

**Problem**:  
Given two arrays:

- `g[]` → greed factor of each child (minimum cookie size needed)
- `s[]` → size of each cookie

Assign at most one cookie per child such that the number of **content children** is maximized.  
A child is content if `cookie ≥ greed`.

---

### 🔍 Core Idea: Greedy Matching with Sorted Arrays

We sort both arrays and use **two pointers** to match the smallest available cookie to the least greedy child.  
This ensures:

- We don’t waste large cookies on small greed
- We maximize the number of satisfied children

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Both Arrays

- `g[]` → increasing greed
- `s[]` → increasing cookie size

#### Step 2: Initialize Pointers

- `i = 0` → child index
- `j = 0` → cookie index

#### Step 3: Match Cookies to Children

- While both pointers are in bounds:
  - If `s[j] ≥ g[i]` → assign cookie, increment both
  - Else → cookie too small → try next cookie (`j++`)

#### Step 4: Return Count of Matches

---

### ✅ Example

```text
g = [1,2,3], s = [1,1]

→ Sorted: g = [1,2,3], s = [1,1]
→ Match:
  s[0] = 1 ≥ g[0] = 1 → assign → count = 1
  s[1] = 1 < g[1] = 2 → skip

Output: 1
```

---

### 📐 Complexity

| Aspect    | Value                                 |
| --------- | ------------------------------------- |
| Time      | O(n log n + m log m) (due to sorting) |
| Space     | O(1)                                  |
| Technique | Greedy + Two-Pointer                  |

---

### 🔁 Pattern

- Greedy resource allocation
- Sorted matching
- Early termination on exhaustion

---

### 🚀 Alternative Approaches

- **Priority Queue**:

  - Match largest cookies to largest greed → more complex, same result

- **Brute Force**:
  - Try every cookie for every child → O(n × m)

---

### ⚠️ Edge Cases

- No cookies → return 0
- No children → return 0
- All cookies too small → return 0
- All greed ≤ smallest cookie → all children satisfied

🔗 [LeetCode – Assign Cookies](https://leetcode.com/problems/assign-cookies)

---

## 9. Array Partition – Maximize Sum of Min Pairs

**Problem**:  
Given an array `nums[]` of `2n` integers, form `n` pairs such that the **sum of the minimum of each pair** is **maximized**.  
Return that maximum sum.

---

### 🔍 Core Idea: Greedy Pairing via Sorting

To maximize the sum of `min(ai, bi)`:

- We want to **pair the smallest numbers together**
- Sorting ensures that pairing adjacent elements gives the best result
- Always take the **first element of each pair** (i.e., every even index)

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort the Array

- Ensures optimal adjacent pairing

#### Step 2: Traverse in Steps of 2

- For every pair `(nums[i], nums[i+1])`, take `nums[i]` (the smaller one)
- Accumulate the sum

#### Step 3: Return the Total

---

### ✅ Example

```text
nums = [1,4,3,2]

→ Sorted: [1,2,3,4]
→ Pairs: (1,2), (3,4)
→ Sum = min(1,2) + min(3,4) = 1 + 3 = 4 ✅
```

---

### 📐 Complexity

| Aspect    | Value                |
| --------- | -------------------- |
| Time      | O(n log n)           |
| Space     | O(1) (in-place sort) |
| Technique | Greedy + Sorting     |

---

### 🔁 Pattern

- Greedy pairing
- Min-max optimization
- Stepwise accumulation

---

### 🚀 Alternative Approaches

- **Counting Sort** (if range is small) → O(n) time
- **Priority Queue** → less efficient, not needed here

---

### ⚠️ Edge Cases

- All elements equal → return `n × value`
- Already sorted → still works
- Negative numbers → handled naturally

🔗 [LeetCode – Array Partition I](https://leetcode.com/problems/array-partition)

---

## 10. Maximum Product of Three Numbers

**Problem**:  
Given an integer array `nums[]`, find the **maximum product** of any **three numbers**.

---

### 🔍 Core Idea: Sort and Compare Two Product Scenarios

To maximize the product of three numbers:

- Either take the **three largest positives**
- Or take **two smallest negatives** and the largest positive  
  (since negative × negative = positive)

Sorting helps us identify both cases efficiently.

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort the Array

- Ascending order gives access to:
  - Two smallest values → `nums[0]`, `nums[1]`
  - Three largest values → `nums[n-1]`, `nums[n-2]`, `nums[n-3]`

#### Step 2: Compute Two Product Candidates

- `prod1 = nums[0] * nums[1] * nums[n-1]` → handles negative × negative × positive
- `prod2 = nums[n-1] * nums[n-2] * nums[n-3]` → handles all positives

#### Step 3: Return the Maximum of Both

---

### ✅ Example

```text
nums = [-10, -10, 5, 2]

→ Sorted: [-10, -10, 2, 5]
→ prod1 = -10 × -10 × 5 = 500
→ prod2 = 5 × 2 × -10 = -100

Output: 500 ✅
```

---

### 📐 Complexity

| Aspect    | Value                  |
| --------- | ---------------------- |
| Time      | O(n log n)             |
| Space     | O(1) (in-place sort)   |
| Technique | Sort + Edge Comparison |

---

### 🔁 Pattern

- Product maximization
- Edge-case handling with negatives
- Dual-scenario evaluation

---

### 🚀 Alternative Approaches

- **Linear scan**:
  - Track top 3 max and bottom 2 min values in one pass
  - Time: O(n), Space: O(1)

---

### ⚠️ Edge Cases

- All positives → take top 3
- All negatives → take least negative (closest to 0)
- Mixed signs → check both scenarios

🔗 [LeetCode – Maximum Product of Three Numbers](https://leetcode.com/problems/maximum-product-of-three-numbers)

---

## 11. Sort Array by Parity

**Problem**:  
Given an array `nums[]`, rearrange it so that **all even integers appear before all odd integers**.  
Return any array that satisfies this condition.

---

### 🔍 Core Idea: Two-Pointer Swap Based on Parity

We use two pointers:

- `i` → scans from the start
- `j` → scans from the end  
  We swap values when:
- `nums[i]` is odd and `nums[j]` is even

This ensures:

- Evens move left
- Odds move right
- No extra space is used

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize Pointers

- `i = 0`, `j = n - 1`

#### Step 2: While `i < j`

- If `nums[i]` is odd and `nums[j]` is even → swap
- If `nums[i]` is even → move `i` forward
- If `nums[j]` is odd → move `j` backward

#### Step 3: Return Modified Array

---

### ✅ Example

```text
nums = [3,1,2,4]

→ Initial: i = 0, j = 3
→ nums[0] = 3 (odd), nums[3] = 4 (even) → swap → [4,1,2,3]
→ nums[0] = 4 (even) → i++
→ nums[1] = 1 (odd), nums[2] = 2 (even) → swap → [4,2,1,3]
→ i = 2, j = 1 → done

Output: [4,2,1,3] ✅
```

---

### 📐 Complexity

| Aspect    | Value            |
| --------- | ---------------- |
| Time      | O(n)             |
| Space     | O(1)             |
| Technique | Two-Pointer Swap |

---

### 🔁 Pattern

- In-place partitioning
- Parity-based rearrangement
- Swap logic with dual traversal

---

### 🚀 Alternative Approaches

- **Extra array**:

  - Create two lists: evens and odds
  - Concatenate → O(n) time, O(n) space

- **Stable sort**:
  - Sort by `num % 2` → preserves relative order

---

### ⚠️ Edge Cases

- Single element → return as-is
- All even or all odd → no swaps needed
- Negative numbers → parity logic still valid

🔗 [LeetCode – Sort Array by Parity](https://leetcode.com/problems/sort-array-by-parity)

---

## 12. Sort Array by Parity II

**Problem**:  
Given an array `nums[]` where half the elements are even and half are odd, rearrange it so that:

- Every even number is placed at an even index
- Every odd number is placed at an odd index

Return any valid arrangement.

---

### 🔍 Core Idea: Two-Pointer Parity Correction

We use two pointers:

- `i` → scans even indices (0, 2, 4, …)
- `j` → scans odd indices (1, 3, 5, …)

If:

- `nums[i]` is odd → misplaced
- `nums[j]` is even → misplaced  
  → Swap them to restore parity alignment

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize Pointers

- `i = 0` (even index)
- `j = 1` (odd index)

#### Step 2: Traverse While `i < n` and `j < n`

- If `nums[i]` is even → correct → move `i += 2`
- If `nums[j]` is odd → correct → move `j += 2`
- Else → swap `nums[i]` and `nums[j]`

#### Step 3: Return Modified Array

---

### ✅ Example

```text
nums = [4,2,5,7]

→ Initial: i = 0, j = 1
→ nums[0] = 4 (even) → i += 2
→ nums[2] = 5 (odd), nums[1] = 2 (even) → swap → [4,5,2,7]

Output: [4,5,2,7] ✅
```

---

### 📐 Complexity

| Aspect    | Value                   |
| --------- | ----------------------- |
| Time      | O(n)                    |
| Space     | O(1)                    |
| Technique | Two-Pointer Parity Swap |

---

### 🔁 Pattern

- Index-based parity enforcement
- In-place correction
- Dual stepping pointers

---

### 🚀 Alternative Approaches

- **Extra arrays**:

  - Separate evens and odds
  - Reconstruct by placing at correct indices → O(n) space

- **Stable sort by index parity**:
  - More complex, not needed here

---

### ⚠️ Edge Cases

- Already sorted → no swaps
- Only two elements → trivial
- Negative numbers → parity logic still valid

🔗 [LeetCode – Sort Array by Parity II](https://leetcode.com/problems/sort-array-by-parity-ii)

---

## 13. Largest Perimeter Triangle

**Problem**:  
Given an array `nums[]` representing side lengths, return the **largest perimeter** of a triangle that can be formed using any three lengths.  
If no valid triangle can be formed, return `0`.

---

### 🔍 Core Idea: Triangle Inequality + Greedy from Largest

To form a triangle with sides `a, b, c`:

- The triangle inequality must hold:  
  \[
  a + b > c,\quad b + c > a,\quad c + a > b
  \]
- When sorted in ascending order, we only need to check:  
  \[
  \text{if } nums[i-2] + nums[i-1] > nums[i]
  \]

We sort the array and check triplets from the end (largest sides) to maximize the perimeter.

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort the Array

- Ascending order ensures largest sides are at the end

#### Step 2: Traverse from End

- For each triplet `(a, b, c)` from right to left:
  - If `b + c > a` → valid triangle → return `a + b + c`

#### Step 3: Return 0 if No Valid Triplet Found

---

### ✅ Example

```text
nums = [2,1,2]

→ Sorted: [1,2,2]
→ Check: 1 + 2 > 2 → valid
→ Perimeter = 1 + 2 + 2 = 5 ✅
```

---

### 📐 Complexity

| Aspect    | Value                        |
| --------- | ---------------------------- |
| Time      | O(n log n)                   |
| Space     | O(1)                         |
| Technique | Greedy + Triangle Inequality |

---

### 🔁 Pattern

- Greedy selection from sorted array
- Feasibility check using mathematical constraint
- Early exit on first valid match

---

### 🚀 Alternative Approaches

- **Brute Force**:

  - Try all triplets → O(n³)
  - Not efficient for large inputs

- **Heap-based**:
  - Maintain top 3 candidates → more complex, not needed here

---

### ⚠️ Edge Cases

- All sides too small → return 0
- All equal → always forms a triangle
- Large gap between largest and others → triangle not possible

🔗 [LeetCode – Largest Perimeter Triangle](https://leetcode.com/problems/largest-perimeter-triangle)

---

## 14. Squares of a Sorted Array

**Problem**:  
Given a sorted array `nums[]` (non-decreasing), return a new array of the **squares of each number**, also sorted in non-decreasing order.

---

### 🔍 Core Idea: Two-Pointer Merge from Ends

Squaring negative numbers can disrupt order:

- Example: `[-4, -1, 0, 3, 10] → [16, 1, 0, 9, 100]`
- Sorting after squaring is trivial but costs `O(n log n)`

Instead, we use a **two-pointer approach**:

- Compare absolute values from both ends
- Place the **larger square** at the end of the result array
- Move inward and fill from right to left

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `i = 0` → start pointer
- `j = n - 1` → end pointer
- `k = n - 1` → fill position in result array

#### Step 2: Compare and Fill

- While `i ≤ j`:
  - If `|nums[i]| > |nums[j]|` → square `nums[i]`, place at `ans[k]`, move `i++`
  - Else → square `nums[j]`, place at `ans[k]`, move `j--`
  - Move `k--`

#### Step 3: Return Result

---

### ✅ Example

```text
nums = [-4,-1,0,3,10]

→ Compare:
  |−4| vs |10| → 10² = 100 → ans[4] = 100
  |−4| vs |3| → 4² = 16 → ans[3] = 16
  |−1| vs |3| → 3² = 9 → ans[2] = 9
  |−1| vs |0| → 1² = 1 → ans[1] = 1
  0² = 0 → ans[0] = 0

Output: [0,1,9,16,100] ✅
```

---

### 📐 Complexity

| Aspect    | Value                      |
| --------- | -------------------------- |
| Time      | O(n)                       |
| Space     | O(n)                       |
| Technique | Two-Pointer + Reverse Fill |

---

### 🔁 Pattern

- Monotonic transformation
- Two-pointer merge
- Reverse construction

---

### 🚀 Alternative Approaches

- **Square + Sort**:

  - Square all → sort → O(n log n)

- **In-place variant**:
  - Requires careful overwrite logic → not used here

---

### ⚠️ Edge Cases

- All non-negative → square preserves order
- All negative → square reverses order
- Mixed signs → two-pointer needed

🔗 [LeetCode – Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array)

---

## 15. Matrix Cells in Distance Order

**Problem**:  
Given a matrix of size `rows × cols` and a center cell `(rCenter, cCenter)`, return all cell coordinates **sorted by their Manhattan distance** from the center.

---

### 🔍 Core Idea: Generate All Coordinates + Sort by Distance

We:

- Generate all cell coordinates in the matrix
- Compute their **Manhattan distance** from `(rCenter, cCenter)`:
  \[
  \text{distance} = |r - rCenter| + |c - cCenter|
  \]
- Sort the list based on this distance

---

### 🧠 Algorithm Breakdown

#### Step 1: Generate All Coordinates

- Loop through every cell `(i, j)` in the matrix
- Add to a list as `[i, j]`

#### Step 2: Sort by Manhattan Distance

- Use a custom comparator:
  - Compare `|i - rCenter| + |j - cCenter|` for each cell

#### Step 3: Convert List to Array

- Return the sorted coordinates as a 2D array

---

### ✅ Example

```text
rows = 2, cols = 3, rCenter = 1, cCenter = 2

→ All cells: [0,0], [0,1], [0,2], [1,0], [1,1], [1,2]
→ Distances: 3, 2, 1, 2, 1, 0
→ Sorted: [1,2], [0,2], [1,1], [0,1], [1,0], [0,0]
```

---

### 📐 Complexity

| Aspect    | Value                            |
| --------- | -------------------------------- |
| Time      | O(n log n) where n = rows × cols |
| Space     | O(n)                             |
| Technique | Grid Generation + Custom Sort    |

---

### 🔁 Pattern

- Grid traversal
- Distance-based sorting
- Coordinate transformation

---

### 🚀 Alternative Approaches

- **Bucket sort by distance**:

  - Precompute max distance
  - Group cells by distance → O(n) time

- **BFS from center**:
  - Layered expansion → preserves order without sorting

---

### ⚠️ Edge Cases

- Single cell → return itself
- Center at edge → still valid
- Multiple cells with same distance → any order accepted

🔗 [LeetCode – Matrix Cells in Distance Order](https://leetcode.com/problems/matrix-cells-in-distance-order)

---

## 16. Height Checker

**Problem**:  
Given an array `heights[]` representing students' current lineup, return the number of indices where `heights[i] ≠ expected[i]`, where `expected[]` is the sorted version of `heights[]`.

---

### 🔍 Core Idea: Compare Original vs Sorted Snapshot

To find how many students are **out of place**:

- Clone and sort the array to get the expected order
- Compare each index between original and sorted
- Count mismatches

---

### 🧠 Algorithm Breakdown

#### Step 1: Clone and Sort

- `expected = heights.clone()`
- `Arrays.sort(expected)`

#### Step 2: Compare Each Index

- For each `i`:
  - If `heights[i] ≠ expected[i]` → increment mismatch count

#### Step 3: Return Count

---

### ✅ Example

```text
heights = [1,1,4,2,1,3]
expected = [1,1,1,2,3,4]

→ Compare:
  i=0: 1 == 1 ✅
  i=1: 1 == 1 ✅
  i=2: 4 ≠ 1 ❌
  i=3: 2 == 2 ✅
  i=4: 1 ≠ 3 ❌
  i=5: 3 ≠ 4 ❌

→ Mismatches = 3 ✅
```

---

### 📐 Complexity

| Aspect    | Value          |
| --------- | -------------- |
| Time      | O(n log n)     |
| Space     | O(n)           |
| Technique | Sort + Compare |

---

### 🔁 Pattern

- Snapshot comparison
- Stability check
- Mismatch detection

---

### 🚀 Alternative Approaches

- **Counting Sort**:
  - Use frequency array (0–100 range)
  - Simulate sorted traversal and compare → O(n) time, O(1) space

---

### ⚠️ Edge Cases

- Already sorted → return 0
- All elements same → return 0
- Completely reversed → return `n`

🔗 [LeetCode – Height Checker](https://leetcode.com/problems/height-checker)

---

## 17. Relative Sort Array

**Problem**:  
Given two arrays `arr1[]` and `arr2[]`:

- All elements of `arr2` are distinct and present in `arr1`
- Sort `arr1` such that:
  - Elements in `arr2` appear first, in the same order as `arr2`
  - Remaining elements (not in `arr2`) appear at the end in ascending order

---

### 🔍 Core Idea: Frequency Count + Ordered Placement

We:

- Count frequencies of all elements in `arr1`
- Place elements from `arr2` in order, using their frequencies
- Append remaining elements (not in `arr2`) in sorted order

This avoids repeated scans and ensures linear time placement.

---

### 🧠 Algorithm Breakdown

#### Step 1: Count Frequencies

- Use a fixed-size array `freq[1001]` since `0 ≤ arr[i] ≤ 1000`

#### Step 2: Place Elements from `arr2`

- For each `num` in `arr2`, place it `freq[num]` times in result
- Decrement frequency as you go

#### Step 3: Place Remaining Elements

- Traverse `freq[]` from 0 to 1000
- For any `freq[i] > 0`, place `i` that many times

---

### ✅ Example

```text
arr1 = [2,3,1,3,2,4,6,7,9,2,19]
arr2 = [2,1,4,3,9,6]

→ Frequency map:
  1→1, 2→3, 3→2, 4→1, 6→1, 7→1, 9→1, 19→1

→ Output:
  [2,2,2,1,4,3,3,9,6] ← from arr2
  [7,19] ← sorted remainder

→ Final: [2,2,2,1,4,3,3,9,6,7,19] ✅
```

---

### 📐 Complexity

| Aspect    | Value                         |
| --------- | ----------------------------- |
| Time      | O(n + m + k) where k = 1001   |
| Space     | O(k)                          |
| Technique | Frequency Map + Ordered Merge |

---

### 🔁 Pattern

- Relative ordering
- Frequency counting
- Hybrid sorting strategy

---

### 🚀 Alternative Approaches

- **Custom Comparator**:

  - Map `arr2` values to ranks
  - Sort `arr1` using comparator → O(n log n)

- **List-based filtering**:
  - Extract and remove `arr2` elements
  - Sort and append remainder

---

### ⚠️ Edge Cases

- All elements in `arr2` → no remainder
- All elements outside `arr2` → full sort
- Duplicates in `arr1` → handled via frequency

🔗 [LeetCode – Relative Sort Array](https://leetcode.com/problems/relative-sort-array)

---

## 18. Minimum Absolute Difference

**Problem**:  
Given an array `arr[]` of **distinct integers**, find all pairs `[a, b]` such that:

- `a < b`
- `b - a == min(abs difference)` among all pairs in `arr`

Return all such pairs in **ascending order**.

---

### 🔍 Core Idea: Sort + Adjacent Difference Scan

Sorting the array ensures:

- The smallest absolute differences are between adjacent elements
- We only need to scan once to find the minimum difference and collect matching pairs

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort the Array

- Ensures adjacent elements are closest in value

#### Step 2: Track Minimum Difference

- Initialize `minDiff = Integer.MAX_VALUE`

#### Step 3: Scan Adjacent Pairs

- For each `i` from `1` to `n-1`:
  - Compute `diff = arr[i] - arr[i-1]`
  - If `diff < minDiff` → update `minDiff`, clear result, add pair
  - If `diff == minDiff` → add pair

#### Step 4: Return Result List

---

### ✅ Example

```text
arr = [4,2,1,3]

→ Sorted: [1,2,3,4]
→ Differences: 1,1,1
→ minDiff = 1
→ Pairs: [1,2], [2,3], [3,4] ✅
```

---

### 📐 Complexity

| Aspect    | Value                       |
| --------- | --------------------------- |
| Time      | O(n log n) (due to sorting) |
| Space     | O(n)                        |
| Technique | Sort + Linear Scan          |

---

### 🔁 Pattern

- Adjacent pair scanning
- Minimum value tracking
- Sorted difference analysis

---

### 🚀 Alternative Approaches

- **Brute Force**:

  - Compare all pairs → O(n²)
  - Inefficient for large inputs

- **TreeSet**:
  - Insert and scan neighbors → more complex, not needed here

---

### ⚠️ Edge Cases

- Already sorted → still works
- Negative numbers → handled naturally
- Only two elements → one pair returned

🔗 [LeetCode – Minimum Absolute Difference](https://leetcode.com/problems/minimum-absolute-difference)

---

## 19. Rank Transform of an Array

**Problem**:  
Given an array `arr[]`, replace each element with its **rank**, where:

- Rank starts from `1`
- Larger elements get higher ranks
- Equal elements share the same rank
- Ranks are as small as possible

---

### 🔍 Core Idea: Sort + Map to Rank

We:

- Clone and sort the array to establish rank order
- Assign ranks to each unique value
- Map original values to their ranks using binary search or hash map

---

### 🧠 Algorithm Breakdown

#### Step 1: Clone and Sort

- `copy = arr.clone()`
- `Arrays.sort(copy)` → ascending order

#### Step 2: Assign Ranks

- Traverse `copy[]`
- If `copy[i] ≠ copy[i-1]` → increment rank
- Store ranks in parallel array or map

#### Step 3: Map Original Values to Ranks

- For each `arr[i]`, find its index in `copy[]` using binary search
- Use that index to fetch rank

---

### ✅ Example

```text
arr = [40,10,20,30]

→ Sorted: [10,20,30,40]
→ Ranks: 10→1, 20→2, 30→3, 40→4

→ Output: [4,1,2,3] ✅
```

---

### 📐 Complexity

| Aspect    | Value                                       |
| --------- | ------------------------------------------- |
| Time      | O(n log n) (due to sorting + binary search) |
| Space     | O(n)                                        |
| Technique | Sort + Rank Mapping                         |

---

### 🔁 Pattern

- Value-to-rank transformation
- Duplicate handling
- Sorted mapping with binary search

---

### 🚀 Alternative Approaches

- **HashMap**:

  - Map each unique value to its rank directly → O(n log n) time, O(n) space

- **TreeMap**:
  - Sorted map for rank assignment → more overhead

---

### ⚠️ Edge Cases

- All elements equal → rank = 1 for all
- Already sorted → ranks increase linearly
- Negative values → handled naturally

🔗 [LeetCode – Rank Transform of an Array](https://leetcode.com/problems/rank-transform-of-an-array)

---

## 20. How Many Numbers Are Smaller Than the Current Number

**Problem**:  
Given an array `nums[]`, return a new array where each element at index `i` is the **count of numbers smaller than `nums[i]`**.

---

### 🔍 Core Idea: Sort + Rank Mapping

We:

- Clone and sort the array to establish value order
- Assign each value a **rank** equal to the number of smaller elements before it
- Use binary search to map each original value to its rank

This avoids nested loops and handles duplicates efficiently.

---

### 🧠 Algorithm Breakdown

#### Step 1: Clone and Sort

- `copy = nums.clone()`
- `Arrays.sort(copy)` → ascending order

#### Step 2: Assign Ranks

- Traverse `copy[]`
- If `copy[i] ≠ copy[i-1]` → `ranks[i] = i`
- Else → `ranks[i] = ranks[i-1]` (same value, same rank)

#### Step 3: Map Original Values to Ranks

- For each `nums[i]`, binary search its index in `copy[]`
- Use that index to fetch `ranks[index]`

---

### ✅ Example

```text
nums = [8,1,2,2,3]

→ Sorted: [1,2,2,3,8]
→ Ranks: 1→0, 2→1, 3→3, 8→4

→ Output: [4,0,1,1,3] ✅
```

---

### 📐 Complexity

| Aspect    | Value                             |
| --------- | --------------------------------- |
| Time      | O(n log n) (sort + binary search) |
| Space     | O(n)                              |
| Technique | Sort + Rank Mapping               |

---

### 🔁 Pattern

- Count of smaller elements
- Sorted index mapping
- Duplicate-aware ranking

---

### 🚀 Alternative Approaches

- **Counting Sort** (range 0–100):

  - Use frequency array and prefix sum → O(n) time, O(1) space

- **Brute Force**:
  - Compare each pair → O(n²)

---

### ⚠️ Edge Cases

- All elements equal → return all zeros
- Already sorted → ranks increase linearly
- Negative values → handled naturally if range extended

🔗 [LeetCode – How Many Numbers Are Smaller Than the Current Number](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number)

---

## 21. Maximum Product of Two Elements in an Array

**Problem**:  
Given an array `nums[]`, choose two different indices `i` and `j` such that the value of \((nums[i] - 1) \cdot (nums[j] - 1)\) is maximized.  
Return that maximum value.

---

### 🔍 Core Idea: Track Top Two Values

To maximize \((a - 1) \cdot (b - 1)\), we need the **two largest values** in the array.  
Subtract 1 from each and multiply.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `max1 = 0`, `max2 = 0`

#### Step 2: Traverse Array

- For each `num`:
  - If `num > max1` → shift `max1 → max2`, update `max1`
  - Else if `num > max2` → update `max2`

#### Step 3: Return Product

- \((max1 - 1) \cdot (max2 - 1)\)

---

### ✅ Example

```text
nums = [3,4,5,2]

→ max1 = 5, max2 = 4
→ (5 - 1) × (4 - 1) = 4 × 3 = 12 ✅
```

---

### 📐 Complexity

| Aspect    | Value        |
| --------- | ------------ |
| Time      | O(n)         |
| Space     | O(1)         |
| Technique | Max Tracking |

---

### 🔁 Pattern

- Top-k value tracking
- Offset-based product
- Linear scan optimization

---

### 🚀 Alternative Approaches

- **Sort and pick last two**:

  - Time: O(n log n)
  - Space: O(1) if in-place

- **Priority Queue**:
  - Track top two → more overhead

---

### ⚠️ Edge Cases

- Only two elements → direct product
- Duplicates → handled naturally
- Negative values → not applicable (constraints: positive integers)

🔗 [LeetCode – Maximum Product of Two Elements in an Array](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array)

---

## 22. Average Salary Excluding the Minimum and Maximum

**Problem**:  
Given an array `salary[]` of unique integers, return the **average salary excluding the minimum and maximum values**.

---

### 🔍 Core Idea: One-Pass Min/Max Tracking

To compute the average excluding min and max:

- Track `sum`, `min`, and `max` in a single pass
- Subtract `min` and `max` from total sum
- Divide by `(n - 2)` to get average

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `max = Integer.MIN_VALUE`
- `min = Integer.MAX_VALUE`
- `sum = 0`

#### Step 2: Traverse Array

- Add each salary to `sum`
- Update `min` and `max` accordingly

#### Step 3: Compute Average

- Formula:  
  \[
  \text{average} = \frac{sum - min - max}{n - 2}
  \]

---

### ✅ Example

```text
salary = [4000,3000,1000,2000]

→ sum = 10000
→ min = 1000, max = 4000
→ average = (10000 - 1000 - 4000) / (4 - 2)
           = 5000 / 2
           = 2500 ✅
```

---

### 📐 Complexity

| Aspect    | Value                   |
| --------- | ----------------------- |
| Time      | O(n)                    |
| Space     | O(1)                    |
| Technique | Single-pass aggregation |

---

### 🔁 Pattern

- Min-max exclusion
- Aggregate + adjust
- Average computation

---

### 🚀 Alternative Approaches

- **Sort + slice**:

  - Sort array, sum middle elements
  - Time: O(n log n), Space: O(1)

- **Stream API (Java)**:
  - Use `IntStream` for concise code

---

### ⚠️ Edge Cases

- Only 3 elements → average is the middle one
- Large values → safe with `int` sum (constraints small)
- Negative salaries → handled naturally

🔗 [LeetCode – Average Salary Excluding the Minimum and Maximum](https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/)

---

## 23. Make Two Arrays Equal by Reversing Subarrays

**Problem**:  
Given two arrays `target[]` and `arr[]` of equal length, determine if `arr` can be transformed into `target` by reversing any number of subarrays.

---

### 🔍 Core Idea: Frequency Equivalence

Key observation:

- Reversing subarrays allows **any permutation** of elements.
- Therefore, the only requirement is that both arrays contain the **same multiset of elements** (same values with same frequencies).
- If frequencies match → return `true`.
- Otherwise → return `false`.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize Frequency Array

- `freq[1001]` (since values are bounded by constraints)

#### Step 2: Count Elements in `target`

- For each `num` in `target`, increment `freq[num]`

#### Step 3: Subtract Elements in `arr`

- For each `num` in `arr`, decrement `freq[num]`
- If any `freq[num] < 0` → mismatch → return `false`

#### Step 4: Return True

- If all frequencies balanced → arrays are equivalent

---

### ✅ Example

```text
target = [1,2,3,4]
arr    = [2,4,1,3]

→ freq after target: {1:1, 2:1, 3:1, 4:1}
→ subtract arr: all counts return to 0
→ result = true ✅
```

---

### 📐 Complexity

| Aspect    | Value                                   |
| --------- | --------------------------------------- |
| Time      | O(n)                                    |
| Space     | O(k) where k = max element value (1001) |
| Technique | Frequency Counting                      |

---

### 🔁 Pattern

- Permutation equivalence
- Frequency-based validation
- Subarray reversal → permutation freedom

---

### 🚀 Alternative Approaches

- **Sorting**:
  - Sort both arrays and compare → O(n log n)
- **HashMap**:
  - Count frequencies with map → O(n), more flexible for larger ranges

---

### ⚠️ Edge Cases

- Single element arrays → always equal if values match
- Different values → immediate false
- Large arrays with duplicates → handled by frequency counts

🔗 [LeetCode – Make Two Arrays Equal by Reversing Subarrays](https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays)

---

## 24. Can Make Arithmetic Progression From Sequence

**Problem**:  
Given an array `arr[]`, determine if it can be rearranged to form an **arithmetic progression** (AP), i.e., a sequence where the difference between consecutive elements is constant.

---

### 🔍 Core Idea: Sort + Uniform Difference Check

- Rearranging means we can sort the array first.
- After sorting, if the difference between every consecutive pair is the same, the array can form an AP.
- Otherwise, return `false`.

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort the Array

- Sorting ensures elements are in ascending order, making AP check straightforward.

#### Step 2: Compute Common Difference

- `diff = arr[1] - arr[0]`

#### Step 3: Validate All Consecutive Differences

- For each `i` from `2` to `n-1`:
  - If `arr[i] - arr[i-1] != diff` → return `false`

#### Step 4: Return True

- If all differences match, array can form AP.

---

### ✅ Example

```text
arr = [3,5,1]

→ Sorted: [1,3,5]
→ Differences: 3-1 = 2, 5-3 = 2
→ All equal → true ✅
```

```text
arr = [1,2,4]

→ Sorted: [1,2,4]
→ Differences: 2-1 = 1, 4-2 = 2
→ Not equal → false ❌
```

---

### 📐 Complexity

| Aspect    | Value                       |
| --------- | --------------------------- |
| Time      | O(n log n) (due to sorting) |
| Space     | O(1)                        |
| Technique | Sort + Difference Check     |

---

### 🔁 Pattern

- Rearrangement feasibility via sorting
- Uniform difference validation
- Sequence property check

---

### 🚀 Alternative Approaches

- **HashSet + min/max**:

  - Compute min, max, and expected difference
  - Check if all expected terms exist in set → O(n) time, O(n) space

- **Direct formula check**:
  - If `(max - min) % (n-1) != 0` → cannot form AP

---

### ⚠️ Edge Cases

- Array length ≤ 2 → always true (any two numbers form AP)
- Negative numbers → handled naturally
- Large gaps → still valid if consistent

🔗 [LeetCode – Can Make Arithmetic Progression From Sequence](https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence)

---

## 25. Sort Array by Increasing Frequency

**Problem**:  
Given an array `nums[]`, sort it such that:

1. Elements with **lower frequency** come first.
2. If two elements have the **same frequency**, sort them in **decreasing order** (larger value first).

Return the sorted array.

---

### 🔍 Core Idea: Frequency Count + Custom Comparator

We:

- Count frequency of each element.
- Sort using a comparator:
  - Primary key → frequency (ascending).
  - Secondary key → value (descending).
- Copy sorted result back into `int[]`.

---

### 🧠 Algorithm Breakdown

#### Step 1: Frequency Array

- Use `freq[201]` since values range from `-100` to `100`.
- Shift index by `+100` to handle negatives.

#### Step 2: Convert to `Integer[]`

- Needed because `Arrays.sort` with comparator doesn’t work directly on primitive `int[]`.

#### Step 3: Custom Comparator

- If `freq[a] == freq[b]` → sort by `b - a` (decreasing order).
- Else → sort by `freq[a] - freq[b]` (increasing frequency).

#### Step 4: Copy Back

- Convert sorted `Integer[]` to `int[]`.

---

### ✅ Example

```text
nums = [1,1,2,2,2,3]

→ Frequencies: 1→2, 2→3, 3→1
→ Sorted by frequency:
   3 (freq=1) → first
   1 (freq=2) → next
   2 (freq=3) → last
→ Output: [3,1,1,2,2,2] ✅
```

```text
nums = [2,3,1,3,2]

→ Frequencies: 1→1, 2→2, 3→2
→ Tie between 2 and 3 → sort by value descending → 3 before 2
→ Output: [1,3,3,2,2] ✅
```

---

### 📐 Complexity

| Aspect    | Value                           |
| --------- | ------------------------------- |
| Time      | O(n log n) (due to sorting)     |
| Space     | O(n + k), k = 201               |
| Technique | Frequency Counting + Comparator |

---

### 🔁 Pattern

- Frequency-based ordering
- Tie-breaking with secondary rule
- Comparator-driven sorting

---

### 🚀 Alternative Approaches

- **HashMap + List Sort**:
  - Store frequencies in a map, sort list with comparator.
- **Bucket Sort**:
  - Group by frequency, then sort within buckets by value descending.

---

### ⚠️ Edge Cases

- All elements same → array unchanged.
- Negative numbers → handled via offset indexing.
- Multiple ties → resolved by descending order rule.

🔗 [LeetCode – Sort Array by Increasing Frequency](https://leetcode.com/problems/sort-array-by-increasing-frequency)

---

## 26. Special Array With X Elements Greater Than or Equal to X

**Problem**:  
Given an array `nums[]` of non-negative integers, determine if there exists a number `x` such that exactly `x` numbers in `nums` are greater than or equal to `x`.  
Return `x` if it exists, otherwise return `-1`.  
If valid, `x` is guaranteed to be unique.

---

### 🔍 Core Idea: Binary Search on Candidate `x`

- Possible values of `x` range from `1` to `n` (array length).
- For each candidate `x`, count how many numbers in `nums` are ≥ `x`.
- If count equals `x`, return it.
- Otherwise, adjust search range:
  - If count > x → need larger `x`.
  - If count < x → need smaller `x`.

This avoids brute force and leverages sorted order.

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Array

- Sorting allows efficient counting of elements ≥ `x`.

#### Step 2: Binary Search on `x`

- Search range: `1 … n`
- Midpoint = candidate `x`
- Count elements ≥ `x` using helper function

#### Step 3: Count Elements ≥ `x`

- Binary search for first index where `arr[i] ≥ x`
- Count = `n - index`

#### Step 4: Return Result

- If count == x → return x
- If no match → return -1

---

### ✅ Example

```text
nums = [0,4,3,0,4]

→ Sorted: [0,0,3,4,4]
→ Try x = 3:
   Count of ≥ 3 = 3 (values 3,4,4)
   Count == x → return 3 ✅
```

```text
nums = [3,5]

→ Sorted: [3,5]
→ Try x = 2:
   Count of ≥ 2 = 2
   Count == x → return 2 ✅
```

```text
nums = [0,0]

→ Sorted: [0,0]
→ No valid x → return -1 ❌
```

---

### 📐 Complexity

| Aspect    | Value                             |
| --------- | --------------------------------- |
| Time      | O(n log n) (sort + binary search) |
| Space     | O(1)                              |
| Technique | Binary Search + Counting          |

---

### 🔁 Pattern

- Candidate search space reduction
- Frequency-based validation
- Unique solution guarantee

---

### 🚀 Alternative Approaches

- **Brute Force**:
  - For each `x` from 1 to n, count manually → O(n²)
- **Direct Scan**:
  - Sort and check counts sequentially → O(n log n)

---

### ⚠️ Edge Cases

- All zeros → always -1
- Single element → only valid if `nums[0] == 1`
- Large duplicates → handled by count logic

🔗 [LeetCode – Special Array With X Elements Greater Than or Equal to X](https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x)

---
