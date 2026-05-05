class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val dict: Map<Int, List<Int>> = nums.withIndex()
                                    .groupBy ({it.value}, {it.index})
        for ((ind, elem) in nums.withIndex()) {
            if (elem == target - elem && dict[elem]!!.size > 1) return intArrayOf(dict[elem]!![0], dict[elem]!![1])
            if ((target - elem) in dict && elem != target - elem) {
                return intArrayOf(minOf(ind, dict[target-elem]!![0]), maxOf(ind, dict[target-elem]!![0]))
            }

        }

        return intArrayOf()
    }
}

fun main() = println("Kotlin solution - two sum")