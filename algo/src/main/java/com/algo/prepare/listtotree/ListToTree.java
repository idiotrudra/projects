package com.algo.prepare.listtotree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListToTree {

	
	public void listToTree(List<Node> list ){
		Map<Integer, NodeTree> map = new HashMap<>();
		for(Node n :list){

			NodeTree parentNode = map.get(n.parentId);
			if(parentNode==null){
				parentNode = new NodeTree();
				parentNode.id=n.parentId;
				parentNode.childernIds.add(n.childId);
				map.put(parentNode.id, parentNode);
			}
			NodeTree nodeTree = map.get(n.childId);
			if(nodeTree==null){
				nodeTree = new NodeTree();
				nodeTree.id=n.childId;
				nodeTree.parentId = n.parentId;
				map.put(nodeTree.id, nodeTree);
				parentNode.childernIds.add(n.childId);
			}else{
				nodeTree.parentId=n.parentId;
			}
			
		}
		
	}
	
	public class NodeTree{
		int parentId;
		int id;
		Set<Integer> childernIds= new HashSet<>();
	}
	
}
