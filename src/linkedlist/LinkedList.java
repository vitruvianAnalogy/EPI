package linkedlist;

import java.lang.reflect.Array;
import java.util.Arrays;

class ListNode{
	public int data;
	public ListNode next;
}

public class LinkedList {
	
	/**
	 * Search for key
	 * @param head - head of the list where the key will be search
	 * @param key - key that you need to search for
	 * @return the node that has the key that we are looking for
	 */
	public ListNode search(ListNode head, int key){
		while(head!=null || head.data!=key){
			head = head.next;
		}
		return head;
		}
	
	/**
	 * Insert node after
	 * @param node - node after which new node has to be inserted
	 */
	public void insertAfter(ListNode node, ListNode newNode){
		newNode.next = node.next;
		node.next = newNode;
	}
	
	/**
	 * Delete nodes immediately after given node
	 * @param node - node whose next has to be deleted
	 */
	public void delete(ListNode node){
		if(node.next!=null){
			node.next = node.next.next;
		}
	}
	
	public ListNode reverseSinglySubList(ListNode list1, int indexStart, int indexEnd){
		
		//Create a dummy head such that if indexStart is 0, we can have the head of the reversed list
		//by giving the next of dummyHead
		ListNode dummyHead = new ListNode();
		dummyHead.next = list1;
		int indexCounter = 1;
		ListNode temp = dummyHead;
		
		//Iterate until the start index is reached
		while(indexCounter<indexStart){
			temp = temp.next;
			indexCounter++;
		}
		
		/**
		 * At this point indexCounter = indexStart
		 * and temp is at the indexStart-1, therefore
		 * we can start reversing 
		 */
		
		ListNode parent = temp; //parent holds the parent of the current node.
		temp = temp.next;
		ListNode son;
		while(indexStart < indexEnd){
			indexStart++;
			//At each index we will reverse the pointer
			son = temp.next;
			temp.next = parent;
			parent = temp;
			temp = son;
		}
		
		return dummyHead.next;
	}
	
	public ListNode isCycle(ListNode head){
		if(head == null)
			return null;
		
		ListNode slow = head;
		ListNode fast = head;
		while(slow!=fast){
			slow = slow.next;
			if(fast.next == null){
				return null;
			}
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public ListNode getHeadOfCycle(ListNode head){
		
		ListNode node;
		if((node = isCycle(head))!=null){
			while(head != node){
				head = head.next;
				node = node.next;
			}
		} else {
			return null;
		}
		return head;
	}
	
	public static void main(String[] args){
		Arrays.asList(1,2,3);
		Arrays.asList(new int []{1,2,3});
		//Arrays.asList(new Integer[]{1,2,3});
		Arrays.copyOf(new int[]{1,2,3}, 3);
	}
}
