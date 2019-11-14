package com.tidc.consumer8001.mapper;

import com.tidc.consumer8001.pojo.Menu;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNmae MenuMapper
 * @Description TODO
 * @Author 冯涛滔
 **/

public interface MenuMapper {
	public List<Menu> getAllMenu();
}
