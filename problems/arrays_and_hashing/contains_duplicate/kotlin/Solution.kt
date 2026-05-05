class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val duplicates: MutableSet<Int> = mutableSetOf()
        for (elem in nums) {
            if (elem in duplicates)
                return true
            duplicates.add(elem)
        }
        return false
    }
}

fun main() = println("Kotlin solution - contains duplicates")