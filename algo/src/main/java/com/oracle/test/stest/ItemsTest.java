package com.oracle.test.stest;

import java.util.ArrayList;
import java.util.List;

public class ItemsTest {

	static class CategoryNode{
		String categoryName;
		List<CategoryNode> childs;
		CategoryNode(String categoryName, List<CategoryNode> childs){
			this.categoryName = categoryName;
			this.childs = childs;
		}
	}
	
	public static void printCategory(CategoryNode category, String previous){
		
		String current = previous+" "+category.categoryName;
		if(category.childs==null || category.childs.isEmpty()){
			System.out.println(current);
			return;
		}
		
		for(CategoryNode node : category.childs){
			printCategory(node, current);
		}
	}
	
	public static void main(String[] args){
		CategoryNode premium = new CategoryNode("premium", null);
		CategoryNode regular = new CategoryNode("regular", null);
		CategoryNode quardz = new CategoryNode("quardz", addList(addList(getList(), premium), regular));
		CategoryNode mechenical = new CategoryNode("mechenical", null);
		CategoryNode watches = new CategoryNode("watches", addList(addList(getList(), quardz), mechenical));
		CategoryNode shirts = new CategoryNode("shirts",null );
		CategoryNode trousers = new CategoryNode("trousers", null);
		CategoryNode cloths = new CategoryNode("cloths", addList(addList(getList(), trousers), shirts));
		CategoryNode casuals = new CategoryNode("casuals", null);
		CategoryNode sports = new CategoryNode("sports", null);
		CategoryNode formal = new CategoryNode("formal",null);
		CategoryNode footware = new CategoryNode("footware",addList(addList(addList(getList(), formal), sports), casuals) );
		CategoryNode electronics = new CategoryNode("electronics", addList(addList(getList(), premium), regular));
		CategoryNode men = new CategoryNode("men", addList(addList(addList(getList(), footware), cloths), watches));
		CategoryNode womens = new CategoryNode("womens", addList(addList(addList(getList(), footware), cloths), watches));
		
		List<CategoryNode> list = new ArrayList<>(3);
		list.add(womens);
		list.add(men);
		list.add(electronics);
		
		printCategoryList(list);
		
	}
	
	static void printCategoryList(List<CategoryNode> list){
		for(CategoryNode n :list){
			printCategory(n, "");
		}
	}
	
	static List<CategoryNode> getList(){
		return new ArrayList<>();
	}
	
	static List<CategoryNode> addList(List<CategoryNode> list, CategoryNode node){
		list.add(node);
		return list;
	}
}

