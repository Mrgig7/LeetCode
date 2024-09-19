class Solution {
    
    private int calVal (int a, int b, char op) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else if (op == '*') return a * b;
        else return a / b;
    }
    
    public List<Integer> diffWaysToCompute(String exp) {
        List<Integer> ans = new ArrayList<> ();
        for (int i = 0; i < exp.length (); i++) {
            char op = exp.charAt (i);
            if (isop (op)) {
                List<Integer> list1 = diffWaysToCompute (exp.substring (0, i));
                List<Integer> list2 = diffWaysToCompute (exp.substring (i + 1));
                for (int j = 0; j < list1.size (); j++) {
                    for (int k = 0; k < list2.size (); k++) {
                        ans.add (calVal (list1.get (j), list2.get (k), op));
                    }
                }
            }
        }
        
        if (ans.size () == 0) {
            ans.add (Integer.valueOf (exp));
            return ans;
        }
        
        return ans;
    }
    
    private boolean isop (char op) {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }
}