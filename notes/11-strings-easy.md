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

## 7. To Lower Case

**Problem**:  
Given a string `s`, return the string after replacing every uppercase letter with the same lowercase letter.

---

### 🔍 Core Idea: ASCII Conversion

- Uppercase letters `'A'`–`'Z'` have ASCII values `65`–`90`.
- Lowercase letters `'a'`–`'z'` have ASCII values `97`–`122`.
- The difference between uppercase and lowercase is **32**.
- So, to convert uppercase → lowercase: `ch[i] = (char)(ch[i] + 32)`.
- Traverse the string, convert each uppercase character, and rebuild the string.

---

### 🧠 Algorithm Breakdown

#### Step 1: Convert String to Char Array

- `char[] ch = s.toCharArray();`

#### Step 2: Traverse Characters

- For each character:
  - If `ch[i]` is between `'A'` and `'Z'`, convert to lowercase by adding 32.
  - Else, leave unchanged.

#### Step 3: Build Result

- Return new string from modified char array.

---

### ✅ Example Walkthrough

```text
s = "Hello"

→ Traverse:
   'H' → 'h'
   'e' → 'e'
   'l' → 'l'
   'l' → 'l'
   'o' → 'o'

→ Result = "hello" ✅
```

```text
s = "here"

→ All lowercase already → unchanged
→ Result = "here" ✅
```

```text
s = "LOVELY"

→ Traverse:
   'L' → 'l'
   'O' → 'o'
   'V' → 'v'
   'E' → 'e'
   'L' → 'l'
   'Y' → 'y'

→ Result = "lovely" ✅
```

---

### 📐 Complexity

| Aspect    | Value                             |
| --------- | --------------------------------- |
| Time      | O(n) (scan through string once)   |
| Space     | O(n) (char array + result string) |
| Technique | ASCII manipulation                |

---

### 🔁 Pattern

- Character-by-character transformation
- ASCII arithmetic for case conversion
- Generalizable to other transformations (e.g., uppercase, digit shifts)

---

### 🚀 Alternative Approaches

- **Built-in Method**:
  - `return s.toLowerCase();` (simpler, uses library function).
- **Streams (Java 8+)**:
  - Convert to stream of chars, map to lowercase, collect.

---

### ⚠️ Edge Cases

- Empty string → returns empty string.
- Already lowercase → unchanged.
- Mixed case → only uppercase letters converted.
- Length up to 100 → efficient.

