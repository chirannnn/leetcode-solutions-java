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

## 5. Sorting the Sentence

**Problem**:  
You are given a shuffled sentence `s` where each word has a **1-indexed position number** appended at the end.  
Reconstruct the original sentence by sorting words according to their position and removing the numbers.

---

### 🔍 Core Idea: Position Extraction + Array Placement

- Each word ends with a digit (`'1'`…`'9'`) representing its correct position.
- Extract the digit, convert it to an index (`digit - '1'`).
- Place the word (without digit) into the correct position in an array.
- Finally, join the words with spaces to form the original sentence.

---

### 🧠 Algorithm Breakdown

#### Step 1: Split Input

- `String[] words = s.split(" ");`
- Break sentence into individual words.

#### Step 2: Extract Position

- For each word:
  - Get last character → position digit.
  - Convert to index: `position - '1'`.
  - Remove digit: `word.substring(0, word.length()-1)`.

#### Step 3: Place Word

- Store pure word in `ans[index]`.

#### Step 4: Build Result

- Join array with spaces → `String.join(" ", ans)`.

---

### ✅ Example Walkthrough

```text
s = "is2 sentence4 This1 a3"

→ Split: ["is2","sentence4","This1","a3"]

→ Process:
   "is2" → position=2 → index=1 → word="is"
   "sentence4" → position=4 → index=3 → word="sentence"
   "This1" → position=1 → index=0 → word="This"
   "a3" → position=3 → index=2 → word="a"

→ ans = ["This","is","a","sentence"]

→ Result = "This is a sentence" ✅
```

```text
s = "Myself2 Me1 I4 and3"

→ Split: ["Myself2","Me1","I4","and3"]

→ Process:
   "Myself2" → index=1 → "Myself"
   "Me1" → index=0 → "Me"
   "I4" → index=3 → "I"
   "and3" → index=2 → "and"

→ ans = ["Me","Myself","and","I"]

→ Result = "Me Myself and I" ✅
```

---

### 📐 Complexity

| Aspect    | Value                            |
| --------- | -------------------------------- |
| Time      | O(n) (process each word once)    |
| Space     | O(n) (array for reordered words) |
| Technique | Index extraction + placement     |

---

### 🔁 Pattern

- Position-based reordering
- String parsing with suffix digits
- Array placement for reconstruction

---

### 🚀 Alternative Approaches

- **Sort with Comparator**:
  - Store words in a list, sort by last character digit.
- **Map-based Placement**:
  - Use `HashMap<position, word>` then build result.

---

### ⚠️ Edge Cases

- Single word → returns word itself.
- Already ordered → returns original sentence.
- Maximum 9 words → safe with char digit extraction.

🔗 [LeetCode – Sorting the Sentence](https://leetcode.com/problems/sorting-the-sentence)

---

## 6. Check If Two String Arrays Are Equivalent

**Problem**:  
Given two string arrays `word1[]` and `word2[]`, return `true` if they represent the same string, and `false` otherwise.  
A string is represented by concatenating all elements of the array in order.

---

### 🔍 Core Idea: Concatenate + Compare

- Concatenate all elements of `word1[]` into a single string.
- Concatenate all elements of `word2[]` into a single string.
- Compare the two strings for equality.
- If equal → return `true`, else → return `false`.

---

### 🧠 Algorithm Breakdown

#### Step 1: Build Strings

- Use `StringBuilder` for efficient concatenation.
- Append each element of `word1[]` → `s1`.
- Append each element of `word2[]` → `s2`.

#### Step 2: Compare

- Convert both builders to strings.
- Return `s1.equals(s2)`.

---

### ✅ Example Walkthrough

```text
word1 = ["ab","c"], word2 = ["a","bc"]

→ s1 = "abc"
→ s2 = "abc"
→ s1.equals(s2) → true ✅
```

```text
word1 = ["a","cb"], word2 = ["ab","c"]

→ s1 = "acb"
→ s2 = "abc"
→ s1.equals(s2) → false ✅
```

```text
word1 = ["abc","d","defg"], word2 = ["abcddefg"]

→ s1 = "abcddefg"
→ s2 = "abcddefg"
→ s1.equals(s2) → true ✅
```

---

### 📐 Complexity

| Aspect    | Value                                  |
| --------- | -------------------------------------- |
| Time      | O(n) (concatenate all characters once) |
| Space     | O(n) (two builders for strings)        |
| Technique | Concatenation + Equality Check         |

---

### 🔁 Pattern

- Concatenate arrays into strings
- Compare results directly
- Useful in problems where arrays represent sequences

---

### 🚀 Alternative Approaches

- **Two-pointer traversal**:
  - Traverse both arrays character by character without building full strings.
  - Saves space, still O(n) time.
- **Stream-based (Java 8+)**:
  - `String.join("", word1).equals(String.join("", word2))`.

---

### ⚠️ Edge Cases

- Single-element arrays → direct comparison.
- Different lengths but same concatenated string → still valid.
- Large arrays (up to 1000 words, each up to 1000 chars) → efficient with O(n).

🔗 [LeetCode – Check If Two String Arrays Are Equivalent](https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent)

---
