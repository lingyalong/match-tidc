package com.tidc.api.pojo.user;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassNmae User
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true)
@Scope(value = "prototype")
@Component
public class User implements Serializable {
	private Integer id;
	private String name;
	private String email;
	private String password;
	private Integer status;
	private Integer user_role_id;
	private UserDetail userDetail;
}
