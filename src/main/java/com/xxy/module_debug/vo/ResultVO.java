package com.xxy.module_debug.vo;

import lombok.Data;

/**
 * Created by xiongxiaoyu
 * Data:2019/5/28
 * Time:10:42
 */
@Data
public class ResultVO<T> {
	private Integer code;

	private String msg;

	private T data;

	public ResultVO(Integer code, T data) {
		this.code = code;
		this.data = data;
	}

	public ResultVO(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
}
