## 1. Valid Number

**Problem**:  
Given a string `s`, determine if it represents a valid number.  
Valid numbers include integers, decimals, and numbers with exponents (`e` or `E`).  
Invalid cases include alphabetic characters, misplaced signs, multiple dots, or incomplete exponents.

---

### 🔍 Core Idea: State Tracking While Scanning

- Traverse the string character by character.
- Track flags:
  - `digitSeen` → at least one digit encountered.
  - `dotSeen` → whether a decimal point has appeared.
  - `eSeen` → whether exponent has appeared.
  - `plusMinusCount` → number of signs used.
- Apply rules:
  - Digits are always valid.
  - Signs (`+`/`-`) must appear at start or immediately after `e/E`.
  - Dot (`.`) allowed only once, before exponent.
  - Exponent (`e/E`) allowed only once, must follow digits, and not be last character.
  - Any other character → invalid.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize Flags

- `digitSeen = false`, `dotSeen = false`, `eSeen = false`, `plusMinusCount = 0`.

#### Step 2: Traverse String

- If digit → `digitSeen = true`.
- If sign → must be at start or after `e/E`.
- If dot → must not appear after exponent or repeat.
- If exponent → must follow digits, not repeat, not be last.
- Else → invalid.

#### Step 3: Final Check

- Return `true` if all rules satisfied.
- Else return `false`.

---

### ✅ Example Walkthrough

```text
s = "0"
→ digitSeen = true
→ No dot, no exponent
→ Valid → true ✅
```

```text
s = "e"
→ Exponent without digits
→ Invalid → false ✅
```

```text
s = "."
→ Dot without digits
→ Invalid → false ✅
```

```text
s = "-0.1"
→ Sign at start → valid
→ Digits + dot → valid
→ Valid → true ✅
```

```text
s = "2e10"
→ Digits → valid
→ Exponent → valid
→ Digits after exponent → valid
→ Valid → true ✅
```

```text
s = "99e2.5"
→ Exponent followed by decimal → invalid
→ Result = false ✅
```

---

### 📐 Complexity

| Aspect    | Value                  |
| --------- | ---------------------- |
| Time      | O(n) (single pass)     |
| Space     | O(1) (constant flags)  |
| Technique | State machine / parser |

---

### 🔁 Pattern

- Parsing problems often use **state machines** or **flag tracking**.
- Similar to validating email addresses, IP addresses, or mathematical expressions.
- Key is enforcing rules at each character.

---

### 🚀 Alternative Approaches

- **Regex validation**: Build a regex for valid numbers.
- **Finite state machine (FSM)**: Explicit states for integer, decimal, exponent.
- **Library parsing**: Use `Double.parseDouble()` in Java (but problem forbids shortcuts).

---

### ⚠️ Edge Cases

- Signs at wrong positions (`--6`, `-+3`) → invalid.
- Multiple dots (`1.2.3`) → invalid.
- Exponent without digits (`e3`, `1e`) → invalid.
- Decimal without digits (`.`) → invalid.
- Leading zeros (`0089`) → valid.
- Large exponents (`-123.456e789`) → valid.

