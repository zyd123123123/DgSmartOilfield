package com.sydx.aqsc.entity.sgtzd;

public class UserVo {
	private int id;
	private String result_f;

	public UserVo(int id, String result_f) {
		this.id = id;
		this.result_f = result_f;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResult_f() {
		return result_f;
	}

	public void setResult_f(String result_f) {
		this.result_f = result_f;
	}
}
