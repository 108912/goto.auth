package com.auth.viewentity;

import org.hibernate.validator.constraints.NotBlank;

public class SysDicView {

	private Long id;

	private Long parentid;

	private Long kindid;

	@NotBlank(message = "²»ÄÜÎª¿Õ")
	private String name;

	private String value;

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

}