🔗 LeetCode – Valid Number (leetcode.com)(https://leetcode.com/problems/valid-number/description/)

---

## 2. Last Substring in Lexicographical Order

**Problem**:  
Given a string `s`, return the lexicographically last substring of `s`.  
Lexicographical order means dictionary order (like comparing words alphabetically).

---

### 🔍 Core Idea: Two-Pointer Lexicographical Comparison

- Brute force (generating all substrings) is too slow for large strings.
- Instead, use a **two-pointer technique** (`i` and `j`) to find the starting index of the lexicographically largest substring.
- Compare substrings character by character:
  - If `s[i+k] < s[j+k]` → substring at `j` is larger → move `i`.
  - If `s[i+k] > s[j+k]` → substring at `i` is larger → move `j`.
  - If equal → continue comparing next character (`k++`).
- At the end, `i` points to the start of the lexicographically last substring.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `i = 0`, `j = 1`, `k = 0`.

#### Step 2: Compare Characters

- While `j + k < n`:
  - If `s[i+k] < s[j+k]`:
    - Move `i` forward → `i = max(i+k+1, j)`.
    - Reset `j = i+1`, `k = 0`.
  - Else if `s[i+k] > s[j+k]`:
    - Move `j` forward → `j += k+1`.
    - Reset `k = 0`.
  - Else (equal) → increment `k`.

#### Step 3: Return Result

- Return `s.substring(i)`.

---

### ✅ Example Walkthrough

```text
s = "abab"

→ Compare substrings:
   i=0 ("abab"), j=1 ("bab")
   'a' vs 'b' → 'b' is larger → move i
→ i=1 → substring = "bab"
→ Result = "bab" ✅
```

```text
s = "leetcode"

→ Largest substring starts at 't'
→ Result = "tcode" ✅
```

---

### 📐 Complexity

| Aspect    | Value                                  |
| --------- | -------------------------------------- |
| Time      | O(n) (linear scan with two pointers)   |
| Space     | O(1) (constant extra space)            |
| Technique | Two-pointer lexicographical comparison |

---

### 🔁 Pattern

- Similar to **Duval’s algorithm** for lexicographically minimal rotation.
- Efficient string comparison without generating all substrings.
- Common in suffix array / string matching problems.

---

### 🚀 Alternative Approaches

- **Suffix array construction**: Build suffix array and take last suffix → O(n log n).
- **Brute force**: Generate all substrings and compare → O(n²), not feasible for large inputs.
- **Built-in sort**: Sort suffixes → slower than two-pointer method.

---

### ⚠️ Edge Cases

- Single-character string → return itself.
- All identical characters → return full string.
- Very large string (up to 400,000) → efficient with O(n).
- Lexicographically last character may appear multiple times → algorithm ensures correct choice.

🔗 LeetCode – Last Substring in Lexicographical Order [(leetcode.com)](https://leetcode.com/problems/last-substring-in-lexicographical-order/description/)

---

## 3. Check If String Is Transformable With Substring Sort Operations

**Problem**:  
Given two strings `s` and `t` (same length, digits only), determine if `s` can be transformed into `t` using the operation:

- Choose a non-empty substring of `s` and sort it in ascending order.  
  Return `true` if transformation is possible, else `false`.

---

### 🔍 Core Idea: Position Tracking + Greedy Validation

- Sorting substrings allows digits to "move left" but **not jump over smaller digits**.
- For each digit in `t`, check if the corresponding digit in `s` can be moved into place without violating ordering constraints.
- Use lists to track positions of each digit in `s`.
- Greedy approach: always consume the earliest available occurrence of the required digit.

---

### 🧠 Algorithm Breakdown

#### Step 1: Store Positions

- Create `pos[10]` → list of indices for each digit (0–9).
- Traverse `s`, add index of each digit to its list.

#### Step 2: Traverse Target String

- For each digit in `t`:
  - If no occurrence left in `s` → return false.
  - Take earliest index `idx` from `pos[digit]`.
  - Check smaller digits (`0 … digit-1`):
    - If any smaller digit still has an occurrence **before `idx`**, then digit cannot move past it → return false.
  - Remove used index from list.

#### Step 3: Return Result

- If all digits matched successfully → return true.

---

### ✅ Example Walkthrough

```text
s = "84532", t = "34852"

→ Positions:
   '8': [0], '4': [1], '5': [2], '3': [3], '2': [4]
→ Match '3' → idx=3 → valid
→ Match '4' → idx=1 → valid
→ Match '8' → idx=0 → valid
→ Match '5' → idx=2 → valid
→ Match '2' → idx=4 → valid
→ Result = true ✅
```

```text
s = "34521", t = "23415"

→ Positions:
   '3': [0], '4': [1], '5': [2], '2': [3], '1': [4]
→ Match '2' → idx=3 → valid
→ Match '3' → idx=0 → valid
→ Match '4' → idx=1 → valid
→ Match '1' → idx=4 → valid
→ Match '5' → idx=2 → valid
→ Result = true ✅
```

```text
s = "12345", t = "12435"

→ Positions:
   '1': [0], '2': [1], '3': [2], '4': [3], '5': [4]
→ Match '1' → idx=0 → valid
→ Match '2' → idx=1 → valid
→ Match '4' → idx=3 → valid
→ Match '3' → idx=2 → smaller digit before idx → invalid
→ Result = false ✅
```

---

### 📐 Complexity

| Aspect    | Value                                                                  |
| --------- | ---------------------------------------------------------------------- |
| Time      | O(n·d) (n = length of string, d = digit range = 10) → effectively O(n) |
| Space     | O(n) (lists of positions)                                              |
| Technique | Greedy + position tracking                                             |

---

### 🔁 Pattern

- Greedy matching with constraints.
- Similar to problems involving subsequence validation with ordering rules.
- Uses **digit buckets** to track positions efficiently.

---

### 🚀 Alternative Approaches

- **Queue-based**: Use queues for each digit instead of lists.
- **Segment tree / Fenwick tree**: For larger alphabets, track ordering constraints more efficiently.
- **Simulation**: Actually sort substrings step by step (inefficient).

---

### ⚠️ Edge Cases

- Exact match (`s == t`) → always true.
- Impossible swaps (digit blocked by smaller digit) → false.
- Large input (up to \(10^5\)) → efficient with O(n).
- Multiple occurrences of digits → handled by position lists.

🔗 LeetCode – Check If String Is Transformable With Substring Sort Operations [(leetcode.com)](https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/description/)

---

## 4. Orderly Queue

**Problem**:  
Given a string `s` and integer `k`, you can choose one of the first `k` letters and append it to the end of the string.  
Return the lexicographically smallest string possible after applying the operation any number of times.

---

### 🔍 Core Idea: Two Cases Based on k

- **Case 1: k = 1**
  - You can only rotate the string (move first character to end).
  - Generate all rotations of `s`.
  - Return the lexicographically smallest rotation.

- **Case 2: k > 1**
  - You can rearrange characters freely (because multiple choices allow permutations).
  - The smallest possible string is simply the sorted version of `s`.

---

### 🧠 Algorithm Breakdown

#### Case 1: k = 1

- Initialize `curr = s`, `small = s`.
- For each rotation:
  - `curr = curr.substring(1) + curr.charAt(0)`.
  - Compare with `small`.
  - Update `small` if `curr` is smaller.
- Return `small`.

#### Case 2: k > 1

- Convert string to char array.
- Sort array.
- Return new string from sorted array.

---

### ✅ Example Walkthrough

```text
s = "cba", k = 1

→ Rotations:
   "cba"
   "bac"
   "acb"
→ Lexicographically smallest = "acb" ✅
```

```text
s = "baaca", k = 3

→ Since k > 1, sort characters:
   ['a','a','a','b','c']
→ Result = "aaabc" ✅
```

---

### 📐 Complexity

| Aspect    | Value                                     |
| --------- | ----------------------------------------- |
| Case k=1  | O(n²) (n rotations, each O(n) comparison) |
| Case k>1  | O(n log n) (sorting)                      |
| Space     | O(n) (char array or rotations)            |
| Technique | Rotation + sorting                        |

---

### 🔁 Pattern

- **Rotation problems**: Similar to "minimum rotation" or "string shift".
- **Sorting for freedom**: When multiple choices allow permutations, sorting gives lexicographically smallest result.
- Hybrid approach depending on constraint (`k`).

---

### 🚀 Alternative Approaches

- **Suffix array for k=1**: More efficient than brute-force rotations (O(n log n)).
- **Deque simulation**: Rotate efficiently without substring creation.
- **Direct sorting**: Always works when `k > 1`.

---

### ⚠️ Edge Cases

- Single-character string → always return itself.
- k = 1 with already smallest rotation → return original string.
- Large string length (up to 1000) → rotation approach still feasible.
- All identical characters → return same string.

🔗 LeetCode – Orderly Queue: [(leetcode.com)](https://leetcode.com/problems/orderly-queue/description/)

---
