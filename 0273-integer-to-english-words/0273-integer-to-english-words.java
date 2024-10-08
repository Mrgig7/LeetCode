public class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        return helper(num).trim();
    }
    
    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 10) {
            return units[num] + " ";
        } else if (num < 20) {
            return teens[num - 10] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else if (num < 1000) {
            return units[num / 100] + " Hundred " + helper(num % 100);
        } else if (num < 1000000) {
            return helper(num / 1000) + "Thousand " + helper(num % 1000);
        } else if (num < 1000000000) {
            return helper(num / 1000000) + "Million " + helper(num % 1000000);
        } else {
            return helper(num / 1000000000) + "Billion " + helper(num % 1000000000);
        }
    }

    private final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
}
