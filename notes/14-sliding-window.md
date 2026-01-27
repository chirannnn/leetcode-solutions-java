## 1. Maximum Points You Can Obtain From Cards

**Problem**:  
You are given an array `cardPoints` and an integer `k`. You must take exactly `k` cards, either from the beginning or the end of the array.  
Return the maximum score possible.

---

### 🔍 Core Idea: Sliding Window Across Ends

- You can only take cards from **left end** or **right end**.
- Equivalent to: choose `k` cards from both ends combined.
- Strategy:
  - Start with sum of first `k` cards (all from left).
  - Gradually replace left cards with right cards, one by one.
  - Track maximum sum during this process.
- This avoids brute force and runs in O(k).

---

### 🧠 Algorithm Breakdown

#### Step 1: Initial Left Sum

- Compute sum of first `k` cards → `leftSum`.
- Initialize `maxSum = leftSum`.

#### Step 2: Replace Left with Right

- Use pointer `l = k-1` (last left card) and `r = n-1` (last card in array).
- For each step:
  - Remove `cardPoints[l]` from current sum.
  - Add `cardPoints[r]`.
  - Update `maxSum = max(maxSum, currSum)`.
  - Move `l--`, `r--`.

#### Step 3: Return Result

- After loop, return `maxSum`.

---

### ✅ Example Walkthrough

```text
cardPoints = [1,2,3,4,5,6,1], k = 3

→ Initial leftSum = 1+2+3 = 6
→ Replace steps:
   Take 2 left + 1 right → 1+2+1 = 4
   Take 1 left + 2 right → 1+6+1 = 8
   Take 0 left + 3 right → 6+5+1 = 12
→ Max = 12 ✅
```

```text
cardPoints = [2,2,2], k = 2
→ leftSum = 2+2 = 4
→ Replacements don’t change → Max = 4 ✅
```

```text
cardPoints = [9,7,7,9,7,7,9], k = 7
→ Must take all cards → sum = 55 ✅
```

---

### 📐 Complexity

| Aspect    | Value                       |
| --------- | --------------------------- |
| Time      | O(k) (sliding window)       |
| Space     | O(1) (constant extra space) |
| Technique | Sliding window across ends  |

---

### 🔁 Pattern

- Sliding window to balance left and right selections.
- Similar to problems where you choose elements from both ends (like "minimum subarray removal").
- Efficient compared to brute force.

---

### 🚀 Alternative Approaches

- **Prefix sums**: Precompute sums from left and right, then combine.
- **Two-pointer brute force**: Try all splits → O(k), same as current solution.
- **Dynamic programming**: Overkill for this problem.

---

### ⚠️ Edge Cases

- k = n → must take all cards.
- k = 1 → max of first or last card.
- All equal values → any choice yields same sum.
- Large input size (up to \(10^5\)) → efficient with O(k).

🔗 LeetCode – Maximum Points You Can Obtain From Cards: [(leetcode.com)](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/)

---

## 2. Longest Substring Without Repeating Characters

**Problem**:  
Given a string `s`, find the length of the longest substring without duplicate characters.  
Return the maximum length.

---

### 🔍 Core Idea: Sliding Window + Hash Frequency

- Use two pointers (`l` and `r`) to maintain a window.
- Expand `r` to include new characters.
- If a character repeats, shrink window from left (`l++`) until substring is valid again.
- Track maximum window size during traversal.
- Hash array (size 256) stores frequency of characters.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `hash[256]` → frequency of characters.
- `l = 0`, `r = 0`, `len = Integer.MIN_VALUE`.

#### Step 2: Expand Window

- Add `s[r]` to hash.
- If frequency > 1 → shrink window from left until valid.

#### Step 3: Update Result

- `len = max(len, r - l + 1)`.
- Move `r++`.

#### Step 4: Return Result

- If no substring found → return 0.
- Else return `len`.

---

### ✅ Example Walkthrough

```text
s = "abcabcbb"

→ Expand:
   "abc" → length 3
   "bca" → length 3
   "cab" → length 3
→ Max length = 3 ✅
```

