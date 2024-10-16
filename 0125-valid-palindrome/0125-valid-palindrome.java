class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        String l = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(l);
        String m = new StringBuilder(l).reverse().toString();
        return m.equals(l);
    }
}