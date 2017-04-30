package com.rudra.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.omg.CORBA.Current;

import com.algo.test.ITest;

public class LinkedListOperation implements ITest {

	
	
	private class Node{
		int data;
		Node next;
	}
	
	public Node removeDuplicate(Node head){
		Map<Integer, Node> map = new HashMap<>();
		
		Node current = head;
		
		map.put(current.data, current);
		
		while(current.next!=null){
			if(map.get(current.next.data)!=null){
				current.next = current.next.next;
			}else{
				current=current.next;
			}
			map.put(current.data, current);
		}
		
		return head;
	}
	
	public Node findNth(Node head, int n){
		int count = n;
		Node current = head;
		Node runner = head;
		while(runner!=null){
			if(count==0){
				current = current.next;
			}else{
				count--;
			}
			runner = runner.next;
		}
		return current;
	}
	
	public Node Sum(Node node1, Node node2){
		Node result ;
		
		Node resultHead = new Node();
		int sum = node1.data+node2.data;
		int carry= sum/10;
		int data = sum%10;
		resultHead.data= data;
		result = resultHead;
		node1=node1.next;
		node2 = node2.next;
		while(node1!=null|| node2!=null){
			sum = node1.data+node2.data+carry;
			carry = sum/10;
			data = sum%10;
			Node node = new Node();
			node.data=data;
			result.next=node;
			node1=node1.next;
			node2=node2.next;
			result = result.next;
		}
		if(carry>0){
			Node node = new Node();
			node.data=carry;
			result.next=node;
		}
		
		return resultHead;
	}
	
	public Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> r = new Stack<>();
		r.push(s.pop());
		while(!s.isEmpty()){
			int tmp = s.pop();
			while(!r.isEmpty() && tmp<r.peek()){
				s.push(r.pop());
			}
			r.push(tmp);
		}
		
		return r;
	}
	
	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub
		/*Node head = new Node();
		head.data=1;
	
		Node n1 = new Node();
		n1.data=8;
		head.next=n1;
		Node n2 = new Node();
		n2.data=3;
		n1.next=n2;
		Node n3 = new Node();
		n3.data=3;
		Node n4 = new Node();
		n4.data=4;
		n3.next=n4;
		Node n5 = new Node();
		n5.data=4;
		n4.next=n5;
		Node result = Sum(head, n3);
		
		while(result!=null){
			System.out.println(result.data);
			result = result.next;
		}
		
		System.out.println(findNth(head, 2).data);
*/	
	
		Stack<Integer> test = new Stack<>();
		test.push(3);
		test.push(4);
		test.push(1);
		test.push(5);
		test.push(9);
		Stack<Integer> r =sort(test);
		while(!r.empty()){
			System.out.println(r.pop());
		}
		
	}

}
