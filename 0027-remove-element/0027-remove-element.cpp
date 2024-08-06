class Solution {
public:
    int removeElement(vector<int>& a, int val) {
        int i = 0;
        for (int j = 0; j < a.size(); j++) {
            if (a[j] != val) {
                a[i] = a[j]; 
                i++;
            }
        }
        a.resize(i);

        return i;  

    }
};