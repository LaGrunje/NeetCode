import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `returns true when duplicates exist`() {
        assertTrue(solution.hasDuplicate(intArrayOf(1, 2, 3, 1)))
    }

    @Test
    fun `returns false when no duplicates`() {
        assertFalse(solution.hasDuplicate(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun `empty array returns false`() {
        assertFalse(solution.hasDuplicate(intArrayOf()))
    }
}