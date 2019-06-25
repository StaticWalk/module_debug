package com.xxy.module_debug.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * Created by xiongxiaoyu
 * Data:2019/5/28
 * Time:10:34
 */

@Data
public class Animal {

	@Max(value = 5 ,message = "名字太长了")
	private String name;
	private Integer age;

	@NotBlank(message = "密码不能为空！")
	private String password;

	private Date birthDay;

}
