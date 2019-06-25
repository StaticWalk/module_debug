package com.xxy.module_debug.controller;

import com.xxy.module_debug.model.Animal;
import com.xxy.module_debug.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * Created by xiongxiaoyu
 * Data:2019/5/28
 * Time:10:35
 */


@RestController
@RequestMapping("/animal")
public class AnimalController {

	private final Logger logger = LoggerFactory.getLogger(AnimalController.class);

	@PostMapping
	public ResultVO createAnimal(@Valid @RequestBody Animal animal, BindingResult bindingResult) {
		logger.info(animal.toString());
		ResultVO result ;
		if (bindingResult.hasErrors()) {
			FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
			result = new ResultVO(400,error.getDefaultMessage());
			return result;
		}
		result = new ResultVO(200,null,animal);
		logger.info(animal.toString());
		return result;
	}
}
