/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map = new HashMap<>();
        dfs(node,map);
        return map.get(node);
    }
    public void dfs(Node node, HashMap<Node,Node> map){
        if(node == null || map.containsKey(node)) return;

        Node newNode = new Node(node.val);
        map.put(node,newNode);
        for(Node n: node.neighbors){
            dfs(n,map);
            map.get(node).neighbors.add(map.get(n));
        }
    }
}