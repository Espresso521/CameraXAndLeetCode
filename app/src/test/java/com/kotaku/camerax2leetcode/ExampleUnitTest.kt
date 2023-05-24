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