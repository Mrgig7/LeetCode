class Solution {

    private static void Mapping(String res,String digits,String[] phoneChar,List<String> a){
        if(digits.length() == 0){
            a.add(res);
            return ;
        }

        String l = phoneChar[digits.charAt(0) - '2'];
        for(char ch:l.toCharArray()){
            Mapping(res+ch,digits.substring(1),phoneChar,a);
        }
    }

    public List<String> letterCombinations(String digits) {


        String[] phoneChar = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> a = new ArrayList<>();

        if(digits.length() == 0)return a;

        Mapping("",digits,phoneChar,a);
        return a;
    }
}