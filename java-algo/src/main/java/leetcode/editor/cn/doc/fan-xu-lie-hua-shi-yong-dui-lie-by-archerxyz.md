### 解题思路
序列化为： 1 _2 __n __n _3 __4 __5

### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        String s = dfs(root,"");
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        if(data.indexOf("_") == -1){
            data = data.trim();
            return new TreeNode(Integer.valueOf(data));
        }
        String[] nodeStr = data.split(" ");
        LinkedList<Node> list = new LinkedList<>();
        for(int i = 0; i < nodeStr.length; i += 2){
            Node node = new Node();
            node.depth = nodeStr[i].length();
            if(!nodeStr[i+1].equals("n"))
                node.n = new TreeNode(Integer.valueOf(nodeStr[i+1]));
            
            if(list.size() > 0){
                if(list.getLast().depth < node.depth){
                    list.getLast().n.left = node.n;
                    list.add(node);
                    continue;
                }
                if(list.getLast().depth == node.depth){
                    list.pollLast();
                    list.getLast().n.right = node.n;
                    list.add(node);
                    continue;
                }
                while(list.getLast().depth >= node.depth){
                    list.pollLast();
                }
                list.getLast().n.right = node.n;
                list.add(node);
            } else 
                list.add(node);
        }
        return list.getFirst().n;
    }

    private String dfs(TreeNode n, String prefix){
        if(n == null)
            return null;
        String left = dfs(n.left,prefix+"_");
        String right = dfs(n.right,prefix+"_");
        String r = prefix+" "+n.val+" ";
        if(left == null && right == null)
            return r;
        if(left != null)
            r += left;
        else
            r += prefix+"_ n ";
        if(right != null)
            r += right;
        else
            r += prefix+"_ n ";
        return r;
    }

    class Node {
        public int depth;
        public TreeNode n;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```