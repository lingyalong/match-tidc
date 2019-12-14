package com.tidc.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @ClassNmae CheckObjectIsNullUtils
 * @Description TODO
 * @Author 冯涛滔
 **/
public class CheckObjectIsNullUtils {
	public static boolean contestObjCheckIsNull(Object object) {
		Class clazz = (Class) object.getClass(); // 得到类对象
		Field fields[] = clazz.getDeclaredFields(); // 得到所有属性
		boolean flag = true; // 定义返回结果，默认为true
		for (Field field : fields) {
			field.setAccessible(true);
			Object fieldValue = null;
			try {
				fieldValue = field.get(object); // 得到属性值
				Type fieldType = field.getGenericType();// 得到属性类型
				String fieldName = field.getName(); // 得到属性名

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			String[] array = {"id","history_examination_id","money","token","start_time"};
			boolean nullFlag = Arrays.asList(array).contains(field.getName());
			if (fieldValue == null&&!nullFlag) { //
				flag = false;
				break;
			}
		}
		return flag;
	}

}
