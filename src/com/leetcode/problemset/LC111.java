package com.leetcode.problemset;

import com.leetcode.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC111 {
    /* 递归 */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (root.left == null || root.right == null) ? (left + right + 1) : (Math.min(left, right) + 1);
    }

    /* BFS */
    /*public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDep = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minDep++;
            while (size-- > 0) {
                TreeNode tmp = queue.poll();
                if (tmp.left == null && tmp.right == null) {
                    return minDep;
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }

        return minDep;
    }*/
}
