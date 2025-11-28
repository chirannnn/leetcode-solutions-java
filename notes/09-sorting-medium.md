## 1. 3Sum

**Problem**:  
Given an integer array `nums[]`, return all unique triplets `[nums[i], nums[j], nums[k]]` such that:

- \(i \neq j \neq k\)
- \(nums[i] + nums[j] + nums[k] = 0\)
- No duplicate triplets in the result.

---

### 🔍 Core Idea: Sort + Two-Pointer Search

- Sort the array to simplify duplicate handling and ordered scanning.
- Fix one number (`nums[i]`) and use two pointers (`j`, `k`) to find pairs that sum to `-nums[i]`.
- Skip duplicates to ensure unique triplets.

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Array

- `Arrays.sort(nums)` → ascending order.

#### Step 2: Iterate with Index `i`

- Skip duplicates (`nums[i] == nums[i-1]`).
- If `nums[i] > 0`, break (since all later numbers are positive, sum cannot be 0).

#### Step 3: Two-Pointer Search

- Initialize `j = i+1`, `k = n-1`.
- Compute `sum = nums[i] + nums[j] + nums[k]`.
  - If `sum == 0` → add triplet, move both pointers, skip duplicates.
  - If `sum > 0` → decrement `k`.
  - If `sum < 0` → increment `j`.

#### Step 4: Return Result

- Collect all valid triplets in a list.

---

### ✅ Example

```text
nums = [-1,0,1,2,-1,-4]

→ Sorted: [-4,-1,-1,0,1,2]

→ i=0 (-4): no valid triplets
→ i=1 (-1):
   j=2 (-1), k=5 (2) → sum=0 → [-1,-1,2]
   j=3 (0), k=4 (1) → sum=0 → [-1,0,1]
→ i=2 (-1): skipped (duplicate)
→ i=3 (0): no new triplets

→ Output: [[-1,-1,2], [-1,0,1]] ✅
```

---

### 📐 Complexity

| Aspect    | Value                                 |
| --------- | ------------------------------------- |
| Time      | O(n²) (outer loop + two-pointer scan) |
| Space     | O(1) (excluding result list)          |
| Technique | Sort + Two-Pointer                    |

---

### 🔁 Pattern

- Sorting for duplicate control
- Two-pointer scanning for pair sums
- Triplet uniqueness via skip logic

---

### 🚀 Alternative Approaches

- **HashSet-based**:
  - Use set to track complements → more overhead, harder to deduplicate.
- **Brute Force**:
  - Check all triplets → O(n³), inefficient.

---

### ⚠️ Edge Cases

- All zeros → return [[0,0,0]]
- No valid triplets → return empty list
- Duplicates → handled by skip logic

