package com.auth.viewentity;

import org.hibernate.validator.constraints.NotBlank;

public class SysProjectView {
	private Long id;

	@NotBlank(message = "²»ÄÜÎª¿Õ")
	private String name;

	private String note;

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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}
}