package com.wang.sparkproject.domain;

public class SessionRandomExtract {

	private long taskid;
	private String sessionid;
	private String startTime;
	private String searchKeyWords;
	private String clickCategoryIds;

	public long getTaskid() {
		return taskid;
	}

	public void setTaskid(long taskid) {
		this.taskid = taskid;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getSearchKeyWords() {
		return searchKeyWords;
	}

	public void setSearchKeyWords(String searchKeyWords) {
		this.searchKeyWords = searchKeyWords;
	}

	public String getClickCategoryIds() {
		return clickCategoryIds;
	}

	public void setClickCategoryIds(String clickCategoryIds) {
		this.clickCategoryIds = clickCategoryIds;
	}

}