🔗 [LeetCode – 3Sum](https://leetcode.com/problems/3sum)

---

## 2. 3Sum Closest

**Problem**:  
Given an integer array `nums[]` and a target value, find three integers in `nums` whose sum is **closest** to the target.  
Return the sum of those three integers.  
Constraint: Exactly one solution exists.

---

### 🔍 Core Idea: Sort + Two-Pointer Search

- Sort the array to simplify scanning.
- Fix one number (`nums[i]`) and use two pointers (`j`, `k`) to find pairs that minimize the difference between `sum` and `target`.
- Track the closest sum found so far.
- Adjust pointers based on whether the current sum is greater or smaller than target.

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Array

- `Arrays.sort(nums)` → ascending order.

#### Step 2: Initialize Closest

- Start with `closest = nums[0] + nums[1] + nums[2]`.

#### Step 3: Iterate with Index `i`

- For each `i`, set `j = i+1`, `k = n-1`.
- While `j < k`:
  - Compute `sum = nums[i] + nums[j] + nums[k]`.
  - If `|sum - target| < |closest - target|` → update `closest`.
  - If `sum > target` → decrement `k`.
  - If `sum < target` → increment `j`.
  - If `sum == target` → return `target` immediately (perfect match).

#### Step 4: Return Closest

- After scanning all possibilities, return `closest`.

---

### ✅ Example

```text
nums = [-1,2,1,-4], target = 1

→ Sorted: [-4,-1,1,2]
→ Initial closest = -4 + -1 + 1 = -4
→ i=0 (-4): sums checked → closest updated to 2
→ i=1 (-1): sums checked → closest remains 2
→ Final result = 2 ✅
```

```text
nums = [0,0,0], target = 1

→ Sorted: [0,0,0]
→ Initial closest = 0
→ Only possible sum = 0
→ Result = 0 ✅
```

---

### 📐 Complexity

| Aspect    | Value                                 |
| --------- | ------------------------------------- |
| Time      | O(n²) (outer loop + two-pointer scan) |
| Space     | O(1)                                  |
| Technique | Sort + Two-Pointer                    |

---

### 🔁 Pattern

- Sorting for ordered scanning
- Two-pointer technique for sum problems
- Closest value tracking with absolute difference

---

### 🚀 Alternative Approaches

- **Brute Force**:
  - Check all triplets → O(n³), inefficient.
- **Binary Search**:
  - Fix two numbers, binary search for third → O(n² log n).

---

### ⚠️ Edge Cases

- All zeros → result = 0
- Exact match → return target immediately
- Negative + positive mix → handled naturally by sorting

🔗 [LeetCode – 3Sum Closest](https://leetcode.com/problems/3sum-closest)

---

## 3. 4Sum

**Problem**:  
Given an integer array `nums[]` and a target value, return all **unique quadruplets** `[nums[a], nums[b], nums[c], nums[d]]` such that:

- \(a, b, c, d\) are distinct indices
- \(nums[a] + nums[b] + nums[c] + nums[d] = target\)
- No duplicate quadruplets in the result

---

### 🔍 Core Idea: Sort + Two-Pointer Extension

- Sort the array to simplify duplicate handling and ordered scanning.
- Fix two numbers (`nums[i]`, `nums[j]`) and use two pointers (`k`, `l`) to find pairs that complete the quadruplet.
- Skip duplicates to ensure uniqueness.
- Use `long` for sum to avoid integer overflow.

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Array

- `Arrays.sort(nums)` → ascending order.

#### Step 2: Outer Loop for First Element

- Iterate `i` from `0` to `n-4`.
- Skip duplicates (`nums[i] == nums[i-1]`).

#### Step 3: Inner Loop for Second Element

- Iterate `j` from `i+1` to `n-3`.
- Skip duplicates (`nums[j] == nums[j-1]`).

#### Step 4: Two-Pointer Search

- Initialize `k = j+1`, `l = n-1`.
- While `k < l`:
  - Compute `sum = nums[i] + nums[j] + nums[k] + nums[l]`.
  - If `sum == target` → add quadruplet, move both pointers, skip duplicates.
  - If `sum > target` → decrement `l`.
  - If `sum < target` → increment `k`.

#### Step 5: Return Result

- Collect all valid quadruplets in a list.

---

### ✅ Example

```text
nums = [1,0,-1,0,-2,2], target = 0

→ Sorted: [-2,-1,0,0,1,2]

→ i=-2, j=-1:
   k=0, l=5 → sum= -2 + -1 + 0 + 2 = -1 → k++
   k=1, l=5 → sum= -2 + -1 + 0 + 2 = -1 → k++
   k=2, l=5 → sum= -2 + -1 + 1 + 2 = 0 → add [-2,-1,1,2]
   k=3, l=4 → sum= -2 + -1 + 0 + 1 = -2 → k++
→ i=-2, j=0:
   k=1, l=5 → sum= -2 + 0 + 0 + 2 = 0 → add [-2,0,0,2]
→ i=-1, j=0:
   k=2, l=5 → sum= -1 + 0 + 1 + 2 = 2 → l--
   k=2, l=4 → sum= -1 + 0 + 1 + 1 = 1 → l--
   k=2, l=3 → sum= -1 + 0 + 0 + 1 = 0 → add [-1,0,0,1]

→ Output: [[-2,-1,1,2], [-2,0,0,2], [-1,0,0,1]] ✅
```

---

### 📐 Complexity

| Aspect    | Value                                       |
| --------- | ------------------------------------------- |
| Time      | O(n³) (two nested loops + two-pointer scan) |
| Space     | O(1) (excluding result list)                |
| Technique | Sort + Two-Pointer                          |

---

### 🔁 Pattern

- Sorting for duplicate control
- Two-pointer scanning for sum problems
- Extension of 3Sum → generalized to 4Sum

---

### 🚀 Alternative Approaches

- **HashSet-based**:
  - Track pairs and check complements → more overhead, harder to deduplicate.
- **General k-Sum recursion**:
  - Reduce problem recursively (k-Sum → (k-1)-Sum) with two-pointer base case.

---

### ⚠️ Edge Cases

- All identical values (e.g., `[2,2,2,2,2]`, target=8) → return [[2,2,2,2]]
- No valid quadruplets → return empty list
- Large numbers → handled safely with `long` sum

🔗 [LeetCode – 4Sum](https://leetcode.com/problems/4sum)

---

## 4. Group Anagrams

**Problem**:  
Given an array of strings `strs[]`, group the anagrams together.  
Return the groups in any order.

---

### 🔍 Core Idea: Canonical Key via Sorted Characters

- Anagrams share the same sorted character sequence.
- Use the sorted string as a **key** to group words.
- Sort each word → pair with original → group by identical keys.

---

### 🧠 Algorithm Breakdown

#### Step 1: Build Key-Value Pairs

- For each string:
  - Convert to char array.
  - Sort characters.
  - Store `[sortedString, originalString]`.

#### Step 2: Sort by Key

- Sort pairs by `sortedString`.
- This ensures anagrams are adjacent.

#### Step 3: Group Anagrams

- Traverse sorted pairs.
- If current key matches previous → add to same group.
- Else → start new group.
- Collect groups into result list.

---

### ✅ Example

```text
strs = ["eat","tea","tan","ate","nat","bat"]

→ Pairs:
   ["aet","eat"], ["aet","tea"], ["ant","tan"],
   ["aet","ate"], ["ant","nat"], ["abt","bat"]

→ Sorted by key:
   ["abt","bat"], ["aet","eat"], ["aet","tea"], ["aet","ate"],
   ["ant","tan"], ["ant","nat"]

→ Grouping:
   ["bat"], ["eat","tea","ate"], ["tan","nat"]

→ Output: [["bat"],["nat","tan"],["ate","eat","tea"]] ✅
```

---

### 📐 Complexity

| Aspect | Value                  |
| ------ | ---------------------- |
| Time   | O(n·k log k + n log n) |

- k = max word length (sorting chars)
- n = number of words (sorting pairs) |
  | Space | O(n·k) (pairs + groups) |
  | Technique | Canonical key grouping |

---

### 🔁 Pattern

- Canonical representation (sorted string)
- Grouping by identical keys
- Deduplication via sorting

---

### 🚀 Alternative Approaches

- **HashMap** (Optimal):
  - Key = sorted string, Value = list of words.
  - Avoids sorting pairs → O(n·k log k).
- **Character Count Signature**:
  - Key = frequency array of 26 letters.
  - Faster than sorting chars → O(n·k).

---

### ⚠️ Edge Cases

- Empty string → grouped as `[""]`.
- Single character → grouped individually.
- All identical words → one group.

🔗 [LeetCode – Group Anagrams](https://leetcode.com/problems/group-anagrams)

---

## 5. Merge Intervals

**Problem**:  
Given an array of intervals `intervals[i] = [start, end]`, merge all overlapping intervals and return the non-overlapping intervals that cover all input ranges.

---

### 🔍 Core Idea: Sort + Greedy Merge

- Sort intervals by their **start time**.
- Traverse sequentially, merging overlapping intervals into one.
- If the current interval overlaps with the next, extend the end boundary.
- Otherwise, finalize the current interval and move forward.

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Intervals

- Sort by `start` value: `Arrays.sort(intervals, (a, b) -> a[0] - b[0])`.

#### Step 2: Traverse and Merge

- Initialize `newStart = intervals[index][0]`, `currEnd = intervals[index][1]`.
- While next interval’s start ≤ `currEnd`, merge by updating:
  - `currEnd = max(currEnd, nextEnd)`.
- Add merged interval `[newStart, currEnd]` to result list.

#### Step 3: Build Result

- Convert list of merged intervals back to `int[][]`.

---

### ✅ Example

```text
intervals = [[1,3],[2,6],[8,10],[15,18]]

→ Sorted: [[1,3],[2,6],[8,10],[15,18]]
→ Merge [1,3] and [2,6] → [1,6]
→ Next: [8,10] → no overlap
→ Next: [15,18] → no overlap
→ Output: [[1,6],[8,10],[15,18]] ✅
```

```text
intervals = [[1,4],[4,5]]

→ Sorted: [[1,4],[4,5]]
→ Overlap since 4 ≥ 4 → merge → [1,5]
→ Output: [[1,5]] ✅
```

```text
intervals = [[4,7],[1,4]]

→ Sorted: [[1,4],[4,7]]
→ Overlap since 4 ≥ 4 → merge → [1,7]
→ Output: [[1,7]] ✅
```

---

### 📐 Complexity

| Aspect    | Value                          |
| --------- | ------------------------------ |
| Time      | O(n log n) (sorting dominates) |
| Space     | O(n) (result list)             |
| Technique | Sort + Greedy Merge            |

---

### 🔁 Pattern

- Sorting for ordered traversal
- Greedy merging of overlapping ranges
- Interval problems (merge, insert, overlap detection)

---

### 🚀 Alternative Approaches

- **Sweep Line Algorithm**:
  - Track start/end events separately → useful for more complex interval problems.
- **Stack-based Merge**:
  - Push intervals, merge top with new one if overlapping.

---

### ⚠️ Edge Cases

- Single interval → return as is.
- Fully nested intervals (e.g., `[1,10],[2,5]`) → merge into `[1,10]`.
- Disjoint intervals → remain unchanged.

🔗 [LeetCode – Merge Intervals](https://leetcode.com/problems/merge-intervals)

---

## 6. Sort Colors

**Problem**:  
Given an array `nums[]` containing values `0`, `1`, and `2` (representing red, white, and blue), sort them **in-place** so that all `0`s come first, followed by `1`s, then `2`s.  
Constraints:

- No library sort function allowed.
- Aim for a one-pass algorithm with constant extra space.

---

### 🔍 Core Idea: Dutch National Flag Algorithm

- Maintain three pointers:
  - `low` → boundary for 0s (red)
  - `mid` → current element under consideration
  - `high` → boundary for 2s (blue)
- Traverse once, swapping elements into their correct regions.
- Ensures in-place sorting in a single pass.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize Pointers

- `low = 0`, `mid = 0`, `high = n-1`.

#### Step 2: Traverse Array

- While `mid <= high`:
  - If `nums[mid] == 0`:
    - Swap `nums[mid] ↔ nums[low]`.
    - Increment both `low` and `mid`.
  - If `nums[mid] == 2`:
    - Swap `nums[mid] ↔ nums[high]`.
    - Decrement `high`.
    - Do **not** increment `mid` (need to recheck swapped value).
  - If `nums[mid] == 1`:
    - Just increment `mid`.

#### Step 3: End Condition

- Loop finishes when `mid > high`.
- Array is sorted in-place.

---

### ✅ Example

```text
nums = [2,0,2,1,1,0]

→ Initial: low=0, mid=0, high=5
→ Step 1: nums[mid]=2 → swap with nums[high] → [0,0,2,1,1,2]
→ Step 2: nums[mid]=0 → swap with nums[low] → [0,0,2,1,1,2]
→ Step 3: nums[mid]=0 → swap with nums[low] → [0,0,2,1,1,2]
→ Step 4: nums[mid]=2 → swap with nums[high] → [0,0,1,1,2,2]
→ Step 5: nums[mid]=1 → mid++
→ Step 6: nums[mid]=1 → mid++
→ Done → [0,0,1,1,2,2] ✅
```

---

### 📐 Complexity

| Aspect    | Value               |
| --------- | ------------------- |
| Time      | O(n) (single pass)  |
| Space     | O(1) (in-place)     |
| Technique | Dutch National Flag |

---

### 🔁 Pattern

- Three-way partitioning
- In-place swaps with boundary pointers
- One-pass sorting for limited categories

---

### 🚀 Alternative Approaches

- **Counting Sort**:
  - Count 0s, 1s, 2s → overwrite array.
  - Time: O(n), Space: O(1).
- **Two-pass Partition**:
  - First segregate 0s, then 2s.
  - Less optimal than Dutch Flag.

---

### ⚠️ Edge Cases

- All elements same → array unchanged.
- Already sorted → algorithm still works.
- Small arrays (n=1 or n=2) → handled naturally.

🔗 [LeetCode – Sort Colors](https://leetcode.com/problems/sort-colors)

---

## 7. Largest Number

**Problem**:  
Given a list of non-negative integers `nums[]`, arrange them such that they form the **largest possible number**.  
Return the result as a string (since the number may be very large).

---

### 🔍 Core Idea: Custom Comparator on Strings

- Convert each integer to a string.
- Sort strings using a comparator that decides order based on concatenation:
  - Compare `(b+a)` vs `(a+b)`.
  - If `(b+a)` is larger, `b` should come before `a`.
- Concatenate sorted strings to form the result.
- Handle leading zeros (e.g., `[0,0]` → `"0"`).

---

### 🧠 Algorithm Breakdown

#### Step 1: Convert Integers to Strings

- `arr[i] = String.valueOf(nums[i])`.

#### Step 2: Sort with Custom Comparator

- Comparator: `(b+a).compareTo(a+b)`
- Ensures correct ordering for cases like `9` vs `34`:
  - `"934"` > `"349"` → `9` comes before `34`.

#### Step 3: Handle Leading Zeros

- If the largest element after sorting is `"0"`, return `"0"` (to avoid `"0000"`).

#### Step 4: Build Result

- Append all strings in sorted order into a `StringBuilder`.

---

### ✅ Example

```text
nums = [10,2]

→ Convert: ["10","2"]
→ Sort: compare "210" vs "102" → "210" > "102"
→ Order: ["2","10"]
→ Result: "210" ✅
```

```text
nums = [3,30,34,5,9]

→ Convert: ["3","30","34","5","9"]
→ Sort order: ["9","5","34","3","30"]
→ Concatenate: "9534330" ✅
```

---

### 📐 Complexity

| Aspect    | Value                                                                       |
| --------- | --------------------------------------------------------------------------- |
| Time      | O(n log n · k) (sorting with string comparisons, k = avg length of numbers) |
| Space     | O(n) (string array + builder)                                               |
| Technique | Custom Comparator + Concatenation                                           |

---

### 🔁 Pattern

- String-based sorting for numerical arrangement
- Comparator logic using concatenation
- Handling edge cases with leading zeros

---

### 🚀 Alternative Approaches

- **Priority Queue**:
  - Insert with custom comparator, build result.
- **Manual Merge Sort**:
  - Implement comparator logic directly in merge sort.

---

### ⚠️ Edge Cases

- All zeros → return `"0"`
- Single element → return that element as string
- Large arrays → efficient due to O(n log n) sorting

🔗 [LeetCode – Largest Number](https://leetcode.com/problems/largest-number)

---

## 8. Kth Largest Element in an Array

**Problem**:  
Given an integer array `nums[]` and an integer `k`, return the **kth largest element** in the array.  
Note: It’s based on sorted order, not distinct values.

---

### 🔍 Core Idea: Sorting + Index Access

- Sort the array in ascending order.
- The `kth` largest element is at index `n-k` (from the end).
- Simple and correct, but not the most efficient.

---

### 🧠 Algorithm Breakdown

#### Step 1: Sort Array

- `Arrays.sort(nums)` → ascending order.

#### Step 2: Access kth Largest

- Return `nums[nums.length - k]`.

---

### ✅ Example

```text
nums = [3,2,1,5,6,4], k=2

→ Sorted: [1,2,3,4,5,6]
→ kth largest = nums[6-2] = nums[4] = 5 ✅
```

```text
nums = [3,2,3,1,2,4,5,5,6], k=4

→ Sorted: [1,2,2,3,3,4,5,5,6]
→ kth largest = nums[9-4] = nums[5] = 4 ✅
```

---

### 📐 Complexity

| Aspect    | Value                          |
| --------- | ------------------------------ |
| Time      | O(n log n) (sorting dominates) |
| Space     | O(1) (in-place sort)           |
| Technique | Sorting + Index Access         |

---

### 🔁 Pattern

- Order-statistics problem (find kth largest/smallest)
- Sorting as baseline solution
- Optimizations possible with selection algorithms

---

### 🚀 Alternative Approaches

- **Quick Select (Optimal Average O(n))**:
  - Partition-based selection (like QuickSort).
  - Only recurse into one side.
- **Min Heap (O(n log k))**:
  - Maintain heap of size `k`.
  - Pop smallest when size exceeds `k`.
  - Top of heap = kth largest.
- **Max Heap (O(n log n))**:
  - Build heap, pop `k` times.

---

### ⚠️ Edge Cases

- `k=1` → largest element.
- `k=n` → smallest element.
- Duplicate values → handled naturally (not distinct).

🔗 [LeetCode – Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array)

---

## 9. Find the Duplicate Number

**Problem**:  
Given an array `nums[]` of length `n+1` containing integers in the range `[1…n]`, exactly one number is repeated (possibly more than twice).  
Return the duplicate number.  
Constraints:

- Do not modify the array.
- Use only constant extra space.
- Solve in linear runtime if possible.

---

### 🔍 Core Idea: Floyd’s Tortoise and Hare (Cycle Detection)

- Treat the array as a **linked list** where each index points to `nums[index]`.
- Because one number is repeated, this creates a **cycle** in the linked list.
- Use cycle detection to find the entry point of the cycle → the duplicate number.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize Pointers

- `slow = nums[0]`, `fast = nums[0]`.

#### Step 2: Detect Cycle

- Move `slow` by one step (`nums[slow]`).
- Move `fast` by two steps (`nums[nums[fast]]`).
- Continue until `slow == fast`.

#### Step 3: Find Entry Point

- Reset `slow = nums[0]`.
- Move both `slow` and `fast` one step at a time.
- When they meet again → that value is the duplicate.

---

### ✅ Example

```text
nums = [1,3,4,2,2]

→ Linked list representation:
   1 → 3 → 2 → 4 → 2 → cycle at 2

→ Phase 1: slow and fast meet inside cycle
→ Phase 2: reset slow, move both step by step
→ Meet at 2 → duplicate = 2 ✅
```

```text
nums = [3,1,3,4,2]

→ Cycle formed at 3
→ Duplicate = 3 ✅
```

```text
nums = [3,3,3,3,3]

→ Cycle formed immediately at 3
→ Duplicate = 3 ✅
```

---

### 📐 Complexity

| Aspect    | Value                    |
| --------- | ------------------------ |
| Time      | O(n) (linear traversal)  |
| Space     | O(1) (constant pointers) |
| Technique | Floyd’s Cycle Detection  |

---

### 🔁 Pattern

- Cycle detection in arrays (linked list analogy)
- Entry point of cycle = duplicate value
- Works without modifying array or extra memory

---

### 🚀 Alternative Approaches

- **Cyclic Sort** (requires modifying array):
  - Place numbers at correct indices, detect mismatch.
- **HashSet** (extra space):
  - Track seen numbers, return first duplicate.
- **Binary Search on Counts**:
  - Count numbers ≤ mid, adjust search range.

---

### ⚠️ Edge Cases

- All elements same → duplicate is that element.
- Duplicate appears multiple times → still detected.
- Large arrays → efficient due to O(n) time and O(1) space.

🔗 [LeetCode – Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number)

---

## 10. Find All Duplicates in an Array

**Problem**:  
Given an integer array `nums[]` of length `n` where each integer is in the range `[1…n]` and appears at most twice, return all integers that appear twice.  
Constraints:

- Must run in **O(n)** time.
- Must use **O(1)** auxiliary space (excluding output list).

---

### 🔍 Core Idea: Cyclic Sort + Index Validation

- Since values are in `[1…n]`, each number has a **correct index** (`num → num-1`).
- Use **cyclic sort** to place each number at its correct index.
- After sorting, any index `i` where `nums[i] ≠ i+1` indicates that `nums[i]` is a duplicate.

---

### 🧠 Algorithm Breakdown

#### Step 1: Cyclic Sort

- Traverse array with index `i`.
- If `nums[i]` is not at its correct position (`nums[i] ≠ nums[nums[i]-1]`), swap.
- Else, move to next index.
- This rearranges numbers into their correct positions unless duplicates prevent it.

#### Step 2: Collect Duplicates

- After cyclic sort, scan array.
- If `nums[index] ≠ index+1`, then `nums[index]` is a duplicate.
- Add to result list.

---

### ✅ Example

```text
nums = [4,3,2,7,8,2,3,1]

→ After cyclic sort: [1,2,3,4,3,2,7,8]
→ Scan:
   index 4 → nums[4]=3 ≠ 5 → duplicate = 3
   index 5 → nums[5]=2 ≠ 6 → duplicate = 2
→ Output: [2,3] ✅
```

```text
nums = [1,1,2]

→ After cyclic sort: [1,1,2]
→ Scan:
   index 1 → nums[1]=1 ≠ 2 → duplicate = 1
→ Output: [1] ✅
```

```text
nums = [1]

→ After cyclic sort: [1]
→ Scan: all correct → no duplicates
→ Output: [] ✅
```

---

### 📐 Complexity

| Aspect    | Value                                  |
| --------- | -------------------------------------- |
| Time      | O(n) (cyclic sort + scan)              |
| Space     | O(1) (in-place, excluding result list) |
| Technique | Cyclic Sort + Index Validation         |

---

### 🔁 Pattern

- Cyclic sort for `[1…n]` problems
- Index mismatch → duplicate detection
- In-place rearrangement with constant space

---

### 🚀 Alternative Approaches

- **Negative Marking**:
  - Iterate array, mark visited index as negative.
  - If already negative → duplicate found.
- **HashSet**:
  - Track seen numbers, return duplicates.
  - Uses O(n) extra space.

---

### ⚠️ Edge Cases

- All unique → return empty list.
- Multiple duplicates → all detected.
- Single element → always empty result.

🔗 [LeetCode – Find All Duplicates in an Array](https://leetcode.com/problems/find-all-duplicates-in-an-array)

---
