## 1. Find Smallest Letter Greater Than Target

**Problem**:  
Given a sorted array of characters `letters` and a character `target`, return the **smallest character** in `letters` that is **lexicographically greater** than `target`.  
If no such character exists, return the **first character** in `letters`.

---

**Approach**: Binary Search with Wrap-Around

- Use binary search to find the **first character greater than `target`**
- If `target < letters[mid]`, search left half
- Else, search right half
- After the loop, `start` points to the correct index
- Use `start % letters.length` to handle wrap-around (e.g., when `target` is greater than all letters)

---

**Complexity**:

- **Time**: O(log n) – binary search
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: letters = ['c','f','j'], target = 'c'

Step-by-step:
→ mid = 1 → letters[1] = 'f' > 'c' → move left
→ mid = 0 → letters[0] = 'c' == 'c' → move right

Final start = 1 → letters[1] = 'f'
Output: 'f'
```

---

**Key Takeaway**:

- This is a classic **binary search variant**.
- The `% length` trick elegantly handles the **wrap-around** case.
- Works even when multiple duplicates exist.

---

**Pattern**:

- Binary search
- Lexicographic comparison
- Circular array logic

---

**Edge Cases**:

- `target` < all letters → return first greater
- `target` ≥ all letters → wrap-around to letters[0]
- Multiple duplicates → still returns correct next letter

🔗 [LeetCode – Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target)

---

## 2. Find First and Last Position of Element in Sorted Array

**Problem**:  
Given a sorted array `nums`, find the **starting and ending index** of a given `target`.  
If the target is not found, return `[-1, -1]`.  
You must solve it in **O(log n)** time.

---

**Approach**: Dual Binary Search

- Perform **two binary searches**:
  1. First to find the **leftmost (first) index** of `target`
  2. Second to find the **rightmost (last) index** of `target`
- Modify the binary search condition:
  - If `target == nums[mid]`, store `mid` as potential answer
    - If searching for first index → move `end = mid - 1`
    - If searching for last index → move `start = mid + 1`

---

**Complexity**:

- **Time**: O(log n) – two binary searches
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: nums = [5,7,7,8,8,10], target = 8

First search (find first index):
→ mid = 2 → nums[2] = 7 < 8 → start = 3
→ mid = 4 → nums[4] = 8 → ans = 4, end = 3
→ mid = 3 → nums[3] = 8 → ans = 3, end = 2

Second search (find last index):
→ mid = 4 → nums[4] = 8 → ans = 4, start = 5

Output: [3,4]
```

---

**Key Takeaway**:

- This is a classic **boundary search** problem.
- Requires careful control of binary search direction.
- Efficiently finds both ends of a target range.

---

**Pattern**:

- Binary search variant
- Left/right boundary detection
- Conditional narrowing

---

**Edge Cases**:

- Target not found → return `[-1, -1]`
- Empty array → return `[-1, -1]`
- All elements are target → return `[0, n-1]`

