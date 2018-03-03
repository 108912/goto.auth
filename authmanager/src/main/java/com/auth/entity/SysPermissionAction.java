package com.auth.entity;

import java.util.Date;

public class SysPermissionAction {
	private Long id;

	private Long permissionid;

	private Long actionid;

	private Boolean eisdel;

	private Date ectime;

	private Date eutime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPermissionid() {
		return permissionid;
	}

	public void setPermissionid(Long permissionid) {
		this.permissionid = permissionid;
	}

	public Long getActionid() {
		return actionid;
	}

	public void setActionid(Long actionid) {
		this.actionid = actionid;
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