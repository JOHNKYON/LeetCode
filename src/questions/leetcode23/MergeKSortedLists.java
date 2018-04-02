package questions.leetcode23;


public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void listNodePrint(ListNode node){
        System.out.print(node.val);
        System.out.print(' ');
        if (node.next != null){
            listNodePrint(node.next);
        }
    }

    /*Merge the lists in pairs until they form single one*/
    public ListNode mergeKLists(ListNode[] lists){
        int total = lists.length;
        int interval = 1;

        if (total == 0){return null;}
        while (interval < total){
            for (int i = 0; i < total-interval; i = i+interval*2){
                lists[i] = merge(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private ListNode merge(ListNode n1, ListNode n2){
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (n1 != null && n2 != null){
            if (n1.val < n2.val){
                point.next = n1;
                n1 = n1.next;
            }else {
                point.next = n2;
                n2 = n2.next;
            }
            point = point.next;
        } if (n1 == null){
            point.next = n2;
        } else {point.next = n1;}
        return head.next;
    }
}
