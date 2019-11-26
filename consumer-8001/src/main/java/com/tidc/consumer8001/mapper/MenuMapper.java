package com.tidc.consumer8001.mapper;

import com.tidc.api.pojo.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassNmae MenuMapper
 * @Description TODO
 * @Author 冯涛滔
 **/

public interface MenuMapper {
	List<Menu> getAllMenu();
}
