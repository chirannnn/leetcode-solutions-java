## 1. Roman to Integer

**Problem**:  
Convert a Roman numeral string into its integer value.

---

### 🔍 Core Idea: Greedy Scan with Subtractive Rule

- Roman numerals are usually written from largest to smallest left to right.
- Exception: subtractive notation (e.g., IV = 4, IX = 9).
- Scan string left to right:
  - Compare current value with next value.
  - If next > current → subtractive case → add `(next - current)` and skip ahead.
  - Else → add current value.

---

### 🧠 Algorithm Breakdown

#### Step 1: Map Roman Characters

- `I=1, V=5, X=10, L=50, C=100, D=500, M=1000`.

#### Step 2: Traverse String

- For each character:
  - Get current value.
  - If next exists and `next > current`:
    - Add `(next - current)` to result.
    - Skip next character.
  - Else add current value.

#### Step 3: Return Result

- Return accumulated integer.

---

### ✅ Example Walkthrough

```text
s = "LVIII"

→ L=50, V=5, I=1, I=1, I=1
→ No subtractive cases
→ Result = 50+5+1+1+1 = 58 ✅
```

```text
s = "MCMXCIV"

→ M=1000
→ C=100, next M=1000 → subtractive → +900
→ X=10, next C=100 → subtractive → +90
→ I=1, next V=5 → subtractive → +4
→ Result = 1994 ✅
```

---

### 📐 Complexity

| Aspect    | Value                             |
| --------- | --------------------------------- |
| Time      | O(n) (single pass through string) |
| Space     | O(1)                              |
| Technique | Greedy scan with subtractive rule |

---

### 🔁 Pattern

- Roman numeral conversion is a **classic greedy parsing problem**.
- Similar to problems where local comparisons determine global result.
- Subtractive cases are the only special handling.

---

### 🚀 Alternative Approaches

- **HashMap lookup**: store values in a map instead of switch-case.
- **Right-to-left scan**: add values, subtract when smaller than previous.
- Current left-to-right greedy approach is clean and intuitive.

---

### ⚠️ Edge Cases

- Single character → return its value.
- Valid subtractive pairs: IV, IX, XL, XC, CD, CM.
- Input guaranteed valid (per constraints).

🔗 LeetCode – Roman to Integer [(leetcode.com)](https://leetcode.com/problems/roman-to-integer/description/)

---

## 2. Happy Number

**Problem**:  
Determine if a number `n` is a **happy number**.  
Process:

- Replace the number with the sum of the squares of its digits.
- Repeat until the number equals 1 (happy) or loops endlessly (not happy).
- Return `true` if happy, else `false`.

---

### 🔍 Core Idea: Cycle Detection

- If the process reaches `1` → happy number.
- If the process enters a cycle → not happy.
- Use a `HashSet` to track previously seen numbers.
- If a number repeats, we’re in a cycle.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- Create `Set<Integer> set` to store seen numbers.

#### Step 2: Iterate

- While `n != 1`:
  - Compute sum of squares of digits.
  - If result already in `set` → cycle detected → return false.
  - Else add to `set`.
  - Update `n`.

#### Step 3: Return Result

- If loop ends with `n == 1` → return true.

---

### ✅ Example Walkthrough

```text
n = 19

→ 1² + 9² = 82
→ 8² + 2² = 68
→ 6² + 8² = 100
→ 1² + 0² + 0² = 1
→ Result = true ✅
```

```text
n = 2

→ 2² = 4
→ 4² = 16
→ 1² + 6² = 37
→ 3² + 7² = 58
→ 5² + 8² = 89
→ 8² + 9² = 145
→ 1² + 4² + 5² = 42
→ 4² + 2² = 20
→ 2² + 0² = 4 (cycle repeats)
→ Result = false ✅
```

---

### 📐 Complexity

| Aspect    | Value                                                        |
| --------- | ------------------------------------------------------------ |
| Time      | O(k) (depends on cycle length, bounded by digit square sums) |
| Space     | O(k) (HashSet for seen numbers)                              |
| Technique | Cycle detection with HashSet                                 |

---

### 🔁 Pattern

- Similar to **Linked List cycle detection**.
- Can also be solved with **Floyd’s cycle detection (fast/slow pointers)** to reduce space.
- Common in problems involving repeated transformations.

---

### 🚀 Alternative Approaches

- **Floyd’s cycle detection**:
  - Use two pointers (slow and fast).
  - If they meet before reaching 1 → cycle.
  - Space complexity O(1).
- Current HashSet approach is simpler and intuitive.

---

### ⚠️ Edge Cases

- n = 1 → true.
- Large n → quickly reduces since digit squares shrink values.
- Guaranteed termination (either 1 or cycle).

🔗 LeetCode – Happy Number [(leetcode.com)](https://leetcode.com/problems/happy-number/description/)

---
