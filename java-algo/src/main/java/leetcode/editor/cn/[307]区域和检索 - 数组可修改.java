package leetcode.editor.cn;
//给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。 
//
// update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。 
//
// 示例: 
//
// Given nums = [1, 3, 5]
//
//sumRange(0, 2) -> 9
//update(1, 2)
//sumRange(0, 2) -> 8
// 
//
// 说明: 
//
// 
// 数组仅可以在 update 函数下进行修改。 
// 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。 
// 
// Related Topics 树状数组 线段树

class RangeSumQueryMutable {
    public static void main(String[] args) {
        NumArray solution = new RangeSumQueryMutable().new NumArray(new int[]{1, 3, 5});
        int i = solution.sumRange(0, 2);

        solution.update(1, 2);

        int j = solution.sumRange(0, 2);
        System.out.println(i + "--" + j);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        class SegmentTreeNode {
            int start, end;
            SegmentTreeNode left, right;
            int sum;

            public SegmentTreeNode(int start, int end) {
                this.start = start;
                this.end = end;
                this.left = null;
                this.right = null;
                this.sum = 0;
            }
        }

        SegmentTreeNode root = null;

        public NumArray(int[] nums) {
            root = buildTree(nums, 0, nums.length - 1);
        }

        private SegmentTreeNode buildTree(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            } else {
                SegmentTreeNode ret = new SegmentTreeNode(start, end);
                if (start == end) {
                    ret.sum = nums[start];
                } else {
                    int mid = start + (end - start) / 2;
                    ret.left = buildTree(nums, start, mid);
                    ret.right = buildTree(nums, mid + 1, end);
                    ret.sum = ret.left.sum + ret.right.sum;
                }
                return ret;
            }
        }

        public void update(int i, int val) {
            update(root, i, val);
        }

        public void update(SegmentTreeNode root, int pos, int val) {
            if (root.start == root.end) {
                root.sum = val;
            } else {
                int mid = root.start + (root.end - root.start) / 2;
                if (pos <= mid) {
                    update(root.left, pos, val);
                } else {
                    update(root.right, pos, val);
                }
                root.sum = root.left.sum + root.right.sum;
            }
        }


        public int sumRange(int i, int j) {
            return sumRange(root, i, j);
        }

        public int sumRange(SegmentTreeNode root, int start, int end) {
            if (root.start == start && root.end == end) {
                return root.sum;
            } else {
                int mid = root.start + (root.end - root.start) / 2;
                if (end <= mid) {
                    return sumRange(root.left, start, end);
                } else if (start >= mid + 1) {
                    return sumRange(root.right, start, end);
                }
                return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
            }
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)

}