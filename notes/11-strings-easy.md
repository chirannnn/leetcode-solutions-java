## 1. Defanging an IP Address

**Problem**:  
Given a valid IPv4 address string, return a **defanged version** where every `"."` is replaced with `"[.]"`.

---

### 🔍 Core Idea: String Replacement

- The task is purely **string manipulation**.
- Replace all occurrences of `"."` with `"[.]"`.
- Two approaches:
  1. Use built-in `String.replace()` (concise).
  2. Use `StringBuilder` and manually construct the result (more control).

---

### 🧠 Algorithm Breakdown

#### Approach 1: Using `String.replace()`

- Directly call `address.replace(".", "[.]")`.
- Returns the defanged IP in one line.

#### Approach 2: Manual Construction

- Initialize `StringBuilder`.
- Traverse each character of the string.
- If character is `"."`, append `"[.]"`.
- Else, append the character itself.
- Return the built string.

---

### ✅ Example Walkthrough

```text
address = "1.1.1.1"

→ Replace "." → "1[.]1[.]1[.]1" ✅
```

```text
address = "255.100.50.0"

→ Replace "." → "255[.]100[.]50[.]0" ✅
```

---

### 📐 Complexity

| Aspect    | Value                           |
| --------- | ------------------------------- |
| Time      | O(n) (scan through string once) |
| Space     | O(n) (new string or builder)    |
| Technique | String replacement              |

---

### 🔁 Pattern

- Simple string manipulation
- Character replacement problems
- Can generalize to sanitization tasks (e.g., escaping special characters)

---

### 🚀 Alternative Approaches

- **Regex Replace**: `address.replaceAll("\\.", "[.]")`
- **Stream-based**: Convert to char stream, map, collect (less efficient but functional style).

---

### ⚠️ Edge Cases

- Empty string → returns empty string.
- No `"."` present → returns original string unchanged.
- Valid IPv4 always contains `"."`, so guaranteed replacements.

