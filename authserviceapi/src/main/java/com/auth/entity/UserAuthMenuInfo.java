package com.auth.entity;

public class UserAuthMenuInfo {
	private long menuid;
	private long prjectid;
	private long parentid;
	private String name;
	private String code;
	private String url;

	public long getMenuid() {
		return menuid;
	}

	public void setMenuid(long menuid) {
		this.menuid = menuid;
	}

	public long getPrjectid() {
		return prjectid;
	}

	public void setPrjectid(long prjectid) {
		this.prjectid = prjectid;
	}

	public long getParentid() {
		return parentid;
	}

	public void setParentid(long parentid) {
		this.parentid = parentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
