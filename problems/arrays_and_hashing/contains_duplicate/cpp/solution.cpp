#include <unordered_set>
#include <vector>

using std::vector;

class Solution {
public:
    bool hasDuplicate(const vector<int>& nums) {
        std::unordered_set<int> duplicates =  std::unordered_set<int>();
        for(int elem : nums) {
            if (duplicates.contains(elem)) return true;
            duplicates.insert(elem);
        }
        return false;
    }
};