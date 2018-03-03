package com.auth.viewentity;

import org.hibernate.validator.constraints.NotBlank;

public class SysUserView {
	private Long id;

	@NotBlank(message = "不能为空")
	private String name;

	@NotBlank(message = "不能为空")
	private String pwd;

	private String note;

	private String orgidlist;

	private String roleidlist;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd == null ? null : pwd.trim();
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public String getOrgidlist() {
		return orgidlist;
	}

	public void setOrgidlist(String orgidlist) {
		this.orgidlist = orgidlist == null ? null : orgidlist.trim();
	}

	public String getRoleidlist() {
		return roleidlist;
	}

	public void setRoleidlist(String roleidlist) {
		this.roleidlist = roleidlist == null ? null : roleidlist.trim();
	}
}