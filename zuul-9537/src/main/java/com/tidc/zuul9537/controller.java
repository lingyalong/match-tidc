package com.tidc.zuul9537;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNmae controller
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class controller {
	@GetMapping("/test")
	public String sd(){
		return "dasda";
	}
}
