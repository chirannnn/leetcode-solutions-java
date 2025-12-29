## 1. Jump Game VII

**Problem**:  
You are given a binary string `s` and integers `minJump`, `maxJump`.

- Start at index `0` (always `'0'`).
- You can jump from index `i` to index `j` if:
  - \(i + \text{minJump} \leq j \leq \min(i + \text{maxJump}, s.length - 1)\)
  - and `s[j] == '0'`.  
    Return `true` if you can reach the last index, else `false`.

---

### 🔍 Core Idea: Dynamic Programming with Sliding Window

- Use a boolean array `db[]` to track reachable indices.
- For each reachable index `i`:
  - Mark all valid positions `j` in range `[i+minJump … i+maxJump]` as reachable if `s[j] == '0'`.
- Optimize by maintaining a sliding window (`start`, `end`) to avoid redundant checks.
- Stop early if last index becomes reachable.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialization

- `db[0] = true` (starting point).
- `start = 0`, `end = 0`.

#### Step 2: Traverse String

- For each index `i`:
  - If `db[i] == false` → skip.
  - Update window:
    - `start = max(i + minJump, end + 1)`
    - `end = min(i + maxJump, n-1)`
  - For each `j` in `[start…end]`:
    - If `s[j] == '0'` → mark `db[j] = true`.
  - If `db[n-1] == true` → return `true`.

#### Step 3: Return Result

- After loop, return `db[n-1]`.

---

### ✅ Example Walkthrough

```text
s = "011010", minJump = 2, maxJump = 3

→ Start at index 0
   From 0 → can jump to [2,3]
   Index 3 reachable
   From 3 → can jump to [5,6]
   Index 5 reachable
→ Last index (5) reachable → true ✅
```

```text
s = "01101110", minJump = 2, maxJump = 3

→ Start at index 0
   From 0 → can jump to [2,3]
   Index 2 is '1' → not valid
   Index 3 is '0' → reachable
   From 3 → can jump to [5,6]
   Both are '1' → blocked
→ Last index unreachable → false ✅
```

---

### 📐 Complexity

| Aspect    | Value                                                |
| --------- | ---------------------------------------------------- |
| Time      | O(n) (each index processed once with sliding window) |
| Space     | O(n) (boolean array for reachability)                |
| Technique | Dynamic programming + sliding window                 |

---

### 🔁 Pattern

- Reachability problems with constraints
- Similar to BFS/DP on string indices
- Sliding window optimization to avoid redundant checks

---

### 🚀 Alternative Approaches

- **Breadth-First Search (BFS)**: Treat indices as graph nodes, explore reachable positions.
- **Greedy + Queue**: Maintain frontier of reachable indices.
- **Segment Tree / Fenwick Tree**: For larger constraints, optimize range updates.

---

### ⚠️ Edge Cases

- `s = "0"` → trivially true.
- `s` with all `'0'` → always reachable.
- `s` with blocking `'1'` at critical positions → false.
- Large input (`10^5`) → efficient with O(n).