🔗 [LeetCode – Defanging an IP Address](https://leetcode.com/problems/defanging-an-ip-address)

---

## 2. Shuffle String

**Problem**:  
You are given a string `s` and an integer array `indices[]` of the same length.  
The string `s` will be shuffled such that the character at position `i` moves to position `indices[i]`.  
Return the shuffled string.

---

### 🔍 Core Idea: Direct Mapping with Auxiliary Array

- Each character in `s` has a **target position** given by `indices[i]`.
- Create a new character array `ans[]` of length `n`.
- Place `s.charAt(i)` into `ans[indices[i]]`.
- Finally, convert `ans[]` back to a string.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize Result Array

- `char[] ans = new char[n]`.

#### Step 2: Map Characters

- For each index `i` in `s`:
  - Place character `s.charAt(i)` into `ans[indices[i]]`.

#### Step 3: Build Result String

- Return `new String(ans)`.

---

### ✅ Example Walkthrough

```text
s = "codeleet"
indices = [4,5,6,7,0,2,1,3]

→ Mapping:
   'c' → ans[4]
   'o' → ans[5]
   'd' → ans[6]
   'e' → ans[7]
   'l' → ans[0]
   'e' → ans[2]
   'e' → ans[1]
   't' → ans[3]

→ ans = ['l','e','e','t','c','o','d','e']
→ Result = "leetcode" ✅
```

```text
s = "abc"
indices = [0,1,2]

→ Mapping:
   'a' → ans[0]
   'b' → ans[1]
   'c' → ans[2]

→ ans = ['a','b','c']
→ Result = "abc" ✅
```

---

### 📐 Complexity

| Aspect    | Value                             |
| --------- | --------------------------------- |
| Time      | O(n) (single pass through string) |
| Space     | O(n) (result array)               |
| Technique | Direct index mapping              |

---

### 🔁 Pattern

- Index-based rearrangement problems
- Mapping values to target positions
- Useful in permutation and reordering tasks

---

### 🚀 Alternative Approaches

- **StringBuilder**:
  - Build result incrementally, but less efficient since random access is needed.
- **In-place swap**:
  - Possible if indices form a permutation cycle, but more complex.

---

### ⚠️ Edge Cases

- Already ordered indices → returns original string.
- Single character string → unchanged.
- Maximum length (n=100) → still efficient.

🔗 [LeetCode – Shuffle String](https://leetcode.com/problems/shuffle-string)

---

## 3. Goal Parser Interpretation

**Problem**:  
You are given a string `command` consisting of `"G"`, `"()"`, and `"(al)"`.  
Interpret it as follows:

- `"G"` → `"G"`
- `"()"` → `"o"`
- `"(al)"` → `"al"`  
  Concatenate results in original order and return the interpreted string.

---

### 🔍 Core Idea: String Traversal + Pattern Matching

- Traverse the string character by character.
- If current character is `'G'` → append `"G"`.
- If current character is `'('`:
  - If next character is `')'` → append `"o"`.
  - Else → append `"al"`.
- Continue until the entire string is processed.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize Builder

- Use `StringBuilder ans` for efficient concatenation.

#### Step 2: Traverse String

- Loop with index `i`.
- Case 1: `command[i] == 'G'` → append `'G'`.
- Case 2: `command[i] == '('`:
  - If `command[i+1] == ')'` → append `'o'`, skip one extra character.
  - Else → append `"al"`, skip three extra characters.

#### Step 3: Return Result

- Convert builder to string → `ans.toString()`.

---

### ✅ Example Walkthrough

```text
command = "G()(al)"

→ Traverse:
   'G' → "G"
   "()" → "o"
   "(al)" → "al"

→ Result = "Goal" ✅
```

```text
command = "G()()()()(al)"

→ Traverse:
   'G' → "G"
   "()" → "o"
   "()" → "o"
   "()" → "o"
   "()" → "o"
   "(al)" → "al"

→ Result = "Gooooal" ✅
```

```text
command = "(al)G(al)()()G"

→ Traverse:
   "(al)" → "al"
   "G" → "G"
   "(al)" → "al"
   "()" → "o"
   "()" → "o"
   "G" → "G"

→ Result = "alGalooG" ✅
```

---

### 📐 Complexity

| Aspect    | Value                                  |
| --------- | -------------------------------------- |
| Time      | O(n) (single pass through string)      |
| Space     | O(n) (builder for result)              |
| Technique | String traversal + conditional parsing |

---

### 🔁 Pattern

- Sequential parsing of string tokens
- Pattern recognition (`G`, `()`, `(al)`)
- Efficient concatenation with `StringBuilder`

---

### 🚀 Alternative Approaches

- **String.replace() chain**:
  - `command.replace("()", "o").replace("(al)", "al")`
  - Concise but less instructive.
- **Regex replacement**:
  - Replace patterns with regex, though overkill for this problem.

---

### ⚠️ Edge Cases

- Single `"G"` → returns `"G"`.
- Multiple `"()"` → returns repeated `"o"`.
- Only `"(al)"` → returns `"al"`.
- Length up to 100 → efficient with O(n).

🔗 [LeetCode – Goal Parser Interpretation](https://leetcode.com/problems/goal-parser-interpretation)

---

## 4. Count Items Matching a Rule

**Problem**:  
You are given a list of items, where each item is represented as `[type, color, name]`.  
You are also given a rule defined by `ruleKey` and `ruleValue`.  
Return the number of items that match the rule.

---

### 🔍 Core Idea: Map RuleKey → Index

- Each item has three attributes:
  - `type` → index `0`
  - `color` → index `1`
  - `name` → index `2`
- Convert `ruleKey` into the corresponding index.
- Traverse all items, check if `item[index] == ruleValue`.
- Count matches.

---

### 🧠 Algorithm Breakdown

#### Step 1: Map RuleKey

- If `ruleKey == "type"` → index = 0
- If `ruleKey == "color"` → index = 1
- If `ruleKey == "name"` → index = 2

#### Step 2: Traverse Items

- For each item in `items`:
  - Compare `item[index]` with `ruleValue`.
  - If equal → increment count.

#### Step 3: Return Count

- Return the total number of matches.

---

### ✅ Example Walkthrough

```text
items = [["phone","blue","pixel"],
         ["computer","silver","lenovo"],
         ["phone","gold","iphone"]]
ruleKey = "color", ruleValue = "silver"

→ index = 1
→ Check each item:
   ["phone","blue","pixel"] → "blue" ≠ "silver"
   ["computer","silver","lenovo"] → "silver" = "silver" → count++
   ["phone","gold","iphone"] → "gold" ≠ "silver"

→ Result = 1 ✅
```

```text
items = [["phone","blue","pixel"],
         ["computer","silver","phone"],
         ["phone","gold","iphone"]]
ruleKey = "type", ruleValue = "phone"

→ index = 0
→ Check each item:
   ["phone","blue","pixel"] → "phone" = "phone" → count++
   ["computer","silver","phone"] → "computer" ≠ "phone"
   ["phone","gold","iphone"] → "phone" = "phone" → count++

→ Result = 2 ✅
```

---

### 📐 Complexity

| Aspect    | Value                            |
| --------- | -------------------------------- |
| Time      | O(n) (single pass through items) |
| Space     | O(1) (constant extra space)      |
| Technique | Index mapping + traversal        |

---

### 🔁 Pattern

- Attribute-based filtering
- Map string keys to indices
- Count matches in linear time

---

### 🚀 Alternative Approaches

- **HashMap for ruleKey → index**:
  - Cleaner mapping instead of if-else.
- **Streams (Java 8+)**:
  - `items.stream().filter(item -> item.get(index).equals(ruleValue)).count();`

---

### ⚠️ Edge Cases

- No matches → return `0`.
- All items match → return `items.length`.
- Single item → works naturally.

🔗 [LeetCode – Count Items Matching a Rule](https://leetcode.com/problems/count-items-matching-a-rule)

---
