package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiangzhuoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 讲座信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiangzhuo")
public class JiangzhuoView extends JiangzhuoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 讲座类型的值
	*/
	@ColumnInfo(comment="讲座类型的字典表值",type="varchar(200)")
	private String jiangzhuoValue;




	public JiangzhuoView() {

	}

	public JiangzhuoView(JiangzhuoEntity jiangzhuoEntity) {
		try {
			BeanUtils.copyProperties(this, jiangzhuoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 讲座类型的值
	*/
	public String getJiangzhuoValue() {
		return jiangzhuoValue;
	}
	/**
	* 设置： 讲座类型的值
	*/
	public void setJiangzhuoValue(String jiangzhuoValue) {
		this.jiangzhuoValue = jiangzhuoValue;
	}




	@Override
	public String toString() {
		return "JiangzhuoView{" +
			", jiangzhuoValue=" + jiangzhuoValue +
			"} " + super.toString();
	}
}
