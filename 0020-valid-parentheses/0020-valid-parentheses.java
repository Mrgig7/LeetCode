class Solution {
  char[] stack;
  int top=-1;
  void push(char a)
  {
      top++;
      stack[top]=a;
  }
  char pop()
  {
   if(top==-1)
       return '*';
      char val=stack[top];
      top--;
      return val;
  }
    public boolean isValid(String s) {
        char[] arr=s.toCharArray();
        stack=new char[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            switch(arr[i])
            {
                case '(':  push('(');break;
                case '[':  push('[');break;
                case '{':  push('{');break;
                case ')': if(pop()!='(') return false;break;
                case ']': if(pop()!='[') return false;break;
                case '}': if(pop()!='{') return false;break;
            }
        }return top<0;    
    }
}