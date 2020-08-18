package com.leetcode.problemset;

import com.leetcode.datastruct.ListNode;
import com.leetcode.datastruct.TreeNode;

public class LC109 {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode begin, ListNode end) {
        if (begin == end) {
            return null;
        }
        ListNode fast = begin, slow = begin;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST(begin, slow);
        node.right = sortedListToBST(slow.next, end);
        return node;
    }
}
