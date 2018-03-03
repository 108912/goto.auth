package com.auth.viewentity;

import org.hibernate.validator.constraints.NotBlank;

public class SysPermissionView {
	private Long id;

	private Long projectid;

	@NotBlank(message = "²»ÄÜÎª¿Õ")
	private String name;

	private String note;

	private String menuidlist;

	public String getMenuidlist() {
		return menuidlist;
	}

	public void setMenuidlist(String menuidlist) {
		this.menuidlist = menuidlist;
	}

	public String getActionidlist() {
		return actionidlist;
	}

	public void setActionidlist(String actionidlist) {
		this.actionidlist = actionidlist;
	}

	private String actionidlist;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}
}