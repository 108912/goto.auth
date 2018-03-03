package com.auth.entity;

import java.util.Date;

public class SysMenu {
	private Long id;

	private Long projectid;

	private Long parentid;

	private String name;

	private String code;

	private String url;

	private String icostyle;

	private String note;

	private Long ordernum;

	private Boolean eisdel;

	private Date ectime;

	private Date eutime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectid() {
		return projectid;
	}

	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getIcostyle() {
		return icostyle;
	}

	public void setIcostyle(String icostyle) {
		this.icostyle = icostyle == null ? null : icostyle.trim();
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public Long getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Long ordernum) {
		this.ordernum = ordernum;
	}

	public Boolean getEisdel() {
		return eisdel;
	}

	public void setEisdel(Boolean eisdel) {
		this.eisdel = eisdel;
	}

	public Date getEctime() {
		return ectime;
	}

	public void setEctime(Date ectime) {
		this.ectime = ectime;
	}

	public Date getEutime() {
		return eutime;
	}

	public void setEutime(Date eutime) {
		this.eutime = eutime;
	}
}