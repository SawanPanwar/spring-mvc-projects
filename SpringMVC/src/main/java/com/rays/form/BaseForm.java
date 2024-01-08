package com.rays.form;

import com.rays.dto.BaseDTO;

public class BaseForm {

	protected long id = 0;

	private Long[] ids;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public BaseDTO getDto() {
		return null;
	}

	public void populate(BaseDTO bDto) {

	}

}
