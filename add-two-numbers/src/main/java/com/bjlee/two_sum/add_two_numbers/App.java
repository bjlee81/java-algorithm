package com.bjlee.two_sum.add_two_numbers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /*
        - 각 링크의 숫자들을 더하는 것 이기에 각 링크별로 10 이 넘어가면 다음 링크로 넘길 수 있는 carry 가 필요.
        - single digit 이기에 10 이 넘어가면 1아니면 0으로 처리. 다음 링크에 +1
     */
    public static void main(String[] args) {
        App app = new App();

        ListNode l1 = stringToListNode(new int[]{1, 8});
        ListNode l2 = stringToListNode(new int[]{0});

        ListNode resultListNode = app.addTwoNumbers(l1, l2);

        while (resultListNode != null) {
            log.info("{}, {}", resultListNode.val, resultListNode.next);

            resultListNode = resultListNode.next;
        }
    }

    private static ListNode stringToListNode(int[] nodeValues) {
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 두가지 링크드 리스트의 끝이 null 이 아닐때까지
        int carry = 0;
        ListNode rtListNode = new ListNode(0);
        // 얇은 복사를 통해 주소값을 이동해가며 추가할 수 있도록한다.
        ListNode ptr = rtListNode;
        while (l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + carry;
            // sum이 두자리 이상이면 carry 체크
            carry = sum >= 10 ? 1 : 0;
            if (carry == 1) sum -= 10;

            ptr.next = new ListNode(sum);
            ptr = ptr.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry == 1) {
            ptr.next = new ListNode(carry);
        }

        return rtListNode.next;
    }

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
