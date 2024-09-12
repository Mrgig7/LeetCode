import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countConsistentStrings(String s1, String[] s2) {
        // Create a set of allowed characters from s1
        Set<Character> allowedChars = new HashSet<>();
        for (char c : s1.toCharArray()) {
            allowedChars.add(c);
        }
        
        int consistentCount = 0;
        
        // Check each string in s2
        for (String s : s2) {
            boolean isConsistent = true;
            for (char c : s.toCharArray()) {
                if (!allowedChars.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                consistentCount++;
            }
        }
        
        return consistentCount;
    }
}
