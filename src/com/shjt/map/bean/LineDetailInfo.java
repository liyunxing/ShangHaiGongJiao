package com.shjt.map.bean;

public class LineDetailInfo {
	
	String lineId;
	String lineName;
	String endEarlyTime;
	String endLateTime;
	String endStop;
	String startEarlyTime;
	String startLateTime;
	String startTop;
	
	public static LineDetailInfo fromXml(String json) {
		if (json == null) {
			return null;
		}
		LineDetailInfo info = new LineDetailInfo();
		
		
		return info;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getEndEarlyTime() {
		return endEarlyTime;
	}

	public void setEndEarlyTime(String endEarlyTime) {
		this.endEarlyTime = endEarlyTime;
	}

	public String getEndLateTime() {
		return endLateTime;
	}

	public void setEndLateTime(String endLateTime) {
		this.endLateTime = endLateTime;
	}

	public String getEndStop() {
		return endStop;
	}

	public void setEndStop(String endStop) {
		this.endStop = endStop;
	}

	public String getStartEarlyTime() {
		return startEarlyTime;
	}

	public void setStartEarlyTime(String startEarlyTime) {
		this.startEarlyTime = startEarlyTime;
	}

	public String getStartLateTime() {
		return startLateTime;
	}

	public void setStartLateTime(String startLateTime) {
		this.startLateTime = startLateTime;
	}

	public String getStartTop() {
		return startTop;
	}

	public void setStartTop(String startTop) {
		this.startTop = startTop;
	}
	
	
}
