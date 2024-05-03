package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XinliyishengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 心理医生
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xinliyisheng")
public class XinliyishengView extends XinliyishengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 心理医生类型的值
	*/
	@ColumnInfo(comment="心理医生类型的字典表值",type="varchar(200)")
	private String xinliyishengValue;




	public XinliyishengView() {

	}

	public XinliyishengView(XinliyishengEntity xinliyishengEntity) {
		try {
			BeanUtils.copyProperties(this, xinliyishengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 心理医生类型的值
	*/
	public String getXinliyishengValue() {
		return xinliyishengValue;
	}
	/**
	* 设置： 心理医生类型的值
	*/
	public void setXinliyishengValue(String xinliyishengValue) {
		this.xinliyishengValue = xinliyishengValue;
	}




	@Override
	public String toString() {
		return "XinliyishengView{" +
			", xinliyishengValue=" + xinliyishengValue +
			"} " + super.toString();
	}
}
