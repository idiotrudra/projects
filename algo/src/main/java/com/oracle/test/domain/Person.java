package com.oracle.test.domain;

import java.util.Date;
import java.util.List;

public class Person {

	private int uid;
	private Date firstEntry;
	private Date LastEntry;
	private String lastEntryType;
	private List<PersonEntry> todayEntry;
	public int getUd() {
		return uid;
	}
	public void setUid(int id) {
		this.uid = id;
	}
	public Date getFirstEntry() {
		return firstEntry;
	}
	public void setFirstEntry(Date firstEntry) {
		this.firstEntry = firstEntry;
	}
	public Date getLastEntry() {
		return LastEntry;
	}
	public void setLastEntry(Date lastEntry) {
		LastEntry = lastEntry;
	}
	public String getLastEntryType() {
		return lastEntryType;
	}
	public void setLastEntryType(String lastEntryType) {
		this.lastEntryType = lastEntryType;
	}
	public List<PersonEntry> getTodayEntry() {
		return todayEntry;
	}
	public void setTodayEntry(List<PersonEntry> todayEntry) {
		this.todayEntry = todayEntry;
	}

}
