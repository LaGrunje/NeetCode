import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `return correct answer for two same numbers`() {
        assertArrayEquals(intArrayOf(0, 1), solution.twoSum(intArrayOf(3, 3), 6))
    }

    @Test
    fun `return correct answer for two different numbers`() {
        assertArrayEquals(intArrayOf(0, 1), solution.twoSum(intArrayOf(3,4,5,6), 7))
    }

    @Test
    fun `return correct answer for two different numbers 2`() {
        assertArrayEquals(intArrayOf(0, 2), solution.twoSum(intArrayOf(4,5,6), 10))
    }

}