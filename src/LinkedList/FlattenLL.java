package LinkedList;

import static LinkedList.merge2LLInplace.mergeLL;

public class FlattenLL {
    /**
     * Function Only
     */
    public static ReverseLL.Node flatten(ReverseLL.Node head){
        if (head.next==null) return head;
        head.next=flatten(head.next);
        return mergeLL(head,head.next);
    }
}
