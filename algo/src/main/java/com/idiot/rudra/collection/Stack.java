package com.idiot.rudra.collection;

public class Stack<Item> {

	Node current;
	
	int size=0;
	
	public boolean isEmpty(){
		if(null==current){
			return true;
		}
		return false;
	}
	
	public int size(){
		return size;
	}
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void push(Item item){
		Node node = new Node();
		node.item = item;
		node.next = current;
		current = node;
		size++;
		}
	
	public Item pop(){
		if(null==current){
			return null;
		}
		Item item = current.item;
		current = current.next;
		size--;
		return item;
	}
	
}
