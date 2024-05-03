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
 * 心理医生预约
 *
 * @author 
 * @email
 */
@TableName("xinliyisheng_yuyue")
public class XinliyishengYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XinliyishengYuyueEntity() {

	}

	public XinliyishengYuyueEntity(T t) {
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
     * 心理医生
     */
    @ColumnInfo(comment="心理医生",type="int(11)")
    @TableField(value = "xinliyisheng_id")

    private Integer xinliyishengId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约原因
     */
    @ColumnInfo(comment="预约原因",type="text")
    @TableField(value = "xinliyisheng_yuyue_text")

    private String xinliyishengYuyueText;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "xinliyisheng_yuyue_time")

    private Date xinliyishengYuyueTime;


    /**
     * 预约状态
     */
    @ColumnInfo(comment="预约状态",type="int(11)")
    @TableField(value = "xinliyisheng_yuyue_yesno_types")

    private Integer xinliyishengYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="text")
    @TableField(value = "xinliyisheng_yuyue_yesno_text")

    private String xinliyishengYuyueYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：心理医生
	 */
    public Integer getXinliyishengId() {
        return xinliyishengId;
    }
    /**
	 * 设置：心理医生
	 */

    public void setXinliyishengId(Integer xinliyishengId) {
        this.xinliyishengId = xinliyishengId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约原因
	 */
    public String getXinliyishengYuyueText() {
        return xinliyishengYuyueText;
    }
    /**
	 * 设置：预约原因
	 */

    public void setXinliyishengYuyueText(String xinliyishengYuyueText) {
        this.xinliyishengYuyueText = xinliyishengYuyueText;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getXinliyishengYuyueTime() {
        return xinliyishengYuyueTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setXinliyishengYuyueTime(Date xinliyishengYuyueTime) {
        this.xinliyishengYuyueTime = xinliyishengYuyueTime;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getXinliyishengYuyueYesnoTypes() {
        return xinliyishengYuyueYesnoTypes;
    }
    /**
	 * 设置：预约状态
	 */

    public void setXinliyishengYuyueYesnoTypes(Integer xinliyishengYuyueYesnoTypes) {
        this.xinliyishengYuyueYesnoTypes = xinliyishengYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getXinliyishengYuyueYesnoText() {
        return xinliyishengYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setXinliyishengYuyueYesnoText(String xinliyishengYuyueYesnoText) {
        this.xinliyishengYuyueYesnoText = xinliyishengYuyueYesnoText;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "XinliyishengYuyue{" +
            ", id=" + id +
            ", xinliyishengId=" + xinliyishengId +
            ", yonghuId=" + yonghuId +
            ", xinliyishengYuyueText=" + xinliyishengYuyueText +
            ", xinliyishengYuyueTime=" + DateUtil.convertString(xinliyishengYuyueTime,"yyyy-MM-dd") +
            ", xinliyishengYuyueYesnoTypes=" + xinliyishengYuyueYesnoTypes +
            ", xinliyishengYuyueYesnoText=" + xinliyishengYuyueYesnoText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
