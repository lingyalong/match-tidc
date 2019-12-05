package com.tidc.utils;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.UserOV;

/**
 * @ClassNmae AffectUtils
 * @Description TODO
 * @Author 冯涛滔
 **/
public class AffectUtils {
	public static void affectOne(int count,UserOV userOV){
		if(count==1){
			userOV.setStatus(CodeConstant.SUCCESS);
		}else{
			userOV.setStatus(CodeConstant.FAIL).setMessage("失败");
		}
	}
}
