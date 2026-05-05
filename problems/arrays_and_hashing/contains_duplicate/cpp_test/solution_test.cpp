#include <gtest/gtest.h>
#include "../cpp/solution.cpp"

TEST(ContainsDuplicate, ReturnsTrueWhenDuplicatesExist) {
    Solution s;
    EXPECT_TRUE(s.hasDuplicate({1, 2, 3, 1}));
}

TEST(ContainsDuplicate, ReturnsFalseWhenNoDuplicates) {
    Solution s;

    EXPECT_FALSE(s.hasDuplicate({1, 2, 3, 4}));
}

TEST(ContainsDuplicate, EmptyArrayReturnsFalse) {
    Solution s;
    EXPECT_FALSE(s.hasDuplicate({}));
}

int main(int argc, char **argv) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}