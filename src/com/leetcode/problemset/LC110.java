package com.leetcode.problemset;

import com.leetcode.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            int leftDepth = depth(tmp.left);
            int rightDepth = depth(tmp.right);
            if (Math.abs(leftDepth - rightDepth) > 1) {
                return false;
            }
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }

        return true;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int dep = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dep++;
            while (size-- > 0) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }

        return dep;
    }
}
