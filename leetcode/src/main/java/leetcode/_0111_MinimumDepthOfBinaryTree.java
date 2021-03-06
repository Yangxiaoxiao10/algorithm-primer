package leetcode;

import util.TreeUtil.TreeNode;

import java.util.LinkedList;

/**
 * @No          111
 * @problem     Minimum Depth of Binary Tree
 * @level       Easy
 * @desc        二叉树的最小深度
 * @author      liyazhou
 * @date        2017/08
 *
 * <pre>
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its minimum depth = 2.
 * </pre>
 */
public class _0111_MinimumDepthOfBinaryTree {


    /**
     * Note
     *
     * Thought
     *     层次遍历二叉树
     *     与递归解二叉树的最大深度的方法不同
     *
     * Challenge
     *
     * Algorithm
     *      1.
     *      2.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            // if (root.left == null || root.right == null) return 1;

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int level = 0;
            while (!queue.isEmpty()){
                level ++;
                int len = queue.size();
                for (int i = 0; i < len; i ++){
                    TreeNode currNode = queue.poll();
                    if (currNode.left == null && currNode.right == null)
                        return level;
                    if (currNode.left != null) queue.offer(currNode.left);
                    if (currNode.right != null) queue.offer(currNode.right);
                }
            }
            return level;
        }
    }


    /**
     * Note
     *
     * Thought
     *      对比"二叉树的最大深度"
     *
     * Challenge
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution2 {

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // 当前两个孩子都为空
            if (root.left == null && root.right == null) {
                return 1;
            }

            int left = minDepth(root.left);
            int right = minDepth(root.right);
            // 只有一个孩子为空，深度为该孩子的深度加上1
            if (root.left == null || root.right == null) { // 等价于 if (left == 0 || right == 0)
                return left + right + 1;
            }

            // 两个孩子均不为空
            // if (root.left != null && root.right != null) // 等价于 if (left != 0 && right != 0)
            return Math.min(left, right) + 1;

        }


        public int minDepth2(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = minDepth(root.left);
            int right = minDepth(root.right);
            // 只有一个孩子为空，深度为该孩子的深度加上1
            // 两个孩子均为空，则返回1
            if (root.left == null || root.right == null) { // 等价于 if (left == 0 || right == 0)
                return left + right + 1;
            }

            // 两个孩子均不为空
            // if (root.left != null && root.right != null) // 等价于 if (left != 0 && right != 0)
            return Math.min(left, right) + 1;

        }
    }
}
