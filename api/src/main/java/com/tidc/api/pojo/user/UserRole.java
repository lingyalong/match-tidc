package com.tidc.api.pojo.user;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassNmae UserRole
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true)
@Scope(value = "prototype")
@Component
public class UserRole implements Serializable {
	private Integer id;
	private Integer user_id;
	private Integer role_id;

	public UserRole(Integer user_id, Integer role_id) {
		this.user_id = user_id;
		this.role_id = role_id;
	}
}
