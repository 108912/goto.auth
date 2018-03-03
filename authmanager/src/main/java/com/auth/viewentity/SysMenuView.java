package com.auth.viewentity;

import org.hibernate.validator.constraints.NotBlank;

public class SysMenuView {
	private Long id;

	private Long projectid;

	private Long parentid;

	@NotBlank(message = "²»ÄÜÎª¿Õ")
	private String name;

	private String url;

	private String icostyle;

	private String note;

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

}
