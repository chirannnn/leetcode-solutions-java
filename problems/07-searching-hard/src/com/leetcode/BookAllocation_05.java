/*
Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: If it is not possible to allocate books to all students, return -1.

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
=> [12] and [34, 67, 90] Maximum Pages = 191
=> [12, 34] and [67, 90] Maximum Pages = 157
=> [12, 34, 67] and [90] Maximum Pages = 113.
The third combination has the minimum pages assigned to a student which is 113.


Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.
 */

package com.leetcode;

public class BookAllocation_05 {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;

        System.out.println(findPages(arr, k));
    }

    /*
Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book.
You also have an integer k representing the number of students.

The goal:
----------
Distribute the books such that:
1️⃣ Each student gets at least one book.
2️⃣ Each student gets a contiguous sequence of books.
3️⃣ No book is assigned to more than one student.

We must minimize the **maximum number of pages** assigned to any student.

If there are fewer books than students, return -1.

---

🧩 Example 1:
--------------
Input: arr = [12, 34, 67, 90], k = 2

Possible Allocations:
---------------------
[12] | [34, 67, 90] → Max Pages = 191
[12, 34] | [67, 90] → Max Pages = 157
[12, 34, 67] | [90] → Max Pages = 113 ✅

So, the minimum possible maximum pages = **113**

---

🧠 Intuition:
-------------
We are searching for the **smallest maximum number of pages** a student can get.
This is a classic case for **Binary Search on Answer**.

Think of it like this:
- If a student can handle at most `mid` pages, can we allocate books to all students?
- If yes → try smaller `mid`
- If no → increase `mid`

---

🪜 Step-by-Step Approach:
--------------------------
1️⃣ Define the search space:
   - `start = max(arr)` → at least one student must take the largest book.
   - `end = sum(arr)` → one student takes all books.

2️⃣ Binary Search:
   - Guess `mid` = possible max pages per student.
   - Traverse books and assign pages to students greedily.
   - If pages exceed `mid`, assign to next student.

3️⃣ Check feasibility:
   - If number of students needed > k → not possible, move right (`start = mid + 1`)
   - Else → possible, move left (`end = mid`)

4️⃣ Return final minimized maximum pages (`end`).

---

✅ Example Trace:
-----------------
arr = [12, 34, 67, 90], k = 2
start = 90, end = 203
mid = 146 → possible
mid = 118 → possible
mid = 104 → not possible
✅ Answer = 113

---

⚙️ Complexity:
--------------
Time  → O(n log(sum(arr)))
Space → O(1)

---

✨ Summary:
-----------
This problem demonstrates the **Binary Search on Feasible Answer** technique:
- Define min/max possible range.
- Use greedy check to test feasibility.
- Narrow down the range efficiently.

It’s one of the most asked binary search pattern problems in interviews.
*/

    static int findPages(int[] arr, int k) {
        if (arr.length < k) {
            return -1; // Not enough books for students
        }

        int start = 0;
        int end = 0;

        // Find initial range
        for (int pages : arr) {
            start = Math.max(start, pages); // min possible max pages
            end += pages; // max possible max pages
        }

        // Binary search on possible answers
        while (start < end) {
            int mid = start + (end - start) / 2;

            int pages = 0;
            int students = 1;

            // Check if mid can be a feasible max limit
            for (int books : arr) {
                if (pages + books > mid) {
                    students++;
                    pages = books;
                } else {
                    pages += books;
                }
            }

            if (students > k) {
                start = mid + 1; // too small, need larger pages per student
            } else {
                end = mid; // possible, try smaller
            }
        }
        return end; // minimized maximum pages
    }
}

