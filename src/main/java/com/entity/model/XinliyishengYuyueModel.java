package com.entity.model;

import com.entity.XinliyishengYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 心理医生预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XinliyishengYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 心理医生
     */
    private Integer xinliyishengId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预约原因
     */
    private String xinliyishengYuyueText;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xinliyishengYuyueTime;


    /**
     * 预约状态
     */
    private Integer xinliyishengYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String xinliyishengYuyueYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
