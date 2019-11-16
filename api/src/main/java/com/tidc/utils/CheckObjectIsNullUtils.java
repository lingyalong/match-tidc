package com.tidc.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

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
			if (fieldValue == null&&!field.getName().equals("money")) { // 只要有一个属性值不为null 就返回false 表示对象不为null
				flag = false;
				break;
			}
		}
		return flag;
	}

}
