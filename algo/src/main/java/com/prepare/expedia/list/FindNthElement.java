package com.prepare.expedia.list;

import com.algo.test.ITest;
import com.prepare.common.list.Node;

public class FindNthElement implements ITest {

	/**
	 * finds the node element at nth position from the end of the linked list. 
	 * @param head
	 * @param n
	 * @return
	 */
	Node findNthElement(Node head, int n){
		Node current = head;
		
		for(int i =0; current!=null&&i<n; i++){
			current = current.next;
		}
		
		if(current==null) return null;
		
		Node nth = head;
		
		while(current.next==null){
			nth = nth.next;
			current= current.next;
		}
		return nth;
	}
	
	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub
		Node node = new Node();
		node.data=8;
		node.next=null;
		//findNthElement(head, n);

	}

}
