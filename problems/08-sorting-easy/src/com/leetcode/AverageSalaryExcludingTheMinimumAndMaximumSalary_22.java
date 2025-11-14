/*
You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.

Example 1:
Input: salary = [4000,3000,1000,2000]
Output: 2500.00000
Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500

Example 2:
Input: salary = [1000,2000,3000]
Output: 2000.00000
Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
Average salary excluding minimum and maximum salary is (2000) / 1 = 2000
 */

package com.leetcode;

import java.util.Arrays;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary_22 {
    public static void main(String[] args) {
        int[] salary = {1000,2000,3000};

        System.out.println(average(salary));
    }

    static double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int sal : salary) {
            sum += sal;
            if (sal > max) {
                max = sal;
            }
            if (sal < min) {
                min = sal;
            }
        }
        return (double) (sum - max - min) / (salary.length - 2);


//        Arrays.sort(salary);
//        int sum = 0;
//        for (int i = 1; i < salary.length - 1; i++) {
//            sum += salary[i];
//        }
//
//        return (double) sum / (salary.length - 2);
    }
}
