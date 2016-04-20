package com.shjt.map.bean;

public class StopInfo {

	String id;
	String name;
	
	public static StopInfo fromXml(String json) {
		if (json == null) {
			return null;
		}
		StopInfo info = new StopInfo();
		
		
		return info;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
