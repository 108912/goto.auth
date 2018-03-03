package com.auth.viewshow;

public class ShowMsgModel {
	public ShowMsgModel() {
		this.setMsg("¼´½«Ìø×ª");
		this.setIntervalnum(5);
		this.setTourl("/");
	}

	private String msg;

	private String tourl;

	private int intervalnum;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg == null ? null : msg.trim();
	}

	public String getTourl() {
		return tourl;
	}

	public void setTourl(String tourl) {
		this.tourl = tourl == null ? null : tourl.trim();
	}

	public int getIntervalnum() {
		return intervalnum;
	}

	public void setIntervalnum(int intervalnum) {
		this.intervalnum = intervalnum;
	}
}
