#include <gtest/gtest.h>
#include "../cpp/solution.cpp"

TEST(ValidAnagram, ReturnsTrueWhenEmptyString) {
    Solution s;
    EXPECT_TRUE(s.isAnagram("", ""));
}

TEST(ValidAnagram, ReturnsTrueWithRealAnagram) {
    Solution s;

    EXPECT_TRUE(s.isAnagram("racecar", "carrace"));
}

TEST(ValidAnagram, ReturnsFalseWithNonAnagram) {
    Solution s;
    EXPECT_FALSE(s.isAnagram("abc", "dec"));
}

TEST(ValidAnagram, ReturnsFalseWithDifferentLength) {
    Solution s;
    EXPECT_FALSE(s.isAnagram("eee", "eeee"));
}

int main(int argc, char **argv) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}