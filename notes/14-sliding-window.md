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

---

🔗 LeetCode – Longest Substring Without Repeating Characters: [(leetcode.com)](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
