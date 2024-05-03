package com.entity.vo;

import com.entity.XinliyishengYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 心理医生预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xinliyisheng_yuyue")
public class XinliyishengYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 心理医生
     */

    @TableField(value = "xinliyisheng_id")
    private Integer xinliyishengId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约原因
     */

    @TableField(value = "xinliyisheng_yuyue_text")
    private String xinliyishengYuyueText;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xinliyisheng_yuyue_time")
    private Date xinliyishengYuyueTime;


    /**
     * 预约状态
     */

    @TableField(value = "xinliyisheng_yuyue_yesno_types")
    private Integer xinliyishengYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "xinliyisheng_yuyue_yesno_text")
    private String xinliyishengYuyueYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：心理医生
	 */
    public Integer getXinliyishengId() {
        return xinliyishengId;
    }


    /**
	 * 获取：心理医生
	 */

    public void setXinliyishengId(Integer xinliyishengId) {
        this.xinliyishengId = xinliyishengId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约原因
	 */
    public String getXinliyishengYuyueText() {
        return xinliyishengYuyueText;
    }


    /**
	 * 获取：预约原因
	 */

    public void setXinliyishengYuyueText(String xinliyishengYuyueText) {
        this.xinliyishengYuyueText = xinliyishengYuyueText;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getXinliyishengYuyueTime() {
        return xinliyishengYuyueTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setXinliyishengYuyueTime(Date xinliyishengYuyueTime) {
        this.xinliyishengYuyueTime = xinliyishengYuyueTime;
    }
    /**
	 * 设置：预约状态
	 */
    public Integer getXinliyishengYuyueYesnoTypes() {
        return xinliyishengYuyueYesnoTypes;
    }


    /**
	 * 获取：预约状态
	 */

    public void setXinliyishengYuyueYesnoTypes(Integer xinliyishengYuyueYesnoTypes) {
        this.xinliyishengYuyueYesnoTypes = xinliyishengYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getXinliyishengYuyueYesnoText() {
        return xinliyishengYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setXinliyishengYuyueYesnoText(String xinliyishengYuyueYesnoText) {
        this.xinliyishengYuyueYesnoText = xinliyishengYuyueYesnoText;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
