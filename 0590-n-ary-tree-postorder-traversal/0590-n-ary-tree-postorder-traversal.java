/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> l=new ArrayList<>();
    public void helper(Node root){
        if(root==null)    return;
        for(Node x: root.children) helper(x);
        l.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        if(root==null)  return l;
        helper(root);
        return l;
    }
}