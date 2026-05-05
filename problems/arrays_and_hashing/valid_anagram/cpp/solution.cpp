#include <vector>

class Solution {
public:
    bool isAnagram(const std::string& s, const std::string& t) {
        if (s.size() != t.size()) return false;
        std::vector<int> dictionary = std::vector<int>(26, 0);
        for(int i = 0; i < s.size(); ++i) {
            ++dictionary[s[i] - 'a'];
            --dictionary[t[i] - 'a'];
        }

        for(int elem : dictionary) {
            if (elem != 0) return false;
        }

        return true;

    }
};