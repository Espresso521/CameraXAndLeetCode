package com.kotaku.camerax2leetcode

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun leetcode1431() {
        /**
        There are n kids with candies. You are given an integer array candies,
        where each candies[i] represents the number of candies the ith kid has,
        and an integer extraCandies, denoting the number of extra candies that you have.
        Return a boolean array result of length n, where result[i] is true if,
        after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids,
        or false otherwise.
        Note that multiple kids can have the greatest number of candies.

        Input: candies = [2,3,5,1,3], extraCandies = 3
        Output: [true,true,true,false,true]
        Explanation: If you give all extraCandies to:
        - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
        - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
        - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
        - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
        - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
         */
        fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
            val ret = MutableList(candies.size) { false }
            val max = candies.max()
            println("candies.size is ${candies.size}, extraCandies is $extraCandies, max is $max")

            for (i in candies.indices) {
                if (candies[i] + extraCandies >= max) {
                    ret[i] = true
                }
            }

            return ret
        }

        val ret = kidsWithCandies(intArrayOf(2, 3, 5, 1, 3), 3)
        ret.forEachIndexed { i, v ->
            println("ret[$i] = $v")
        }
    }

    @Test
    fun leetcode605() {
        /**
        You have a long flowerbed in which some of the plots are planted, and some are not.
        However, flowers cannot be planted in adjacent plots.
        Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
        and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

        Example 1:
        Input: flowerbed = [1,0,0,0,1], n = 1
        Output: true

        Example 2:
        Input: flowerbed = [1,0,0,0,1], n = 2
        Output: false
         */
        fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
            if (flowerbed.size == 1) {
                return if (n > 1) false
                else if (n == 1) return flowerbed[0] == 0
                else return true
            }
            var can = 0
            for (i in flowerbed.indices) {
                if (flowerbed[i] == 1) continue
                val leftEmpty = if (i == 0) true else flowerbed[i - 1] == 0

                val rightEmpty = if (i == flowerbed.size - 1) true else flowerbed[i + 1] == 0

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1
                    can++
                }
            }
            return can >= n
        }

        val ret = canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2)
        println("ret is $ret")
    }

    @Test
    fun leetcode345() {
        /**
        Given a string s, reverse only all the vowels in the string and return it.
        The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

        Example 1:
        Input: s = "hello"
        Output: "holle"

        Example 2:
        Input: s = "leetcode"
        Output: "leotcede"
         */

        fun reverseVowels(s: String): String {
            val vowels = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
            val chars = s.toCharArray()
            var left = 0
            var right = chars.size - 1

            while (left < right) {
                if (chars[left] in vowels && chars[right] in vowels) {
                    val temp = chars[left]
                    chars[left] = chars[right]
                    chars[right] = temp
                    left++
                    right--
                } else if (chars[left] in vowels) {
                    right--
                } else {
                    left++
                }
            }

            return String(chars)
        }

        val ret = reverseVowels("leetcode")
        println("ret is $ret")

    }

    @Test
    fun leetcode151() {
        /**
        Given an input string s, reverse the order of the words.
        A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
        Return a string of the words in reverse order concatenated by a single space.
        Note that s may contain leading or trailing spaces or multiple spaces between two words.
        The returned string should only have a single space separating the words. Do not include any extra spaces.

        Example 1:
        Input: s = "the sky is blue"
        Output: "blue is sky the"

        Example 2:
        Input: s = "  hello world  "
        Output: "world hello"
        Explanation: Your reversed string should not contain leading or trailing spaces.

        Example 3:
        Input: s = "a good   example"
        Output: "example good a"
        Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
         **/
        fun reverseWords(s: String): String {
            //return s.trim().split(" ").reversed().filter { it.trim().isNotEmpty() }.joinToString(separator = " ")

            val wordsArray = s.trim().split(" ").reversed()
            wordsArray.forEach {
                println("words is $it ;")
            }

            return wordsArray.filter { it.trim().isNotEmpty() }.joinToString(separator = " ")
        }

        val ret = reverseWords("a good   example")
        println("ret is $ret")
    }

    @Test
    fun leetcode334() {
        /**
        Given an integer array nums, return true if there exists a triple of indices (i, j, k)
        such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

        Example 1:
        Input: nums = [1,2,3,4,5]
        Output: true
        Explanation: Any triplet where i < j < k is valid.

        Example 2:
        Input: nums = [5,4,3,2,1]
        Output: false
        Explanation: No triplet exists.

        Example 3:
        Input: nums = [2,1,5,0,4,6]
        Output: true
        Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
         */
        fun increasingTriplet(nums: IntArray): Boolean {
            var small = Int.MAX_VALUE
            var big = Int.MAX_VALUE

            for (num in nums) {
                if (num <= small) {
                    small = num
                } else if (num <= big) {
                    big = num
                } else {
                    return true
                }

                println("small is $small ; big is $big ")
            }

            return false
        }

        val ret = increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6))
        println("ret is $ret")
    }

    @Test
    fun leetcode443() {
        /**
        Given an array of characters chars, compress it using the following algorithm:
        Begin with an empty string s. For each group of consecutive repeating characters in chars:

        If the group's length is 1, append the character to s.
        Otherwise, append the character followed by the group's length.
        The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
        Note that group lengths that are 10 or longer will be split into multiple characters in chars.

        After you are done modifying the input array, return the new length of the array.
        You must write an algorithm that uses only constant extra space.

        Example 1:
        Input: chars = ["a","a","b","b","c","c","c"]
        Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
        Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
        */
        fun compress(chars: CharArray): Int {
            var writeIndex = 0
            var readIndex = 0

            while (readIndex < chars.size) {
                val currentChar = chars[readIndex]
                var count = 0

                while (readIndex < chars.size && chars[readIndex] == currentChar) {
                    readIndex++
                    count++
                }

                chars[writeIndex] = currentChar
                writeIndex++

                if (count > 1) {
                    val countChars = count.toString().toCharArray()
                    for (i in countChars.indices) {
                        chars[writeIndex] = countChars[i]
                        writeIndex++
                    }
                }
            }

            printCharArray(chars.toTypedArray())

            return writeIndex
        }

        val ret =
            compress(charArrayOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'))
        println("ret is $ret")

    }

    @Test
    fun leetcode283() {
        /**
        Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
        Note that you must do this in-place without making a copy of the array.

        Example 1:
        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]

        Example 2:
        Input: nums = [0]
        Output: [0]
        */
        fun moveZeroes(nums: IntArray): IntArray {
            if (nums.size == 1) {
                return nums
            }

            var left = 0
            var right = 0

            while (left < nums.size && nums[left] != 0) {
                left++
                right++
            }

            while (right < nums.size) {
                if (nums[right] == 0) {
                    right++
                } else {
                    nums[left++] = nums[right]
                    nums[right++] = 0
                }
            }

            return nums
        }

        val ret = moveZeroes(intArrayOf(0,1,0,3,12))
        printIntArray(ret.toTypedArray())

    }

    @Test
    fun leetcode392() {
        /***
        Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
        A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of
        the characters without disturbing the relative positions of the remaining characters.
        (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
        Example 1:
        Input: s = "abc", t = "ahbgdc"
        Output: true

        Example 2:
        Input: s = "axc", t = "ahbgdc"
        Output: false
        */

        fun isSubsequence(s: String, t: String): Boolean {
            var i = 0
            var j = 0

            while (i < s.length && j < t.length) {
                if (s[i] == t[j]) {
                    i++
                }
                j++
            }

            return i == s.length
        }

        val ret = isSubsequence("abc", "ahbgdc")
        println("ret is $ret")
    }

    @Test
    fun leetcode11() {
        /**
        You are given an integer array height of length n.
        There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
        Find two lines that together with the x-axis form a container, such that the container contains the most water.
        Return the maximum amount of water a container can store.

        Example 1:
        Input: height = [1,8,6,2,5,4,8,3,7]
        Output: 49
        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
        In this case, the max area of water (blue section) the container can contain is 49.
         */

        fun maxArea(height: IntArray): Int {
            var left = 0
            var right = height.size - 1
            var maxArea = 0

            while (left <= right) {
                val area = height[left].coerceAtMost(height[right]) * (right - left)
                if (height[right] > height[left]) {
                    left ++
                } else {
                    right--
                }
                maxArea = maxArea.coerceAtLeast(area)
            }

            return maxArea
        }

        val ret = maxArea(intArrayOf(1,8,6,2,5,4,8,3,7))
        println("ret is $ret")
    }

    @Test
    fun leetcode1679() {
        /**
        You are given an integer array nums and an integer k.
        In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
        Return the maximum number of operations you can perform on the array.

        Example 1:
        Input: nums = [1,2,3,4], k = 5
        Output: 2
        Explanation: Starting with nums = [1,2,3,4]:
        - Remove numbers 1 and 4, then nums = [2,3]
        - Remove numbers 2 and 3, then nums = []
        There are no more pairs that sum up to 5, hence a total of 2 operations.

        Example 2:
        Input: nums = [3,1,3,4,3], k = 6
        Output: 1
        Explanation: Starting with nums = [3,1,3,4,3]:
        - Remove the first two 3's, then nums = [1,4,3]
        There are no more pairs that sum up to 6, hence a total of 1 operation.
         */
        fun maxOperations(nums: IntArray, k: Int): Int {
            nums.sort()
            var left = 0
            var right = nums.size - 1
            var ret = 0

            while(left < right) {
                if(nums[left] + nums[right] == k) {
                    ret++
                    left++
                    right--
                } else if(nums[left] + nums[right] < k) {
                    left++
                } else if(nums[left] + nums[right] > k) {
                    right--
                }
            }

            return ret
        }

        val ret = maxOperations(intArrayOf(1,2,3,4), 5)
        println("ret is $ret")
    }

    private fun printCharArray(array: Array<Char>) {
        array.forEachIndexed { i, v ->
            println("chars[$i] = $v")
        }
    }

    private fun printIntArray(array: Array<Int>) {
        array.forEachIndexed { i, v ->
            println("Int[$i] = $v")
        }
    }

}