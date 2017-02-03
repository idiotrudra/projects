package com.oracle.test.domain;

import java.util.Date;

public class PersonEntry {

	final public int uid;
	final Date time;
	final String entryType;
	
	public PersonEntry(int uid, Date time, String entryType){
		this.uid= uid;
		this.time=time;
		this.entryType=entryType;
	}

	public int getUid() {
		return uid;
	}

	public Date getTime() {
		return time;
	}

	public String getEntryType() {
		return entryType;
	}
	
	
}
