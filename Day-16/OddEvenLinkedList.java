class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode ptr = head;
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode head2 = head;
        while(ptr.next != null) {
            if(ptr == head) {
                head2 = ptr.next;
            }
            ListNode temp = ptr.next;
            ptr.next = temp.next;
            if(ptr.next != null)
                temp.next = ptr.next.next;
            else
                temp.next = null;
            if(ptr.next != null)
                ptr = ptr.next;
            else 
                break;
        }
        ptr.next = head2;
        return head;
    }
}