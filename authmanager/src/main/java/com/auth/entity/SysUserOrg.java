package com.auth.entity;

import java.util.Date;

public class SysUserOrg {
	private Long id;

	private Long userid;

	private Long orgid;

	private Boolean eisdel;

	private Date ectime;

	private Date eutime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
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