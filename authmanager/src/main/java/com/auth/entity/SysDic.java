package com.auth.entity;

import java.util.Date;

public class SysDic {
	private Long id;

	private Long parentid;

	private Long kindid;

	private String name;

	private String value;

	private Integer ordernum;

	private Boolean eisdel;

	private Date ectime;

	private Date eutime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public Long getKindid() {
		return kindid;
	}

	public void setKindid(Long kindid) {
		this.kindid = kindid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
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