```text
s = "bbbbb"

→ Only "b" → length 1 ✅
```

```text
s = "pwwkew"

→ "pw" → length 2
→ "wke" → length 3
→ Max length = 3 ✅
```

---

### 📐 Complexity

| Aspect    | Value                  |
| --------- | ---------------------- |
| Time      | O(n) (single pass)     |
| Space     | O(1) (fixed hash size) |
| Technique | Sliding window         |

---

### 🔁 Pattern

- Classic sliding window problem.
- Similar to "Longest substring with at most K distinct characters".
- Frequency tracking ensures duplicates are handled.

---

### 🚀 Alternative Approaches

- **HashSet**: Track current window characters.
- **Map with indices**: Store last seen index of each character, jump `l` directly.
- **Optimized sliding window**: Avoid shrinking one by one.

---

### ⚠️ Edge Cases

- Empty string → return 0.
- All unique characters → return length of string.
- All same characters → return 1.
- Large input (up to 50,000) → efficient with O(n).

🔗 LeetCode – Longest Substring Without Repeating Characters: [(leetcode.com)](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

---

## 3. Max Consecutive Ones III

**Problem**:  
Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`s in the array if you can flip at most `k` zeros.

---

### 🔍 Core Idea: Sliding Window with Zero Count

- Use two pointers (`l` and `r`) to maintain a window.
- Expand `r` to include more elements.
- Count zeros inside the window.
- If zero count exceeds `k`, shrink window from left (`l++`) until valid.
- Track maximum window size during traversal.

This ensures we always maintain a valid window with at most `k` flips.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `l = 0`, `r = 0` → window boundaries.
- `zeroCount = 0` → number of zeros in current window.
- `maxLen = 0` → result.

#### Step 2: Expand Window

- For each `r`:
  - If `nums[r] == 0` → increment `zeroCount`.
  - If `zeroCount > k`:
    - Shrink window from left until `zeroCount ≤ k`.

#### Step 3: Update Result

- `maxLen = max(maxLen, r - l + 1)`.

#### Step 4: Return Result

- After traversal, return `maxLen`.

---

### ✅ Example Walkthrough

```text
nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2

→ Expand window:
   [1,1,1,0,0,1,1,1,1,1,1]
→ Longest valid window length = 6 ✅
```

```text
nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3

→ Expand window:
   Flip 3 zeros → longest window length = 10 ✅
```

---

### 📐 Complexity

| Aspect    | Value                       |
| --------- | --------------------------- |
| Time      | O(n) (single pass)          |
| Space     | O(1) (constant extra space) |
| Technique | Sliding window              |

---

### 🔁 Pattern

- Classic sliding window problem with constraint.
- Similar to "Longest substring with at most K replacements".
- Zero count acts as the constraint tracker.

---

### 🚀 Alternative Approaches

- **Prefix sums**: Precompute zero counts, then use binary search to find longest valid window.
- **Deque approach**: Track indices of zeros, slide window accordingly.
- Current sliding window is simplest and optimal.

---

### ⚠️ Edge Cases

- All ones → return length of array.
- k = 0 → longest run of consecutive ones without flips.
- All zeros with k ≥ length → return length of array.
- Large input (up to \(10^5\)) → efficient with O(n).

🔗 LeetCode – Max Consecutive Ones III: [(leetcode.com)](https://leetcode.com/problems/max-consecutive-ones-iii/)

---

## 4. Fruit Into Baskets

**Problem**:  
You are given an array `fruits` where each element represents the type of fruit a tree produces. You have two baskets, each holding only one type of fruit but unlimited quantity. Starting from any tree, you must pick one fruit per tree moving right, and stop when a tree produces a fruit that doesn’t fit into your baskets.  
Return the maximum number of fruits you can collect.

---

### 🔍 Core Idea: Sliding Window with At Most Two Distinct Types

- This is essentially the **Longest Subarray with at most 2 distinct elements** problem.
- Use two pointers (`l` and `r`) to maintain a window.
- Expand `r` to include more fruits.
- Track the number of distinct fruit types in the window.
- If distinct count exceeds 2, shrink window from left until valid.
- Track maximum window size during traversal.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `hash[]` → frequency of fruit types.
- `l = 0`, `r = 0` → window boundaries.
- `count = 0` → distinct fruit types.
- `maxLen = 0` → result.

#### Step 2: Expand Window

- Add `fruits[r]` to hash.
- If new type → increment `count`.
- If `count > 2`:
  - Shrink window from left (`l++`) until `count ≤ 2`.

#### Step 3: Update Result

- `maxLen = max(maxLen, r - l + 1)`.

#### Step 4: Return Result

- After traversal, return `maxLen`.

---

### ✅ Example Walkthrough

```text
fruits = [1,2,1]

→ Window expands:
   [1,2,1] → 2 types → length = 3
→ Result = 3 ✅
```

```text
fruits = [0,1,2,2]

→ Window expands:
   [0,1] → 2 types → length = 2
   [1,2,2] → 2 types → length = 3
→ Result = 3 ✅
```

```text
fruits = [1,2,3,2,2]

→ Window expands:
   [1,2] → length = 2
   [2,3,2,2] → length = 4
→ Result = 4 ✅
```

---

### 📐 Complexity

| Aspect    | Value                                                           |
| --------- | --------------------------------------------------------------- |
| Time      | O(n) (single pass)                                              |
| Space     | O(n) (hash array, though can be optimized to O(1) with HashMap) |
| Technique | Sliding window                                                  |

---

### 🔁 Pattern

- Sliding window with constraint on distinct elements.
- Same as "Longest substring with at most K distinct characters" (here K=2).
- Frequency tracking ensures valid window.

---

### 🚀 Alternative Approaches

- **HashMap**: More memory-efficient than array when fruit types are sparse.
- **Two-pointer greedy**: Track last two fruit types and their counts.
- Current sliding window is optimal and simple.

---

### ⚠️ Edge Cases

- All fruits same → return length of array.
- Only two distinct types → return length of array.
- Large input (up to \(10^5\)) → efficient with O(n).
- k=1 fruit type repeatedly → handled correctly.

🔗 LeetCode – Fruit Into Baskets: [(leetcode.com)](https://leetcode.com/problems/fruit-into-baskets/)

---

## 5. Longest Substring With At Most K Distinct Characters

**Problem**:  
Given a string `s` and integer `k`, return the length of the longest substring of `s` that contains at most `k` distinct characters.

---

### 🔍 Core Idea: Sliding Window + Frequency Tracking

- Use two pointers (`l` and `r`) to maintain a window.
- Expand `r` to include new characters.
- Track distinct characters using a frequency array.
- If distinct count exceeds `k`, shrink window from left until valid.
- Track maximum window size during traversal.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `hash[]` → frequency of characters.
- `l = 0`, `r = 0` → window boundaries.
- `distinct = 0` → number of distinct characters.
- `maxLen = 0` → result.

#### Step 2: Expand Window

- Add `s[r]` to hash.
- If new character → increment `distinct`.
- If `distinct > k`:
  - Shrink window from left (`l++`) until `distinct ≤ k`.

#### Step 3: Update Result

- `maxLen = max(maxLen, r - l + 1)`.

#### Step 4: Return Result

- After traversal, return `maxLen`.

---

### ✅ Example Walkthrough

```text
s = "eceba", k = 2

→ Expand window:
   "ece" → 2 distinct → length = 3
   "ceba" → 3 distinct → shrink
→ Result = 3 ✅
```

```text
s = "aa", k = 1

→ Expand window:
   "aa" → 1 distinct → length = 2
→ Result = 2 ✅
```

---

### 📐 Complexity

| Aspect    | Value                              |
| --------- | ---------------------------------- |
| Time      | O(n) (single pass)                 |
| Space     | O(26) → O(1) (fixed alphabet size) |
| Technique | Sliding window                     |

---

### 🔁 Pattern

- Classic sliding window problem with constraint on distinct characters.
- Similar to "Fruit Into Baskets" (K=2).
- Frequency tracking ensures valid window.

---

### 🚀 Alternative Approaches

- **HashMap**: More general solution for larger alphabets (digits, symbols, spaces).
- **Optimized shrink**: Jump left pointer directly using last seen indices.
- Current array-based approach works since input is lowercase letters.

---

### ⚠️ Edge Cases

- k = 0 → return 0 (no valid substring).
- k ≥ length of string → return full length.
- All identical characters → return length of string.
- Large input (up to 50,000) → efficient with O(n).

🔗 LeetCode – Longest Substring With At Most K Distinct Characters: [(NeetCode)](https://neetcode.io/problems/longest-substring-with-at-most-k-distinct-characters/question)

---

## 6. Number of Substrings Containing All Three Characters

**Problem**:  
Given a string `s` consisting only of characters `a`, `b`, and `c`, return the number of substrings that contain at least one occurrence of all three characters.

---

### 🔍 Core Idea: Sliding Window / Index Tracking

- We need substrings that contain **all three characters**.
- Two main approaches:
  1. **Sliding Window**: Expand right pointer until substring contains all three, then shrink left pointer while counting valid substrings.
  2. **Index Tracking**: Track last seen positions of `a`, `b`, and `c`. Once all are seen, the minimum index among them determines how many substrings ending at current position are valid.

---

### 🧠 Algorithm Breakdown (Method 1: Sliding Window)

#### Step 1: Initialize

- `l = 0`, `r = 0` → window boundaries.
- `hash[3]` → frequency of `a`, `b`, `c`.
- `count = 0`.

#### Step 2: Expand Window

- Add `s[r]` to `hash`.
- While all three counts > 0:
  - Every substring starting at `l` and ending at ≥ `r` is valid.
  - Add `n - r` to `count`.
  - Shrink window from left (`l++`).

#### Step 3: Return Result

- After traversal, return `count`.

---

### 🧠 Algorithm Breakdown (Method 2: Index Tracking)

#### Step 1: Initialize

- `hash = {-1, -1, -1}` → last seen indices of `a`, `b`, `c`.
- `count = 0`.

#### Step 2: Traverse String

- For each character at index `i`:
  - Update `hash[ch - 'a'] = i`.
  - If all three indices are valid (not -1):
    - Add `1 + min(hash[0], hash[1], hash[2])` to `count`.
    - This counts substrings ending at `i` that include all three.

#### Step 3: Return Result

- Return `count`.

---

### ✅ Example Walkthrough

```text
s = "abcabc"

→ Sliding window:
   "abc" → valid
   "abca", "abcab", "abcabc" → valid
   "bca", "bcab", "bcabc" → valid
   "cab", "cabc" → valid
   "abc" (second occurrence) → valid
→ Total = 10 ✅
```

```text
s = "aaacb"

→ Valid substrings:
   "aaacb", "aacb", "acb"
→ Total = 3 ✅
```

```text
s = "abc"

→ Only "abc" → Total = 1 ✅
```

---

### 📐 Complexity

| Method         | Time | Space |
| -------------- | ---- | ----- |
| Sliding Window | O(n) | O(1)  |
| Index Tracking | O(n) | O(1)  |

Both are efficient for \(n \leq 5 \times 10^4\).

---

### 🔁 Pattern

- Sliding window for substring problems with constraints.
- Index tracking for "last seen" problems.
- Both approaches are common in substring counting tasks.

---

### 🚀 Alternative Approaches

- **Prefix sums**: Not efficient here.
- **Brute force**: Generate all substrings → O(n²), too slow.
- **Optimized index tracking**: Cleaner and faster in practice.

---

### ⚠️ Edge Cases

- String length < 3 → return 0.
- String with only one or two characters → return 0.
- All identical characters → return 0.
- Large input size → O(n) methods are efficient.

🔗 LeetCode – Number of Substrings Containing All Three Characters: [(leetcode.com)](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/)

---
