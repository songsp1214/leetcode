package com.leetcode.problemset;

import com.leetcode.datastruct.ListNode;
import com.leetcode.datastruct.TreeNode;

public class LC109_1 {
    public ListNode gHead;
    public TreeNode sortedListToBST(ListNode head) {
        gHead = head;
        int len = getLen(head);
        return sortedListToBST(0, len - 1);
    }

    public int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public TreeNode sortedListToBST(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode node = new TreeNode();
        node.left = sortedListToBST(left, mid - 1);
        node.val = gHead.val;
        gHead = gHead.next;
        node.right = sortedListToBST(mid + 1, right);
        return node;
    }
}
