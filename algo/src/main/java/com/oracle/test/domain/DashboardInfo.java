package com.oracle.test.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DashboardInfo {

	private Map<Integer, Person> personMap = new ConcurrentHashMap<>();
	
	private static final DashboardInfo INSTANCE = new DashboardInfo();
	
	private DashboardInfo(){
		
	}
	
	public static DashboardInfo getInstance(){
		return INSTANCE;
	}
	
	public Map<Integer, Person> getPersonMap(){
		return personMap;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		throw new CloneNotSupportedException("Clone not supported for the class");
	}
	
}
