package com.auth.viewentity;

import org.hibernate.validator.constraints.NotBlank;

public class SysOrgView {
    private Long id;

    private Long parentid;

	@NotBlank(message = "²»ÄÜÎª¿Õ")
    private String name;

    private String note;

    private String permissionidlist;
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
    public String getPermissionidlist() {
        return permissionidlist;
    }

    public void setPermissionidlist(String permissionidlist) {
        this.permissionidlist = permissionidlist == null ? null : permissionidlist.trim();
    }
    
}