🔗 [LeetCode – Find First and Last Position of Element in Sorted Array](https://leetcodethehardway.com/solutions/0000-0099/find-first-and-last-position-of-element-in-sorted-array-medium)

---

## 3. Peak Index in a Mountain Array

**Problem**:  
Given a mountain array `arr` (strictly increasing to a peak, then strictly decreasing), return the **index of the peak element**.  
You must solve it in **O(log n)** time.

---

**Approach**: Binary Search on Shape

- Use binary search to locate the peak:
  - If `arr[mid] > arr[mid + 1]`, you're in the **descending slope** → move `end = mid`
  - Else, you're in the **ascending slope** → move `start = mid + 1`
- Loop continues until `start == end`, which is the **peak index**

---

**Complexity**:

- **Time**: O(log n) – binary search halves the search space
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: arr = [0,10,5,2]

Step-by-step:
→ mid = 1 → arr[1] = 10 > arr[2] = 5 → move end = 1
→ mid = 0 → arr[0] = 0 < arr[1] = 10 → move start = 1

Now start == end == 1 → peak index = 1

Output: 1
```

---

**Key Takeaway**:

- This is a classic **binary search on unimodal function**.
- Efficiently finds the peak without scanning the entire array.
- Works only because the array is guaranteed to be a mountain.

---

**Pattern**:

- Binary search
- Slope detection (ascending vs descending)
- Peak localization

---

**Edge Cases**:

- Peak at start or end → handled naturally by binary logic
- Minimum length = 3 → peak always exists
- No duplicates → guarantees strict slope

🔗 [LeetCode – Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array)

---

## 4. Find Peak Element

**Problem**:  
Given an integer array `nums`, find a **peak element** and return its index.  
A peak is defined as an element that is **strictly greater than its neighbors**.  
Assume `nums[-1] = nums[n] = -∞` to handle edge boundaries.  
You must solve this in **O(log n)** time.

---

**Approach**: Binary Search on Slope

- Use binary search to find a peak:
  - If `nums[mid] > nums[mid + 1]`, you're on a **descending slope** → move `end = mid`
  - Else, you're on an **ascending slope** → move `start = mid + 1`
- Loop continues until `start == end`, which is a **peak index**
- Since multiple peaks may exist, any valid peak is acceptable

---

**Complexity**:

- **Time**: O(log n) – binary search
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: nums = [1,2,1,3,5,6,4]

Step-by-step:
→ mid = 3 → nums[3] = 3 < nums[4] = 5 → move start = 4
→ mid = 4 → nums[4] = 5 < nums[5] = 6 → move start = 5
→ mid = 5 → nums[5] = 6 > nums[6] = 4 → move end = 5

Now start == end == 5 → peak index = 5

Output: 5
```

---

**Key Takeaway**:

- This is a classic **binary search on unsorted terrain**.
- Efficiently finds a peak without scanning the entire array.
- Works even when multiple peaks exist — any one is valid.

---

**Pattern**:

- Binary search
- Slope detection (ascending vs descending)
- Peak localization

---

**Edge Cases**:

- Single element → always a peak
- Peak at start or end → handled naturally by boundary logic
- Multiple peaks → any valid index is acceptable

🔗 [LeetCode – Find Peak Element](https://leetcode.com/problems/find-peak-element)

---

## 5. Find in Mountain Array

**Problem**:  
You're given a **mountain array** — strictly increasing to a peak, then strictly decreasing.  
Return the **minimum index** where `arr[index] == target`.  
If the target doesn't exist, return `-1`.  
You must solve this in **O(log n)** time and simulate access via a restricted interface.

---

**Approach**:

1. **Find the peak index** using binary search:

   - If `arr[mid] > arr[mid + 1]`, you're on the **descending slope** → move `end = mid`
   - Else, you're on the **ascending slope** → move `start = mid + 1`
   - Loop ends with `start == end` → peak index

2. **Binary search on both sides** of the peak:

   - Left side (ascending) → standard binary search
   - Right side (descending) → reverse binary search

3. Return the **first match** found (left side prioritized)

---

**Complexity**:

- **Time**: O(log n) + O(log n) = O(log n)
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: arr = [1,2,3,4,5,3,1], target = 3

Step 1: Find peak → index = 4 (value = 5)

Step 2: Search left (0 to 4):
→ mid = 2 → arr[2] = 3 → match found → return 2

Output: 2
```

---

**Key Takeaway**:

- This is a **hybrid binary search** problem.
- Efficiently narrows down search space using peak detection.
- Handles both ascending and descending segments with tailored logic.

---

**Pattern**:

- Binary search on unimodal array
- Peak detection
- Dual search strategy (left/right of peak)

---

**Edge Cases**:

- Target at peak → found in first search
- Target on descending side → second search required
- Target not present → return `-1`
- Multiple matches → return **minimum index**

🔗 [LeetCode – Find in Mountain Array](https://leetcode.com/problems/find-in-mountain-array)

---

## 6. Search in Rotated Sorted Array

**Problem**:  
Given a sorted array `nums` that’s been **rotated at an unknown pivot**, return the index of a given `target`.  
If the target is not found, return `-1`.  
You must solve this in **O(log n)** time.

---

**Approach**: Pivot Detection + Binary Search

1. **Find the pivot index**:

   - Pivot is the index where the rotation occurs (i.e., the largest element).
   - Use binary search to detect the point where `arr[mid] > arr[mid + 1]` or `arr[mid - 1] > arr[mid]`.

2. **Binary search in the correct half**:

   - If `target == arr[pivot]` → return pivot
   - If `target ≥ arr[0]` → search in left half `[0, pivot - 1]`
   - Else → search in right half `[pivot + 1, n - 1]`

3. If no pivot is found (array is not rotated), perform standard binary search.

---

**Complexity**:

- **Time**: O(log n) – binary search for pivot + binary search for target
- **Space**: O(1) – constant space

---

**Example**:

```text
Input: nums = [4,5,6,7,0,1,2], target = 0

Step 1: Find pivot → index = 3 (value = 7)

Step 2: target < nums[0] → search in right half [4,6]

Binary search → target found at index 4

Output: 4
```

---

**Key Takeaway**:

- This is a classic **binary search on rotated array**.
- Efficiently narrows down the search space by detecting rotation.
- Handles both rotated and non-rotated arrays seamlessly.

---

**Pattern**:

- Pivot detection
- Conditional binary search
- Rotation-aware logic

---

**Edge Cases**:

- Array not rotated → fallback to standard binary search
- Single element → check directly
- Target not present → return `-1`

🔗 [LeetCode – Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

---
