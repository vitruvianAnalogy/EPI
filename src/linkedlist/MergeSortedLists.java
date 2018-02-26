package linkedlist;

class DoublyListNode{
	public int data;
	public ListNode pre;
	public ListNode post;
}

public class MergeSortedLists {
	public static ListNode mergeLists(ListNode list1, ListNode list2){
		ListNode head = new ListNode();
		ListNode temp = head;
		
		while(list1.next!=null && list2.next!=null){
			if(list1.data<=list2.data){
				temp.next = list1;
				list1 = list1.next;
			}else {
				temp.next = list2;
				list2 = list2.next;
			}
			temp = temp.next;
		}
		
		temp.next = (list1!=null)?list1:list2; //if list1 is not null then append list1 else append list2
		return head.next;
	}
	
	public static ListNode mergeDoublyLists(DoublyListNode list1, DoublyListNode list2){
		//TODO
		return null;
	}
}
