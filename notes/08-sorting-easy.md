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