🔗 [LeetCode – To Lower Case](https://leetcode.com/problems/to-lower-case)

---

## 8. Determine If String Halves Are Alike

**Problem**:  
Given a string `s` of even length, split it into two halves `a` and `b`.  
Return `true` if both halves contain the same number of vowels (`a, e, i, o, u` in both cases).  
Otherwise, return `false`.

---

### 🔍 Core Idea: Count Vowels in Each Half

- Split string into two halves:
  - `a = s[0 … mid-1]`
  - `b = s[mid … n-1]`
- Count vowels in each half.
- Compare counts → if equal, return `true`.

---

### 🧠 Algorithm Breakdown

#### Step 1: Split String

- `int mid = n / 2;`
- First half: indices `[0 … mid-1]`
- Second half: indices `[mid … n-1]`

#### Step 2: Count Vowels

- Helper function `vowelsCount(s, start, end)` counts vowels in substring.
- Check if character exists in `"aeiouAEIOU"`.

#### Step 3: Compare Counts

- If counts are equal → halves are alike.
- Else → not alike.

---

### ✅ Example Walkthrough

```text
s = "book"

→ n=4, mid=2
→ a = "bo", b = "ok"
→ vowelsCount("bo") = 1 ('o')
→ vowelsCount("ok") = 1 ('o')
→ Equal → true ✅
```

```text
s = "textbook"

→ n=8, mid=4
→ a = "text", b = "book"
→ vowelsCount("text") = 1 ('e')
→ vowelsCount("book") = 2 ('o','o')
→ Not equal → false ✅
```

```text
s = "Failure"

→ n=7 (⚠️ odd length, but constraint says even length)
→ If adjusted to even input, works correctly.
```

---

### 📐 Complexity

| Aspect    | Value                           |
| --------- | ------------------------------- |
| Time      | O(n) (scan through string once) |
| Space     | O(1) (constant extra space)     |
| Technique | Vowel counting                  |

---

### 🔁 Pattern

- String splitting into halves
- Character classification (vowel vs consonant)
- Counting and comparing values

---

### 🚀 Alternative Approaches

- **Single-pass comparison**:
  - Traverse both halves simultaneously, increment/decrement a counter.
  - If final count = 0 → halves are alike.
- **Regex-based counting**:
  - Use regex to count vowels in substrings (less efficient).

---

### ⚠️ Edge Cases

- All vowels → both halves equal.
- No vowels → both halves equal (count=0).
- Mixed case letters → handled since both uppercase and lowercase vowels are checked.
- Input length must be even (constraint ensures this).

🔗 [LeetCode – Determine if String Halves Are Alike](https://leetcode.com/problems/determine-if-string-halves-are-alike)

---

## 9. Decrypt String from Alphabet to Integer Mapping

**Problem**:  
You are given a string `s` formed by digits and `'#'`.  
Mapping rules:

- `'1'` → `'a'`, `'2'` → `'b'`, … `'9'` → `'i'`
- `'10#'` → `'j'`, `'11#'` → `'k'`, … `'26#'` → `'z'`  
  Return the decoded string.

---

### 🔍 Core Idea: Reverse Traversal + Conditional Mapping

- Traverse the string **from right to left**.
- If current character is `'#'`:
  - Take the two digits before it → form number (10–26).
  - Convert to corresponding letter.
  - Skip those two digits.
- Else:
  - Single digit (1–9) → convert directly.
- Append characters to a builder, then reverse at the end.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `StringBuilder ans` to store decoded characters.
- Start loop from `n-1` down to `0`.

#### Step 2: Check Character

- If `s.charAt(i) == '#'`:
  - Extract two digits before `i`.
  - Compute number: `(s[i-2]-'0')*10 + (s[i-1]-'0')`.
  - Convert: `(char)('a' + num - 1)`.
  - Move `i -= 2`.
- Else:
  - Single digit → `(char)('a' + (s[i]-'0') - 1)`.

#### Step 3: Reverse Result

- Since we processed backwards, reverse builder before returning.

---

### ✅ Example Walkthrough

```text
s = "10#11#12"

→ Traverse from right:
   '2' → 'b'
   '1' → 'a'
   "11#" → 'k'
   "10#" → 'j'

→ ans = "bakj"
→ Reverse → "jkab" ✅
```

```text
s = "1326#"

→ Traverse:
   "26#" → 'z'
   '3' → 'c'
   '1' → 'a'

→ ans = "zca"
→ Reverse → "acz" ✅
```

---

### 📐 Complexity

| Aspect    | Value                                |
| --------- | ------------------------------------ |
| Time      | O(n) (single pass through string)    |
| Space     | O(n) (builder for result)            |
| Technique | Reverse traversal + ASCII conversion |

---

### 🔁 Pattern

- Reverse traversal for multi-character tokens (`10#`–`26#`)
- ASCII arithmetic for mapping digits → letters
- Common in decoding/encoding problems

---

### 🚀 Alternative Approaches

- **Forward traversal with lookahead**:
  - Check if next two characters + `'#'` form a valid mapping.
- **Regex replacement**:
  - Replace `\d\d#` with mapped letters, then single digits.
- **Stack-based decoding**:
  - Push characters, pop when encountering `'#'`.

---

### ⚠️ Edge Cases

- Only single digits → maps to `'a'`–`'i'`.
- Only `'#'` mappings → maps to `'j'`–`'z'`.
- Mixed cases → handled naturally.
- Length up to 1000 → efficient with O(n).

🔗 [LeetCode – Decrypt String from Alphabet to Integer Mapping](https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping)

---

## 10. Number of Strings That Appear as Substrings in Word

**Problem**:  
Given an array of strings `patterns[]` and a string `word`, return the number of strings in `patterns` that exist as substrings in `word`.

---

### 🔍 Core Idea: Substring Checking

- For each string in `patterns[]`, check if it exists inside `word`.
- Use `word.contains(str)` to test substring presence.
- Count how many patterns match.
- Return the count.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize Counter

- `int count = 0;`

#### Step 2: Traverse Patterns

- For each `str` in `patterns`:
  - If `word.contains(str)` → increment `count`.

#### Step 3: Return Result

- Return `count`.

---

### ✅ Example Walkthrough

```text
patterns = ["a","abc","bc","d"], word = "abc"

→ Check:
   "a" → yes
   "abc" → yes
   "bc" → yes
   "d" → no

→ Count = 3 ✅
```

```text
patterns = ["a","b","c"], word = "aaaaabbbbb"

→ Check:
   "a" → yes
   "b" → yes
   "c" → no

→ Count = 2 ✅
```

```text
patterns = ["a","a","a"], word = "ab"

→ Check:
   "a" → yes
   "a" → yes
   "a" → yes

→ Count = 3 ✅
```

---

### 📐 Complexity

| Aspect    | Value                                                                        |
| --------- | ---------------------------------------------------------------------------- |
| Time      | O(n · m) (n = patterns length, m = word length, substring check per pattern) |
| Space     | O(1) (constant extra space)                                                  |
| Technique | Substring search                                                             |

---

### 🔁 Pattern

- Direct substring checking
- Useful in problems involving pattern matching
- Can generalize to searching multiple substrings in text

---

### 🚀 Alternative Approaches

- **Regex Matching**: Combine patterns into a regex and count matches.
- **KMP Algorithm / Rabin-Karp**: Efficient substring search for larger inputs.
- **Set-based Counting**: If duplicates in `patterns` matter, count each occurrence separately (as in Example 3).

---

### ⚠️ Edge Cases

- Duplicate patterns → each occurrence is counted separately.
- No matches → return `0`.
- Word shorter than some patterns → those patterns cannot match.
- Maximum constraints (100 patterns, each up to 100 chars, word length up to 100) → still efficient with `contains`.

🔗 [LeetCode – Number of Strings That Appear as Substrings in Word](https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word)

---

## 11. Robot Return to Origin

**Problem**:  
A robot starts at position `(0,0)` on a 2D plane. Given a string `moves` consisting of `'U'`, `'D'`, `'L'`, `'R'`, determine if the robot returns to the origin after executing all moves.

- `'U'` → move up
- `'D'` → move down
- `'L'` → move left
- `'R'` → move right

Return `true` if robot ends at `(0,0)`, else `false`.

---

### 🔍 Core Idea: Coordinate Tracking

- Represent robot’s position with `(x,y)`.
- Initialize at `(0,0)`.
- For each move:
  - `'U'` → increment `x`
  - `'D'` → decrement `x`
  - `'R'` → increment `y`
  - `'L'` → decrement `y`
- After all moves, check if `(x,y) == (0,0)`.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `x = 0, y = 0`

#### Step 2: Traverse Moves

- For each character in `moves`:
  - Update coordinates based on direction.

#### Step 3: Check Origin

- If `x == 0 && y == 0` → return `true`.
- Else → return `false`.

---

### ✅ Example Walkthrough

```text
moves = "UD"

→ Start (0,0)
   'U' → (1,0)
   'D' → (0,0)

→ End = (0,0) → true ✅
```

```text
moves = "LL"

→ Start (0,0)
   'L' → (0,-1)
   'L' → (0,-2)

→ End = (0,-2) → false ✅
```

```text
moves = "URDL"

→ Start (0,0)
   'U' → (1,0)
   'R' → (1,1)
   'D' → (0,1)
   'L' → (0,0)

→ End = (0,0) → true ✅
```

---

### 📐 Complexity

| Aspect    | Value                          |
| --------- | ------------------------------ |
| Time      | O(n) (scan through moves once) |
| Space     | O(1) (constant variables)      |
| Technique | Coordinate tracking            |

---

### 🔁 Pattern

- Movement simulation on a grid
- Tracking coordinates with counters
- Common in path-following and robot problems

---

### 🚀 Alternative Approaches

- **Count-based method**:
  - Count `'U'` vs `'D'`, and `'L'` vs `'R'`.
  - If counts match for both directions → return `true`.
- **Vector-based approach**:
  - Treat moves as vectors, sum them, check if result is `(0,0)`.

---

### ⚠️ Edge Cases

- Empty string → robot stays at origin → `true`.
- Only one move → always `false`.
- Long sequences (up to 20,000 moves) → still efficient with O(n).

🔗 [LeetCode – Robot Return to Origin](https://leetcode.com/problems/robot-return-to-origin)

---

## 12. Reverse Words in a String III

**Problem**:  
Given a string `s`, reverse the characters of each word while preserving:

- Whitespace between words
- Original word order

Return the transformed string.

---

### 🔍 Core Idea: Reverse Each Word Individually

- Words are separated by spaces.
- For each word: reverse its characters.
- Keep spaces and word order intact.
- Two approaches:
  1. **In-place reversal** using character array.
  2. **Split + reverse** using `StringBuilder`.

---

### 🧠 Algorithm Breakdown

#### Method 1: In-place Reversal

1. Convert string to `char[] arr`.
2. Traverse array with index `i`.
3. When encountering a space or end of string:
   - Reverse the segment `[start … i-1]`.
   - Update `start = i+1`.
4. Return new string from modified array.

#### Method 2: Split + Reverse

1. Split string by spaces → `String[] arr`.
2. For each word: reverse using `StringBuilder.reverse()`.
3. Join words back with spaces.
4. Return result.

---

### ✅ Example Walkthrough

```text
s = "Let's take LeetCode contest"

→ Split words: ["Let's","take","LeetCode","contest"]

→ Reverse each:
   "Let's" → "s'teL"
   "take" → "ekat"
   "LeetCode" → "edoCteeL"
   "contest" → "tsetnoc"

→ Result = "s'teL ekat edoCteeL tsetnoc" ✅
```

```text
s = "Mr Ding"

→ Split words: ["Mr","Ding"]

→ Reverse each:
   "Mr" → "rM"
   "Ding" → "gniD"

→ Result = "rM gniD" ✅
```

---

### 📐 Complexity

| Aspect    | Value                                |
| --------- | ------------------------------------ |
| Time      | O(n) (each character processed once) |
| Space     | O(n) (char array or split array)     |
| Technique | Word-by-word reversal                |

---

### 🔁 Pattern

- String manipulation by word boundaries
- In-place reversal vs split-and-reverse
- Preserving structure while transforming content

---

### 🚀 Alternative Approaches

- **Stack-based reversal**: push characters until space, then pop.
- **Regex split**: split by `\\s+` for flexible whitespace handling.
- **Stream-based (Java 8+)**: map each word to reversed form, then join.

---

### ⚠️ Edge Cases

- Single word → reversed entirely.
- Multiple spaces not allowed (constraint ensures single space).
- Very long string (up to 50,000 chars) → efficient with O(n).
- No leading/trailing spaces → simplifies logic.

🔗 [LeetCode – Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii)

---

## 13. Excel Sheet Column Title

**Problem**:  
Given an integer `columnNumber`, return its corresponding Excel column title.  
Mapping rules:

- `1 → A`, `2 → B`, … `26 → Z`
- `27 → AA`, `28 → AB`, …
- Essentially, this is a **base-26 number system** but with letters `A–Z` instead of digits.

---

### 🔍 Core Idea: Base-26 Conversion with Offset

- Excel columns behave like a **1-indexed base-26 system**.
- Subtract 1 before modulo to handle offset (`A=1` not `0`).
- Compute remainder → map to letter (`'A' + remainder`).
- Divide columnNumber by 26 → continue until 0.
- Reverse the result since we build from least significant digit.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `StringBuilder ans = new StringBuilder();`

#### Step 2: Loop Until Zero

- While `columnNumber > 0`:
  - Decrement `columnNumber` by 1 (to adjust offset).
  - Compute remainder: `columnNumber % 26`.
  - Convert to letter: `(char)('A' + remainder)`.
  - Append to builder.
  - Update `columnNumber = columnNumber / 26`.

#### Step 3: Reverse Result

- Reverse builder → final column title.

---

### ✅ Example Walkthrough

```text
columnNumber = 1
→ columnNumber-- → 0
→ remainder = 0 → 'A'
→ Result = "A" ✅
```

```text
columnNumber = 28
→ Step 1: columnNumber=27 → remainder=1 → 'B'
→ Step 2: columnNumber=1 → remainder=0 → 'A'
→ Result = "AB" ✅
```

```text
columnNumber = 701
→ Step 1: columnNumber=700 → remainder=24 → 'Y'
→ Step 2: columnNumber=26 → remainder=25 → 'Z'
→ Result = "ZY" ✅
```

---

### 📐 Complexity

| Aspect    | Value                                         |
| --------- | --------------------------------------------- |
| Time      | O(log₍26₎ n) (loop runs per digit in base-26) |
| Space     | O(1) (builder + result string)                |
| Technique | Base-26 conversion with offset                |

---

### 🔁 Pattern

- Similar to converting numbers into another base system.
- Offset adjustment because Excel columns start at 1, not 0.
- Reverse at the end since digits are built backwards.

---

### 🚀 Alternative Approaches

- **Recursive solution**:
  - Recurse until `columnNumber == 0`, build string from remainder.
- **Mathematical approach**:
  - Directly compute letters without reversing, but more complex.

---

### ⚠️ Edge Cases

- Smallest input (`1`) → `"A"`.
- Largest input (`2³¹ - 1`) → still works with loop.
- Multiples of 26 (like `26`, `52`, `702`) → correctly map to `"Z"`, `"AZ"`, `"ZZ"`.

🔗 [LeetCode – Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title)

---

## 14. Find the Index of the First Occurrence in a String

**Problem**:  
Given two strings `haystack` and `needle`, return the index of the first occurrence of `needle` in `haystack`.  
If `needle` is not found, return `-1`.

---

### 🔍 Core Idea: Substring Search

- Traverse `haystack` and check substrings of length `m = needle.length()`.
- If substring matches `needle`, return starting index.
- If no match found, return `-1`.
- Multiple approaches possible: manual comparison, substring method, or built-in `indexOf`.

---

### 🧠 Algorithm Breakdown

#### Method 1: Manual Comparison (Implemented)

1. Get lengths: `n = haystack.length()`, `m = needle.length()`.
2. If `m > n`, return `-1`.
3. For each index `i` from `0` to `n-m`:
   - Compare characters of `haystack[i…i+m-1]` with `needle`.
   - If all match → return `i`.
4. If no match → return `-1`.

#### Method 2: Substring Comparison

- For each index `i`:
  - Extract substring `haystack.substring(i, i+m)`.
  - Compare with `needle`.
  - If equal → return `i`.

#### Method 3: Built-in Function

- Directly use `haystack.indexOf(needle)`.

---

### ✅ Example Walkthrough

```text
haystack = "sadbutsad", needle = "sad"

→ Check substrings:
   "sad" at index 0 → match → return 0 ✅
```

```text
haystack = "leetcode", needle = "leeto"

→ Check substrings:
   No match found → return -1 ✅
```

---

### 📐 Complexity

| Aspect    | Value                                 |
| --------- | ------------------------------------- |
| Time      | O(n·m) worst case (manual comparison) |
| Space     | O(1) (constant extra space)           |
| Technique | Substring search                      |

---

### 🔁 Pattern

- Classic substring search problem
- Variants: naive search, KMP algorithm, Rabin-Karp
- Useful in text processing and pattern matching

---

### 🚀 Alternative Approaches

- **KMP Algorithm**: O(n+m), efficient for large strings.
- **Rabin-Karp**: Hash-based substring search.
- **Built-in indexOf**: Simplest, optimized internally.

---

### ⚠️ Edge Cases

- `needle` longer than `haystack` → return `-1`.
- `needle` empty → usually return `0` (but here constraints ensure length ≥ 1).
- Multiple occurrences → return first index only.

🔗 [LeetCode – Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string)

---

## 15. Long Pressed Name

**Problem**:  
You are given two strings:

- `name` → the intended string.
- `typed` → the actual typed string (may contain long-pressed characters).

Return `true` if `typed` could be produced from `name` by long-pressing some characters, otherwise `false`.

---

### 🔍 Core Idea: Two-Pointer Traversal

- Use two pointers:
  - `i` → index for `name`.
  - `j` → index for `typed`.
- Traverse `typed`:
  - If `name[i] == typed[j]` → move both pointers forward.
  - Else if `typed[j] == typed[j-1]` → long press detected → move `j` forward only.
  - Else → mismatch → return `false`.
- At the end, check if all characters in `name` were matched (`i == n`).

---

### 🧠 Algorithm Breakdown

#### Step 1: Length Check

- If `name.length() > typed.length()` → impossible → return `false`.

#### Step 2: Traverse with Two Pointers

- While `j < typed.length()`:
  - Case 1: Characters match → increment both `i` and `j`.
  - Case 2: Long press → `typed[j] == typed[j-1]` → increment `j`.
  - Case 3: Mismatch → return `false`.

#### Step 3: Final Validation

- Return `true` only if `i == name.length()` (all characters matched).

---

### ✅ Example Walkthrough

```text
name = "alex", typed = "aaleex"

→ Compare:
   'a' vs 'a' → match → i=1, j=1
   'l' vs 'a' → long press → j=2
   'l' vs 'l' → match → i=2, j=3
   'e' vs 'e' → match → i=3, j=4
   'x' vs 'e' → long press → j=5
   'x' vs 'x' → match → i=4, j=6

→ i == n → true ✅
```

```text
name = "saeed", typed = "ssaaedd"

→ Compare:
   's' vs 's' → match
   'a' vs 's' → long press
   'a' vs 'a' → match
   'e' vs 'a' → long press
   'e' vs 'e' → match
   'e' vs 'd' → mismatch → false ✅
```

---

### 📐 Complexity

| Aspect    | Value                       |
| --------- | --------------------------- |
| Time      | O(m) (scan through `typed`) |
| Space     | O(1) (constant extra space) |
| Technique | Two-pointer traversal       |

---

### 🔁 Pattern

- Two-pointer matching problems
- Handling duplicates or extended sequences (long press, repeated chars)
- Validation by consuming both strings in sync

---

### 🚀 Alternative Approaches

- **Group comparison**: Compare consecutive character groups in `name` and `typed`.
- **Regex-based**: Build regex from `name` allowing repeats, match against `typed` (less efficient).

---

### ⚠️ Edge Cases

- `typed` shorter than `name` → always false.
- Exact match → true.
- All characters long pressed → still valid.
- Different characters → false immediately.

🔗 [LeetCode – Long Pressed Name](https://leetcode.com/problems/long-pressed-name)

---

## 16. Valid Palindrome

**Problem**:  
Given a string `s`, determine if it is a palindrome after:

- Converting all uppercase letters to lowercase.
- Removing all non-alphanumeric characters.  
  Return `true` if the cleaned string reads the same forward and backward.

---

### 🔍 Core Idea: Two-Pointer Check

- Palindrome check requires comparing characters from both ends.
- Skip non-alphanumeric characters.
- Compare lowercase versions of valid characters.
- If mismatch → return `false`.
- If all match → return `true`.

---

### 🧠 Algorithm Breakdown

#### Method 1: Two-Pointer Traversal (Efficient)

1. Initialize two pointers: `i = 0`, `j = s.length()-1`.
2. While `i < j`:
   - Skip non-alphanumeric characters using `Character.isLetterOrDigit()`.
   - Compare lowercase characters at `i` and `j`.
   - If mismatch → return `false`.
   - Move inward (`i++`, `j--`).
3. Return `true` if all pairs matched.

#### Method 2: String Filtering + Reverse (Simpler)

1. Convert string to lowercase.
2. Build a new string with only alphanumeric characters.
3. Compare the string with its reverse.
4. Return `true` if equal, else `false`.

---

### ✅ Example Walkthrough

```text
s = "A man, a plan, a canal: Panama"

→ Cleaned: "amanaplanacanalpanama"
→ Compare forward/backward → same → true ✅
```

```text
s = "race a car"

→ Cleaned: "raceacar"
→ Compare forward/backward → mismatch → false ✅
```

```text
s = " "

→ Cleaned: "" (empty string)
→ Empty string is palindrome → true ✅
```

---

### 📐 Complexity

| Aspect    | Value                                                  |
| --------- | ------------------------------------------------------ |
| Time      | O(n) (scan through string once)                        |
| Space     | O(1) for two-pointer method, O(n) for filtering method |
| Technique | Two-pointer traversal / string reverse                 |

---

### 🔁 Pattern

- Palindrome checking with preprocessing
- Two-pointer technique for efficiency
- Filtering + reverse for simplicity

---

### 🚀 Alternative Approaches

- **Regex filtering**: `s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase()` then check palindrome.
- **Recursive check**: Compare ends recursively (less efficient).

---

### ⚠️ Edge Cases

- Empty string → always palindrome.
- String with only non-alphanumeric characters → palindrome (becomes empty).
- Mixed case letters → handled by lowercase conversion.
- Very long string (up to 200,000 chars) → efficient with O(n).

🔗 [LeetCode – Valid Palindrome](https://leetcode.com/problems/valid-palindrome)

---

## 17. Valid Palindrome II

**Problem**:  
Given a string `s`, return `true` if it can be a palindrome after deleting **at most one character**.  
Otherwise, return `false`.

---

### 🔍 Core Idea: Two-Pointer Check with One Skip

- Use two pointers (`i` at start, `j` at end).
- Traverse inward:
  - If characters match → move both pointers.
  - If mismatch → try deleting one character:
    - Either skip `s[i]` or skip `s[j]`.
    - Check if the remaining substring is a palindrome.
- If either option works → return `true`.
- Else → return `false`.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `i = 0`, `j = s.length()-1`.

#### Step 2: Traverse

- While `i < j`:
  - If `s[i] == s[j]` → move inward (`i++`, `j--`).
  - Else → check two cases:
    - `isPalin(s, i, j-1)` (skip right char).
    - `isPalin(s, i+1, j)` (skip left char).
  - If either is true → return `true`.
  - Otherwise → return `false`.

#### Step 3: Helper Function

- `isPalin(s, start, end)` → standard palindrome check between indices.

---

### ✅ Example Walkthrough

```text
s = "aba"

→ Compare:
   'a' == 'a' → ok
   'b' → center → palindrome
→ Result = true ✅
```

```text
s = "abca"

→ Compare:
   'a' == 'a' → ok
   'b' != 'c' → mismatch
   Check skip:
      isPalin("abc", i=1, j=2) → "bc" → false
      isPalin("aca", i=0, j=2) → "aca" → true
→ Result = true ✅
```

```text
s = "abc"

→ Compare:
   'a' != 'c' → mismatch
   Check skip:
      isPalin("ab") → false
      isPalin("bc") → false
→ Result = false ✅
```

---

### 📐 Complexity

| Aspect    | Value                                                   |
| --------- | ------------------------------------------------------- |
| Time      | O(n) (single pass + at most one extra palindrome check) |
| Space     | O(1) (constant extra space)                             |
| Technique | Two-pointer traversal with conditional skip             |

---

### 🔁 Pattern

- Palindrome validation with tolerance (skip one mismatch).
- Two-pointer technique for efficiency.
- Generalizable to problems like "valid palindrome after k deletions".

---

### 🚀 Alternative Approaches

- **Recursive check**: On mismatch, recurse with one deletion allowed.
- **Dynamic programming**: Check longest palindromic subsequence, but overkill here.
- **Greedy two-pointer**: Most efficient and simplest.

---

### ⚠️ Edge Cases

- Single character → always true.
- Already a palindrome → true.
- One mismatch → true if skipping fixes it.
- Multiple mismatches → false.
- Very long string (up to 100,000 chars) → efficient with O(n).

🔗 [LeetCode – Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii)

---

## 18. Longest Common Prefix

**Problem**:  
Given an array of strings `strs`, return the longest common prefix among them.  
If no common prefix exists, return `""`.

---

### 🔍 Core Idea: Iterative Prefix Shrinking

- Start with the first string as the initial prefix.
- For each subsequent string:
  - While it doesn’t start with the current prefix, shrink the prefix by removing its last character.
- If prefix becomes empty → return `""`.
- Otherwise, return the final prefix.

---

### 🧠 Algorithm Breakdown

#### Step 1: Initialize

- `prefix = strs[0]`

#### Step 2: Compare with Each String

- For each string in `strs[1…n-1]`:
  - While `!strs[i].startsWith(prefix)`:
    - Shrink prefix → `prefix = prefix.substring(0, prefix.length()-1)`
  - If prefix becomes empty → return `""`.

#### Step 3: Return Result

- After loop, return `prefix`.

---

### ✅ Example Walkthrough

```text
strs = ["flower","flow","flight"]

→ prefix = "flower"
→ Compare with "flow":
   "flower" not prefix → shrink → "flowe" → "flow" → match
→ Compare with "flight":
   "flow" not prefix → shrink → "flo" → "fl" → match
→ Result = "fl" ✅
```

```text
strs = ["dog","racecar","car"]

→ prefix = "dog"
→ Compare with "racecar":
   shrink → "do" → "d" → "" → stop
→ Result = "" ✅
```

---

### 📐 Complexity

| Aspect    | Value                                                         |
| --------- | ------------------------------------------------------------- |
| Time      | O(n·m) (n = number of strings, m = length of shortest string) |
| Space     | O(1) (prefix string only)                                     |
| Technique | Iterative prefix shrinking                                    |

---

### 🔁 Pattern

- Common prefix problems → shrink until match.
- Similar to string matching in trie-based solutions.
- Useful in problems involving shared substrings.

---

### 🚀 Alternative Approaches

- **Vertical scanning**: Compare characters column by column across all strings.
- **Divide and conquer**: Split array, find prefix in halves, merge results.
- **Trie-based solution**: Insert all strings into a trie, traverse until mismatch.

---

### ⚠️ Edge Cases

- Single string → return itself.
- Empty array → return `""`.
- No common prefix → return `""`.
- All identical strings → return that string.

🔗 [LeetCode – Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix)

---

## 19. Maximum Repeating Substring

**Problem**:  
For a given string `sequence` and a string `word`:

- A string is **k-repeating** if `word` concatenated `k` times is a substring of `sequence`.
- The maximum k-repeating value is the largest `k` for which this holds true.
- If `word` is not a substring at all → return `0`.

---

### 🔍 Core Idea: Count Consecutive Repetitions

- Traverse `sequence` and check for consecutive occurrences of `word`.
- For each starting index, count how many times `word` repeats continuously.
- Track the maximum repetition count.
- Return the maximum.

---

### 🧠 Algorithm Breakdown

#### Method 1: Substring Scanning (Preferred)

1. Initialize `maxRepeat = 0`.
2. For each index `i` in `sequence`:
   - Start from `j = i`.
   - While substring `sequence[j…j+m] == word`:
     - Increment `temp` (repetition count).
     - Move `j += m`.
   - Update `maxRepeat = max(maxRepeat, temp)`.
3. Return `maxRepeat`.

#### Method 2: Incremental Concatenation (Simpler but less efficient)

1. Start with `repeat = word`.
2. While `sequence.contains(repeat)`:
   - Increment `k`.
   - Append another `word` to `repeat`.
3. Return `k`.

---

### ✅ Example Walkthrough

```text
sequence = "ababc", word = "ab"

→ Check:
   "ab" at index 0 → repeat once
   "abab" at index 0 → repeat twice
   "ababc" contains "abab" → maxRepeat = 2
→ Result = 2 ✅
```

```text
sequence = "ababc", word = "ba"

→ Check:
   "ba" at index 1 → repeat once
   "baba" not found
→ Result = 1 ✅
```

```text
sequence = "ababc", word = "ac"

→ "ac" not found anywhere
→ Result = 0 ✅
```

---

### 📐 Complexity

| Method         | Time Complexity   | Space Complexity | Notes                       |
| -------------- | ----------------- | ---------------- | --------------------------- |
| Substring scan | O(n·m) worst case | O(1)             | Efficient for small strings |
| Concatenation  | O(k·n)            | O(k·m)           | Simpler but less efficient  |

---

### 🔁 Pattern

- Repetition detection in strings
- Substring scanning with sliding window
- Useful in problems involving repeated patterns or periodic substrings

---

### 🚀 Alternative Approaches

- **Regex matching**: Build pattern `(word)+` and check longest match.
- **KMP algorithm**: Efficient substring search for larger inputs.
- **Dynamic programming**: Track repetition counts, though overkill here.

---

### ⚠️ Edge Cases

- `word` not in `sequence` → return `0`.
- `sequence` shorter than `word` → return `0`.
- `word` repeats partially but not fully → only full matches count.
- Multiple overlapping matches → only consecutive repetition counts matter.

🔗 [LeetCode – Maximum Repeating Substring](https://leetcode.com/problems/maximum-repeating-substring)

---
