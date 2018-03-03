package com.auth.condition;

import com.auth.queryentity.SysActionQuery;

public class SysActionCondition {
	public SysActionCondition() {
		this.setSkip(0);
		this.setLimit(10);
	}

	public void SetQuery(SysActionQuery queryparam) {
		this.setId(queryparam.getId());
		this.setName(queryparam.getName());
		this.UpdatePageSize(queryparam.getPageindex(), queryparam.getPagesize());
	}

	public void UpdatePageSize(int pageindex, int pagesize) {
		if (pagesize > 0 && pageindex > 0) {
			this.skip = pagesize * (pageindex - 1);
			this.limit = pagesize;
		}
	}

	private int id;
	private String name;
	private int skip;
	private int limit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
