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
