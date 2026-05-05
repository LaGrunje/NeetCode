class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        var dictionary: IntArray = IntArray(26) { 0 }
        for (ind in s.indices) {
            dictionary[s[ind] - 'a']++
            dictionary[t[ind] - 'a']--
        }

        for (elem in dictionary) {
            if (elem != 0) return false
        }

        return true;
    }
}

fun main() = println("Kotlin solution - valid anagram")