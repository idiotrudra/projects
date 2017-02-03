package com.prepare.expedia.friends;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algo.test.ITest;

public class FindFriendsDepth implements ITest {

	class Node{
		int distance;
		
		int id;
		
		List<Node> friends;
		
		boolean visited = false;
	}
	int findFriends(Node user, Node friend){
		Queue<Node> queue = new LinkedList<>();
		if(user.id==friend.id){
			return 0;
		}
		
		queue.add(user);
		
		while(!queue.isEmpty()){
			Node current =queue.poll();
			current.visited=true;
			if(current.distance>3){
				return Integer.MAX_VALUE;
			}
			for(Node node: current.friends){
				if(!node.visited){
					node.distance++;
					if(node.id==friend.id){
						return node.distance;
					}
					queue.add(node);
				}
			}
		}
				
		
		
		return 0;
		
	}
	
	@Override
	public void PerformTest() {
		// TODO Auto-generated method stub
		
	}

}
