package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 心理医生
 *
 * @author 
 * @email
 */
@TableName("xinliyisheng")
public class XinliyishengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XinliyishengEntity() {

	}

	public XinliyishengEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 心理医生名称
     */
    @ColumnInfo(comment="心理医生名称",type="varchar(200)")
    @TableField(value = "xinliyisheng_name")

    private String xinliyishengName;


    /**
     * 心理医生类型
     */
    @ColumnInfo(comment="心理医生类型",type="int(11)")
    @TableField(value = "xinliyisheng_types")

    private Integer xinliyishengTypes;


    /**
     * 头像
     */
    @ColumnInfo(comment="头像",type="varchar(200)")
    @TableField(value = "xinliyisheng_photo")

    private String xinliyishengPhoto;


    /**
     * 就职点
     */
    @ColumnInfo(comment="就职点",type="varchar(200)")
    @TableField(value = "xinliyisheng_jiuzhi")

    private String xinliyishengJiuzhi;


    /**
     * 主攻方向
     */
    @ColumnInfo(comment="主攻方向",type="varchar(200)")
    @TableField(value = "xinliyisheng_zhugong")

    private String xinliyishengZhugong;


    /**
     * 职位
     */
    @ColumnInfo(comment="职位",type="varchar(200)")
    @TableField(value = "xinliyisheng_zhiwei")

    private String xinliyishengZhiwei;


    /**
     * 心理医生简介
     */
    @ColumnInfo(comment="心理医生简介",type="text")
    @TableField(value = "xinliyisheng_content")

    private String xinliyishengContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "xinliyisheng_delete")

    private Integer xinliyishengDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间     homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：心理医生名称
	 */
    public String getXinliyishengName() {
        return xinliyishengName;
    }
    /**
	 * 设置：心理医生名称
	 */

    public void setXinliyishengName(String xinliyishengName) {
        this.xinliyishengName = xinliyishengName;
    }
    /**
	 * 获取：心理医生类型
	 */
    public Integer getXinliyishengTypes() {
        return xinliyishengTypes;
    }
    /**
	 * 设置：心理医生类型
	 */

    public void setXinliyishengTypes(Integer xinliyishengTypes) {
        this.xinliyishengTypes = xinliyishengTypes;
    }
    /**
	 * 获取：头像
	 */
    public String getXinliyishengPhoto() {
        return xinliyishengPhoto;
    }
    /**
	 * 设置：头像
	 */

    public void setXinliyishengPhoto(String xinliyishengPhoto) {
        this.xinliyishengPhoto = xinliyishengPhoto;
    }
    /**
	 * 获取：就职点
	 */
    public String getXinliyishengJiuzhi() {
        return xinliyishengJiuzhi;
    }
    /**
	 * 设置：就职点
	 */

    public void setXinliyishengJiuzhi(String xinliyishengJiuzhi) {
        this.xinliyishengJiuzhi = xinliyishengJiuzhi;
    }
    /**
	 * 获取：主攻方向
	 */
    public String getXinliyishengZhugong() {
        return xinliyishengZhugong;
    }
    /**
	 * 设置：主攻方向
	 */

    public void setXinliyishengZhugong(String xinliyishengZhugong) {
        this.xinliyishengZhugong = xinliyishengZhugong;
    }
    /**
	 * 获取：职位
	 */
    public String getXinliyishengZhiwei() {
        return xinliyishengZhiwei;
    }
    /**
	 * 设置：职位
	 */

    public void setXinliyishengZhiwei(String xinliyishengZhiwei) {
        this.xinliyishengZhiwei = xinliyishengZhiwei;
    }
    /**
	 * 获取：心理医生简介
	 */
    public String getXinliyishengContent() {
        return xinliyishengContent;
    }
    /**
	 * 设置：心理医生简介
	 */

    public void setXinliyishengContent(String xinliyishengContent) {
        this.xinliyishengContent = xinliyishengContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXinliyishengDelete() {
        return xinliyishengDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setXinliyishengDelete(Integer xinliyishengDelete) {
        this.xinliyishengDelete = xinliyishengDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xinliyisheng{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", xinliyishengName=" + xinliyishengName +
            ", xinliyishengTypes=" + xinliyishengTypes +
            ", xinliyishengPhoto=" + xinliyishengPhoto +
            ", xinliyishengJiuzhi=" + xinliyishengJiuzhi +
            ", xinliyishengZhugong=" + xinliyishengZhugong +
            ", xinliyishengZhiwei=" + xinliyishengZhiwei +
            ", xinliyishengContent=" + xinliyishengContent +
            ", xinliyishengDelete=" + xinliyishengDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
