    // 看着比较像归并排序
    class Solution {
        public List<List<Integer>> BSTSequences(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null){
                res.add(new ArrayList<Integer>());
                return res;
            }
            List<List<Integer>> left = BSTSequences(root.left);
            List<List<Integer>> right = BSTSequences(root.right);
            // merge
            for(List<Integer> l : left) {
                for(List<Integer> r : right) {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(root.val);             // 根节点开头
                    merge(l, 0, r, 0, list, res);   // 左右子树序列穿插
                }
            }
            return res;
        }

        public void merge(List<Integer> l, int i, List<Integer> r, int j, LinkedList<Integer> list,
                List<List<Integer>> res) {
            if(i == l.size() && j == r.size()) {
                res.add(new LinkedList<>(list));
                return;
            }
            if(i < l.size()) {
                list.add(l.get(i));
                merge(l, i + 1, r, j, list, res);
                list.removeLast();
            }
            if(j < r.size()) {
                list.add(r.get(j));
                merge(l, i, r, j + 1, list, res);
                list.removeLast();
            }
        }
    }