🔗 [LeetCode – Jump Game VII](https://leetcode.com/problems/jump-game-vii)

---

## 2. Split Two Strings to Make Palindrome

**Problem**:  
Given two strings `a` and `b` of equal length, choose an index and split both strings at that index:

- `a = aprefix + asuffix`
- `b = bprefix + bsuffix`

Check if either `aprefix + bsuffix` or `bprefix + asuffix` forms a palindrome.  
Return `true` if possible, else `false`.

---

### 🔍 Core Idea: Two-Pointer Matching + Palindrome Check

- Traverse from both ends (`i` from start, `j` from end).
- Compare characters from `a` (prefix) and `b` (suffix).
- Stop when mismatch occurs.
- At mismatch, check if the remaining substring in either `a` or `b` is a palindrome.
- If yes → return `true`.
- Otherwise → return `false`.
- Repeat the process swapping roles of `a` and `b`.

---

### 🧠 Algorithm Breakdown

#### Step 1: Main Function

- `checkPalindromeFormation(a, b)` → returns `check(a, b) || check(b, a)`.

#### Step 2: Check Function

- Initialize `i = 0`, `j = a.length()-1`.
- While `i < j` and `a[i] == b[j]`: move inward (`i++`, `j--`).
- If pointers cross (`i >= j`) → palindrome possible → return `true`.
- Else → check if substring `a[i…j]` or `b[i…j]` is palindrome.

#### Step 3: Palindrome Helper

- `isPalin(s, start, end)` → standard two-pointer palindrome check.
- Return `true` if substring is palindrome, else `false`.

---

### ✅ Example Walkthrough

```text
a = "x", b = "y"

→ aprefix = "", asuffix = "x"
→ bprefix = "", bsuffix = "y"
→ "" + "y" = "y" → palindrome
→ Result = true ✅
```

```text
a = "xbdef", b = "xecab"

→ Compare from ends:
   mismatch leads to substrings "bdef" and "xecab"
   neither forms palindrome
→ Result = false ✅
```

```text
a = "ulacfd", b = "jizalu"

→ Split at index 3:
   aprefix = "ula", asuffix = "cfd"
   bprefix = "jiz", bsuffix = "alu"
→ aprefix + bsuffix = "ulaalu" → palindrome
→ Result = true ✅
```

---

### 📐 Complexity

| Aspect    | Value                                      |
| --------- | ------------------------------------------ |
| Time      | O(n) (two-pointer scan + palindrome check) |
| Space     | O(1) (constant extra space)                |
| Technique | Two-pointer + palindrome validation        |

---

### 🔁 Pattern

- Palindrome problems with conditional splits
- Two-pointer traversal for efficiency
- Similar to "Valid Palindrome II" (allowing one mismatch)

---

### 🚀 Alternative Approaches

- **Brute force**: Try all split indices → O(n²).
- **Optimized two-pointer**: Current approach → O(n).
- **String reversal**: Compare prefix with reversed suffix, but less clean.

---

### ⚠️ Edge Cases

- Single-character strings → always palindrome.
- Already palindrome strings → return `true`.
- No valid split → return `false`.
- Large strings (up to 100,000 chars) → efficient with O(n).

🔗 [LeetCode – Split Two Strings to Make Palindrome](https://leetcode.com/problems/split-two-strings-to-make-palindrome)

---

## 3. Number of Ways to Split a String

**Problem**:  
Given a binary string `s`, split it into 3 non-empty parts `s1`, `s2`, `s3` such that each part has the **same number of ones**.  
Return the number of valid splits modulo \(10^9 + 7\).

---

### 🔍 Core Idea: Count Ones + Combinatorics

- Total number of ones in `s` determines feasibility.
- If total ones = 0 → all zeros → choose any two split points → combinatorial formula.
- If total ones not divisible by 3 → impossible → return 0.
- Otherwise:
  - Each part must contain exactly `totalOnes / 3`.
  - Count possible split positions where prefix sum equals `onceInBlock` and `2 * onceInBlock`.
  - Multiply counts → total ways.

---

### 🧠 Algorithm Breakdown

#### Step 1: Count Total Ones

- Traverse `s`, count total ones → `once`.

#### Step 2: Handle Special Cases

- If `once == 0`:
  - All zeros → number of ways = \(\binom{n-1}{2} = \frac{(n-1)(n-2)}{2}\).
- If `once % 3 != 0`:
  - Not divisible → return 0.

#### Step 3: Count Split Positions

- `onceInBlock = once / 3`.
- Traverse string again, maintain running count of ones.
- When running count = `onceInBlock` → increment `way1`.
- When running count = `2 * onceInBlock` → increment `way2`.

#### Step 4: Compute Result

- Result = `(way1 * way2) % MOD`.

---

### ✅ Example Walkthrough

```text
s = "10101"

→ Total ones = 3
→ onceInBlock = 1
→ Traverse:
   prefix ones = 1 → way1++
   prefix ones = 2 → way2++
   prefix ones = 3 → done
→ way1 = 2, way2 = 2
→ Result = 2 * 2 = 4 ✅
```

```text
s = "1001"

→ Total ones = 2
→ Not divisible by 3 → Result = 0 ✅
```

```text
s = "0000"

→ Total ones = 0
→ Ways = (n-1)(n-2)/2 = 3 ✅
```

---

### 📐 Complexity

| Aspect    | Value                               |
| --------- | ----------------------------------- |
| Time      | O(n) (two passes over string)       |
| Space     | O(1) (constant extra space)         |
| Technique | Prefix sum counting + combinatorics |

---

### 🔁 Pattern

- Prefix sum counting for substring constraints
- Combinatorial formula for zero-case
- Multiplicative counting for independent choices

---

### 🚀 Alternative Approaches

- **Prefix array**: Precompute prefix sums, then scan for split points.
- **Mathematical formula**: Directly compute based on positions of ones.
- **Sliding window**: Track partitions dynamically.

---

### ⚠️ Edge Cases

- All zeros → combinatorial case.
- Total ones not divisible by 3 → return 0.
- Very large string (up to \(10^5\)) → efficient with O(n).
- Minimum length (3) → only one possible split.

🔗 [LeetCode – Number of Ways to Split a String](https://leetcode.com/problems/number-of-ways-to-split-a-string)

---

## 4. Sentence Similarity III

**Problem**:  
Two sentences `sentence1` and `sentence2` are considered similar if you can insert an arbitrary sentence (possibly empty) into one of them so that they become equal.  
The inserted sentence must be separated by spaces.  
Return `true` if they are similar, else `false`.

---

### 🔍 Core Idea: Match Prefix and Suffix

- Split both sentences into arrays of words.
- Ensure `sentence2` is the longer one (swap if needed).
- Compare words from the start (prefix) until mismatch.
- Compare words from the end (suffix) until mismatch.
- If the matched prefix and suffix together cover all words of the shorter sentence → return `true`.
- Otherwise → return `false`.

---

### 🧠 Algorithm Breakdown

#### Step 1: Split Sentences

- `s1 = sentence1.split(" ")`
- `s2 = sentence2.split(" ")`

#### Step 2: Ensure `s2` is Longer

- If `s2.length < s1.length` → swap roles.

#### Step 3: Match Prefix

- Start from index `0`.
- While words match → increment `i`.

#### Step 4: Match Suffix

- Start from end (`j = s1.length-1`, `k = s2.length-1`).
- While words match → decrement both.

#### Step 5: Final Check

- If `i > j` → all words in shorter sentence are covered by prefix + suffix matches → return `true`.
- Else → return `false`.

---

### ✅ Example Walkthrough

```text
sentence1 = "My name is Haley"
sentence2 = "My Haley"

→ s1 = ["My","name","is","Haley"]
→ s2 = ["My","Haley"]

→ Prefix match: "My"
→ Suffix match: "Haley"
→ Covered all words in s2 → true ✅
```

```text
sentence1 = "of"
sentence2 = "A lot of words"

→ s1 = ["of"]
→ s2 = ["A","lot","of","words"]

→ Prefix match: none
→ Suffix match: "of" vs "words" → mismatch
→ Not covered → false ✅
```

```text
sentence1 = "Eating right now"
sentence2 = "Eating"

→ s1 = ["Eating","right","now"]
→ s2 = ["Eating"]

→ Prefix match: "Eating"
→ Suffix match: none needed
→ Covered all words in s2 → true ✅
```

---

### 📐 Complexity

| Aspect    | Value                             |
| --------- | --------------------------------- |
| Time      | O(n+m) (scan both sentences once) |
| Space     | O(n+m) (arrays of words)          |
| Technique | Prefix + suffix matching          |

---

### 🔁 Pattern

- Prefix and suffix matching problems
- Similar to string overlap checks
- Useful in text similarity and sentence alignment tasks

---

### 🚀 Alternative Approaches

- **Two-pointer scan without splitting**: Compare directly on characters.
- **Deque approach**: Pop words from front and back until mismatch.
- **Regex-based**: Match prefix and suffix patterns.

---

### ⚠️ Edge Cases

- One sentence is a prefix of the other → true.
- One sentence is a suffix of the other → true.
- Completely different sentences → false.
- Single-word sentences → handled correctly.
- Case sensitivity → exact match required.

🔗 [LeetCode – Sentence Similarity III](https://leetcode.com/problems/sentence-similarity-iii)

---

## 5. Repeated String Match

**Problem**:  
Given two strings `a` and `b`, return the minimum number of times you must repeat `a` so that `b` becomes a substring of the repeated string.  
If impossible, return `-1`.

---

### 🔍 Core Idea: Build Until Length ≥ b

- Keep repeating `a` until the repeated string length is at least the length of `b`.
- Check if `b` is a substring.
- If not, append one more `a` (to cover overlap cases) and check again.
- If still not found → return `-1`.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `count = 0`
- `StringBuilder sb = new StringBuilder()`

#### Step 2: Build Until Length ≥ b

- While `sb.length() < b.length()`:
  - Append `a`
  - Increment `count`

#### Step 3: Check Substring

- If `sb.contains(b)` → return `count`.
- Else append one more `a` and check again:
  - If found → return `count+1`.
  - Else → return `-1`.

---

### ✅ Example Walkthrough

```text
a = "abcd", b = "cdabcdab"

→ Repeat "abcd" until length ≥ 8:
   "abcdabcd" (count=2)
→ Check: contains "cdabcdab"? No
→ Append one more "abcd" → "abcdabcdabcd" (count=3)
→ Contains "cdabcdab"? Yes
→ Result = 3 ✅
```

```text
a = "a", b = "aa"

→ Repeat "a" until length ≥ 2:
   "aa" (count=2)
→ Contains "aa"? Yes
→ Result = 2 ✅
```

```text
a = "abc", b = "cab"

→ Repeat "abc" until length ≥ 3:
   "abc" (count=1)
→ Contains "cab"? No
→ Append one more "abc" → "abcabc" (count=2)
→ Contains "cab"? No
→ Result = -1 ✅
```

---

### 📐 Complexity

| Aspect    | Value                                                  |
| --------- | ------------------------------------------------------ |
| Time      | O(n·m) worst case (string building + substring search) |
| Space     | O(n+m) (StringBuilder storage)                         |
| Technique | Iterative string building + substring check            |

---

### 🔁 Pattern

- Problems involving repeated concatenation until condition met.
- Substring search with overlap handling.
- Similar to "minimum repetitions to cover substring".

---

### 🚀 Alternative Approaches

- **Mathematical bound**:
  - Minimum repeats = `ceil(b.length / a.length)`
  - Check that many repeats and one extra.
- **KMP algorithm**: Efficient substring search in repeated string.
- **Regex**: Match `b` against repeated `a`.

---

### ⚠️ Edge Cases

- `b` shorter than `a` → may still require multiple repeats.
- `b` not possible → return `-1`.
- Large strings (up to 10,000 chars) → StringBuilder efficient.
- Exact overlap at boundary → requires one extra repeat.

🔗 [LeetCode – Repeated String Match](https://leetcode.com/problems/repeated-string-match)

---

## 6. Next Greater Element III

**Problem**:  
Given a positive integer `n`, find the smallest integer that:

- Uses exactly the same digits as `n`.
- Is greater than `n`.
- Fits within a 32-bit signed integer.  
  If no such integer exists, return `-1`.

---

### 🔍 Core Idea: Next Permutation

This problem is essentially asking for the **next lexicographical permutation** of the digits of `n`.  
Steps:

1. Find the first decreasing digit from the right.
2. Swap it with the next larger digit to its right.
3. Reverse the suffix to get the smallest possible arrangement.
4. Convert back to integer and check 32-bit limit.

---

### 🧠 Algorithm Breakdown

#### Step 1: Convert to Char Array

- `arr = String.valueOf(n).toCharArray()`
- Work with digits directly.

#### Step 2: Find Pivot

- Traverse from right to left.
- Find index `i` where `arr[i] < arr[i+1]`.
- If none found → digits are in descending order → no greater permutation → return `-1`.

#### Step 3: Find Next Larger Digit

- From rightmost end, find smallest digit greater than `arr[index]`.
- Swap them.

#### Step 4: Reverse Suffix

- Reverse digits from `index+1` to end → ensures smallest arrangement after pivot.

#### Step 5: Convert Back

- Parse result into `long`.
- If > `Integer.MAX_VALUE` → return `-1`.
- Else return result.

---

### ✅ Example Walkthrough

```text
n = 12
→ arr = ['1','2']
→ Pivot at index 0 ('1' < '2')
→ Swap '1' and '2' → ['2','1']
→ Reverse suffix (only one digit) → ['2','1']
→ Result = 21 ✅
```

```text
n = 21
→ arr = ['2','1']
→ Digits in descending order → no greater permutation
→ Result = -1 ✅
```

---

### 📐 Complexity

| Aspect    | Value                       |
| --------- | --------------------------- |
| Time      | O(d) (d = number of digits) |
| Space     | O(d) (char array)           |
| Technique | Next permutation            |

---

### 🔁 Pattern

- Classic **next permutation** algorithm.
- Same logic used in problems like "Next Permutation" (LeetCode #31).
- Useful in generating ordered sequences.

---

### 🚀 Alternative Approaches

- **Use arrays directly**: Avoid string conversion, work with integer digits.
- **Library functions**: Some languages have built-in next permutation utilities.
- **Heap-based approach**: Overkill, but possible to generate all permutations and pick next.

---

### ⚠️ Edge Cases

- Already largest permutation (e.g., `987654`) → return `-1`.
- Single-digit numbers → return `-1`.
- Result exceeds 32-bit integer → return `-1`.
- Smallest valid case: `n = 12 → 21`.

🔗 [LeetCode – Next Greater Element III](https://leetcode.com/problems/next-greater-element-iii)

---

## 7. Maximum Number of Removable Characters

**Problem**:  
Given strings `s` and `p` (where `p` is a subsequence of `s`) and an array `removable` of indices, find the maximum integer `k` such that after removing the first `k` indices from `s`, `p` is still a subsequence of the modified `s`.

---

### 🔍 Core Idea: Binary Search on k

- We want the **maximum k**.
- Instead of checking every possible `k` (which is inefficient), use **binary search**:
  - Try a mid-point `k`.
  - Remove first `k` indices.
  - Check if `p` is still a subsequence.
  - If yes → move right (increase `k`).
  - If no → move left (decrease `k`).
- Continue until maximum valid `k` is found.

---

### 🧠 Algorithm Breakdown

#### Step 1: Binary Search Setup

- `start = 0`, `end = removable.length`.
- `k = 0` (answer).

#### Step 2: Midpoint Check

- For each `mid`:
  - Mark first `mid` indices in `removed[]`.
  - Check if `p` is subsequence of modified `s`.

#### Step 3: Subsequence Validation

- Traverse `s` with two pointers (`i` for `s`, `j` for `p`).
- Skip removed indices.
- If `s[i] == p[j]` → move `j`.
- At end, if `j == p.length` → `p` is subsequence.

#### Step 4: Update Binary Search

- If subsequence valid → `k = mid`, move `start = mid+1`.
- Else → move `end = mid-1`.

#### Step 5: Return Result

- Return `k`.

---

### ✅ Example Walkthrough

```text
s = "abcacb", p = "ab", removable = [3,1,0]

→ Binary search range: [0…3]
→ mid=1 → remove index 3 → "abcab" → "ab" subsequence → valid
→ mid=2 → remove indices [3,1] → "accb" → "ab" subsequence → valid
→ mid=3 → remove indices [3,1,0] → "ccb" → "ab" not subsequence → invalid
→ Maximum k = 2 ✅
```

```text
s = "abcbddddd", p = "abcd", removable = [3,2,1,4,5,6]

→ mid=1 → remove index 3 → "abcddddd" → "abcd" subsequence → valid
→ mid=2 → remove indices [3,2] → "abddddd" → "abcd" not subsequence → invalid
→ Maximum k = 1 ✅
```

```text
s = "abcab", p = "abc", removable = [0,1,2,3,4]

→ mid=1 → remove index 0 → "bcab" → "abc" not subsequence → invalid
→ Maximum k = 0 ✅
```

---

### 📐 Complexity

| Aspect    | Value                                                 |
| --------- | ----------------------------------------------------- |
| Time      | O(n log m) (n = length of s, m = length of removable) |
| Space     | O(n) (boolean array for removed indices)              |
| Technique | Binary search + subsequence check                     |

---

### 🔁 Pattern

- **Binary search on answer**: Instead of brute force, search for maximum valid `k`.
- **Subsequence validation**: Classic two-pointer technique.
- Common in problems where you maximize/minimize under constraints.

---

### 🚀 Alternative Approaches

- **Linear scan**: Try all `k` from 0…m → O(n·m), too slow for large inputs.
- **HashSet for removals**: Instead of boolean array, use set for faster marking.
- **Greedy**: Not sufficient here, since removals must be checked systematically.

---

### ⚠️ Edge Cases

- `p` already equals `s` → maximum removals possible.
- Removing any index breaks subsequence → answer = 0.
- Large input sizes (up to 100,000) → binary search ensures efficiency.
- Distinct indices in `removable` → no duplicates to handle.

🔗 [LeetCode – Maximum Number of Removable Characters](https://leetcode.com/problems/maximum-number-of-removable-characters)

---

## 8. Swap Adjacent in LR String

**Problem**:  
Given two strings `start` and `result` composed of `'L'`, `'R'`, and `'X'`, determine if `start` can be transformed into `result` using valid moves:

- Replace `"XL"` → `"LX"` (move `L` left).
- Replace `"RX"` → `"XR"` (move `R` right).  
  Return `true` if transformation is possible, else `false`.

---

### 🔍 Core Idea: Two-Pointer Matching with Movement Rules

- Ignore `'X'` characters (they act as placeholders).
- Align non-`X` characters in both strings.
- Ensure characters match (`L` with `L`, `R` with `R`).
- Apply movement rules:
  - `'L'` can only move **left** → its position in `result` must be ≤ position in `start`.
  - `'R'` can only move **right** → its position in `result` must be ≥ position in `start`.
- If all checks pass → return `true`.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize Pointers

- `i = 0` for `start`, `j = 0` for `result`.

#### Step 2: Skip X’s

- Move `i` forward until `start[i] != 'X'`.
- Move `j` forward until `result[j] != 'X'`.

#### Step 3: Compare Characters

- If both pointers reach end → return `true`.
- If characters differ → return `false`.

#### Step 4: Apply Movement Rules

- If character is `'L'` and `j > i` → invalid (L cannot move right).
- If character is `'R'` and `j < i` → invalid (R cannot move left).
- Otherwise → valid, move both pointers.

#### Step 5: Final Check

- If both pointers exhausted simultaneously → return `true`.
- Else → return `false`.

---

### ✅ Example Walkthrough

```text
start = "RXXLRXRXL"
result = "XRLXXRRLX"

→ Skip X’s, align characters:
   start: R L R L
   result: R L R L
→ Movement rules:
   R moves right → valid
   L moves left → valid
→ All matched → true ✅
```

```text
start = "X"
result = "L"

→ start has no L
→ Characters mismatch → false ✅
```

---

### 📐 Complexity

| Aspect    | Value                                           |
| --------- | ----------------------------------------------- |
| Time      | O(n) (single pass with two pointers)            |
| Space     | O(1) (constant extra space)                     |
| Technique | Two-pointer traversal with movement constraints |

---

### 🔁 Pattern

- Two-pointer alignment ignoring placeholders.
- Movement constraints applied to specific characters.
- Similar to problems involving string transformation with rules.

---

### 🚀 Alternative Approaches

- **Greedy simulation**: Actually perform swaps step by step (less efficient).
- **Queue-based approach**: Track positions of `L` and `R` separately.
- **Mathematical check**: Compare indices directly without traversal.

---

### ⚠️ Edge Cases

- Strings with only `'X'` → always true if lengths match.
- Single-character mismatch → false.
- Large strings (up to 10,000) → efficient with O(n).
- Misaligned `L` or `R` → false.

🔗 [LeetCode – Swap Adjacent in LR String](https://leetcode.com/problems/swap-adjacent-in-lr-string)

---

## 9. Multiply Strings

**Problem**:  
Given two non-negative integers `num1` and `num2` represented as strings, return their product as a string.  
Constraints:

- No use of built-in `BigInteger`.
- No direct integer conversion.
- Length up to 200 digits.

---

### 🔍 Core Idea: Manual Multiplication (Like Pen-and-Paper)

- Reverse both strings to simplify multiplication from least significant digit.
- Use an integer array `res[]` to store partial results.
- Multiply each digit pair and add to the correct position.
- Handle carry propagation.
- Build final string from result array, skipping leading zeros.

---

### 🧠 Algorithm Breakdown

#### Step 1: Handle Zero Case

- If either number is `"0"` → return `"0"`.

#### Step 2: Reverse Strings

- Reverse `num1` and `num2` for easier multiplication.

#### Step 3: Multiply Digits

- For each digit pair `(i, j)`:
  - Multiply → `digit = (num1[i]-'0') * (num2[j]-'0')`.
  - Add to `res[i+j]`.
  - Handle carry → `res[i+j+1] += res[i+j] / 10`.
  - Reduce → `res[i+j] %= 10`.

#### Step 4: Build Result String

- Skip leading zeros in `res[]`.
- Append digits in reverse order to `StringBuilder`.
- Return final string.

---

### ✅ Example Walkthrough

```text
num1 = "123", num2 = "456"

→ Reverse: "321", "654"
→ Multiply:
   3*6 → add to res[0]
   2*6 → add to res[1]
   1*6 → add to res[2]
   … continue for all pairs
→ Result array = [8,8,0,6,5]
→ Skip leading zeros → "56088"
→ Result = "56088" ✅
```

```text
num1 = "2", num2 = "3"
→ Reverse: "2", "3"
→ Multiply: 2*3 = 6
→ Result = "6" ✅
```

---

### 📐 Complexity

| Aspect    | Value                                           |
| --------- | ----------------------------------------------- |
| Time      | O(n·m) (n = length of num1, m = length of num2) |
| Space     | O(n+m) (result array)                           |
| Technique | Manual digit multiplication                     |

---

### 🔁 Pattern

- Classic **big integer multiplication** simulation.
- Similar to grade-school multiplication algorithm.
- Useful in problems requiring arbitrary precision arithmetic.

---

### 🚀 Alternative Approaches

- **Karatsuba multiplication**: Faster for very large numbers (divide-and-conquer).
- **FFT-based multiplication**: Used in competitive programming for huge inputs.
- **StringBuilder optimization**: Avoid reversing by careful index placement.

---

### ⚠️ Edge Cases

- Either input = `"0"` → return `"0"`.
- Leading zeros in result → must be trimmed.
- Very large inputs (200 digits each) → handled efficiently with O(n·m).
- Single-digit multiplication → straightforward.

🔗 [LeetCode – Multiply Strings](https://leetcode.com/problems/multiply-strings)

---

## 10. Minimum Length of String After Deleting Similar Ends

**Problem**:  
Given a string `s` consisting only of `'a'`, `'b'`, and `'c'`, repeatedly perform the following operation:

- Pick a non-empty prefix where all characters are equal.
- Pick a non-empty suffix where all characters are equal.
- Prefix and suffix must not overlap.
- Characters of prefix and suffix must be the same.
- Delete both.

Return the minimum length of `s` after performing the operation any number of times.

---

### 🔍 Core Idea: Two-Pointer Shrinking

- Use two pointers (`i` at start, `j` at end).
- If `s[i] == s[j]`, shrink both sides inward:
  - Skip consecutive identical characters at both ends.
  - Move `i++` and `j--`.
- If `s[i] != s[j]`, stop — return remaining length.
- Continue until pointers meet or cross.
- Handle empty string case (return 0).

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `i = 0`, `j = s.length()-1`.

#### Step 2: While Loop

- While `i < j`:
  - If `s[i] == s[j]`:
    - Record character `ch = s[i]`.
    - Skip duplicates at left (`i++`).
    - Skip duplicates at right (`j--`).
    - Move inward (`i++`, `j--`).
  - Else → break and return `j - i + 1`.

#### Step 3: Final Result

- If pointers cross → return 0.
- Else → return `j - i + 1`.

---

### ✅ Example Walkthrough

```text
s = "ca"
→ i=0 ('c'), j=1 ('a')
→ Different → stop
→ Remaining length = 2 ✅
```

```text
s = "cabaabac"
→ i=0 ('c'), j=7 ('c') → match
→ Remove prefix 'c' and suffix 'c' → "abaaba"
→ Next: prefix 'a', suffix 'a' → remove → "baab"
→ Next: prefix 'b', suffix 'b' → remove → "aa"
→ Next: prefix 'a', suffix 'a' → remove → ""
→ Result = 0 ✅
```

```text
s = "aabccabba"
→ i=0 ('a'), j=8 ('a') → match
→ Remove → "bccabb"
→ i=0 ('b'), j=5 ('b') → match
→ Remove → "cca"
→ Remaining length = 3 ✅
```

---

### 📐 Complexity

| Aspect    | Value                           |
| --------- | ------------------------------- |
| Time      | O(n) (scan from both ends once) |
| Space     | O(1) (constant extra space)     |
| Technique | Two-pointer shrinking           |

---

### 🔁 Pattern

- Two-pointer technique for symmetric operations.
- Similar to palindrome checking or string trimming problems.
- Efficient for problems with prefix-suffix constraints.

---

### 🚀 Alternative Approaches

- **Recursive trimming**: Repeatedly trim prefix/suffix until mismatch.
- **Stack-based approach**: Overkill, but possible to simulate deletions.
- **Greedy shrink**: Always shrink as much as possible from both ends.

---

### ⚠️ Edge Cases

- Single-character string → cannot delete → return 1.
- Entire string deletable → return 0.
- Different prefix/suffix characters → return full length.
- Large input (up to 100,000) → efficient with O(n).

🔗 [LeetCode – Minimum Length of String After Deleting Similar Ends](https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends)

---
